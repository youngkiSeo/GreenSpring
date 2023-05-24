package com.example.board7.fileupload;

import com.example.board7.fileupload.model.FileEntity;
import com.example.board7.fileupload.model.FileuploadInsDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileuploadService {
    private fileuploadMapper mapper;
    public FileuploadService(fileuploadMapper mapper){
        this.mapper=mapper;
    }

    @Value("${file.dir}") //파일 읽어오는
    private String fileDir; //파일 위치 값이 fileDir 전역변수에 주입됨
    public void fileupload(FileuploadInsDto dto, MultipartFile img) {
        System.out.println("fileDir:"+fileDir);

        //원래파일 이름 추출 (확장자를 빼내기 위해서 추출함)
        String originFileName = img.getOriginalFilename();

        //파일 이름으로 사용할 uuid 생성 (자바의 UUID값 생성하는법) UUID를 생성하면 계속 랜덤한 값이 나옴
        String uuid = UUID.randomUUID().toString();

        //확장자명 찾기
        int dotIdx = originFileName.lastIndexOf(".");
        String ext = originFileName.substring(dotIdx);

        String savedFileName= uuid + ext;
        String savedFilePath= fileDir + savedFileName;
        File file = new File(savedFilePath); //saveFilePath경로로 객체를 만들었음 .예외처리를 service class 에서 해야함
        file.exists(); //파일 위치 물어보기 없으니깐 false
        try {
            img.transferTo(file); //img.transferTo 파일객체를 보냄\
            FileEntity entity =FileEntity.builder().path(savedFilePath).uploader(dto.getUploader()).levelvalue(dto.getLevelvalue()).build();
            //path랑 uploader랑 levelvalue 값만 넣어서 객체생성함
            mapper.insFile(entity);
        } catch (IOException e) {
           e.printStackTrace();
        }

    }
}
