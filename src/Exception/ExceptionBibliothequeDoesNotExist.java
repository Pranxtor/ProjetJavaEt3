package Exception;

public class ExceptionBibliothequeDoesNotExist extends Exception {
    private String message;

    public ExceptionBibliothequeDoesNotExist(){
        message = "La bibliotheque n'existe pas ! ";
    }

    @Override
    public String getMessage(){
        return message;
    }
}
