package MyExample1.demo.exception;

public class OrderLineNotFoundException extends RuntimeException {
    public OrderLineNotFoundException(String message) {
        super(message);
    }
}
