package com.guli.ucenter.mapper;

import com.guli.ucenter.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author Journey
 * @since 2020-02-24
 */
public interface MemberMapper extends BaseMapper<Member> {
    Integer selectRegisterCount(String day);
}
