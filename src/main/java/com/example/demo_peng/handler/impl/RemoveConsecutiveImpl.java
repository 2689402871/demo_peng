package com.example.demo_peng.handler.impl;

import com.example.demo_peng.handler.StringHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;

/**
 * Strategy implementation class: Remove consecutive duplicate letters
 * Used for specific behavior extension in the {@link StringHandler} template method
 */
@Slf4j
public class RemoveConsecutiveImpl extends StringHandler {

    @Override
    protected String specificMethod(Matcher matcher, String str) {
        String group = matcher.group();
        str = str.replace(group, "");
        log.info(str);
        return str;
    }
}
