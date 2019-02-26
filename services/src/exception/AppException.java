package exception;

public class AppException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    private ErrCode error;
    public AppException(ErrCode error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return error.getMessage();

    }
}

