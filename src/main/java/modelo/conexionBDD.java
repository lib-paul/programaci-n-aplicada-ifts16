package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexionBDD {
    private Connection con;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String pass = "1234";
    private final String url = "jdbc:mysql://localhost:3306/turnospi";
    
    public Connection conexion() throws SQLException{
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexión éxitosa.");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
