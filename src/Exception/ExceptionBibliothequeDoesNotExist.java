package Exception;

public class ExceptionBibliothequeDoesNotExist extends Exception {
    private String message;

    public ExceptionBibliothequeDoesNotExist(){
        message = "Le document n'existe pas ! ";
    }

    @Override
    public String getMessage(){
        return message;
    }
}
