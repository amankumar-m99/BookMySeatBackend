package m99.bookmyseat.customexception.movie;

public class MovieNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2046027119053703062L;

	public MovieNotFoundException() {
		super();
	}

	public MovieNotFoundException(String message) {
		super(message);
	}
}
