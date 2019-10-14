package com.sethjava.oneaway;

/**
 * 1.5 - There are 3 types of edits that can be performed on strings: insert, remove, replace a char.
 * Given 2 strings, write a function to check if they are one edit (or zero edits) away
 */
//Time complexity : O(n). where N is length of shorter string.
public class OneAwaySingleMethod
{
    private static boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1)
            return false;

        // s1 = shorter, s2 = longer
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0, index2 = 0;
        boolean foundDifference = false;

        while(index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                // Ensure that this is the first difference found
                if(foundDifference){
                    return false;
                }
                foundDifference = true;

                // if on insert mode move pointer to the longer string
                if (s1.length() < s2.length())
                    ++index2;
            }else{
                ++index1; ++index2;
            }
        }
        return true;
    }

    public static void main( String[] args )
    {
        String str1 = "pales";
        String str2 = "pale";
        boolean isOneEditAway = false;
        if(str1 != null && str2 != null)
            isOneEditAway = oneEditAway(str1, str2);
        if(isOneEditAway){
            System.out.println(str1 + " and "+ str2 + " is one edit away");
        }else{
            System.out.println(str1 + " and "+ str2 + " is not one edit away");
        }

    }
}
