package com.mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.entity.PmpContDDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author cc
 * @date 2023/9/16-15:36
 */
@Mapper
@Repository
public interface PmpContDDAO extends BaseMapper<PmpContDDO> {
}
