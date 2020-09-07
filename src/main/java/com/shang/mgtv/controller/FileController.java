package com.shang.mgtv.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

@RestController("/file")
public class FileController {
    @RequestMapping("/upload")
    public void upload(@RequestParam("file")MultipartFile file) throws IOException {  //RequestParam中的参数"file"与使用的上传控件的名称相对应
//        如果不设置路径 默认保存到项目根目录
        String filePath = file.getOriginalFilename();             // <input type="file" name="file"/>
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        outputStream.write(file.getBytes());
        outputStream.flush();
        outputStream.close();

    }
}
