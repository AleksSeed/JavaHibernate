import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Connection {

    public static Properties loadProperties(String resourceFileName) throws IOException {
        Properties configuration = new Properties();
        InputStream inputStream = Connection.class
                .getClassLoader()
                .getResourceAsStream(resourceFileName);
        configuration.load(inputStream);
        if (inputStream != null) {
            inputStream.close();
        }
        return configuration;
    }

    public static Connection getConnection() {
        Properties properties;
        Connection connection;
        try {
            properties = loadProperties("application.properties");
            String user = properties.getProperty("datasource.username");
            String password = properties.getProperty("datasource.password");
            String url = properties.getProperty("datasource.url");
            connection = (Connection) DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
