package com.green.board10.board;

import com.green.board10.board.model.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "글작성")
    public int PostBoard(@RequestBody BoardInsDto dto){
        return service.Insboard(dto);
    }
    @GetMapping
    @Operation(summary = "글목록")
    public List<BoardVo> GetBoard(@RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "30")int row){
        BoardSelDto dto = new BoardSelDto();
        dto.setPage(page);
        dto.setRow(row);
        List<BoardVo> list = service.selboard(dto);
        return list;
    }
    @GetMapping("/{iboard}")
    @Operation(summary = "자세히보기")
    public BoardDetail GetBoardDetail(@PathVariable int iboard){
        BoardVo dto = new BoardVo();
        dto.setIboard(iboard);
        return service.detail(dto);
    }

    @PutMapping
    @Operation(summary = "글 수정")
    public int PutBoard(BoardUpdDto dto){
        return service.Updboard(dto);
    }

    @DeleteMapping
    @Operation(summary = "글 삭제")
    public int delBoard(BoardDel dto){
        return service.BoardDel(dto);
    }

}
