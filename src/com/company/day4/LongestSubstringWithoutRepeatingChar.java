package com.company.day4;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String str = "abcaabcdba";
        System.out.println(lengthOfLongestSubstring(str));
    }

    private static int lengthOfLongestSubstring(String str) {
        int length = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < str.length()) {
            if(map.containsKey(str.charAt(right))) {
                left = Math.max(map.get(str.charAt(right)) + 1, left);
            }
            map.put(str.charAt(right), right);
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }
}
