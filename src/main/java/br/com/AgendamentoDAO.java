package br.com;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {
    public void createAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamento (título, descrição, data_agendamento, status, usuarios_id VALUES (?, ?, ?, ?, ?)";

        try
                (Connection conn = DataBaseConnection.getConnection()) {
            ;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            {
                pstmt.setString(1, agendamento.getTítulos());
                pstmt.setString(2, agendamento.getDescrição());
                pstmt.setTimestamp(3, Timestamp.valueOf(agendamento.getData_Agendamento()));
            }
            ;
            pstmt.setString(4, agendamento.getStatus());
            pstmt.setInt(5, agendamento.getUsuarios_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Agendamento> getAgendamentoByUsuarios_id(int usuarios_id) {
        String sql = "SELECT * FROM agendamento WHERE usuarios_id = ?";

        List<Agendamento> agendamentos = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement preparedStatement = conn.preparedStatement(sql);
            {
                preparedStatement.setInt(1, usuarios_id);

                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        Agendamento agendamento = new Agendamento();
                        agendamento.setId(rs.getInt("id"));
                        agendamento.setTítulo(rs.getString("título"));

                        agendamento.setDescrição(rs.getString("descrição"));

                        agendamento.setData_Agendamento(rs.getTimestamp("data_agendamento").toLocalDateTime());

                        agendamento.setStatus(rs.getString("status"));
                        agendamento.setUsuarios_id(rs.getInt("usuarios_id"));
                        agendamento.add(agendamento);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return agendamentos;
    }
}