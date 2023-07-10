package UI;

import DatabaseConnect.Pairs;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerMenu extends Menus {
    private HashMap<String, Runnable> operations;
    private Scanner sc = new Scanner(System.in);

    public CustomerMenu(){
        operations = new HashMap<>();
        operations.put("Add Customer", this::addCustomer);
        operations.put("Modify Customer", this::modifyCustomer);
        operations.put("Delete Customer", this::deleteCustomer);
        operations.put("Display Purchase History", this::displayPurchaseHistory);
        operations.put("Display Overdue Fees", this::displayOverdueFees);
        operations.put("Return To Main Menu", this::mainMenu);

    }

    private void addCustomer(){
        String name = inputStr("Name: ");
        String phoneNumber = inputStr("Phone Number: ");
        String dob = inputStr("Date Of Birth: ");
        String address = inputStr("Address: ");

        String[] addressComponents = address.split(",");
        String houseNumber = addressComponents[0];
        String street = addressComponents[1];
        String town = addressComponents[2];
        String county = addressComponents[3];
        String postcode = addressComponents[4];

        String values = String.format("HouseNo = %s AND Street = '%s' AND Town = '%s' AND County = '%s' AND PostCode = '%s'", houseNumber, street, town, county, postcode);
        if (database.select("CustomerAddress", "AddressID", values).isEmpty()){
            database.insert("CustomerAddress",
                    new Pairs<>("HouseNo", houseNumber),
                    new Pairs<>("Street", String.format("'%s'", street)),
                    new Pairs<>("Town", String.format("'%s'", town)),
                    new Pairs<>("County", String.format("'%s'", county)),
                    new Pairs<>("PostCode", String.format("'%s'", postcode)));
        }
        database.insert("Customer",
                new Pairs<>("CustomerName", String.format("'%s'",name)),
                new Pairs<>("PhoneNumber", String.format( "'%s'", phoneNumber)),
                new Pairs<>("DateOfBirth", dob),
                new Pairs<>("CustomerAddressID", database.select("CustomerAddress", "AddressID", values).get(0).get(0)));
    }

    private void modifyCustomer(){

    }

    private void deleteCustomer(){

    }

    private void displayPurchaseHistory(){

    }

    private void displayOverdueFees(){

    }

    private void mainMenu(){
        for(int i = 0; i < 25; i++){
            System.out.println();
        }
    }

    public HashMap<String, Runnable> getOperations() {
        return operations;
    }
}
