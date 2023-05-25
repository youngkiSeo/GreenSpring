package com.example.board7.fileupload;

import com.example.board7.fileupload.model.FileEntity;
import com.example.board7.fileupload.model.FileLoadDto;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface fileuploadMapper {
    int insFile(FileEntity entity);
    FileEntity selFileById(FileLoadDto dto);
}
