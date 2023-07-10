package UI;

import java.util.HashMap;

public class RentalMenu extends Menus {

    private HashMap<String, Runnable> operations;

    public RentalMenu(){
        operations = new HashMap<>();
        operations.put("Add Rental", this::addRental);
        operations.put("Modify Rental", this::modifyRental);
        operations.put("Delete Rental", this::deleteRental);
    }

    private void addRental(){}

    private void modifyRental(){}

    private void deleteRental(){}

    public HashMap<String, Runnable> getOperations() {
        return operations;
    }

}
