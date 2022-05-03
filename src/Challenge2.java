import java.util.HashMap;

public class Challenge2 {
    /**
     * Find the character that has the highest number
     * of occurrences within a certain string
     * @param input A string consist by several characters with different cases
     * @return The character that appeared most in the String
     */

    // invalid input
    private static char findHighestOccurrence (String input){
        // Uniform cases
        input = input.toUpperCase();

        // Boundary cases: input is empty
        if (input.length() <= 0) return ' ';

        // Input length is one; Return itself if its a letter
        char check = input.charAt(0);
        if (input.length() == 1){
            if (65 <= check && check <= 90) return input.charAt(0);
            else return ' ';
        }

        // Store each char occurrence and current highest occurrence char
        int[] occurrence = new int[26];
        int localMaxOcr = -1;
        char localMaxOcrChar = ' ';

        // Store each letter first occurrence position
        int[] ocrPosition = new int[26];

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (65 <= currentChar && currentChar <= 90){
                int currentOcr = occurrence[currentChar - 65];
                // Check whether current char is first appearance
                if (currentOcr == 0) ocrPosition[currentChar - 65] = i;

                occurrence[currentChar - 65] = currentOcr + 1;

                // Update when current letter has higher occurrence
                if (currentOcr > localMaxOcr){
                    localMaxOcr = currentOcr;
                    localMaxOcrChar = currentChar;

                // If two letter has same occurrence, choose the first appeared one
                }if (currentOcr == localMaxOcr){
                    int currentCharPos = ocrPosition[currentChar - 65];
                    int localMaxCharPos = ocrPosition[localMaxOcrChar - 65];
                    localMaxOcrChar = currentCharPos > localMaxCharPos ? localMaxOcrChar : currentChar;
                }
            }
        }

        // Consider non of char in input are letters
        if (localMaxOcr == -1) return ' ';
        else return localMaxOcrChar;
    }


}
