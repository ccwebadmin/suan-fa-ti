package com.mybatis.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("xx")
public class SysResuDDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rid;
    @TableId
    private String resuId;

}