package com.sethjava.palindrome;

// Time complexity : O(N). This algorithm takes O(N) time where N is length of the String
//Space complexity : O(1). A table of constant size(256) is used.
// It treats the lower and upper character as different. It also works for special symbols such as @, ! etc.
public class PalindromePermutationUsingArraySolution2 {

    private static final int MAX_NO_OF_CHARS = 256;

    private static boolean isPalindromePermutation(String word){
        int [] countArr = buildCountArr(word);
        return checkOddOccurence(countArr);
    }

    // For each character in input strings, increment count in the corresponding count array
    private static int[] buildCountArr(String word){
        int [] countArr = new int[MAX_NO_OF_CHARS];
        for(int i=0; i < word.length(); i++){
            // Can also use Character.getNumericValue(word.charAt(i))
            //int character = Character.getNumericValue(word.charAt(i));
            int character = word.charAt(i);
            countArr[character]++;
        }
        return countArr;
    }

    // check the odd occurrence of characters
    private static boolean checkOddOccurence(int [] countArr){
        boolean isOdd = false;
        for(int count : countArr){
            if(count % 2 ==1){
                if(isOdd){
                    return false;
                }
                isOdd = true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String word = "Tact Coa";
        boolean isPalindrome = isPalindromePermutation(word);
        if(isPalindrome)
            System.out.println("Yes, "+ word + " is a Palindrome Permutation.");
        else
            System.out.println("No, "+ word + " is not a Palindrome Permutation.");
    }
}
