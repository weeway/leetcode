package com.company;

import sun.security.util.Length;

/**
 * Created by waywee on 2017/5/27.
 */
public class LongestSubstring {
    public static void main(String[] args){
        String str = "pwwkew";
        System.out.println(LengthOfLongestSubstring(str));
    }

    public static int LengthOfLongestSubstring(String s){
        int ans = 0;
        char[] str = s.toCharArray();
        String substring = "";
        for(char ch : str){
            if(!substring.contains(""+ch))
                substring+=ch;
            else
            {
                int index = substring.indexOf(ch);
                substring+=ch;
                substring = substring.substring(index+1);
            }

            if(ans < substring.length())
                ans = substring.length();
        }

        return ans;
    }
}


