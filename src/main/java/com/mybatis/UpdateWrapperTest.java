package com.mybatis;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mybatis.dao.PmpContDDAO;
import com.mybatis.dto.ResuDTO;
import com.mybatis.entity.PmpContDDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cc
 * @date 2023/9/16-15:13
 */
@Service
public class UpdateWrapperTest {
    @Resource
    PmpContDDAO pmpContDao;

    /**
     * updateWrapper 更新数据
     */
    public void method1(ResuDTO dto) {
        UpdateWrapper<PmpContDDO> updatePmpContWrapper = new UpdateWrapper<>();
        updatePmpContWrapper.lambda().eq(PmpContDDO::getContId, "xx").eq(PmpContDDO::getValiFlag, "1");
        PmpContDDO pmpContDo = new PmpContDDO();
        pmpContDo.setContNo("xx");
        pmpContDao.update(pmpContDo, updatePmpContWrapper);
    }
}
