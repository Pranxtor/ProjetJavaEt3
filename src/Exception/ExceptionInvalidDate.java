package Exception;

public class ExceptionInvalidDate extends java.lang.Exception {
    private String message;

    public ExceptionInvalidDate(){
        message = "La date est invalide ! ";
    }

    @Override
    public String getMessage(){
        return message;
    }
}
