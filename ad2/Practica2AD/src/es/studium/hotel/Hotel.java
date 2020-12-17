package es.studium.hotel;
public class Hotel {
public static void main(String[] args) {
int id = ClientePersist.createCliente("María José",
"Martínez", "mjmartinez@grupostudium.com", "12345678Z",
"Studium2020");
System.out.println(ClientePersist.readCliente(id,
"apellidos"));
ClientePersist.updateCliente(id, "apellidos", "Martínez Navas");
System.out.println(ClientePersist.readCliente(id,
"apellidos"));
ClientePersist.deleteCliente(id);
System.out.println(ClientePersist.readCliente(id,
"apellidos"));}}