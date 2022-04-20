import java.util.Properties;
import java.util.Set;
// TODO borrar
public class test {

    public static void main(String[] args) {

        Properties properties = System.getProperties();


        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(key + " : " + properties.getProperty(key));
        }
    }
}
