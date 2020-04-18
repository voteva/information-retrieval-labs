package irs.labs.search;

import java.util.HashMap;
import java.util.Map;

public class FiniteStateAutomatonAlgorithm
        implements Searchable {

    @Override
    public boolean contains(String string, String substring) {
        if (string == null || substring == null || string.length() < substring.length()) {
            return false;
        }

        Map<Integer, Integer> letters = new HashMap<>();

        int nb = (int) substring.chars().distinct().count();
        int[] lettersArray = substring.chars().distinct().sorted().toArray();
        for (int i = 0; i < lettersArray.length; i++) {
            letters.put(lettersArray[i], i);
        }

        int finalState = substring.length();
        int[][] states = new int[finalState + 1][nb];

        for (int line = 0; line <= finalState; line++) {
            for (int column = 0; column < nb; column++) {

                String subTry = substring.substring(0, line) + (char) lettersArray[column];
                int posLastLetter = Math.min(line + 1, finalState);

                String subPattern = substring.substring(0, posLastLetter);
                while (!isSuffix(subPattern, subTry)) {
                    subPattern = substring.substring(0, --posLastLetter);
                }

                states[line][column] = posLastLetter;
            }
        }


        int q = 0;
        for (int i = 0; i < string.length(); i++) {
            Integer index = letters.get((int) string.charAt(i));
            if (index != null) {
                q = states[q][index];
                if (q == substring.length()) {
                    return true;
                }
            } else {
                q = 0;
            }
        }

        return false;
    }

    private boolean isSuffix(String str1, String str2) {
        return str1.length() <= str2.length() &&
                str2.substring(str2.length() - str1.length()).equals(str1);
    }
}
