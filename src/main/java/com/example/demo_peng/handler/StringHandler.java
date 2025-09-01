package com.example.demo_peng.handler;


import com.example.demo_peng.untils.StringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public abstract class StringHandler {

//    subclass-specific implementation method
    protected abstract String specificMethod(Matcher matcher, String str);

//    Preload the Pattern
    private static final Pattern CONSECUTIVE_PATTERN = Pattern.compile(StringUtil.CANSECUTIVE_LETTERS_REGEX);

//    common string processing method
    public final List<String> run(String str) {
        return Optional.ofNullable(str)
                .filter(StringUtil::isLowercaseLetterOnly)
                .map(this::processConsecutive)
                .orElseGet(() -> {
                    log.error("Input error, not processed. input：{}", str);
                    return new ArrayList<>(); // Illegal input returns an empty list
                });
    }

    private List<String> processConsecutive(String original) {
        List<String> processHistory = new ArrayList<>();

        String currentStr = original;
        Matcher matcher = CONSECUTIVE_PATTERN.matcher(currentStr);

        while (matcher.find()) {
            currentStr = specificMethod(matcher, currentStr);
            // Record the results of each processing step
            processHistory.add(currentStr);
            // Re match the updated string
            matcher = CONSECUTIVE_PATTERN.matcher(currentStr);
        }
        return processHistory;
    }
}
