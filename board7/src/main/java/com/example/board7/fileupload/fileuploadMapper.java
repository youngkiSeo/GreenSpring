package com.example.board7.fileupload;

import com.example.board7.fileupload.model.FileEntity;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface fileuploadMapper {
    int insFile(FileEntity entity);
}
