package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ObservableList<ToDoItem> items = FXCollections.observableArrayList(); //method found in documentation

    @FXML
    TextField textField; //defines the textfield from the image box as textfield (variable name)

    @FXML
    ListView listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(items); //list is where we tell it to use items.
    }

    public void addItem() {
        ToDoItem item = new ToDoItem(textField.getText(), false);
        items.add(item); //calling the add method and passing in what we want to add
        textField.setText(""); //sets textField to a blank string "clears it" after we add an item
    }
I
    public void toggleItem() { //toggleitem method
        ToDoItem item = (ToDoItem) listView.getSelectionModel().getSelectedItem();
        if (item != null) {
            item.isDone = !item.isDone;

            //forcing listView to refresh
            listView.setItems(null);
            listView.setItems(items);
        }
    }
}
