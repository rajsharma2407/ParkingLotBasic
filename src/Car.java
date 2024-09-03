public class Car {
    private String number;
    private String colour;
    public Car(String number, String colour){
        this.number = number;
        this.colour = colour;
    }

    String getNumber(){
        return this.number;
    }
    String getColour(){
        return this.colour;
    }
}
