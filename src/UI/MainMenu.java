package UI;

import java.util.HashMap;

public class MainMenu extends Menus {
    HashMap<String, Runnable> operations;

    public MainMenu(){
        operations = new HashMap<>();
        while (true){
            operations.put("Customer Maintenance", this::customerMaintenance);
            operations.put("Movie Maintenance", this::movieMaintenance);
            operations.put("Download Maintenance", this::downloadMaintenance);
            operations.put("Rental Maintenance", this::rentalMaintenance);
            operations.put("Display Overdue Fees", this::overdueFee);
            operations.put("Exit", this::exit);
            displayMenu(operations);
        }
    }



    private void customerMaintenance(){
        CustomerMenu customer = new CustomerMenu();
        displayMenu(customer.getOperations());
    }
    private void movieMaintenance(){
        MovieMenu movie = new MovieMenu();
        displayMenu(movie.getOperations());
    }
    private void downloadMaintenance(){
        DownloadMenu download = new DownloadMenu();
        displayMenu(download.getOperations());
    }
    private void rentalMaintenance(){
        RentalMenu rental = new RentalMenu();
        displayMenu(rental.getOperations());
    }
    private void overdueFee(){
        System.out.println("overdue");
    }

    private void exit(){
        System.exit(0);
    }

    public HashMap<String, Runnable> getOperations() {
        return operations;
    }
}
