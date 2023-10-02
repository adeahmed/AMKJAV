package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Note;
import model.Notebook;


public class NoteController {
    @FXML
    private TextArea noteTextArea;

    @FXML
    private TextField titleTextField;

    @FXML
    private Button addButton;

    @FXML
    private Text noteDisplayText;

    private Notebook notebook = new Notebook();

    @FXML
    void addNote(ActionEvent event) {
        String title = titleTextField.getText();
        String content = noteTextArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(title, content);
            notebook.addNote(note);
            displayNotes();
            // Clear input fields
            titleTextField.clear();
            noteTextArea.clear();
        }
    }

    private void displayNotes() {
        StringBuilder sb = new StringBuilder();
        for (Note note : notebook.getNotes()) {
            sb.append("Title: ").append(note.getTitle()).append("\n");
            sb.append("Content: ").append(note.getContent()).append("\n\n");
        }
        noteDisplayText.setText(sb.toString());
    }
}
