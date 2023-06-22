package com.green.board11_2.user;

import com.green.board11_2.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping
    @Operation(summary = "회원가입")
    public int PostUser(@RequestParam String uid,
                        @RequestParam String upw,
                        @RequestParam String nm,
                        @RequestParam char gender,
                        @RequestParam String addr
                        ){
        UserInsDto dto = new UserInsDto();
        dto.setUid(uid);
        dto.setUpw(upw);
        dto.setNm(nm);
        dto.setGender(gender);
        dto.setAddr(addr);
        return service.UserCmtIns(dto);
    }
    @PostMapping("/login")
    @Operation(summary = "로그인",description = 
            "(1)로그인 성공"+
            "(2)아이디 없음"+
            "(3)비밀번호 다름"
    )
    public int GetUser(@RequestParam String uid, @RequestParam String upw){
        UserLoginDto dto = new UserLoginDto();
        dto.setUid(uid);
        dto.setUpw(upw);
        return service.selUserById(dto);
    }

    @PatchMapping("/Pw")
    @Operation(summary = "비번변경")
    public int PatchPw(@RequestParam String uid, @RequestParam String upw){
        UserPatchPwDto dto = new UserPatchPwDto();
        dto.setUid(uid);
        dto.setUpw(upw);
        return service.UpdUserPw(dto);
    }
    @PatchMapping(name="/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "사진변경")
    public int patchPicUser(@RequestPart MultipartFile pic, @RequestParam String uid ){
        UserPatchPicDto dto = new UserPatchPicDto();
        dto.setUid(uid);
        return service.UpUserPic(pic,dto);
    }



}
