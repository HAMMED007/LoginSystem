package com.example.loginsytem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private Button button_register;
    @FXML
    private Button button_log_in;
    @FXML
    private RadioButton rb_microsoft;
    @FXML
    private RadioButton rb_oracle;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup toggleGroup = new ToggleGroup();
        rb_microsoft.setToggleGroup(toggleGroup);
        rb_oracle.setToggleGroup(toggleGroup);
        rb_microsoft.setSelected(true);
        button_register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
                if(!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()){
                    DButils.registerUser(event, tf_username.getText(),tf_password.getText(),toggleName);
                }else {
                    System.out.println("please fill in all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("field cannot be empty");
                    alert.show();
                }
            }
        });
        button_log_in.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DButils.changeScene(event, "sample.fxml","log in",null,null);
            }
        });
    }
}
