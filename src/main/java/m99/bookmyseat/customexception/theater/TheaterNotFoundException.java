package m99.bookmyseat.customexception.theater;

public class TheaterNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2046027119053703062L;

	public TheaterNotFoundException() {
		super();
	}

	public TheaterNotFoundException(String message) {
		super(message);
	}
}
