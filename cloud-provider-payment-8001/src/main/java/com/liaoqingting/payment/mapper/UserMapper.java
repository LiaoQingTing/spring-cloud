package com.liaoqingting.payment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liaoqingting.springcloud.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
