package com.guli.aliyunoss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: journey
 * @Date: 2019-11-17
 * @Time: 18:54
 * @Description:
 */
public interface FileService {
    /**
     * 文件上传至阿里云
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
