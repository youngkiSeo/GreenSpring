package com.green.board11_2.board;

import com.green.board11_2.board.model.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "글 작성")
    public int PostBoard(@RequestParam String title,
                         @RequestParam String ctnt,
                         @RequestParam int iuser
                         ){
        BoardInsDto dto = new BoardInsDto();
        dto.setTitle(title);
        dto.setCtnt(ctnt);
        dto.setIuser(iuser);
        return service.InsBoard(dto);
    }
    @PutMapping
    @Operation(summary = "글 수정")
    public int PutBoard(@RequestParam int iboard,
                        @RequestParam String title,
                        @RequestParam String ctnt,
                        @RequestParam int iuser){
        BoardUpdDto dto = new BoardUpdDto();
        dto.setIboard(iboard);
        dto.setTitle(title);
        dto.setCtnt(ctnt);
        dto.setIuser(iuser);
        return service.UpdBoard(dto);
    }

    @GetMapping
    @Operation(summary = "글 보기")
    public String GetBoard(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "30") int row,Model model){
        BoardSelDto dto = new BoardSelDto();
        dto.setPage(page);
        dto.setRow(row);
        model.addAttribute("boardList",service.SelBoard(dto));
        return "boardList";
    }
    @GetMapping("/{iboard}")
    @Operation(summary = "디테일 보기")
    public String GetDetail(@PathVariable int iboard,
                            Model model){
        BoardSelDto dto = new BoardSelDto();
        dto.setIboard(iboard);
        model.addAttribute("boardDetail",service.selBoardDetail(dto));
        return "boardDetail";
    }

    @GetMapping("/{iboard}")
    @Operation(summary = "디테일 보기")
    public BoardDetailCmtVo GetDetail(@PathVariable int iboard){
        BoardSelDto dto = new BoardSelDto();
        dto.setIboard(iboard);
        return service.selBoardDetail(dto);
    }
}
