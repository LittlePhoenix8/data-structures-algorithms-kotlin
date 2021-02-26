package pramp;

/**
 * https://www.pramp.com/challenge/KvZ3aL35Ezc5K9Eq9Llp
 * */
public class BasicRegexParser {
    static boolean isMatch(String text, String pattern, int indexText, int indexPattern) {
        if(text == null) {
            return false;
        }
        if(pattern == null) {
            return false;
        }
        if(text.isEmpty() && pattern.isEmpty()) {
            return true;
        }
        if(text.equals(pattern)) {
            return true;
        }
        if (indexText >= text.length()) {
            //text index too long
            if (indexPattern >= pattern.length()) {
                //both are done so true
                return true;
            } else {
                //pattern not over
                if (indexPattern + 1 < pattern.length() && pattern.charAt(indexPattern + 1) == '*') {
                    //pattern * skip
                    return isMatch(text, pattern, indexText, indexPattern + 2);
                } else {
                    //no match
                    return false;
                }
            }
        } else if (indexPattern >= pattern.length()) {
            return false;
        } else if (indexPattern + 1 < pattern.length() && pattern.charAt(indexPattern + 1) == '*') {
            //check if pattern previous is a match
            if (pattern.charAt(indexPattern) == '.' || pattern.charAt(indexPattern) == text.charAt(indexText)) {
                //is a match
                //return isMatch(text, pattern, indexText + 1, indexPattern);
                return (isMatch(text, pattern, indexText, indexPattern + 2) || isMatch(text, pattern, indexText + 1, indexPattern));
            } else {
                //no match, skip pattern *
                return isMatch(text, pattern, indexText, indexPattern + 1);
            }
        } else if (pattern.charAt(indexPattern) == '.' || pattern.charAt(indexPattern) == text.charAt(indexText)) {
            //wildcard or match
            return isMatch(text, pattern, indexText + 1, indexPattern + 1);
        } else {
            //no match or wildcard or *
            return false;
        }
    }

    static boolean isMatch(String text, String pattern) {
        return isMatch(text, pattern, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println("Expected: true, Actual: " + isMatch("", ""));
        System.out.println("Expected: false, Actual:  " + isMatch("aa", "a"));
        System.out.println("Expected: true, Actual:  " + isMatch("bb", "bb"));
        System.out.println("Expected: true, Actual:  " + isMatch("", "a*"));
        System.out.println("Expected: false, Actual:  " + isMatch("abbdbb", "ab*d"));
        System.out.println("Expected: true, Actual:  " + isMatch("aba", "a.a"));
        System.out.println("Expected: true, Actual:  " + isMatch("acd", "ab*c."));
        System.out.println("Expected: true, Actual:  " + isMatch("abaa", "a.*a*"));
    }
}
