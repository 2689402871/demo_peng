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

    //    Preload the Pattern
    private static final Pattern CONSECUTIVE_PATTERN = Pattern.compile(StringUtil.CANSECUTIVE_LETTERS_REGEX);

    /**
     * Hook Method：To be implemented by subclasses, defining how to handle the matched consecutive characters.
     *
     * @param matcher Current matcher
     * @param str Current String
     * @return Processed string
     */
    protected abstract String specificMethod(Matcher matcher, String str);

    /**
     * Template method: Define a fixed process for string processing
     * 1. Validate the input
     * 2. Cyclically search for consecutive repeated letters
     * 3. Call the specific processing method of the subclass
     * 4. Record the result of each step
     *
     * @param str Input string
     * @return Historical records of the processing process
     */
    public final List<String> run(String str) {
        return Optional.ofNullable(str)
                .filter(StringUtil::isLowercaseLetterOnly)
                .map(this::processConsecutive)
                .orElseGet(() -> {
                    log.error("Input error, not processed. input：{}", str);
                    return new ArrayList<>(); // Illegal input returns an empty list
                });
    }

    /**
     * Execute the processing loop: find all consecutive repeated characters and hand them over to the subclass for processing.
     */
    private final List<String> processConsecutive(String original) {
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
