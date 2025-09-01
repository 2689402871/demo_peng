package com.example.demo_peng.service;

import java.util.List;

public interface StringServer {

//    Replace consecutive letters with empty string
    List<String> removeConsecutive(String str);

//    Replace consecutive letters with the previous letter in the alphabet.
    List<String> replaceConsecutive(String str);

}
