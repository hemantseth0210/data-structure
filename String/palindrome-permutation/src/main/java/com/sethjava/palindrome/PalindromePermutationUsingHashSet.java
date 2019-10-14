package com.sethjava.palindrome;

import java.util.HashSet;
import java.util.Set;

//Time complexity : O(n). We traverse over the string of length N once only.
//Space complexity : O(n). The sett can grow upto a maximum size of N in case of all distinct elements.
// ArrayList or Hashmap can also be used to implement the same logic.
// It treats the lower and upper character as different. It also works for special symbols such as @, ! etc.
public class PalindromePermutationUsingHashSet {

    // For each character in input strings, remove character if set contains else add character to set
    private static boolean isPalindromePermutation(String word){
        Set<Character> characterSet = new HashSet<>();
        for(int i = 0; i < word.length(); i++){
            if(!characterSet.add(word.charAt(i))){
                characterSet.remove((Character) word.charAt(i));
            }
        }
        // if character length is even Set is expected to be empty
        // or if character length is odd list size is expected to be 1
        return characterSet.size() <= 1;
    }

    public static void main(String[] args) {
        String word = "tactcoa";
        boolean isPalindrome = isPalindromePermutation(word);
        if(isPalindrome)
            System.out.println("Yes, "+ word + " is a Palindrome Permutation.");
        else
            System.out.println("No, "+ word + " is not a Palindrome Permutation.");
    }

}
