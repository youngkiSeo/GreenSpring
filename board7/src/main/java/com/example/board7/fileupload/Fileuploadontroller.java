package com.example.board7.fileupload;

import com.example.board7.board.BoardController;
import com.example.board7.fileupload.model.FileuploadInsDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.slf4j.Logger;

@RestController
@RequestMapping("/fileupload")
public class Fileuploadontroller {
    private FileuploadService service;
    private final Logger LOGGER;

    @Autowired
    public Fileuploadontroller(FileuploadService service){
        LOGGER = LoggerFactory.getLogger(Fileuploadontroller.class);
        this.service=service;
    }
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE}) //json으로 날린다면  주소값이 필요함 consumes를 적어준다.
    public void fileupload(@RequestPart FileuploadInsDto dto, @RequestPart MultipartFile img){ //img는 무조건 @RequestPart를 적어준다  스프링이 알아서 MultipartFile 형태로 변환해준다.
        // img는 파일로 날리고 dto는 ??로 날린다
        LOGGER.info("DTO:" + dto);
        LOGGER.info("imgFileName:"+img.getName()); //LOGGER 찍기
        service.fileupload(dto,img); //service한테 fileupload로 전달
    }
}