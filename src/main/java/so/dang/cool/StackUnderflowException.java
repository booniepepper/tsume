package so.dang.cool;

public class StackUnderflowException extends RuntimeException {
    public StackUnderflowException() {
        super();
    }

    public StackUnderflowException(Exception cause) {
        super(cause);
    }

    public StackUnderflowException(String message) {
        super(message);
    }

    public StackUnderflowException(String message, Exception cause) {
        super(message, cause);
    }
}
