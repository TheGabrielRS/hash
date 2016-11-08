package br.edu.ufcspa.control;

import br.edu.ufcspa.model.ListaHash;
import br.edu.ufcspa.model.Paciente;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by GabrielRS on 06/11/2016.
 */
public class App {

    public static void main(String[] args) {
        ListaHash lista = new ListaHash();
        LinkedList<Paciente> pacientes = new LinkedList<Paciente>();
        pacientes.add(new Paciente("19147848049", "RS"));
        pacientes.add(new Paciente("85597481053", "GO"));
        pacientes.add(new Paciente("66652452090", "TO"));
        pacientes.add(new Paciente("44113960097", "AC"));
        pacientes.add(new Paciente("44113960097", "AC"));



        for (Paciente p: pacientes) {
            System.out.println(p.hash()+'\n');
            lista.adiciona(p);
        }

        lista.chaves();



    }

}
