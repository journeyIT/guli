package com.guli.vod.service;

import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: journey
 * @Date: 2020/2/29
 * @Time: 11:18 下午
 * @Description:
 */
public interface VideoService {
    /**
     * 调用阿里云java SDK执行文件上传
     * @param file
     * @return 文件videoId
     */
    String UploadVideoId(MultipartFile file);

    /**
     * 通过videoId删除视频文件
     * @param videoId
     */
    void removeVideo(String videoId);

    CreateUploadVideoResponse getUploadAuthAndAddress(String title, String fileName);

    RefreshUploadVideoResponse refreshUploadAuthAndAddress(String videoId);

    String getVideoPlayAuth(String videoId);
}
