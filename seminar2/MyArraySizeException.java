package seminar2;

public class MyArraySizeException extends  CustomArrayException{
    public MyArraySizeException(String message, int x, int y) {
        super(message, x, y);
    }

    public MyArraySizeException(String message, Throwable throwable, int x, int y) {
        super(message, throwable, x, y);
    }
}

