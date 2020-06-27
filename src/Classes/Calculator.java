package Classes;

public class Calculator {
    private double BMI;
    Person person;

    public Calculator(Person person){
        this.person = person;
    }

    public void calculate_BMI(){

        BMI =  ((person.getWeight() * 703.0) /( (person.getHeight() * person.getHeight() )));

    }

    public double getBMI() {
        return BMI;
    }
}
