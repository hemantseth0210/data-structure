package com.sethjava.palindrome;

// This algorithm takes O(N) time where N is length of the String
/**
 * Use a single integer (as a bit vector) - when we see a letter, we map it to an
 * integer between 0 and 25 (assuming an English alphabet). Then we toggle the
 * bit at that value. At the end of the iteration, we check that at most one bit
 * in the ingeger is set to
 */
public class PalindromePermutationUsingBitVector
{
    static boolean isPalindromePermutation(String word){
        int bitVector = createBitVector(word);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    /* Create a bit vector for the string. For each letter with value i, toggle the ith bit. */
    private static int createBitVector(String word) {
        int bitVector = 0;
        for (char c : word.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, int index) {
        if (index < 0)	return bitVector;
        int mask = 1 << index;
        if((bitVector & mask) == 0)
            bitVector |= mask;
        else
            bitVector &= ~mask;
        return bitVector;
    }

    /* Check that exactly one bit is set by subtracting one from the integer and ANDing it with the original integer */
    static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector-1)) == 0;
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
