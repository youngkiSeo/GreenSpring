package com.green.board10.cmt;

import com.green.board10.board.BoardService;
import com.green.board10.cmt.model.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cmt")
public class CmtController {
    private final CmtService service;

    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "댓글 작성")
    public int PostCmt(@RequestBody CmtInsDto dto){
        return service.CmtIns(dto);
    }
    @PutMapping
    @Operation(summary = "댓글 수정")
    public int PutCmt(@RequestBody CmtUpdDto dto){
        return service.CmtUpd(dto);
    }
    @GetMapping
    @Operation(summary = "댓글 보기")
    public List<CmtVo>GetCmt(@RequestParam (defaultValue = "1")int page, @RequestParam (defaultValue = "30")int row){
        CmtSelDto dto = new CmtSelDto();
        dto.setPage(page);
        dto.setRow(row);
        return service.CmtSel(dto);
    }
    @GetMapping("/{iboard}")
    @Operation(summary = "댓글 자세히 보기")
    public CmtRes GetCmt2(@PathVariable int iboard, @RequestParam (defaultValue = "1")int page, @RequestParam (defaultValue = "5")int row) {
        CmtSelDto dto = new CmtSelDto();
        dto.setPage(page);
        dto.setRow(row);
        dto.setIboard(iboard);
        return service.CmtSel2(dto);
    }

    @DeleteMapping("/{iboardCmt}")
    @Operation(summary = "댓글 삭제")
    public int DelCmt(@PathVariable int iboardCmt,
                      @RequestParam int iuser){
      CmtDelDto dto = new CmtDelDto();
      dto.setIboard_cmt(iboardCmt);
      dto.setIuser(iuser);
      return service.delCmt(dto);
    }
}
