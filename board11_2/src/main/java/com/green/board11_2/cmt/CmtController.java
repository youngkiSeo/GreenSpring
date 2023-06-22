package com.green.board11_2.cmt;

import com.green.board11_2.cmt.model.CmtEntity;
import com.green.board11_2.cmt.model.CmtRes;
import com.green.board11_2.cmt.model.CmtSelDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class CmtController {
    private final CmtService cmtService;

    @Autowired
    public CmtController(CmtService cmtService) {
        this.cmtService = cmtService;
    }

    @PostMapping("/{iboard}/cmt")
    @Operation(summary = "댓글 작성")
    public int PostCmt(@PathVariable int iboard,
                       @RequestParam int iuser,
                       @RequestParam String ctnt
                       ){
        CmtEntity entity = new CmtEntity();
        entity.setIboard(iboard);
        entity.setIuser(iuser);
        entity.setCtnt(ctnt);
        return cmtService.CmtIns(entity);
    }

    @GetMapping("/{iboard}/cmt")
    @Operation(summary = "댓글 보기")
    public CmtRes GetBoardCmt(@PathVariable int iboard,
                              @RequestParam int page,
                              @RequestParam int row){
        CmtSelDto dto = new CmtSelDto();
        dto.setIboard(iboard);
        dto.setPage(page);
        dto.setRow(row);
        return cmtService.selBoardCmt(dto);
    }

    @PutMapping("/cmt/{iboardCmt}")
    @Operation(summary = "댓글 수정")
    public int PutBoardCmt(@PathVariable int iboardCmt,
                           @RequestParam int iuser,
                           @RequestParam String ctnt
                           ){
        CmtEntity entity = new CmtEntity();
        entity.setIboardCmt(iboardCmt);
        entity.setCtnt(ctnt);
        entity.setIuser(iuser);
        return cmtService.UpdCmt(entity);
    }

    @DeleteMapping("/cmt/{iboardCmt}")
    @Operation(summary = "댓글 삭제")
    public int DelBoardCmt(@PathVariable int iboardCmt
                           ){
        CmtEntity entity = new CmtEntity();
        entity.setIboardCmt(iboardCmt);
        return cmtService.DelCmt(entity);
    }
}
