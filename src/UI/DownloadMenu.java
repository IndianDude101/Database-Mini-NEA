package UI;

import java.util.HashMap;

public class DownloadMenu extends Menus {
    private HashMap<String, Runnable> operations;

    public DownloadMenu(){
        operations = new HashMap<>();
        operations.put("Add Download", this::addDownload);
        operations.put("Modify Download", this::modifyDownload);
        operations.put("Delete Download", this::deleteDownload);
    }

    private void addDownload(){}

    private void modifyDownload(){}

    private void deleteDownload(){}

    public HashMap<String, Runnable> getOperations() {
        return operations;
    }


}
