package com.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author cc
 * @date 2023/9/16-15:14
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("xxx")
public class PmpContDDO extends Model<PmpContDDO> {

    @TableId("CONT_ID")
    private String contId;

    @TableField("CONT_NO")
    private String contNo;

    @TableField("VALI_FLAG")
    private String valiFlag;

    @Override
    protected Serializable pkVal() {
        return this.contId;
    }
}
