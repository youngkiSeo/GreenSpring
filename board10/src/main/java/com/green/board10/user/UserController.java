package com.green.board10.user;

import com.green.board10.user.model.UserInsDto;
import com.green.board10.user.model.UserUpdDto;
import com.green.board10.user.model.Usermainpic;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping
    @Operation(
            summary = "회원가입", description = " "+
            "uid\": [20] 회원 아이디\", <br>"+
            "upw\": [100] 회원 비밀번호\", <br>"+
            "nm\": [30] 회원 이름\", <br>"+
            "gender\": [1] m:남자 f:여자 \", <br>"+
            "addr\": [100] 주소")
    public int PostUser(@RequestBody UserInsDto dto){
        return service.InsUser(dto);
    }
    @PutMapping
    @Operation(
            summary = "마이페이지수정", description = ""
    )
    public int PutUser(@RequestBody UserUpdDto dto){
        return service.UpdUser(dto);
    }


    @PatchMapping(name = "/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @Operation(summary = "사진등록", description = "")
    public int patchPicUser(@RequestPart MultipartFile pic, @RequestParam int iuser){
        Usermainpic dto = new Usermainpic();
        dto.setIuser(iuser);
        return service.UPd_mainpic(pic,dto);
    }



}
