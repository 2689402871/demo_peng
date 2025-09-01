package com.example.demo_peng;

import com.example.demo_peng.service.Impl.StringServerImpl;
import com.example.demo_peng.untils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StringServerImplTests {

    private StringServerImpl stringServerImpl;

//      测试根据小写字符串 返回字母表中前一位字母方法
    @Test
    void testGetPreviousLetterFromLowercase(){
        log.info("testGetPreviousLetterFromLowercase 输入：{}，输出：{}" , "a" , StringUtil.getPreviousLetterFromLowercase("a"));
        log.info("testGetPreviousLetterFromLowercase 输入：{}，输出：{}" , "sss" , StringUtil.getPreviousLetterFromLowercase("sss"));
        log.info("testGetPreviousLetterFromLowercase 输入：{}，输出：{}" , "zzs" , StringUtil.getPreviousLetterFromLowercase("zzs"));
        log.info("testGetPreviousLetterFromLowercase 输入：{}，输出：{}" , "AAS" , StringUtil.getPreviousLetterFromLowercase("A"));
        log.info("testGetPreviousLetterFromLowercase 输入：{}，输出：{}" , "44#" , StringUtil.getPreviousLetterFromLowercase("4"));
        log.info("testGetPreviousLetterFromLowercase 输入：{}，输出：{}" , "" , StringUtil.getPreviousLetterFromLowercase(""));
        log.info("testGetPreviousLetterFromLowercase 输入：{}，输出：{}" , " " , StringUtil.getPreviousLetterFromLowercase(" "));
        log.info("testGetPreviousLetterFromLowercase 输入：{}，输出：{}" , null , StringUtil.getPreviousLetterFromLowercase(null));
    }

//    测试是否仅包含字母方法
    @Test
    void testIsLowercaseLetterOnly(){
        log.info("isLowercaseLetterOnly 输入：{}，输出：{}" , "skjsi" , StringUtil.isLowercaseLetterOnly("skjsi"));
        log.info("isLowercaseLetterOnly 输入：{}，输出：{}" , "askSjij" , StringUtil.isLowercaseLetterOnly("askSjij"));
        log.info("isLowercaseLetterOnly 输入：{}，输出：{}" , "asda1a" , StringUtil.isLowercaseLetterOnly("asda1a"));
        log.info("isLowercaseLetterOnly 输入：{}，输出：{}" , "aaa##asd" , StringUtil.isLowercaseLetterOnly("aaa##asd"));
        log.info("isLowercaseLetterOnly 输入：{}，输出：{}" , "asd sdgh" , StringUtil.isLowercaseLetterOnly("asd sdgh"));
        log.info("isLowercaseLetterOnly 输入：{}，输出：{}" , "" , StringUtil.isLowercaseLetterOnly(""));
        log.info("isLowercaseLetterOnly 输入：{}，输出：{}" , " " , StringUtil.isLowercaseLetterOnly(" "));
        log.info("isLowercaseLetterOnly 输入：{}，输出：{}" , null , StringUtil.isLowercaseLetterOnly(null));
    }

//    测试删除重复字母方法
    @Test
    void testRemoveConsecutive() {
        stringServerImpl.removeConsecutive("aabcccbbad");
        log.info("-----------------------------------");
        stringServerImpl.removeConsecutive("nnnssksppkl");
        log.info("-----------------------------------");
        stringServerImpl.removeConsecutive("js9sssk");
        log.info("-----------------------------------");
        stringServerImpl.removeConsecutive("SJksjj");
        log.info("-----------------------------------");
        stringServerImpl.removeConsecutive("slkj sskkkl");
        log.info("-----------------------------------");
        stringServerImpl.removeConsecutive("slkj*&skkkl");
        log.info("-----------------------------------");
        stringServerImpl.removeConsecutive("");
        log.info("-----------------------------------");
        stringServerImpl.removeConsecutive(" ");
        log.info("-----------------------------------");
        stringServerImpl.removeConsecutive(null);
    }

    //    测试将连续字母替换为字母表中前一位字母，并按格式输出方法
    @Test
    void testReplaceConsecutive() {
        stringServerImpl.replaceConsecutive("aabcccbbad");
        log.info("-----------------------------------");
        stringServerImpl.replaceConsecutive("nnnssksppkl");
        log.info("-----------------------------------");
        stringServerImpl.replaceConsecutive("js9sssk");
        log.info("-----------------------------------");
        stringServerImpl.replaceConsecutive("SJksjj");
        log.info("-----------------------------------");
        stringServerImpl.replaceConsecutive("slkj sskkkl");
        log.info("-----------------------------------");
        stringServerImpl.replaceConsecutive("slkj*&skkkl");
        log.info("-----------------------------------");
        stringServerImpl.replaceConsecutive("");
        log.info("-----------------------------------");
        stringServerImpl.replaceConsecutive(" ");
        log.info("-----------------------------------");
        stringServerImpl.replaceConsecutive(null);
    }
}
