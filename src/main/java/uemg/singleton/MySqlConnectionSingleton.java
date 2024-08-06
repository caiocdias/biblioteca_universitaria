package uemg.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionSingleton {
    private Connection connection;
    private static MySqlConnectionSingleton instance;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/acervodb"; // Combine URL, PORT e DATABASE
    private static final String USER = "root";
    private static final String PASS = "LitTle1@";
    private static final String TIMEZONE = "?useTimezone=true&serverTimezone=UTC"; // Ajuste para timezone

    private MySqlConnectionSingleton() {
        String connect = URL + TIMEZONE; // Ajustar URL para incluir o timezone
        try {
            Class.forName(DRIVER); // Carregar o driver JDBC
            connection = DriverManager.getConnection(connect, USER, PASS);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver do banco de dados");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static MySqlConnectionSingleton getInstance() {
        if (instance == null || instance.getConnection() == null) {
            instance = new MySqlConnectionSingleton();
        }
        return instance;
    }
}
