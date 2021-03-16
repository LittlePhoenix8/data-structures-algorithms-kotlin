package pramp;

import java.util.*;

/**
 * https://www.pramp.com/challenge/W5EJq2Jld3t2ny9jyZXG
 * */
public class WordCountEngine {
    static String[][] wordCountEngine(String document) {
        Map<String, int[]> wordMap = new HashMap<>();
        String[] wordList = document.toLowerCase().split(" ");
        int largestCount = 0;

        for (int i = 0; i < wordList.length; i++) {
            //word in lowercase
            String word = wordList[i];
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : word.toCharArray()) {
                //remove punctuation characters
                if (ch >= 'a' && ch <= 'z') {
                    stringBuilder.append(ch);
                }
            }
            //create word without punctuation
            String cleanWord = stringBuilder.toString();
            if (cleanWord.isEmpty()) {
                //if word is empty skip it
                continue;
            }
            //save count & word position on the array
            int[] count;
            if (wordMap.containsKey(cleanWord)) {
                //if word exist increment count
                count = wordMap.get(cleanWord);
                count[0]++;
            } else {
                //if word doesn't exist add with count 1
                count = new int[2];
                count[0] = 1;
                count[1] = i;
            }
            if (count[0] > largestCount) {
                largestCount = count[0];
            }
            wordMap.put(cleanWord, count);
        }
        ArrayList<ArrayList<String[]>> counterList = new ArrayList<>(largestCount + 1);
        for (int i = 0; i < largestCount + 1; i++) {
            counterList.add(new ArrayList<>());
        }

        for (String word : wordMap.keySet()) {
            int[] counter = wordMap.get(word);
            counterList.get(counter[0]).add(new String[] { word, Integer.toString(counter[1]) });
        }
        String[][] result = new String[wordMap.size()][2];
        int r = 0;
        for (int i = counterList.size() - 1; i >= 0; i--) {
            ArrayList<String[]> wordCounterList = counterList.get(i);
            if (wordCounterList == null) {
                continue;
            }
            String occurrence = Integer.toString(i);
            if (wordCounterList.size() == 1) {
                String[] s = wordCounterList.get(0);
                result[r] = new String[]{s[0], occurrence};
                r++;
            } else {
                //if more thant 1 element, sort list by position on the original sentence
                wordCounterList.sort((a, b) -> Integer.valueOf(a[1]).compareTo(Integer.valueOf(b[1])));
                for (String[] s : wordCounterList) {
                    result[r] = new String[]{s[0], occurrence};
                    r++;
                }
            }
        }
        return result;
    }

    static String[][] wordCountEngineWithQueue(String document) {
        //O(n)
        String[] words = removePunctuation(document.toLowerCase());

        //O(n)
        Map<String, int[]> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                int[] list;
                if(map.containsKey(words[i])) {
                    list = map.get(words[i]);
                    list[0] = list[0] + 1;
                } else {
                    list = new int[2];
                    list[0] = 1;
                    list[1] = i;
                }
                map.put(words[i], list);
            }
        }

        //use a lambda as a comparator
        //when you poll the data you'll get the minor data according the position of [1] (on the sentence)
        PriorityQueue<Map.Entry<String, int[]>> queue = new PriorityQueue<>((a, b) ->
                (b.getValue()[0] == a.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : b.getValue()[0] - a.getValue()[0]));
        //if [0] are equal, take the value on [1] (position in the sentence) to compare and get the minor first
        //O(1)
        for(Map.Entry<String, int[]> entry : map.entrySet()){
            queue.offer(entry);
        }

        String[][] output = new String[map.size()][2];
        int j = 0;
        //0(1)
        while(!queue.isEmpty()) {
            Map.Entry<String, int[]> entry = queue.poll();
            output[j] = new String[] { entry.getKey(), Integer.toString(entry.getValue()[0]) };
            j++;
        }
        return output;
    }

    private static String[] removePunctuation(String document) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : document.toCharArray()) {
            if (Character.isLetter(letter) || letter == ' ') {
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString().trim().split(" ");
    }

    private static void printOutput(String[][] output) {
        for (String[] strings : output) {
            System.out.println(strings[0] + " " + strings[1]);
        }
        System.out.println("------");
    }

    public static void main(String[] args) {
        //printOutput(wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!"));
        //printOutput(wordCountEngine("Practice makes perfect, you'll get perfecT by practice. just practice! just just just!!"));
        //printOutput(wordCountEngine("To be, or not to be, that is the question:"));
        //printOutput(wordCountEngine("Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. "));
        printOutput(wordCountEngine("I have failed over and over and over again in my life and that is why I succeed."));
        printOutput(wordCountEngine("Look If you had One shot, Or one opportunity, To seize everything you ever wanted, In one moment, Would you capture it, Or just let it slip?"));
        printOutput(wordCountEngine("Cause I'm Slim Shady, yes I'm the real Shady, All you other Slim Shadys are just imitating So won't the real Slim Shady, please stand up, Please stand up, Please stand up"));
    }
}
