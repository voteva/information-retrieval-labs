package irs.labs.search;

public class KnutMorrisPrattAlgorithm
        implements Searchable {

    @Override
    public boolean contains(String string, String substring) {
        if (string == null || substring == null || string.length() < substring.length()) {
            return false;
        }

        int[] pfl = pfl(substring);
        int substrIndex = 0;

        for (int i = 0; i < string.length(); ++i) {
            while (substring.charAt(substrIndex) != string.charAt(i) && substrIndex > 0) {
                substrIndex = pfl[substrIndex - 1];
            }

            if (substring.charAt(substrIndex) == string.charAt(i)) {
                substrIndex = substrIndex + 1;
                if (substrIndex == substring.length()) {
                    return true;
                }
            } else {
                substrIndex = 0;
            }
        }

        return false;
    }

    public int[] pfl(String str) {
        int[] pfl = new int[str.length()];
        pfl[0] = 0;

        for (int i = 1; i < str.length(); ++i) {
            int substrIndex = pfl[i - 1];
            while (str.charAt(substrIndex) != str.charAt(i) && substrIndex > 0) {
                substrIndex = pfl[substrIndex - 1];
            }
            if (str.charAt(substrIndex) == str.charAt(i)) {
                pfl[i] = substrIndex + 1;
            } else {
                pfl[i] = 0;
            }
        }

        return pfl;
    }
}
