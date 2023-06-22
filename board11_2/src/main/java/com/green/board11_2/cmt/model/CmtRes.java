package com.green.board11_2.cmt.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CmtRes {
    private int maxPage;
    private int row;
    private int isMore;
    private List<CmtVo> list;
}
