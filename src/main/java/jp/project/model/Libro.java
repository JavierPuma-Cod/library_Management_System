package jp.project.model;

public class Libro
{
    private String titulo;
    private String autor;
    private String isbn;
    private int cant;
    private boolean disponible;
    public Libro(String titulo, String autor, String isbn, boolean disponible, int cant)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.cant = cant;
        this.disponible = disponible;
    }
    //Getter's and Setter's
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getAutor() {return autor;}
    public void setAutor(String autor) {this.autor = autor;}
    public String getIsbn() {return isbn;}
    public void setIsbn(String isbn) {this.isbn = isbn;}
    public boolean isDisponible() {return disponible;}
    public void setDisponible(boolean disponible) {this.disponible = disponible;}
    public int getCant() {return cant;}
    public void setCant(int cant) {this.cant = cant;}
    //Mothods
    public void motrarInformacion()
    {
        System.out.println("Titulo: "+titulo);
        System.out.println("Autor: "+autor);
        System.out.println("ISBN: "+isbn);
        System.out.println("Cantidad: "+cant);
        System.out.println("Disponible: "+(disponible?"Si":"No"));
    }
    public void prestar()
    {
        cant--;
        this.disponible = false;
    }
    public void devolver()
    {
        cant++;
        this.disponible = true;
    }
}