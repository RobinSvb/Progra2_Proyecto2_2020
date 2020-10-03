package sample.Controladores;

import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import sample.Main;

import javax.swing.*;
import java.io.IOException;

public class ControlLogin{
    public TextField txtUsuario;
    public PasswordField txtPassword;

    public void validarIngreso(ActionEvent actionEvent) throws IOException {
        //validar el ingreso al usuario
        //usuario=Robin , password=123456

        if( txtUsuario.getText().equals("admin") && txtPassword.getText().equals("123456") ){
            //tiene acceso
            Main menu = new Main();
            menu.start();
            txtPassword.clear();
            txtUsuario.clear();
        }else{
            //acceso restringido
            JOptionPane.showMessageDialog(null, "Acceso denegado", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

}
