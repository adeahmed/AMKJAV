package Week6.JavaFx;


public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
        // You can add initial words and meanings here using dictionary.addWord(...)
    }

    public String searchWord(String word) {
        return dictionary.searchWord(word);
    }
}
