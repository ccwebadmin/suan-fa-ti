package com.util;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @author cc
 * @date 2023/4/25-10:06
 */
public class Regex {
    public static void main(String[] args) {
        PathMatcher pathMatcher = new AntPathMatcher();
        boolean isMatch = pathMatcher.match("/web/*/**", "/web/getUrl/getArcUrl");
        System.out.println(isMatch); // true
    }
}
