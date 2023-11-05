package seminar3;

public class MyFileNotFountException extends Exception{

    private final String fileName;

    public String getFileName() {
        return fileName;
    }

    public MyFileNotFountException(String message, String fileName) {
        super(message);
        this.fileName = fileName;
    }
}
