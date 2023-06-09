package com.green.board10.board.model;

import com.green.board10.cmt.model.CmtRes;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardDetailAll {
    private BoardDetail iboard;
    private CmtRes cmtRes;
}
