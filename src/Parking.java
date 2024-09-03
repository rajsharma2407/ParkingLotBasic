import java.util.*;
import java.util.stream.IntStream;

public class Parking {
    private int n;
    List<Car> slots;
    Queue<Integer> pq = new PriorityQueue<>();;
    HashMap<String, ArrayList<Car>> carUsingColourCode = new HashMap();
    HashMap<String, ArrayList<String>> slotUsingColourCode = new HashMap();
    HashMap<String, String> carSlotUsingRegNumber = new HashMap<>();

   public Parking(int n){
        this.n = n;
        this.slots = new ArrayList<>(n);
        IntStream.rangeClosed(1, n+1)
                .forEach(pq::add);
    }

    void setCarUsingColourCode(Car car){
        String colour = car.getColour().toLowerCase();
        ArrayList<Car> lst;
        if(carUsingColourCode.containsKey(colour)){
            lst = carUsingColourCode.get(colour);
        }else{
            lst = new ArrayList<>();
        }
        lst.add(car);
        carUsingColourCode.put(colour, lst);
    }

    void setCarSlotUsingColourOrNumber(Car car, String slot){
        ArrayList<String> lst;
        String number = car.getNumber();
        String colour = car.getColour().toLowerCase();
        if(slotUsingColourCode.containsKey(colour)){
            lst = slotUsingColourCode.get(colour);
        }else{
            lst = new ArrayList<>();
        }
        lst.add(slot);
        slotUsingColourCode.put(colour, lst);

        if(carSlotUsingRegNumber.containsKey(slot)){
            System.out.println("Car is already parked with this R no");
        }
        carSlotUsingRegNumber.put(number, slot);
    }

    List<Car> getCarUsingColourCode(String colour){
        return carUsingColourCode.containsKey(colour) ? carUsingColourCode.get(colour) : new ArrayList<>();
    }

    String getCarSlotUsingRegNumber(String colour){
        return carSlotUsingRegNumber.containsKey(colour) ? carSlotUsingRegNumber.get(colour) : "No Car with this R No";
    }

    List<String> getSlotUsingColourCode(String colour){
        return slotUsingColourCode.containsKey(colour) ? slotUsingColourCode.get(colour) : new ArrayList<>();
    }

    void park(Car car){
        Integer slot = pq.poll();
        if(slot == null){
            System.out.println("Slot full");
            return;
        }
        slots.set(slot, car);
        setCarUsingColourCode(car);
        setCarSlotUsingColourOrNumber(car, slot.toString());
    }

//    void unPark(String key, String value){
//
//    }

}
