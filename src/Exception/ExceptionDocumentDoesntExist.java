package Exception;

public class ExceptionDocumentDoesntExist extends java.lang.Exception {
    private String message;

    public ExceptionDocumentDoesntExist(){
        message = "Le document n'existe pas ! ";
    }

    @Override
    public String getMessage(){
        return message;
    }
}
