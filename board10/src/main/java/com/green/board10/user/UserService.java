package com.green.board10.user;

import com.green.board10.user.model.UserInsDto;
import com.green.board10.user.model.UserUpdDto;
import com.green.board10.user.model.Usermainpic;
import com.green.board10.utils.CommonUtils;
import com.green.board10.utils.FileUtils;
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

    @Value("D:/download/board10")
    private String fileDir;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils commonUtils) {
        this.mapper = mapper; this.commonUtils = commonUtils;
    }
    public int InsUser(UserInsDto dto){
        char gender = Character.toUpperCase(dto.getGender());
        if(!(gender == 'M' || gender == 'F')) {
            return -1;
        }
        dto.setGender(gender);
        //비밀번호 암호화
        String hashedPw = commonUtils.encodeSha256(dto.getUpw());
        dto.setUpw(hashedPw);
        try{
            return mapper.InsUser(dto);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public int UpdUser(UserUpdDto dto){
        return mapper.UpdUser(dto);
    }
    public int UPd_mainpic(MultipartFile pic,Usermainpic dto){
        String centerPath = String.format("user/%d", dto.getIuser()); //user/syg
        String dicPath = String.format("%s/%s", fileDir,centerPath); //:/download/board10 + //user/syg

        File dic = new File(dicPath);
        if (!dic.exists()){
            dic.mkdirs();
        }

        String originFileName= pic.getOriginalFilename();
        String saveFileName= FileUtils.makeRandomFileNm(originFileName);
        String savedFilePath = String.format("%s/%s",centerPath,saveFileName);
        String targetPath = String.format("%s/%s",fileDir,savedFilePath);
        File target = new File(targetPath);
        try{
            pic.transferTo(target);
        } catch (IOException e) {
            return 0;
        }
        dto.setMain_pic(savedFilePath);

        try {
            int result = mapper.Updmainpic(dto);
            if(result == 0) {
                throw new Exception("프로필 사진을 등록할 수 없습니다.");
            }
        } catch (Exception e) {
            //파일 삭제
            target.delete();
            return 0;
        }
        return 1;
    }
}


