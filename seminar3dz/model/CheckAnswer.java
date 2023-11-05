package seminar3dz.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CheckAnswer {

    String[] answerUserArray;
    UserAnswer answer;

    public CheckAnswer(UserAnswer answer) {
        this.answer = answer;
        this.answerUserArray = getAnswerUserArray();
    }

    /**
     * Преобразует строку с ответом пользователя в массив, проверяет количество данных
     * @return массив строк данных
     * @throws InsufficientDataException Недостаточно данных!
     * @throws ExtraInfoException Лишняя информация!
     */
    public String[] getAnswerUserArray() {
        try {
            answerUserArray = answer.getAnswer().split(" ");
            if (answerUserArray.length < 6) {
                throw new InsufficientDataException("Недостаточно данных!");
            }
            if (answerUserArray.length > 6) {
                throw new ExtraInfoException("Лишняя информация!");
            }
            return answerUserArray;
        } catch (InsufficientDataException | ExtraInfoException e) {
            System.out.println(e.getMessage());
        }
        return answerUserArray;
    }

    /**
     * Разбирает элементы массива с данными от пользователя на соответствие информации о поле
     * @return возвращает символ соответствующий полу или null, если нет соответствия
     * @throws ParseGenderException Отсутствует значение пола!
     */
    public Character parseUserAnswerToGender(){
        Character gender = null;
        try {
            for (String answer : this.answerUserArray) {
                if (answer.equals("w") || answer.equals("m")) {
                    gender = answer.charAt(0);
                }
            }
            if(gender == null){
                throw new ParseGenderException("Отсутствует значение пола!");
            } else {
                return gender;
            }
        }
        catch(ParseGenderException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /**
     * Разбирает элементы массива с данными от пользователя на соответствие информации о номере телефона
     * @return возвращает число соответствующее номеру телефона или null, если нет соответствия
     * @throws ParseTelNumberException некорректный номер телефона
     */
    public Long parseUserAnswerToTelNumber() throws ParseTelNumberException{
        Long telNumber = null;
        try{
            boolean res = true;
            for(String answer: this.answerUserArray) {
                res = answer.matches("\\d+");
                if (res) {
                    telNumber = Long.parseLong(answer);
                    return telNumber;
                }
            }
            if(!res){
                throw new ParseTelNumberException("Некорректный номер телефона!");
            }
            }
        catch (ParseTelNumberException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Разбирает элементы массива с данными от пользователя на соответствие информации о имени
     * @return возвращает строку соответствующее имени или null, если нет соответствия
     * @throws ParseNameException Некорректное значение имени!
     */
    public String parseUserAnswerToName(){
        StringBuilder name = new StringBuilder();
        try{
            boolean res = true;
            for (String s : this.answerUserArray) {
                res = s.matches("[a-zA-zА-Яа-я]+");
                if (res && s.length() > 1) {
                    name.append(s).append(" ");
                }
            }
            if(name.toString().split(" ").length != 3){
                throw new ParseNameException("Некорректное значение имени!");
            } else {
                return name.toString();
            }
        }
        catch (ParseNameException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    /**
     * Разбирает элементы массива с данными от пользователя на соответствие информации о дате рождения
     * @return возвращает дату или null, если нет соответствия
     * @throws ParseBirthDateException Некорректная дата дня рождения!
     */
    public Date parseUserAnswerToBirthDate() {
        Date birthDate = null;
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try{
            boolean res = true;
            for(String s: this.answerUserArray){
                res = s.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
                if(res){
                    birthDate = format.parse(s);
                    return birthDate;
                } else {
                    continue;
                }
            }
            throw new ParseBirthDateException("Некорректная дата дня рождения!");
        } catch (ParseBirthDateException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Разбирает элементы массива с данными от пользователя на соответствие информации о готовности выйти из приложения
     * @return true или false
     */
    public boolean parseUserAnswerToQuit(){
        for (String answer : this.answerUserArray) {
            if (answer.equals("q")) {
                return false;
            }
        }
        return true;
    }
}
