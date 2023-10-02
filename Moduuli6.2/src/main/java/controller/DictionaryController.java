package controller;
import model.DictionaryModel;
import view.DictionaryView;



    public class DictionaryController {
        private DictionaryView view;
        private DictionaryModel model = new DictionaryModel();

        public DictionaryController(DictionaryView view) {
            this.view = view;
        }

        public void convert(double amount, String from, String to) {
            double result = model.convert(amount, from, to);
            view.convertAnswer(model.format(result, to));
        }

        public static void main(String[] args) {
            DictionaryView.launch(DictionaryView.class);
        }
    }


