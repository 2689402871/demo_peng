package com.example.demo_peng.handler;


import com.example.demo_peng.untils.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public abstract class StringHandler {

//    子类 具体实现方法
    protected abstract String specificMethod(Matcher matcher, String str);

//    字符串处理 公共方法
    public final void run(String str){
        if(!StringUtil.isLowercaseLetterOnly(str)){
            log.error("输入有误，不处理。输入：{}", str);
            return;
        }
        String crruntStr = str;
        Pattern compile = Pattern.compile(StringUtil.CANSECUTIVE_LETTERS_REGEX);
        Matcher matcher = compile.matcher(crruntStr);
        while (matcher.find()){
//            调用子类实现
            crruntStr = specificMethod(matcher, crruntStr);
            matcher = compile.matcher(crruntStr);
        }
    }

}
