package br.com;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();

        Usuarios usuarios = new usuarios();
        usuarios.setUsername("joão");
        usuariosDAO.createUsuarios(usuarios);

        List<Usuarios> usuarios = usuariosDAO.getUsuarios();

        usuarios.forEach(usuarios1 -> System.out.println(usuarios1.getUsername));

        Agendamento agendamento = new Agendamento();
        agendamento.setTítulo("Corte de Cabelo");
        agendamento.setDescrição("Corte de cabelo com o cabeleireiro João");

        agendamento.setData_Agendamento(LocalDateTime.now().plusDays(1));

        agendamento.setStatus("Agendado");

        agendamento.setUsuarios_id(usuarios.get(0).getId());

        agendamentoDAO.createAgendamento(agendamento);

        List<Agendamento> agendamentos = agendamentoDAO.getAgendamentosByUsuarios_id(usuarios.get(0).getId());

        agendamento.forEach(a -> System.out.println(a.getTítulo));
    }
}
