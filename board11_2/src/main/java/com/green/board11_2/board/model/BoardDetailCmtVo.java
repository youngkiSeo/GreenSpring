package com.green.board11_2.board.model;

import com.green.board11_2.cmt.model.CmtRes;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDetailCmtVo {
    private BoardDetailVo vo;
    private CmtRes cmtRes;
}
