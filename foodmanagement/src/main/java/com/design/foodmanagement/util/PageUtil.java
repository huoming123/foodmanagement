package com.design.foodmanagement.util;


import com.design.foodmanagement.dto.Page;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {
    public static Map<Object, Object> pagingPrepare(Page page, int count) throws Exception {
        Map<Object, Object> map = new HashMap<>();
        if (page.getPageNum() <= 0 || page.getPageSize()<= 0 ) {
            throw new Exception("页数和数量不正确");
        }
        int i = count / page.getPageSize();
        i = count-(page.getPageSize()*i) == 0? i:++i;
        i = i == 0 ? 1 : i;
        map.put("pageNum", i); //最大有多少页
        map.put("total", count); //总条数
        return map;
    }
}
