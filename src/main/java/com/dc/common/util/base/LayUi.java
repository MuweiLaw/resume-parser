package com.dc.common.util.base;

import java.util.HashMap;
import java.util.List;

public class LayUi extends HashMap<String, Object> {

    public static LayUi data(Integer count, List<?> data) {
        LayUi r = new LayUi();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        return r;
    }
}