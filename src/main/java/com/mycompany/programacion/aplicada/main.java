package com.mycompany.programacion.aplicada;

import controlador.ctrlAltaPaciente;
import java.sql.SQLException;
import modelo.Consultas;
import modelo.Paciente;
import vista.formAltaPaciente;

public class main {
    public static void main(String[] args) throws SQLException {
        Paciente paciente = new Paciente();
        Consultas consultas = new Consultas();
        formAltaPaciente formulario = new formAltaPaciente();
        ctrlAltaPaciente controlador = new ctrlAltaPaciente(paciente, formulario, consultas);
        consultas.cargarComboBox(formulario);
        controlador.iniciar();
        formulario.setVisible(true);
    }
}
