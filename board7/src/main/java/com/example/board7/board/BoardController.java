package com.example.board7.board;


import com.example.board7.board.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "게시판",description = "ddde")
@RestController //json 형태의 문자열을 보내줌     Controller는 html태그로 이루어진 문자열
@RequestMapping("/board") //주소값
public class BoardController {
    private final Logger LOGGER;
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service){
        LOGGER = LoggerFactory.getLogger(BoardController.class);
        this.service=service;
    }

    // get post put delete
    @PostMapping
    //@Validated //유효성 검사
    @Operation(summary = "글등록", description = "글 등록후 할 수 있습니다")
    public int Postboard(@RequestBody BoardInsDto dto){
        return service.insBoard(dto);
    }
    @PutMapping
    @Operation(summary = "글수정", description = "글 수정할 수 있습니다")
    public int PutMapping(@RequestBody BoardDto dto){
        return service.updBoard(dto);
    }
    @DeleteMapping
    @Operation(summary = "글삭제", description = "PK값을 넣어 주시면 됩니다")
    public int DelMapping(@PathVariable int iboard){
       BoardDto dto = new BoardDto();
       dto.setIboard(iboard);
       return service.delBoard(dto);
    }

    @GetMapping
    @Operation(summary = "글보기", description = "글 전체 보기")
    public List<BoardVo>GetALLBoard(@RequestParam(defaultValue = "1") @Min(value = 1, message = "page 값이 1이상이어야함") int page,
                                    @RequestParam(defaultValue = "30") int row){
        LOGGER.info("page : "+ page);
        BoardDto dto = new BoardDto();
        dto.setPage(page);
        dto.setRowLen(row);
        return service.selALLBoard(dto);
    }

    @GetMapping("/{iboard}")
    @Operation(summary = "글보기", description = "pk값을 넣어주세요")
    public BoardDetailVo getBoardById(@PathVariable int iboard){
        BoardDto dto = new BoardDto();
        dto.setIboard(iboard);
        LOGGER.debug(dto.toString());
        return service.selBoardDetail(dto);

        //rest APi 에서 url에 변수가 들어가는걸 실무에서 많이 볼수있다.
        //url에서 @PathVariable로 처리해줄 수 있는 부분이다.
    }
}
    //request가 들어오는 타입에 따라
    //1.url 변수(pathVariable) 2.queryString @requestParam 3.body 4.form

// BoardDEtailVo VO: 한번입력된값이 바뀌지않을때 사용
// BoardDto: 데이터를 넘길때 프론트에서 넘어오는 친구
// Entity : 데이터 베이스 테이블 이름과 같음
// BoardVo : valueobject
// VO: 백엔드에서 서버로 값 넘길떄 Value Object