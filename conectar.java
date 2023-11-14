package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3307/tienda";

    public conectar() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                 System.out.println("Conexion establecida..");          
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error al conectar"+ e);
        }
    }      
    // este metodo nos retorna la conexion
    public Connection getConnection() {
        return conn;
    }
   
    public void desconectar(){
        conn = null;
        if (conn == null) {
            System.out.println("Conexion terminada");
    }
}
}