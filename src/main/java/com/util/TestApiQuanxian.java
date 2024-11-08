package com.util;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.HashMap;
import java.util.Map;

public class TestApiQuanxian {

    public static void main(String[] args) {
        Map<String,String> map =new HashMap<String,String>();
        map.put("/web/menufav/sysMenuFavD/ids","202004041723471002951001440000");
        map.put("/web/sysResuD/menu/*","202004041723471002951001440000");
        map.put("web/instmem/list","202004041723471002951001440000");
        //放行类似/web/subsys/sysSubsysD/page这种请求
        map.put("/*/*/*/*","202004041723471002951001440000");
        map.put("/img/**","202004041723471002951001440000");
        map.put("疾病诊断查询","202004041723471002951001440000");
        map.put("/*/*","202004041723471002951001440000");
        map.put("/*","202004041723471002951001440000");
        map.put("002","202004041723471002951001440000");
        map.put("web/instmem/checkCode*","202004041723471002951001440000");
        map.put("/*/*/*/*/*","202004041723471002951001440000");
        map.put("web/admdiv/delete?finAdmdvs=*","202004041723471002951001440000");
        //放行类似/web/subsys/sysSubsysD这种请求
        map.put("/*/*/*","202004041723471002951001440000");
        map.put("/web/secRole/*/users","202004041723471002951001440000");
        map.put("/web/user/","202004041723471002951001440000");
        //放行类似/web/subsys/sysSubsysD/page这种请求
        map.put("/web/subsys/sysSubsysD/**","202004041723471002951001440000");
        matchMapValue(map,"/web/subsys/sysSubsysD/pagegeeg");


    }
    public static void matchMapValue(Map map, String requestUrl)
    {
        Map<String,String> blackList=new HashMap<String,String>();
        blackList.put("/**", "1");
        blackList.put("/web/**", "1");
        blackList.put("/**/*", "1");
        blackList.put("/web/**/*", "1");
        blackList.put("/*", "1");
        PathMatcher matcher = new AntPathMatcher();
        for (Object mapKey : map.keySet()) {
            if(mapKey.toString().indexOf("*")>0 && !"1".equals(blackList.get(mapKey.toString())))
            {
                if(matcher.match(mapKey.toString(), requestUrl))
                {
//                    return true;
                    System.out.println(mapKey.toString());
                    System.out.println(true);
                }
            }
        }
        System.out.println("==============end ====================");
        System.out.println(false);
//        return false;
    }
}
