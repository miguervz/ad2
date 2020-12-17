package es.studium.hotel;
import java.sql.*;
public class ClientePersist {
public static Connection conectar()
{
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/hotel?useSSL=false";
String user = "root";
String password = "Studium2019;";
Connection con = null;
try
{
// Cargar los controladores para el acceso a la BD
Class.forName(driver);
// Establecer la conexión con la BD
con = DriverManager.getConnection(url, user, password);
if (con != null)
{
System.out.println("Conectado a la base de datos");
}
}catch (SQLException ex)
{
System.out.println("ERROR:La dirección no es válida o el usuario y clave");
ex.printStackTrace();
} catch (ClassNotFoundException cnfe)
{
System.out.println("Error 1-" + cnfe.getMessage());
}
return con;
}
public static void desconectar(Connection conect)
{
try
{
conect.close();
System.out.println("Desconectado de la base de datos");
} catch (Exception e)
{
System.out.println(e.getMessage());
}
}
public static int createCliente(String nombre, String apellidos,
String email, String dni, String clave) {
// Conectar a la base de datos

Connection conect = conectar();
int respuesta=0;
try
{


Statement statement = conect.createStatement();
String cadenaSQL = "INSERT INTO Clientes" + " VALUES('1', '"+ nombre + " ', '" + apellidos + "', '"+ email + "', '" + dni + "', '" + clave +"');";
System.out.println(cadenaSQL);
statement.executeUpdate(cadenaSQL);
statement = conect.createStatement();
String select = "Select idClientes FROM Clientes where dni = '" + dni +"'";
ResultSet rs = statement.executeQuery(select);
while(rs.next()) {
respuesta = rs.getInt("idClientes");
}
statement.close();
} catch (SQLException ex)
{
System.out.println("Ha ocurrido un error al realizar el INSERT en la BD");
ex.printStackTrace();
respuesta = 1;
}
// Cerrar conexión con la BD
desconectar(conect);
return respuesta;
/* Devuelve el id del nuevo cliente */
}
public static String readCliente(int idCliente, String campo) {
String texto="";
String statement = "SELECT "+campo+" FROM clientes where idClientes ="+ idCliente ;
//Crear conexión
Connection conect = conectar();
try
{
// Creación de un statement para la consulta
Statement stmt = conect.createStatement();
ResultSet rs = stmt.executeQuery(statement);
while(rs.next()) {
texto = rs.getString(campo);
}
rs.close();
stmt.close();
} catch (SQLException ex)
{
System.out.println("Ha ocurrido un error al consultar la BD");
ex.printStackTrace();
}
// Cerrar la conexión
desconectar(conect);
return texto;

/* Devuelve el valor de la columna "campo" del cliente
identificado por "idCliente" */
}
public static boolean updateCliente(int idCliente, String campo,
String nuevoValor) {
boolean actualizado = false;
// Ejecutar el UPDATE
String sqlUpdate = "UPDATE Clientes SET " + campo+ " = '" + nuevoValor + "' WHERE idClientes = " +idCliente ;
// Conectar a la base de datos
Connection conect = conectar();
try
{
// Creación de un statement para la consulta Select
Statement stmt = conect.createStatement();
stmt.executeUpdate(sqlUpdate);
stmt.close();
actualizado = true;
} catch (SQLException ex)
{
System.out.println("Se ha producido un error al modificar la BD");
ex.printStackTrace();
}
// Cerrar la conexión
desconectar(conect);
return actualizado;
/* Actualiza el valor de la columna "campo" del cliente
identificado por "idCliente". Devuelve true si se ha logrado actualizar. */
}
public static boolean deleteCliente(int idCliente) {
boolean respuesta = false;
String sql = "DELETE FROM Clientes WHERE idClientes = " + idCliente;

Connection conect = conectar();
try
{

Statement sta = conect.createStatement();
sta.executeUpdate(sql);
sta.close();
respuesta = true;
System.err.println("El cliente ha sido eliminado correctamente");
} catch (SQLException ex)
{
System.out.println("Se ha producido un error al eliminarel cliente de la BD");
ex.printStackTrace();
respuesta = false;
}
return respuesta;}}
