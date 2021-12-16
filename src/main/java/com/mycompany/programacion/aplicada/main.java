package com.mycompany.programacion.aplicada;

import java.sql.SQLException;
import vista.*;

public class main {

    public static void main(String[] args) throws SQLException {

        /* Formulario Principal */
        formLogin login = new formLogin();
        login.empezar();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
    }
}
