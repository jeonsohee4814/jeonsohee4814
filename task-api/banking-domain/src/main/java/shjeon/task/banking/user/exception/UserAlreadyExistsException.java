package shjeon.task.banking.user.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String userId) {
        super("User id already exists: " + userId);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
