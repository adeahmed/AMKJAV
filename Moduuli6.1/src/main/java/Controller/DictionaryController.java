package Controller;

import Model.DictionaryModel;
import View.DictionaryView;

public class DictionaryController {
    private DictionaryView model;
    private DictionaryModel ModelDictionary = new DictionaryModel();

    public DictionaryController(DictionaryView model) {
        this.model = model;
    }

    public void addWord(String word, String translation) {
        ModelDictionary.addWord(word, translation);
    }

    public String searchWord(String word) {
        return ModelDictionary.searchWord(word);
    }

    public static void main(String[] args) {
        DictionaryView.launch(DictionaryView.class);
    }
}