package UI;

import java.util.HashMap;

public class MovieMenu extends Menus {

    private HashMap<String, Runnable> operations;

    public MovieMenu(){
        operations = new HashMap<>();
        operations.put("Add Movie", this::addMovie);
        operations.put("Modify Movie", this::modifyMovie);
        operations.put("Delete Movie", this::deleteMovie);
    }

    private void addMovie(){}
    private void modifyMovie(){}
    private void deleteMovie(){}


    public HashMap<String, Runnable> getOperations() {
        return operations;
    }

}
