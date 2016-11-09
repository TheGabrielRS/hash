package br.edu.ufcspa.model;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by GabrielRS on 08/11/2016.
 */
public class ListaHash {

    private Hashtable<String, LinkedList<Paciente>> lista;

    public ListaHash(){
        this.lista = new Hashtable<String, LinkedList<Paciente>>();
    }


    public boolean contemHash(String hash)
    {
        return this.lista.containsKey(hash);
    }

    public void adiciona(Paciente p){

        if(contemHash(p.hash()))
        {
            LinkedList tmp = this.lista.get(p.hash());
            tmp.push(p);
            this.lista.put(p.hash(),tmp);
        }else {
            LinkedList tmp = new LinkedList();
            tmp.push(p);
            this.lista.put(p.hash(), tmp);
        }
    }

    public String listagem()
    {
        String str = "";
        for(Enumeration<LinkedList<Paciente>> e = this.lista.elements(); e.hasMoreElements();)
        {
            for(Paciente p : e.nextElement()){
                str += p.toString()+'\n';
            }
        }
        return str;
    }

    public void chaves()
    {
        for(Enumeration<String> e = lista.keys(); e.hasMoreElements();)
            System.out.println(e.nextElement());
    }

    public Paciente busca(String cpf)
    {
        for(Enumeration<LinkedList<Paciente>> e = this.lista.elements(); e.hasMoreElements();)
        {
            for(Paciente p : e.nextElement()){
                if(p.getCpf() == cpf)
                    return p;
            }
        }

        return null;
    }

    public void edita(String cpf, String relatorio)
    {
        for(Enumeration<LinkedList<Paciente>> e = this.lista.elements(); e.hasMoreElements();)
        {
            for(Paciente p : e.nextElement()){
                if(p.getCpf() == cpf)
                    p.adicionaRelatorio(relatorio);
            }
        }
    }



}
