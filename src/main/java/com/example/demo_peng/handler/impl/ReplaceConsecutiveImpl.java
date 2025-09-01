package com.example.demo_peng.handler.impl;

import com.example.demo_peng.handler.StringHandler;
import com.example.demo_peng.untils.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;


/*
* Strategy implementation class: Replace consecutive letters with the previous letter in the alphabet.
* Used for specific behavior extension in the {@link StringHandler} template method
* */
@Slf4j
public class ReplaceConsecutiveImpl extends StringHandler {

    @Override
    protected String specificMethod(Matcher matcher, String str) {
        var group = matcher.group();
        return StringUtil.getPreviousLetterFromLowercase(group)
                .map(prevLetter -> {
                    String processedStr = str.replace(group, prevLetter.toString());
                    log.info("{}: {} is replaced by {}", processedStr, group, prevLetter);
                    return processedStr;
                })
                .orElseGet(() -> {
                    String processedStr = str.replace(group, "");
                    log.info("{}", processedStr);
                    return processedStr;
                });
    }
}
