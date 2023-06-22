package com.green.board11_2.user;

import com.green.board11_2.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int CmtIns(UserInsDto dto);
    UserLoginVo selUserById(UserLoginDto dto);
    int UpdUserPw(UserPatchPwDto dto);
    int UpUserPic(UserPatchPicDto dto);
}
