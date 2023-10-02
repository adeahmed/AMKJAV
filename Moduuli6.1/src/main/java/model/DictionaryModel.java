package model;

import java.util.HashMap;

public class DictionaryModel {
    private HashMap<String, String> dictionary = new HashMap<>();

    public void addWord(String word, String translation) {
        dictionary.put(word, translation);
    }

    public String translate(String word) {
        return dictionary.get(word);
    }

    public String searchWord(String word) {
        if (dictionary.containsKey(word)) {
            return word + " = " + dictionary.get(word);
        } else {
            return "Word not found";
        }
    }

}