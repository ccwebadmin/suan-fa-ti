package com.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.dao.SysResuDDAO;
import com.mybatis.dto.ResuDTO;
import com.mybatis.entity.SysResuDDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author cc
 * @date 2023/9/16-11:24
 */
@Service
public class QueryWrapperTest {

    @Autowired
    private SysResuDDAO sysResuDDao;
    /**
     * queryWrapper 查询
     */
    public void method1(ResuDTO dto) {

        //查询用
        QueryWrapper<SysResuDDO> queryWrapperP = new QueryWrapper<SysResuDDO>();
        queryWrapperP.lambda().eq(SysResuDDO::getResuId, dto.getPrntResuId());
        SysResuDDO prnt = sysResuDDao.selectOne(queryWrapperP);
    }

}
