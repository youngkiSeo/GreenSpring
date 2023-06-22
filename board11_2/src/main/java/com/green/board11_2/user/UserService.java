package com.green.board11_2.user;

import com.green.board11_2.user.model.*;
import com.green.board11_2.utils.CommonUtils;
import com.green.board11_2.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UserService {
    private final UserMapper mapper;
    private final CommonUtils commonUtils;

    @Value("D:/download/board11")
    private String fileDir;
    @Autowired
    public UserService(UserMapper mapper, CommonUtils commonUtils) {
        this.mapper = mapper;
        this.commonUtils = commonUtils;
    }

    public int UserCmtIns(UserInsDto dto){
        char gender = Character.toUpperCase(dto.getGender());
        if (!(gender == 'M' || gender == 'F')){
            return -1;
        }
        dto.setGender(gender);
        String hashedPw = commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hashedPw);
        try{
            return mapper.CmtIns(dto);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int selUserById(UserLoginDto dto){
        UserLoginVo Vo = mapper.selUserById(dto);
        if (Vo == null){
            return 2;
        }
        String hashedPw = commonUtils.encodeSha256(dto.getUpw());
        if (Vo.getUpw().equals(hashedPw)){
            return 1;
        }
        return 3;
    }
    public int UpdUserPw(UserPatchPwDto dto){
        String hashedPw = commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hashedPw);
        return mapper.UpdUserPw(dto);
    }
    public int UpUserPic(MultipartFile pic, UserPatchPicDto dto){
        String centerPatch = String.format("com/green/board11_2/user/%s", dto.getUid());
        String dicPath = String.format("%s/%s", fileDir,centerPatch);
        File dic = new File(dicPath);
        if (!dic.exists()){
            dic.mkdirs();
        }

        String originFileName = pic.getOriginalFilename(); // 원래 이름 추출
        String savedFileName = FileUtils.makeRandomFileNm(originFileName); // UUID 이름 생성
        String savedFilePath = String.format("%s/%s", centerPatch, savedFileName); // 파일 경로 생성
        String targetPath = String.format("%s/%s", fileDir,savedFilePath);  //파일경로 생성
        File target = new File(targetPath); // 파일 객체 생성

        try {
            pic.transferTo(target);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        dto.setMainPic(savedFilePath);

        try {
            int result = mapper.UpUserPic(dto);
            if (result == 0) {
                throw new Exception("프로필 사진을 등록 할 수 없습니다.");
            }
        }catch (Exception e){
            e.printStackTrace();
            target.delete();
            return 0;
        }
        return 1;

    }
}