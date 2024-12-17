package m99.bookmyseat.customexception;

public class BadCredentialsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4814616587101247921L;

	public BadCredentialsException() {
		super();
	}

	public BadCredentialsException(String message) {
		super(message);
	}
}
