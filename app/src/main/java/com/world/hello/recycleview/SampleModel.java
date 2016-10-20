package com.world.hello.recycleview;

/**
 * 模拟对象数据
 * Created by chengguo on 2016/5/30.
 */
public class SampleModel {
    private String message;

    public SampleModel(String message) {
        this.message = message;
    }

    public void setMessage(String s) {
        message = s;
    }

    public String getMessage() {
        return message;
    }
}
