package com.sethjava.palindrome;

// This is an alternate solution but not optimal solution
// Time complexity : O(n). This algorithm takes O(N) time where N is length of the String
//Space complexity : O(1). A table of constant size(26) is used.
public class PalindromePermutationUsingArraySinglePass
{
    static boolean isPalindromePermutation(String word){
        return buildCharFrequencyArray(word);
    }

   private static boolean buildCharFrequencyArray(String word) {
       int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
       int countOdd = 0;
       for(char character : word.toCharArray()){
            int x = getCharNumber(character);
            if(x != -1) {
                table[x]++;
                if(table[x] % 2 == 1){
                    countOdd++;
                }else{
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
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
        String word = "sadfsaf";
        boolean isPalindrome = isPalindromePermutation(word);
        if(isPalindrome)
            System.out.println("Yes, "+ word + " is a Palindrome Permutation.");
        else
            System.out.println("No, "+ word + " is not a Palindrome Permutation.");

    }
}
