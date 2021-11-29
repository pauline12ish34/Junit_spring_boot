package rw.ac.rca.smsJunit.utils.Exception;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {
	public BadRequestException(String message) {
		super(message);
		
	}
	 public BadRequestException(String message, Throwable cause) {
	        super(message, cause);
	    }
	 
}
