package uemg.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionSingleton {
    private Connection connection;
    private static MySqlConnectionSingleton instance;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASS = "LitTle1@";
    private static final String DATABASE = "acervodb";
    private static final String TIMEZONE = "useTimezone=true&serverTimezone=UTC";

    private MySqlConnectionSingleton() {
        String connect = URL + ":" + PORT + "/" + DATABASE + "?" + TIMEZONE;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(connect, USER, PASS);
            System.out.println("Conexão com o banco de dados estabeelecida com sucesso");
        } catch (Exception ex) {
            System.out.println("Erro ao conectar ao banco de dados");
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static MySqlConnectionSingleton getInstance() {
        if(instance == null) {
            instance = new MySqlConnectionSingleton();
        } else if(instance.getConnection() == null) {
            instance = new MySqlConnectionSingleton();
        }
        return instance;
    }
}
