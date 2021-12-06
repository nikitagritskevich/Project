package JavaException.exception;

public class EmptyGroupUniversityException extends Exception{
    public EmptyGroupUniversityException() {
    }

    public EmptyGroupUniversityException(String message) {
        super(message);
    }

    public EmptyGroupUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyGroupUniversityException(Throwable cause) {
        super(cause);
    }
}
