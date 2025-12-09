package jp.project;

import jp.project.model.Biblioteca;
import jp.project.model.Libro;
import jp.project.model.Usuario;

import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner dato = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion;
        String menu= """
                ##########################
                #####_MENU_BIBLIOTECA_####
                1. Agregar libro
                2. Registar usuario
                3. Prestar libro
                4. Devolver libro
                5. Mostrar libro
                ##########################
                0. Salir
                ##########################""";
        do {
            System.out.println(menu);
            opcion=dato.nextInt();
            switch (opcion)
            {
                case 1:
                    System.out.println("Ingrese el titulo del libro");
                    String titulo=dato.next();
                    dato.nextLine();
                    System.out.println("Ingrese el autor del libro");
                    String autor=dato.next();
                    dato.nextLine();
                    System.out.println("Ingrese el ISBN del libro");
                    String isbn=dato.next();
                    dato.nextLine();
                    System.out.println("Cuantos libros se estan ingresando?");
                    int cant=dato.nextInt();
                    dato.nextLine();
                    Libro libro=new Libro(titulo,autor,isbn,true,cant);
                    biblioteca.agregarLibro(libro);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del usuario: ");
                    String nombreUsuario = dato.next();
                    dato.nextLine();
                    System.out.println("Ingrese el ID del usuario: ");
                    int idUser = dato.nextInt();
                    dato.nextLine(); // Consume la nueva línea

                    Usuario usuario = new Usuario(nombreUsuario, idUser);
                    biblioteca.registrarUsuario(usuario);
                    break;
                case 3:
                    // Prestar libro
                    System.out.println("Ingrese el ISBN del libro a prestar: ");
                    String isbnPrestar = dato.next();
                    dato.nextLine();
                    System.out.println("Ingrese el ID del usuario que tomará el libro prestado: ");
                    int idUsuarioPrestar = dato.nextInt();
                    dato.nextLine(); // Consume la nueva línea

                    biblioteca.prestarLibro(isbnPrestar, idUsuarioPrestar);
                    break;
                case 4:
                    // Devolver libro
                    System.out.println("Ingrese el ISBN del libro a devolver: ");
                    String isbnDevolver = dato.next();
                    dato.nextLine();
                    System.out.println("Ingrese el ID del usuario que devuelve el libro: ");
                    int idUsuarioDevolver = dato.nextInt();
                    dato.nextLine(); // Consume la nueva línea

                    biblioteca.devolverLibro(isbnDevolver, idUsuarioDevolver);
                    break;
                case 5:
                    // Mostrar libros disponibles
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    dato.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while(opcion!=0);
    }
}