package org.rastakiki.stringindexkata;

public class StringIndex {

    public int[] index(String input) {
        if (input == null || input.equals("")) {
            return new int[]{};
        }

        int[] inexValue = new int[input.length()];
        inexValue[0] = -1;

        if (input.length() > 2) {
            inexValue[1] = 0;
            for (int i = 2; i < input.length(); i++) {
                int previousCharIndex = i - 1;
                if (input.charAt(previousCharIndex) == input.charAt(inexValue[previousCharIndex])) {
                    inexValue[i] = 1 + inexValue[previousCharIndex];
                }
            }
        }
        return inexValue;
    }

}
