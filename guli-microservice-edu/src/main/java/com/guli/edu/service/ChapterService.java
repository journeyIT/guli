package com.guli.edu.service;

import com.guli.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.edu.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author Journey
 * @since 2020-01-31
 */
public interface ChapterService extends IService<Chapter> {
    void removeChapterById(String id);

    List<ChapterVo> nestedList(String courseId);
}
