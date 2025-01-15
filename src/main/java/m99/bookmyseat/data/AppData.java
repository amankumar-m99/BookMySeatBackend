package m99.bookmyseat.data;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AppData {

	public static String APP_DATA_DIRECTORY;
	public static final Map<String, String> STATIC_DATA_MAP = new HashMap<>();
	public static final String MOVIE_COVERS_PATH = "profilePicPath";
	public static final String MOVIE_POSTERS_PATH = "moviePOsterPath";
	public static final String MOVIE_PLACEHOLDER_PATH = "moviePlaceholderPath";
	public static final String THEATER_LOGO_PATH = "theaterLogoPath";
	public static final String THEATER_PLACEHOLDER_PATH = "theaterPlaceholderPath";
	public static final String PERSON_PROFILE_PIC_PATH = "personProfilePicPath";
	public static final String PERSON_PLACEHOLDER_PATH = "personPlaceholderPicPath";

	public static final void initData(String dataDirectory){
		APP_DATA_DIRECTORY = dataDirectory;
		STATIC_DATA_MAP.put(MOVIE_COVERS_PATH, makeDirs("images.movies.covers"));
		STATIC_DATA_MAP.put(MOVIE_POSTERS_PATH, makeDirs("images.movies.posters"));
		STATIC_DATA_MAP.put(MOVIE_PLACEHOLDER_PATH, makeDirs("images.placeholders.movie"));
		STATIC_DATA_MAP.put(PERSON_PLACEHOLDER_PATH, makeDirs("images.placeholders.person"));
		STATIC_DATA_MAP.put(THEATER_PLACEHOLDER_PATH, makeDirs("images.placeholders.theater"));
		STATIC_DATA_MAP.put(PERSON_PROFILE_PIC_PATH, makeDirs("images.profile_pics"));
		STATIC_DATA_MAP.put(PERSON_PLACEHOLDER_PATH, makeDirs("images.theaters"));
	}

	private static String makeDirs(String s) {
		String path = APP_DATA_DIRECTORY + File.separator + s.replace(".", File.separator);
		new File(path).mkdirs();
		return path;
	}
}
