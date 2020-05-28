package Exception;

public class ExceptionDocumentNonEmprunte extends java.lang.Exception {
    private String message;

    public ExceptionDocumentNonEmprunte(){
        message = "Vous n'avez pas emprunté ce document ! ";
    }

    @Override
    public String getMessage(){
        return message;
    }
}
