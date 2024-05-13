package codemin.recreasy.exception;

public class NotEnoughGameSlotException extends RuntimeException {
    public NotEnoughGameSlotException() {

    }

    public NotEnoughGameSlotException(String message) {
        super(message);
    }

    public NotEnoughGameSlotException(String message, Throwable cause) {
        super(message, cause);
    }
    public NotEnoughGameSlotException(Throwable cause) {
        super(cause);
    }
}
