package br.edu.ufcspa.view;

import br.edu.ufcspa.model.ListaHash;
import br.edu.ufcspa.model.Paciente;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

/**
 * Created by GabrielRS on 08/11/2016.
 */
public class Cadastro {

    public Paciente cadastraPaciente(){

        Paciente paciente = new Paciente();

        String cpf = (String)JOptionPane.showInputDialog("Informe o CPF:");
        if(paciente.validaCPF(cpf))
            paciente.setCpf(cpf);
        else{
            JOptionPane.showMessageDialog(null, "CPF inválido");
            return null;
        }

        Object[] estados = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RS", "RR", "SC", "SE", "SP", "TO"};

        paciente.setEstado((String)JOptionPane.showInputDialog(null,"Selecione o estado:", "Estado", JOptionPane.INFORMATION_MESSAGE, null, estados, "AC"));

        String rg = (String)JOptionPane.showInputDialog("Informe o RG:");
        if(paciente.validaRg(rg))
            paciente.setRg(rg);
        else{
            JOptionPane.showMessageDialog(null, "RG inválido");
            return null;
        }

        String data = (String)JOptionPane.showInputDialog("Informe a data de nascimento: (dd/mm/yyyy)");
        if(paciente.validaData(data))
            paciente.setNascimento(data);
        else{
            JOptionPane.showMessageDialog(null, "Data inválida");
            return null;
        }

        paciente.setNome((String)JOptionPane.showInputDialog("Nome do paciente: "));

        return paciente;
    }

    public String busca()
    {
        Paciente paciente = new Paciente();

        String cpf = (String)JOptionPane.showInputDialog("Informe o CPF:");
        paciente.setCpf(cpf);
        if(paciente.validaCPF(cpf))
            return paciente.getCpf();
        else
            return null;
    }

    public String relatorio()
    {
        return (String)JOptionPane.showInputDialog("Informações adicionais:");
    }

    public void erroRelatorio()
    {
        JOptionPane.showMessageDialog(null, "Não há paciente cadastrado");
    }

}
