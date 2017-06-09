package com.handy.frame.shared.constant;

/**
 * @author longhairen
 * @create 2017/6/9 0009 下午 4:11
 */
public enum Logical {
    IS(1),NOT(0);

    private int value;
    private Logical(int value){
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
