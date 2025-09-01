package com.example.demo_peng.service.Impl;

import com.example.demo_peng.handler.StringHandler;
import com.example.demo_peng.service.StringServer;

public class StringServerImpl implements StringServer {

    private StringHandler removeConsecutiveImpl;

    private StringHandler replaceConsecutiveImpl;

    public void removeConsecutive(String str){
        removeConsecutiveImpl.run(str);
    }

    public void replaceConsecutive(String str){
        replaceConsecutiveImpl.run(str);
    }

}
