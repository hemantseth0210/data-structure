package com.sethjava.oneaway;

/**
 * 1.5 - There are 3 types of edits that can be performed on strings: insert, remove, replace a char.
 * Given 2 strings, write a function to check if they are one edit (or zero edits) away
 */
//Time complexity : O(n). where N is length of shorter string.
public class OneAway
{
    private static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length())
            return replace(first, second);
        else if (first.length() + 1 == second.length())
            return insert(first, second);
        else if (first.length() == second.length() + 1)
            return insert(second, first);
        return false;
    }

    private static boolean replace(String first, String second) {
        boolean isOneReplace = false;
        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) != second.charAt(i)){
                if(isOneReplace){
                    return false;
                }
                isOneReplace = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into first to make second */
    private static boolean insert(String first, String second) {
        int index1 = 0, index2 = 0;
        while(index1 < first.length() && index2 < second.length()){
            if(first.charAt(index1) != second.charAt(index2)){
                if(index1 != index2)
                    return false;
                index2++;
            }else{
                index1++;
                index2++;
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
