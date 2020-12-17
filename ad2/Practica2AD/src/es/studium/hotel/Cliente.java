package es.studium.hotel;
public class Cliente {
private String nombre;
private String apellidos;
private String email;
private String DNI;
private String clave;
public Cliente() {
nombre="";
apellidos="";
email="";
DNI="";
clave="";
}
public Cliente( String n, String a, String e, String d, String c) {
nombre=n;
apellidos=a;
email=e;
DNI=d;
clave=c;
}
public String getNombre() {
return nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}
public String getApellidos() {
return apellidos;
}
public void setApellidos(String apellidos) {
this.apellidos = apellidos;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getDNI() {
return DNI;
}
public void setDNI(String dni) {
DNI = dni;
}
public String getClave() {
return clave;
}
public void setClave(String clave) {
this.clave = clave;
}
}