package com.mert.model;

import java.util.Map;

public class ListResult<T> extends CommonResult {
    private Map data;

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
