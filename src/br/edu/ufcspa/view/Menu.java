package br.edu.ufcspa.view;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

/**
 * Created by GabrielRS on 08/11/2016.
 */
public class Menu {

    public String opcoes()
    {
        Object[] opc = {"Cadastrar", "Adicionar relatório", "Listar", "Sair"};
        return (String)(JOptionPane.showInputDialog(null,"Selecione uma opção:", "Menu Principal",JOptionPane.INFORMATION_MESSAGE, null, opc, "Cadastrar"));
    }

    public String senha()
    {
        return (String)JOptionPane.showInputDialog("Informe sua senha:");
    }

    public void listagem(String str)
    {
        JOptionPane.showMessageDialog(null, str);
    }

    public void erroSenha()
    {
        JOptionPane.showMessageDialog(null, "Senha incorreta");
    }


}
