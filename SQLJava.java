import java.sql.*;

public class SQLJava {
    public static void main(String[] args) {
        // 1. La URL de conexión. Usa "localhost" o "127.0.0.1"
        // El puerto es 3306 y la base de datos es "miBaseDatos"
        String connectionUrl = "jdbc:mysql://localhost:3306/miBaseDatos";
        
        // 2. El usuario, que es "root"
        String user = "root"; 
        
        // 3. La contraseña de tu usuario "root"
        String password = "fer11102003"; // <-- ¡Cambia esta línea!

        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password);
             Statement statement = connection.createStatement()) {
            
            System.out.println("Conectado a MySQL!");
            
            // Aquí irían tus consultas SQL para los ejercicios
            String sql = "SELECT * FROM producto";
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Precio: " + resultSet.getDouble("precio"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
