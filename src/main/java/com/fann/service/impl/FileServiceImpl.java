package com.fann.service.impl;

import com.fann.service.IFileService;


import com.fann.util.FTPUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by b1109_000 on 2017/5/6.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);


    public String upload(MultipartFile file,String path){
            String fileName = file.getOriginalFilename();
            String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
            String uploadFileName = UUID.randomUUID().toString() + fileExtensionName;
            logger.info("开始上传文件，上传的文件名：{},上传的路径：{},新文件名：{}",fileName,path,uploadFileName);

            File fileDir = new File(path);
            if (!fileDir.exists()){
                fileDir.setWritable(true);
                fileDir.mkdirs();
            }

            File targetFile = new File(path,uploadFileName);
            try {
                file.transferTo(targetFile);
                //文件上传成功

                //将targetFile上传到FTP服务器上面
                FTPUtil.uploadFile(Lists.newArrayList(targetFile));

                //将upload目录下的文件删除
                targetFile.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return targetFile.getName();
    }
}
