package JavaException.exception;

public class IncorrectSubjectScoreException extends Exception {
    public IncorrectSubjectScoreException() {
    }

    public IncorrectSubjectScoreException(String message) {
        super(message);
    }

    public IncorrectSubjectScoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectSubjectScoreException(Throwable cause) {
        super(cause);
    }
}
