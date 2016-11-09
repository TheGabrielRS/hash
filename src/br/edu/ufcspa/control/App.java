package br.edu.ufcspa.control;

import br.edu.ufcspa.model.ListaHash;
import br.edu.ufcspa.model.Paciente;
import br.edu.ufcspa.view.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by GabrielRS on 06/11/2016.
 */
public class App {

    public static void main(String[] args) {
        ListaHash lista = new ListaHash();
        LinkedList<Paciente> pacientes = new LinkedList<Paciente>();
        Cadastro cad = new Cadastro();
        Menu menu = new Menu();

        while (true){
            String str = menu.opcoes();
            switch (str)
            {
                case "Cadastrar" :
                    Paciente paciente = cad.cadastraPaciente();
                    if(paciente != null)
                        lista.adiciona(paciente);
                    break;
                case "Adicionar relatório" :
                    String relatorio;
                    String cpf = cad.busca();
                    if(cpf != null)
                    {
                        relatorio = cad.relatorio();
                        lista.edita(cpf,relatorio);
                    }
                    else {
                        cad.erroRelatorio();
                    }
                    break;
                case "Listar" :
                    String senha = menu.senha();
                    if(senha.equals("qwe123"))
                        menu.listagem(lista.listagem());
                    else
                        menu.erroSenha();
                    break;
                case "Sair" :
                    System.exit(0);
            }
        }
//
//        pacientes.add(new Paciente("19147848049", "RS"));
//        pacientes.add(new Paciente("85597481053", "GO"));
//        pacientes.add(new Paciente("66652452090", "TO"));
//        pacientes.add(new Paciente("44113960097", "AC"));
//        pacientes.add(new Paciente("44113960097", "AC"));
//
//
//
//        for (Paciente p: pacientes) {
//            System.out.println(p.hash()+'\n');
//            lista.adiciona(p);
//        }
//
//        lista.chaves();



    }

}
