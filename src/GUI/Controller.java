package GUI;

import Classes.Calculator;
import Classes.Person;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button back;
    Person person = new Person();
        Calculator calculator = new Calculator(person);

    public TextField name;
    public TextField age;
    public TextField weight;
    public TextField height;
    public ComboBox gender;
    public Label results_name;
    public Label results_age;
    public Label results_weight;
    public Label results_height;
    public Label results_gender;
    public Label results_bmi;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
        gender.getItems().addAll(
                "Male",
                "Female",
                "Unspecified"
        );}
        catch (Exception ex){
            System.out.println(ex);
        }


    }

    public void onSubmit(){
        Stage stage ;
        try {
            person.setName(name.getText());
            person.setAge(Integer.parseInt(age.getText()));
            person.setGender((String)gender.getValue());
            person.setWeight(Double.parseDouble(weight.getText()));
            person.setHeight(Double.parseDouble(height.getText()));


            calculator.calculate_BMI();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Results.fxml"));
            Parent root = loader.load();


            //Get controller of scene2
            Results scene2Controller = loader.getController();
            //Pass whatever data you want. You can have multiple method calls here
            scene2Controller.transferMessages(person.getName() , Integer.toString(person.getAge()) , Double.toString(person.getWeight()), Double.toString(person.getHeight()),person.getGender(),Double.toString(calculator.getBMI()));


            stage = (Stage) name.getScene().getWindow();
            stage.setScene(new Scene(root, 484, 484));

        }
        catch (Exception ex){
            ex.printStackTrace();
        }



    }



}
