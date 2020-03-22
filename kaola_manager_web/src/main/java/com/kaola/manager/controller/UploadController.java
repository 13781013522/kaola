package com.kaola.manager.controller;

import com.kaola.util.FastDFSClient;
import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @Value("${FILE_SERVER_URL}")
   private String  FILE_SERVER_URL;

    @RequestMapping("/upload")
    public Result uploadPic(MultipartFile file){
        //1.获取到文件扩展名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

        //创建一个FastDFS客户端
        try {
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);
            String url = FILE_SERVER_URL+path;
            return new Result(true,url);

        } catch (Exception e) {
            e.printStackTrace();
            return  new Result(false,"图片上传失败");
        }
    }
}
