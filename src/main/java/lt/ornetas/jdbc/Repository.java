package lt.ornetas.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Repository {

    private String url;
    private String username;
    private String password;
    private Connection connection;

    public Connection getConnection() throws SQLException {

        if (connection == null) {

            getProperties();

            connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );
        }
        return connection;
    }
    private void getProperties() {
        Properties properties = new Properties();

        try (
                FileInputStream fileInputStream = new FileInputStream("./src/main/resources/db.properties")
        ) {
            properties.load(fileInputStream);
            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
