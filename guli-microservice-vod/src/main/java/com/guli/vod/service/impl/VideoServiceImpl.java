package com.guli.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.*;
import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.exception.GuliException;
import com.guli.vod.service.VideoService;
import com.guli.vod.util.AliyunVODSDKUtils;
import com.guli.vod.util.ConstantPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: journey
 * @Date: 2020/2/29
 * @Time: 11:20 下午
 * @Description:
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Override
    public String UploadVideoId(MultipartFile file) {
        String videoId = null;

        try {
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String title = fileName.substring(0, fileName.lastIndexOf("."));

            //创建请求对象
            UploadStreamRequest request = new UploadStreamRequest(
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET,
                    title,
                    fileName,
                    inputStream);

            // 创建文件上传器
            UploadVideoImpl uploadVideo = new UploadVideoImpl();

            // 执行文件上传，得到响应对象
            UploadStreamResponse response = uploadVideo.uploadStream(request);

            videoId = response.getVideoId();
        } catch (IOException e) {
            throw new GuliException(ResultCodeEnum.VIDEO_UPLOAD_ERROR);
        }

        return videoId;
    }

    @Override
    public void removeVideo(String videoId) {

        DefaultAcsClient client = null;
        try {
            client = AliyunVODSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoId);

            DeleteVideoResponse response = client.getAcsResponse(request);

        } catch (ClientException e) {
            throw new GuliException(ResultCodeEnum.VIDEO_DELETE_ALIYUN_ERROR);
        }

    }

    /**
     * 获取上传凭证和上传地址
     * @param title
     * @param fileName
     * @return
     */
    @Override
    public CreateUploadVideoResponse getUploadAuthAndAddress(String title, String fileName) {

        try {
            //创建请求对象
            DefaultAcsClient client = AliyunVODSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET
            );

            //为请求对象组织私有参数
            CreateUploadVideoRequest request = new CreateUploadVideoRequest();
            request.setTitle(title);
            request.setFileName(fileName);

            //发送请求，获取响应对象
            CreateUploadVideoResponse response = client.getAcsResponse(request);

            //从响应对象中获取返回值
            return response;

        }catch (ClientException e){
            throw  new GuliException(ResultCodeEnum.FETCH_VIDEO_UPLOADAUTH_ERROR);
        }

    }

    @Override
    public RefreshUploadVideoResponse refreshUploadAuthAndAddress(String videoId) {

        try {
            //初始化
            DefaultAcsClient client = AliyunVODSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET
            );

            //创建请求对象:为请求对象组织私有参数
            RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
            request.setVideoId(videoId);

            //发送请求，获取响应对象
            RefreshUploadVideoResponse response = client.getAcsResponse(request);

            //从响应对象中获取返回值
            return response;

        }catch (ClientException e){
            throw  new GuliException(ResultCodeEnum.REFRESH_VIDEO_UPLOADAUTH_ERROR);
        }
    }

    @Override
    public String getVideoPlayAuth(String videoId) {

        try {

            //初始化
            DefaultAcsClient client = AliyunVODSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET
            );

            //创建请求对象:为请求对象组织私有参数
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(videoId);

            //响应对象
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);

            //获取播放凭证
            String playAuth = response.getPlayAuth();

            return playAuth;

        }catch (ClientException e){
            throw  new GuliException(ResultCodeEnum.FETCH_VIDEO_PLAYAUTH_ERROR);
        }
    }


}
