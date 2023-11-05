package seminar2;

public class MyArrayDataException extends CustomArrayException {
    public MyArrayDataException(String message, int x, int y) {
        super(message, x, y);
    }

    public MyArrayDataException(String message, Throwable throwable, int x, int y) {
        super(message, throwable, x, y);
    }
}

