package ma.gestion.pharmacie.exception;

public class ResourceNotFoundExceptionConstimized extends RuntimeException {

	public ResourceNotFoundExceptionConstimized(String message) {
		super(message);
	}

	public ResourceNotFoundExceptionConstimized(String message, Throwable throwable) {
		super(message, throwable);
	}
}
