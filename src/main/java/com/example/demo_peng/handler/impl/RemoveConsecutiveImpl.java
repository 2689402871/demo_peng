package com.example.demo_peng.handler.impl;

import com.example.demo_peng.handler.StringHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;

@Slf4j
public class RemoveConsecutiveImpl extends StringHandler {

//    将联系字母替换为空
    @Override
    protected String specificMethod(Matcher matcher, String str) {
        String group = matcher.group();
        str = str.replace(group, "");
        log.info(str);
        return str;
    }
}
