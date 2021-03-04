package pramp;

/**
 * https://www.pramp.com/challenge/KvZ3aL35Ezc5K9Eq9Llp
 * */
public class BasicRegexParser {
    static boolean isMatch(String text, String pattern, int i, int j) {
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
        if (i >= text.length()) {
            //text index too long
            if (j >= pattern.length()) {
                //both are done so true
                return true;
            } else {
                //pattern not over
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    //pattern * skip
                    return isMatch(text, pattern, i, j + 2);
                } else {
                    //no match
                    return false;
                }
            }
        } else if (j >= pattern.length()) {
            return false;
        } else if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            //check if pattern previous is a match
            if (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i)) {
                //is a match
                //return isMatch(text, pattern, i + 1, j);
                return (isMatch(text, pattern, i, j + 2) || isMatch(text, pattern, i + 1, j));
            } else {
                //no match, skip pattern *
                return isMatch(text, pattern, i, j + 1);
            }
        } else if (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i)) {
            //wildcard or match
            return isMatch(text, pattern, i + 1, j + 1);
        } else {
            //no match or wildcard or *
            return false;
        }
    }

    static boolean isMatch(String text, String pattern) {
        return isMatch(text, pattern, 0, 0);
    }

    static boolean isMatchIterative(String text, String pattern) {
        if (text == null || pattern == null) {
            return false;
        }
        if (text.isEmpty() && pattern.isEmpty()) {
            return true;
        }
        if (text.equals(pattern)) {
            return true;
        }
        int i = 0;
        int j = 0;
        while (i < text.length()) {
            if (j >= pattern.length()) {
                return false;
            }
            char t = text.charAt(i);
            char p = pattern.charAt(j);
            if (t == p) {
                i++;
                j++;
            } else {
                if (p == '.') {
                    i++;
                    j++;
                } else if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    j += 2;
                } else if (p == '*'){
                    if (j - 1 > 0 && pattern.charAt(j - 1) == t) {
                        i++;
                    } else {
                        j++;
                        //this is for the case text="abaa", pattern="a.*a*"
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Recursive");
        System.out.println("Expected: true, Actual: " + isMatch("", ""));
        System.out.println("Expected: false, Actual:  " + isMatch("aa", "a"));
        System.out.println("Expected: true, Actual:  " + isMatch("bb", "bb"));
        System.out.println("Expected: true, Actual:  " + isMatch("", "a*"));
        System.out.println("Expected: false, Actual:  " + isMatch("abbdbb", "ab*d"));
        System.out.println("Expected: true, Actual:  " + isMatch("aba", "a.a"));
        System.out.println("Expected: true, Actual:  " + isMatch("acd", "ab*c."));
        System.out.println("Expected: true, Actual:  " + isMatch("abaa", "a.*a*"));

        System.out.println("Iterative");
        System.out.println("Expected: true, Actual: " + isMatchIterative("", ""));
        System.out.println("Expected: false, Actual:  " + isMatchIterative("aa", "a"));
        System.out.println("Expected: true, Actual:  " + isMatchIterative("bb", "bb"));
        System.out.println("Expected: true, Actual:  " + isMatchIterative("", "a*"));
        System.out.println("Expected: false, Actual:  " + isMatchIterative("abbdbb", "ab*d"));
        System.out.println("Expected: true, Actual:  " + isMatchIterative("aba", "a.a"));
        System.out.println("Expected: true, Actual:  " + isMatchIterative("acd", "ab*c."));
        System.out.println("Expected: true, Actual:  " + isMatchIterative("abaa", "a.*a*"));
    }
}
