package GUI;

import Classes.Spreadsheet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Results {

    public Label results_name;
    public Label results_age;
    public Label results_weight;
    public Label results_height;
    public Label results_gender;
    public Label results_bmi;
    Spreadsheet spreadsheet = new Spreadsheet();
    public void transferMessages(String Name , String Age , String Weight , String Height , String Gender , String BMI) {

            results_name.setText(Name);
            results_age.setText(Age);
            results_weight.setText(Weight);
            results_height.setText(Height);
            results_gender.setText(Gender);
            results_bmi.setText(BMI);

            spreadsheet.writingCSVFile( Name , Age ,  Weight ,  Height , Gender ,  BMI);

    }


    public void onBack() throws IOException {
        Stage stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        stage = (Stage) results_name.getScene().getWindow();
        stage.setScene(new Scene(root, 484, 484));

    }

}
