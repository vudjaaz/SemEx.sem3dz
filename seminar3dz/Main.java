package seminar3dz;

import seminar3dz.service.DataService;

public class Main {
    public static void main(String[] args) {
        DataService service = new DataService();
        service.createUser();
    }
}