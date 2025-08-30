package com.example.demo_peng.service.Impl;

import com.example.demo_peng.handler.StringHandler;
import com.example.demo_peng.service.StringServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StringServerImpl implements StringServer {

    @Autowired
    private StringHandler removeConsecutiveImpl;

    @Autowired
    private StringHandler replaceConsecutiveImpl;

    public void removeConsecutive(String str){
        removeConsecutiveImpl.run(str);
    }

    public void replaceConsecutive(String str){
        replaceConsecutiveImpl.run(str);
    }

}
