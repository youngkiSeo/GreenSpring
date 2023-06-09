package com.green.board10.cmt;

import com.green.board10.cmt.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int CmtIns(CmtInsDto dto);
    int CmtUpd(CmtUpdDto dto);
    List<CmtVo>CmtSel(CmtSelDto dto);
    int selBoardCmtRowCountByIBoard(int iboard);
    int delCmt(CmtDelDto dto);

}
