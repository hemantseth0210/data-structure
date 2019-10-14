package com.sethjava.palindrome;

// This algorithm takes O(N) time where N is length of the String
// It treats the lower and upper character as same. It doesn't special symbols such as @, ! etc.
//Space complexity : O(1). A table of constant size(26) is used.
public class PalindromePermutationUsingArraySolution1
{
    static boolean isPalindromePermutation(String word){
        int [] countArray = buildCharFrequencyArray(word);
        return checkMaxOneOdd(countArray);
    }

    private static boolean checkMaxOneOdd(int[] countArray) {
        boolean foundOdd = false;
        for(int count : countArray){
            if (count % 2 == 1){
                if(foundOdd)
                    return false;
                foundOdd = true;
            }
        }
        return true;
    }

    private static int[] buildCharFrequencyArray(String word) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(char character : word.toCharArray()){
            int x = getCharNumber(character);
            if(x != -1)
                table[x]++;
        }
        return table;
    }

    private static int getCharNumber(char character) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');

        int val = Character.getNumericValue(character);
        if( a <= val && val <= z)
            return val - a;
        else if (A <= val && val <= Z)
            return val - A;
        return -1;
    }

    public static void main( String[] args )
    {

        String word = "Tact Coa";
        boolean isPalindrome = isPalindromePermutation(word);
        if(isPalindrome)
            System.out.println("Yes, "+ word + " is a Palindrome Permutation.");
        else
            System.out.println("No, "+ word + " is not a Palindrome Permutation.");
    }
}
