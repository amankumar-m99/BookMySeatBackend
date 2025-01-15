package m99.bookmyseat.configuration;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import m99.bookmyseat.data.AppData;

@Configuration
public class AppConfig {

	@Value("${application.data.directory.home}")
	private String dataDirectoryHome;

	@Value("${application.data.directory.name}")
	private String dataDirectoryName;

	@Value("${application.data.directory.policy}")
	private String dataDirectoryPolicy;

	@PostConstruct()
	public void initApplicationDataDirectory() {
		System.out.println("Initialising data-directory...");
		if (dataDirectoryHome == null || dataDirectoryHome.trim().isEmpty()) {
			dataDirectoryHome = System.getProperty("user.dir");
		}
		if (dataDirectoryName == null || dataDirectoryName.trim().isEmpty()) {
			dataDirectoryName = "BookMySeatData";
		}
		dataDirectoryHome = dataDirectoryHome.trim().replace(".", File.separator);
		AppData.initData(dataDirectoryHome + File.separator + dataDirectoryName.trim());
		System.out.println("Data-directory initialed to " + AppData.APP_DATA_DIRECTORY);
	}
}
