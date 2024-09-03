import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("This is a console based application and it only accept a filename");
            return;
        }
        String filename = args[0];
        Path path = Paths.get(filename);
        try{
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            Parking parking = null;
            for(String line: lines){
                String[] task = line.split(" ");
                if(task.length == 0) continue;
                System.out.println(line);
                switch(task[0]){
                    case "slots":
                        parking = new Parking(Integer.parseInt(task[1]));
                        break;
                    case "park":
                        System.out.println(task[1]);
                        String number = task[1];
                        String colour = task[2];
                        Car car = new Car(number, colour);
                        parking.park(car);
                        System.out.println("Car is parked "+ car);
                        break;
                    case "find_all_reg_using_colour":
                        System.out.println(parking.getCarSlotUsingRegNumber(task[1]));
                        break;
                    case "find_all_slots_using_colour":
                        System.out.println(parking.getSlotUsingColourCode(task[1]));
                        break;
                    case "find_all_car_using_colour":
                        System.out.println(parking.getCarUsingColourCode(task[1]));
                        break;
                    default:
                        System.out.println("No Invalid");
                        break;
                }
            }
        }catch (Exception err){
            System.out.println("An error occured "+err);
        }
    }
}