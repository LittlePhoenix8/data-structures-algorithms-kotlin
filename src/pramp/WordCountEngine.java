package pramp;

import java.util.*;

public class WordCountEngine {
    /*static String[][] wordCountEngine(String document) {
        Map<String, Integer> wordMap = new HashMap<>();
        String [] wordList = document.toLowerCase().split(" ");
        int largestCount = 0;

        for (String s : wordList) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    stringBuilder.append(c);
                }
            }
            String cleanWord = stringBuilder.toString().trim();
            if (!cleanWord.isEmpty()) {
                int count = 1;
                if (wordMap.containsKey(cleanWord)) {
                    count = wordMap.get(cleanWord);
                    count++;
                }
                if (count > largestCount) {
                    largestCount = count;
                }
                wordMap.put(cleanWord, count);
            }
        }

        ArrayList<ArrayList<String>> counterList = new ArrayList<>();
        for (int j = 0; j < largestCount + 1; j++) {
            counterList.add(new ArrayList<>());
        }

        for (String word : wordMap.keySet()) {
            int counter = wordMap.get(word);
            counterList.get(counter).add(word);
        }
        String[][] output = new String[wordMap.size()][2];
        int k = 0;
        for (int i = counterList.size() - 1; i >= 0; i--) {
            ArrayList<String> wordCounterList = counterList.get(i);
            if (wordCounterList != null) {
                for (String s : wordCounterList) {
                    output[k] = new String[] { s, Integer.toString(i) };
                    k++;
                }
            }
        }
        return output;
    }*/

    static String[][] wordCountEngine(String document) {
        String[] words = removePunctuation(document.toLowerCase());

        Map<String, int[]> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
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

        PriorityQueue<Map.Entry<String, int[]>> queue = new PriorityQueue<>((a, b) ->
                (b.getValue()[0] == a.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : b.getValue()[0] - a.getValue()[0]));
        for(Map.Entry<String, int[]> entry : map.entrySet()){
            queue.offer(entry);
        }

        String[][] output = new String[map.size()][2];
        int j = 0;
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
        printOutput(wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!"));
        printOutput(wordCountEngine("Practice makes perfect, you'll get perfecT by practice. just practice! just just just!!"));
        printOutput(wordCountEngine("To be, or not to be, that is the question:"));
        printOutput(wordCountEngine("Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. "));
        printOutput(wordCountEngine("I have failed over and over and over again in my life and that is why I succeed."));
        printOutput(wordCountEngine("Look If you had One shot, Or one opportunity, To seize everything you ever wanted, In one moment, Would you capture it, Or just let it slip?"));
        printOutput(wordCountEngine("Cause I'm Slim Shady, yes I'm the real Shady, All you other Slim Shadys are just imitating So won't the real Slim Shady, please stand up, Please stand up, Please stand up"));
    }
}
