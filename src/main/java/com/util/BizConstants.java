package com.util;

/**
 * @author cc
 * @date 2023/9/14-11:12
 */
public class BizConstants {
    public enum LeafNodFlag {
        /**
         * 是叶子
         */
        YES("1"),
        /**
         * 不是
         */
        NO("0");

        private String r;

        LeafNodFlag(String leafNodFlag) {
            this.r = leafNodFlag;
        }

        public String getValue() {
            return this.r;
        }
    }
}
