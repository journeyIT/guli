package com.guli.edu.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: journey
 * @Date: 2020/2/24
 * @Time: 2:57 下午
 * @Description:
 */
@Data
public class SubjectNestedVo {
    private String id;
    private String title;
    private List<SubjectVo> children = new ArrayList<>();
}
