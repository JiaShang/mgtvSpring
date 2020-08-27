package com.shang.mgtvspring.controller;

import com.shang.mgtvspring.ftp.utils.FtpUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("ftp")
public class FtpTestController {


    @RequestMapping("/test")
    public void FtpTest(HttpServletResponse response, MultipartFile file) throws IOException {
        //FileInputStream inputStream = file.getInputStream();
        //String fileName = file.getOriginalFilename();
        FileInputStream inputStream = new FileInputStream(new File("/1.jpg"));
        //上传
        String path = "/upLoads";
        String fileName = FtpUtil.upload(inputStream, "1.jpg",path);

        System.out.println(fileName);

        //下载
        FtpUtil.downLoad(fileName,path,response);
    }

    //被动下载文件  路径/文件名/文件格式
    @RequestMapping("/downLoads/{path}/{fileName1}/{fileName2}")
    public void downLoadFiles(HttpServletResponse response, @PathVariable String fileName1,@PathVariable String fileName2,@PathVariable String path){
        String fileName = fileName1+"."+fileName2;
        FtpUtil.downLoad(fileName,path,response);
    }


    @RequestMapping("/getFtpImage")
    public void getFtpImage(HttpServletResponse response, MultipartFile file) throws IOException {
        //FileInputStream inputStream = file.getInputStream();
        //String fileName = file.getOriginalFilename();
        FileInputStream inputStream = new FileInputStream(new File("1.jpg"));
        //上传
        String path = "/upLoads";
        String fileName = FtpUtil.upload(inputStream, "1.jpg",path);

        System.out.println(fileName);

        //查看图片
        String filePath = path+"/"+fileName;
        FtpUtil.getFtpImage(response,filePath);
    }



    @RequestMapping("/deleteFiles")
    public void deleteFiles() throws FileNotFoundException {
        //FileInputStream inputStream = file.getInputStream();
        //String fileName = file.getOriginalFilename();
        FileInputStream inputStream = new FileInputStream(new File("/1.jpg"));
        //上传
        String path = "image";
        String fileName = FtpUtil.upload(inputStream, "1.jpg",path);

        //删除
        List<String> files = new ArrayList<>();
        files.add(fileName);
        FtpUtil.deleteFiles(path,files);
    }





    //多文件上传
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public void fileUploads(HttpServletRequest request) throws IOException {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String path = "image";
        for (MultipartFile multipartFile : files) {
            if (!multipartFile.isEmpty()) {
                FtpUtil.upload((FileInputStream) multipartFile.getInputStream(), Objects.requireNonNull(multipartFile.getOriginalFilename()), path);
            }
        }
    }

    /** HTML
     * <p>多文件上传</p>
     * <form method="POST" enctype="multipart/form-data"
     *         action="/upload">
     *     Name: <input type="text" name="name"/>
     *     <p>文件1：<input type="file" name="file" /></p>
     *     <p>文件2：<input type="file" name="file" /></p>
     *     <p><input type="submit" value="多文件上传" /></p>
     * </form>
     */

}
