package com.mycompany.programacion.aplicada;

import controlador.ctrAltaMedico;
import controlador.ctrAltaPaciente;
import controlador.ctrAgregarEspecialidad;
import controlador.ctrModMedico;
import java.sql.SQLException;
import modelo.Consultas;
import modelo.Medico;
import modelo.Paciente;
import vista.formAgregarEspecialidad;
import vista.formAltaMedico;
import vista.formAltaPaciente;
import vista.formModMedico;

public class main {
    public static void main(String[] args) throws SQLException {
        /*Paciente paciente = new Paciente();
        Consultas consultas = new Consultas();
        formAltaPaciente formulario = new formAltaPaciente();
        ctrAltaPaciente controlador = new ctrAltaPaciente(paciente, formulario, consultas);
        consultas.cargarComboBoxP(formulario);
        controlador.iniciar();
        formulario.setVisible(true);*/
        
        
        /*Medico medico = new Medico();
        Consultas consultas = new Consultas();
        formAltaMedico formulario = new formAltaMedico();
        ctrAltaMedico controlador = new ctrAltaMedico(medico, formulario, consultas);
        consultas.cargarComboBoxM(formulario);
        controlador.iniciar();
        formulario.setVisible(true);*/
        
        
        formAgregarEspecialidad formulario = new formAgregarEspecialidad();
        Consultas consultas = new Consultas();
        ctrAgregarEspecialidad controlador = new ctrAgregarEspecialidad(formulario, consultas);
        consultas.cargarComboBoxE(formulario);
        controlador.iniciar();
        formulario.setVisible(true);
        
        /*Medico medico = new Medico();
        Consultas consultas = new Consultas();
        formModMedico formulario = new formModMedico();
        ctrModMedico controlador = new ctrModMedico(medico, formulario, consultas);
        //consultas.cargarComboBoxM(formulario);
        controlador.iniciar();
        formulario.setVisible(true);*/
        
    }
}
