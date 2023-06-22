package com.green.board11_2.cmt;

import com.green.board11_2.cmt.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int CmtIns(CmtEntity entity);
    List<CmtVo> selBoardCmt(CmtSelDto dto);
    int CmtIboardCount(int iboard);
    int UpdCmt(CmtEntity entity);
    int DelCmt(CmtEntity entity);
}
