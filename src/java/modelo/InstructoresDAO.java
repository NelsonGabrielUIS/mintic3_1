package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Nelson Diaz
 */
public class InstructoresDAO {
    
    Connection conexion;
    
    public InstructoresDAO() throws ClassNotFoundException{
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Instructores> listarInstructores(){
        PreparedStatement ps;
        ResultSet rs;     
        List<Instructores> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("SELECT id, num, nombre, apellido, perfil FROM Instructores");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id =  rs.getInt("id");
                String num = rs.getString("num");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String perfil = rs.getString("perfil");
                Instructores instructor = new Instructores(id, num, nombre, apellido, perfil);
                lista.add(instructor);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public Instructores mostrarInstructor(int _id){
        PreparedStatement ps;
        ResultSet rs;     
        Instructores instructor = null;
        try {
            ps = conexion.prepareStatement("SELECT id, num, nombre, apellido, perfil FROM Instructores WHERE id = ?");
            ps.setInt(1, _id);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                int id =  rs.getInt("id");
                String num = rs.getString("num");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String perfil = rs.getString("perfil");
                instructor = new Instructores(id, num, nombre, apellido, perfil);
            }
            return instructor;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public boolean insertar(Instructores instructor){
        PreparedStatement ps;  
        try {
            ps = conexion.prepareStatement("INSERT INTO instructores (num,nombre,apellido,perfil) VALUES (?,?,?,?)");
            ps.setString(1, instructor.getNum());
            ps.setString(2, instructor.getNombre());
            ps.setString(3, instructor.getApellido());
            ps.setString(4, instructor.getPerfil());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean actualizar(Instructores instructor){
        PreparedStatement ps;  
        try {
            ps = conexion.prepareStatement("UPDATE instructores SET num = ?,nombre = ?,apellido = ?,perfil = ? WHERE id = ?");
            ps.setString(1, instructor.getNum());
            ps.setString(2, instructor.getNombre());
            ps.setString(3, instructor.getApellido());
            ps.setString(4, instructor.getPerfil());
            ps.setInt(5, instructor.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean eliminar(int _id){
        PreparedStatement ps;  
        try {
            ps = conexion.prepareStatement("DELETE FROM instructores WHERE id = ?");
            ps.setInt(1, _id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
