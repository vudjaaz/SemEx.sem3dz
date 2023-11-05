package seminar3dz.service;

import seminar3dz.model.*;

import java.io.*;

public class WriteUserData {
    User user;
    File file;

    public WriteUserData(User user) {
        this.user = user;
        this.file = new File(String.format("%s.txt", user.getFirstName()));
    }
    public void writeFile() throws IOException {
        try(FileWriter writer = new FileWriter(file, true)){
            if(file.createNewFile()){
                System.out.println("Файл создан");
            }
            writer.write(user.toString() + "\n");
            writer.flush();
            System.out.println("Ваши данные сохранены.");
        } catch (IOException e){
            System.out.println(e.getMessage());

        }
    }
}