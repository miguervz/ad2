package es.studium.hotel;
public class Hotel {
public static void main(String[] args) {
int id = ClientePersist.createCliente("Mar�a Jos�",
"Mart�nez", "mjmartinez@grupostudium.com", "12345678Z",
"Studium2020");
System.out.println(ClientePersist.readCliente(id,
"apellidos"));
ClientePersist.updateCliente(id, "apellidos", "Mart�nez Navas");
System.out.println(ClientePersist.readCliente(id,
"apellidos"));
ClientePersist.deleteCliente(id);
System.out.println(ClientePersist.readCliente(id,
"apellidos"));}}