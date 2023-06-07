package com.green.board10.user;

import com.green.board10.user.model.UserInsDto;
import com.green.board10.user.model.UserUpdDto;
import com.green.board10.user.model.Usermainpic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int InsUser(UserInsDto dto);
    int UpdUser(UserUpdDto dto);
    int Updmainpic(Usermainpic dto);
}
