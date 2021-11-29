package rw.ac.rca.smsJunit.utils;

public class APIReponse {
	 private boolean status;

	    private String message;
	    public APIReponse() {
			super();
			// TODO Auto-generated constructor stub
	    }
	    
	    public boolean isStatus() {
	        return status;
	    }


		public APIReponse(boolean status, String message) {
	super();
	this.status = status;
	this.message = message;
}

		public void setStatus(boolean status) {
	        this.status = status;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	

}
