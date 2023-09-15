package com.util;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

/**
 * @author cc
 * @date 2023/9/14-16:02
 */
public class CommonUtil {
    /**
     * 对象拷贝
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        BeanUtil.copyProperties(source, target, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
    }
}
