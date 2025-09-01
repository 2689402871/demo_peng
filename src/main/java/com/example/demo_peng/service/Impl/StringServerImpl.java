package com.example.demo_peng.service.Impl;

import com.example.demo_peng.handler.StringHandler;
import com.example.demo_peng.handler.impl.RemoveConsecutiveImpl;
import com.example.demo_peng.handler.impl.ReplaceConsecutiveImpl;
import com.example.demo_peng.service.StringServer;

import java.util.List;

public class StringServerImpl implements StringServer {

    private final StringHandler removeConsecutiveImpl = new RemoveConsecutiveImpl();

    private final StringHandler replaceConsecutiveImpl = new ReplaceConsecutiveImpl();

    public List<String> removeConsecutive(String str){
         return removeConsecutiveImpl.run(str);
    }

    public List<String> replaceConsecutive(String str){
         return replaceConsecutiveImpl.run(str);
    }

}
