package java.com.ofs.training.java.utility;

import java.util.ArrayList;
import java.util.List;

public class AppException extends RuntimeException  {

    private static final long serialVersionUID = 1L;
    private List<ErrCode> errorCodes;

    public AppException(ErrCode error) {
        super();
        this.errorCodes = new ArrayList<>();
        errorCodes.add(error);
    }

    public AppException(ErrCode error, Throwable cause) {
        super(cause);
        errorCodes.add(error);
    }

    public AppException(List<ErrCode> errorCodes) {
        super();
        this.errorCodes = errorCodes;
    }

    public AppException(Exception e) {
        super();
    }

    public List<ErrCode> getErrorCodes() {
        return errorCodes;
    }
}
