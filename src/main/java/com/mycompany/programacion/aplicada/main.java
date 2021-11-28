package com.mycompany.programacion.aplicada;

import controlador.ctrlAltas;
import controlador.ctrlMod;
import java.sql.SQLException;
import modelo.Consultas;
import modelo.Medico;
import modelo.Paciente;
import controlador.ctrAgregarEspecialidad;
import javax.swing.DefaultListModel;
import vista.formAgregarEspecialidad;
import vista.formAlta;
import vista.formMod;

public class main {

    public static void main(String[] args) throws SQLException {
        Paciente paciente = new Paciente();
        Medico medico = new Medico();
        Consultas consultas = new Consultas();
        /*formAlta formulario = new formAlta();
        ctrlAltas controlador = new ctrlAltas(medico, paciente, formulario, consultas);*/

        formMod formulario = new formMod();
        ctrlMod controlador = new ctrlMod(medico, paciente, formulario, consultas);
        controlador.iniciar();
        formulario.setVisible(true);
        
    }
}
