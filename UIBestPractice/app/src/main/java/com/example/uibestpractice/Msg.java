package com.example.uibestpractice;

/**
 * Created by subaru on 2017/3/17.
 */

public class Msg {
    public static final int TYPE_RECEVIED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
