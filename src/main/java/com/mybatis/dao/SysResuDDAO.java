package com.mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.entity.SysResuDDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author cc
 * @date 2023/9/16-14:10
 */
@Mapper
@Repository
public interface SysResuDDAO extends BaseMapper<SysResuDDO> {
}
