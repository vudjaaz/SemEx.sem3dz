package seminar3dz.service;

import seminar3dz.model.*;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


public class DataService {

    static Scanner scanner = new Scanner(System.in);
    MakeRequestToUser request;
    CheckAnswer checkAnswer;
    boolean stage;

    public DataService() {
        this.request = new MakeRequestToUser(scanner);
        this.stage = true;
    }

    /**
     * Проверяет данные пользователя по всем критериям соответствия, записывает данные в файл
     * @throws AssertionError Данные не могут быть записаны, т.к. некорректное значение имени!
     */
    public void createUser(){
        while(stage){
            try {
                checkAnswer = new CheckAnswer(request.getMakeUserAnswer());
                stage = checkAnswer.parseUserAnswerToQuit();
                String name = checkAnswer.parseUserAnswerToName();
                Date birthDate = checkAnswer.parseUserAnswerToBirthDate();
                Long telNumber = checkAnswer.parseUserAnswerToTelNumber();
                Character gender = checkAnswer.parseUserAnswerToGender();

                if (name == null) throw new AssertionError("Данные не могут быть записаны, т.к. некорректное значение имени!");

                WriteUserData writeUserData = new WriteUserData(new User(name, birthDate, telNumber, gender));
                writeUserData.writeFile();

            }
            catch(AssertionError e){
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}