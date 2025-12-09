package jp.project.model;

public class Usuario
{
    private String Nombre;
    private int idUser;
    public Usuario(String nombre, int idUser) {
        Nombre = nombre;
        this.idUser = idUser;
    }
    //Getter's and Setter's
    public String getNombre() {return Nombre;}
    public void setNombre(String nombre) {Nombre = nombre;}
    public int getIdUser() {return idUser;}
    public void setIdUser(int idUser) {this.idUser = idUser;}
    //Methods
    public void mostrarInformacion() {
        System.out.println("Nombre: " + Nombre);
        System.out.println("ID Usuario: " + idUser);
    }
}