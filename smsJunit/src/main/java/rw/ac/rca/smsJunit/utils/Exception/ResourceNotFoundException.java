package rw.ac.rca.smsJunit.utils.Exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends  RuntimeException {
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String resourceName,String fieldName,int id) {
		  super(String.format("%s with %s %s " +
                "is not found", resourceName, fieldName, id));
	}
	
}
