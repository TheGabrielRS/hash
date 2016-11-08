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

    public void listagem()
    {
        for(Enumeration<LinkedList<Paciente>> e = this.lista.elements(); e.hasMoreElements();)
        {
            System.out.println("Quebrou lista");
            for(Paciente p : e.nextElement()){
                System.out.println(p.toString());
            }
        }
    }

    public void chaves()
    {
        for(Enumeration<String> e = lista.keys(); e.hasMoreElements();)
            System.out.println(e.nextElement());
    }



}
