package com.example.board7.fileupload;

import com.example.board7.fileupload.model.*;
import com.example.board7.fileupload.model.FileuploadInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

@Service
public class FileuploadService {


    @Value("${file.dir}") //파일 읽어오는
    private String fileDir; //파일 위치 값이 fileDir 전역변수에 주입됨
    private fileuploadMapper mapper;
    @Autowired
    public FileuploadService(fileuploadMapper mapper){
        this.mapper=mapper;
    }

    public Resource fileLoad(FileLoadDto dto) { //Resource 파일
        FileEntity entity = mapper.selFileById(dto);
        try {
            File file = new File(fileDir + entity.getPath());//getPaht 파일경로
            Resource resource = new UrlResource(file.toURI());//file을 uri 정보로 변환시킴 url uri ... 파일경로를 객체화  파일을 resource 형식으로 객체화
            if(resource.exists()) {//바이널 0과1로 이어진 자료를 1열로 세움 존재하면 return 시키고 아니면 return null
                return resource;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

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
        file.exists(); //파일 위치 물어보기 없으니깐 false 있으면 true
        try {
            img.transferTo(file); //img.transferTo 파일객체를 보냄
            FileEntity entity =FileEntity.builder().path(savedFileName).uploader(dto.getUploader()).levelvalue(dto.getLevelvalue()).build();
            //path랑 uploader랑 levelvalue 값만 넣어서 객체생성함
            // 생성자 대신 setter 처럼 사용하는 builder 원하는 값만 넣어서 생성할수있게 해줌
            mapper.insFile(entity);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}