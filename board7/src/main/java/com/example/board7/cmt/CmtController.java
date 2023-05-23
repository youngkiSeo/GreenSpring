package com.example.board7.cmt;

import com.example.board7.board.BoardController;
import com.example.board7.cmt.model.BoardCmtDelDto;
import com.example.board7.cmt.model.BoardCmtDto;
import com.example.board7.cmt.model.BoardCmtInsDto;
import com.example.board7.cmt.model.BoardCmtVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class CmtController {
    private final CmtService service;
   // private final Logger LOOGER;

    @Autowired
    public CmtController(CmtService service) {
       // LOOGER = LoggerFactory.getLogger(BoardController.class);
        this.service = service;

    }

    @PostMapping("/cmt")
    public int PostCmt(@RequestBody BoardCmtInsDto dto){
        return service.insBoardCmt(dto);
    }

    @DeleteMapping("/cmt")
    public int delCmt(BoardCmtDelDto dto){
        return service.delBoardCmt(dto);
    }
    @GetMapping("/{iboard}/cmt")
    public List<BoardCmtVo>PostCmt(@PathVariable int iboard){
        BoardCmtDto dto = new BoardCmtDto();
        dto.setIboard(iboard);
        return service.selBoardCmt(dto);
    }


}
