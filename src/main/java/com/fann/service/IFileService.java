package com.fann.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by b1109_000 on 2017/5/6.
 */
public interface IFileService {
    public String upload(MultipartFile file, String path);
}
