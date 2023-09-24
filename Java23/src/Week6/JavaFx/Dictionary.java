package Week6.JavaFx;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> wordMeanings;

    public Dictionary() {
        wordMeanings = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        wordMeanings.put(word, meaning);
    }

    public String searchWord(String word) {
        return wordMeanings.getOrDefault(word, "Word not found in the dictionary.");
    }
}

