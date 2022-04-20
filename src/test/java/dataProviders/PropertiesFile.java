package dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesFile {
    private static final String projectPath = System.getProperty("user.dir");
    private static PropertiesFile propertiesFileInstance = null;
    private InputStream is;
    private static Properties properties;

    private PropertiesFile() throws IOException {
        properties = new Properties();
        is = Files.newInputStream(Paths.get(projectPath + "/config.properties"));
        properties.load(is);
    }

    public static PropertiesFile pfInstance() throws IOException {
        if(propertiesFileInstance == null){
            propertiesFileInstance = new PropertiesFile();
        }

        return propertiesFileInstance;
    }

    public String getProperty(String propName){
        return properties.getProperty(propName);
    }
}
