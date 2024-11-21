package org.iesbelen.dao;

import org.iesbelen.model.Producto;
import org.iesbelen.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class UsuarioDAOImpl extends AbstractDAOImpl implements UsuarioDAO {
    @Override
    public void create(Usuario usuario) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("INSERT INTO usuarios (usuario, password, rol) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            int idx =1;
            ps.setString(idx++, usuario.getNombre());
            ps.setString(idx++, usuario.getPassword());
            ps.setString(idx++, usuario.getRol());

    int rows = ps.executeUpdate();
    if (rows > 0) {
        System.out.println("INSERT de fabricante con 0 filas insertadas.");
    }
    rsGenKeys = ps.getGeneratedKeys();
    if (rsGenKeys.next()) {
        usuario.setIdUsuario(rsGenKeys.getInt(1));
    }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Usuario> listUser = new ArrayList<>();

        try {
            conn= connectDB();
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                Usuario user = new Usuario();
                int idx = 1;
                user.setIdUsuario(rs.getInt(idx++));
                user.setNombre(rs.getString(idx++));
                user.setPassword(rs.getString(idx++));
                user.setRol(rs.getString(idx++));
                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listUser;
    }

    @Override
    public Optional<Usuario> getById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM usuarios WHERE idUsuario = ?");

            int idx =  1;
            ps.setInt(idx, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Usuario user = new Usuario();
                idx = 1;
                user.setIdUsuario(rs.getInt(idx++));
                user.setNombre(rs.getString(idx++));
                user.setPassword(rs.getString(idx++));
                user.setRol(rs.getString(idx++));

                return Optional.of(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();


    }

    @Override
    public void update(Usuario usuario) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("UPDATE usuario SET nombre = ?, password = ?, rol = ? WHERE idUsuario = ?");
            int idx = 1;
            ps.setString(idx++, usuario.getNombre());
            ps.setString(idx++, usuario.getPassword());
            ps.setString(idx++, usuario.getRol());
            ps.setInt(idx++, usuario.getIdUsuario());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("UPDATE de fabricante con 0 filas updates.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }

    @Override
    public void delete(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();
            ps = conn.prepareStatement("DELETE FROM usuarios WHERE idUsuario = ?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("DELETE de fabricante con 0 filas deletes.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }
    }
}
