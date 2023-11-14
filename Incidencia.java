package elecciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Incidencia {
    
    public static void MostrarIncidencia(String usr, String observacion) {
        String url = "jdbc:mysql://localhost:3307/tienda";
        String user = "root";
        String password = "";
        
        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO incidencia (Usuario, Hora, Observacion) VALUES (?, NOW(), ?)";
            try {
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
                
                preparedStatement.setString(1, usr);
                preparedStatement.setString(2, observacion);
               
                int filas = preparedStatement.executeUpdate();
                if (filas > 0) {
                    System.out.println("Se registró un ingreso al sistema.");
                } else {
                    System.out.println("Error al registrar incidencia.");
                }
            } catch (SQLException e) {
            
                System.err.println("Error al ejecutar la consulta SQL: " + e.getMessage());
            }
      
        } catch (SQLException e) {
        
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
