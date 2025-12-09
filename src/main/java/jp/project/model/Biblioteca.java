package jp.project.model;
import jp.project.conection.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Biblioteca
{
    public void agregarLibro(Libro libro) {
        String sql = "INSERT INTO libros (isbn, titulo, autor, disponible,cantidad) VALUES (?,?, ?, ?, ?)";
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, libro.getIsbn());
            pstmt.setString(2, libro.getTitulo());
            pstmt.setString(3, libro.getAutor());
            pstmt.setBoolean(4, libro.isDisponible());
            pstmt.setInt(5,libro.getCant());
            pstmt.executeUpdate();
            System.out.println("Libro agregado: " + libro.getTitulo());
        } catch (SQLException e) {
            System.err.println("Error al agregar libro: " + e.getMessage());
        }
    }
    public void registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id_usuario, nombre) VALUES (?, ?)";
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, usuario.getIdUser());
            pstmt.setString(2, usuario.getNombre());
            pstmt.executeUpdate();
            System.out.println("Usuario registrado: " + usuario.getNombre());
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }
    public void prestarLibro(String isbn, int idUser) {
        String sql = "UPDATE libros SET disponible = FALSE WHERE isbn = ? AND disponible = TRUE";
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Libro con ISBN " + isbn + " prestado.");
            } else {
                System.out.println("No se pudo prestar el libro con ISBN " + isbn + ".");
            }
        } catch (SQLException e) {
            System.err.println("Error al prestar libro: " + e.getMessage());
        }
    }
    public void devolverLibro(String isbn, int idUsuario) {
        String sql = "UPDATE libros SET disponible = TRUE WHERE isbn = ?";
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Libro con ISBN " + isbn + " devuelto.");
            } else {
                System.out.println("No se pudo devolver el libro con ISBN " + isbn + ".");
            }
        } catch (SQLException e) {
            System.err.println("Error al devolver libro: " + e.getMessage());
        }
    }
    /*
    public Libro buscarLibro(String isbn) {
        String sql = "SELECT * FROM libros WHERE isbn = ?";
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Libro libro = new Libro(rs.getString("titulo"),rs.getString("autor"),rs.getString("isbn"),rs.getBoolean("disponible"),rs.getInt("cantidad"));
                libro.devolver(); // Asegúrate de que el estado 'disponible' se actualice correctamente
                return libro;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar libro: " + e.getMessage());
        }
        return null;
    }
    */
    public void mostrarLibrosDisponibles() {
        String sql = "SELECT * FROM libros";
        try (Connection conexion = ConexionBD.conectar();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Libros disponibles:");
            while (rs.next()) {
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Autor: " + rs.getString("autor"));
                System.out.println("ISBN: " + rs.getString("isbn"));
                System.out.println("Cantidad disponible: "+rs.getInt("cantidad"));
                System.out.println("Disponible: "+rs.getBoolean("disponible"));
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar libros disponibles: " + e.getMessage());
        }
    }
    /*
    private Usuario buscarUsuario(int idUser) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idUser);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario(rs.getString("nombre"), rs.getInt("id_usuario"));
                return usuario;
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar usuario: " + e.getMessage());
        }
        return null;
    }
    */
}