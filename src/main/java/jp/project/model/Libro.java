package jp.project.model;

public class Libro
{
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;
    public Libro(String titulo, String autor, String isbn, boolean disponible)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
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
    //Mothods
    public void motrarInformacion()
    {
        System.out.println("Titulo: "+titulo);
        System.out.println("Autor: "+autor);
        System.out.println("ISBN: "+isbn);
        System.out.println("Disponible: "+(disponible?"Si":"No"));
    }
    public void prestar()
    {
        this.disponible = false;
    }
    public void devolver()
    {
        this.disponible = true;
    }
}