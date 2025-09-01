package com.example.demo_peng.handler.impl;

import com.example.demo_peng.handler.StringHandler;
import com.example.demo_peng.untils.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;

@Slf4j
public class ReplaceConsecutiveImpl extends StringHandler {

//    将连续字母替换为字母表中前一位字母，并按格式输出
    @Override
    protected String specificMethod(Matcher matcher, String str) {
        String group = matcher.group();
        Character previousLetter = StringUtil.getPreviousLetterFromLowercase(group);
        if(previousLetter != null){
            str = str.replace(group, previousLetter.toString());
            log.info("{}, {} is replaced by {}", str, group, previousLetter);
        }else{
            str = str.replace(group, "");
            log.info(str);
        }
        return str;
    }
}
