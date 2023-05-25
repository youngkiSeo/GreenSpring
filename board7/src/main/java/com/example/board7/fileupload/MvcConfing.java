package com.example.board7.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfing implements WebMvcConfigurer {
    @Value("D:/download/") //절대경로
    private String fileDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){ //조종?
        exposeDirectory(fileDir,registry);
    }
    //상대경로를 절대경로로 바꿔주는 소스
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry){
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        if (dirName.startsWith("../")) dirName = dirName.replace("../","");
        registry.addResourceHandler("/images/**").addResourceLocations("file:/"+uploadPath+"/"); // /images/로 시작한다면 file:/ 연결하고싶은경로
    }
}
