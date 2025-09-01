package com.example.demo_peng;

import com.example.demo_peng.service.Impl.StringServerImpl;
import com.example.demo_peng.service.StringServer;
import com.example.demo_peng.untils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class StringServerImplTests {

    private final StringServer stringServerImpl = new StringServerImpl();

//      Test the method that returns the previous letter in the alphabet based on a lowercase string.
    @Test
    void testGetPreviousLetterFromLowercase(){
        assertEquals('r', StringUtil.getPreviousLetterFromLowercase("sss").get());
        assertEquals('y', StringUtil.getPreviousLetterFromLowercase("zzs").get());

        assertEquals(Optional.empty(), StringUtil.getPreviousLetterFromLowercase("a"));
        assertEquals(Optional.empty(), StringUtil.getPreviousLetterFromLowercase("A"));
        assertEquals(Optional.empty(), StringUtil.getPreviousLetterFromLowercase("4"));
        assertEquals(Optional.empty(), StringUtil.getPreviousLetterFromLowercase(""));
        assertEquals(Optional.empty(), StringUtil.getPreviousLetterFromLowercase(" "));
        assertEquals(Optional.empty(), StringUtil.getPreviousLetterFromLowercase(null));
    }

//    Test the method that checks whether it contains only letters.
    @Test
    void testIsLowercaseLetterOnly(){
        assertEquals(true, StringUtil.isLowercaseLetterOnly("skjsi"));

        assertEquals(false, StringUtil.isLowercaseLetterOnly("askSjij"));
        assertEquals(false, StringUtil.isLowercaseLetterOnly("asda1a"));
        assertEquals(false, StringUtil.isLowercaseLetterOnly("aaa##asd"));
        assertEquals(false, StringUtil.isLowercaseLetterOnly("asd sdgh"));
        assertEquals(false, StringUtil.isLowercaseLetterOnly(""));
        assertEquals(false, StringUtil.isLowercaseLetterOnly(" "));
        assertEquals(false, StringUtil.isLowercaseLetterOnly(null));
    }

//    Test the method that removes duplicate letters.
    @Test
    void testRemoveConsecutive() {
        List<String> res1 = stringServerImpl.removeConsecutive("aabcccbbad");
        List<String> expectedRes1 = List.of("aabbbad", "aaad", "d");
        assertThat(res1).containsExactlyElementsOf(expectedRes1);

        List<String> res2 = stringServerImpl.removeConsecutive("nnnssksppkl");
        List<String> expectedRes2 = List.of("ssksppkl");
        assertThat(res2).containsExactlyElementsOf(expectedRes2);



        List<String> errorRes = List.of();

        List<String> res3 = stringServerImpl.removeConsecutive("js9sssk");
        assertThat(res3).containsExactlyElementsOf(errorRes);

        List<String> res4 = stringServerImpl.removeConsecutive("SJksjj");
        assertThat(res4).containsExactlyElementsOf(errorRes);

        List<String> res5 = stringServerImpl.removeConsecutive("slkj sskkkl");
        assertThat(res5).containsExactlyElementsOf(errorRes);

        List<String> res6 = stringServerImpl.removeConsecutive("slkj*&skkkl");
        assertThat(res6).containsExactlyElementsOf(errorRes);

        List<String> res7 = stringServerImpl.removeConsecutive("");
        assertThat(res7).containsExactlyElementsOf(errorRes);

        List<String> res8 = stringServerImpl.removeConsecutive(" ");
        assertThat(res8).containsExactlyElementsOf(errorRes);

        List<String> res9 = stringServerImpl.removeConsecutive(null);
        assertThat(res9).containsExactlyElementsOf(errorRes);
    }

    //    Test the method that replaces consecutive letters with the previous letter in the alphabet.
    @Test
    void testReplaceConsecutive() {
        List<String> res1 = stringServerImpl.replaceConsecutive("aabcccbbad");
        List<String> expectedRes1 = List.of("aabbbbad", "aaaad", "d");
        assertThat(res1).containsExactlyElementsOf(expectedRes1);

        List<String> res2 = stringServerImpl.replaceConsecutive("nnnssksppkl");
        List<String> expectedRes2 = List.of("mssksppkl");
        assertThat(res2).containsExactlyElementsOf(expectedRes2);



        List<String> errorRes = List.of();

        List<String> res3 = stringServerImpl.removeConsecutive("js9sssk");
        assertThat(res3).containsExactlyElementsOf(errorRes);

        List<String> res4 = stringServerImpl.removeConsecutive("SJksjj");
        assertThat(res4).containsExactlyElementsOf(errorRes);

        List<String> res5 = stringServerImpl.removeConsecutive("slkj sskkkl");
        assertThat(res5).containsExactlyElementsOf(errorRes);

        List<String> res6 = stringServerImpl.removeConsecutive("slkj*&skkkl");
        assertThat(res6).containsExactlyElementsOf(errorRes);

        List<String> res7 = stringServerImpl.removeConsecutive("");
        assertThat(res7).containsExactlyElementsOf(errorRes);

        List<String> res8 = stringServerImpl.removeConsecutive(" ");
        assertThat(res8).containsExactlyElementsOf(errorRes);

        List<String> res9 = stringServerImpl.removeConsecutive(null);
        assertThat(res9).containsExactlyElementsOf(errorRes);
    }
}
