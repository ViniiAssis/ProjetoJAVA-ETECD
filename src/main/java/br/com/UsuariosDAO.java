package br.com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class UsuariosDAO {

    public UsuariosDAO() throws SQLException {
    }

    public void createUsuarios (Usuarios usuarios){
        String sql = "INSERT INTO usuarios (username) VALUES (?)";
    } try (Connection conn = DataBaseConnection.getConnection(){
    PreparedStatement pstmt = conn.prepareStatement(sql)
        {
        pstmt.setString(1, usuarios.getUsuarios());
        pstmt.executeUpdate();
    }
    catch (SQLException e){
        e.printStackTrace();
    }
}

public List<Usuarios> getUsuarios(){
    String sql = "SELECT * FROM usuarios";
    List<Usuarios> usuarios = new ArrayList<>();

    try (Connection conn = DataBaseConnection.getConnection());
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql));{

        while (rs.next()){
            Usuarios usuarios = new Usuarios();
            usuarios.setId(rs.getInt("id"));
            usuarios.setUsername(rs.getString("username"));
            usuarios.add(usuarios);
        }
    }
    catch (SQLException e){
        e.printStackTrace();
    }

    return usuarios;
}
