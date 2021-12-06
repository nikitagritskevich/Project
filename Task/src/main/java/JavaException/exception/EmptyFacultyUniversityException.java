package JavaException.exception;

public class EmptyFacultyUniversityException extends Exception{
    public EmptyFacultyUniversityException() {
    }

    public EmptyFacultyUniversityException(String message) {
        super(message);
    }

    public EmptyFacultyUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFacultyUniversityException(Throwable cause) {
        super(cause);
    }
}
