package br.edu.ufcspa.model;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.StringJoiner;

/**
 * Created by GabrielRS on 06/11/2016.
 */
public class Paciente {

    private String cpf;
    private String rg;
    private String estado;
    private String nome;
    private Date   nascimento;
    private String informacoes;

    public Paciente(String cpf, String rg, String estado, String nome, Date nascimento, String informacoes) {
        this.cpf = cpf;
        this.rg = rg;
        this.estado = estado;
        this.nome = nome;
        this.nascimento = nascimento;
        this.informacoes = informacoes;
    }

    public Paciente(){}

    public int hashCPF(String CPF){
        int estado = this.converteEstado();
        int digitoEstado = Integer.parseInt(Character.toString(this.cpf.charAt(7)));

        int hash = estado*digitoEstado;
        return hash = Integer.parseInt(Integer.toString(hash) + Integer.toString(chave()));

    }

    public int converteEstado(){
        return Character.getNumericValue(this.estado.charAt(0))+Character.getNumericValue(this.estado.charAt(1));
    }

    public int chave(){
        char[] cpfArray = this.cpf.toCharArray();
        int aux = 6, soma = 0;
        for(int x=0; x < cpfArray.length; x++)
        {
            soma += Integer.parseInt(Character.toString(cpfArray[x]))+Integer.parseInt(Character.toString(cpfArray[aux]));
            aux--;
        }
        return soma;
    }

    public int somaCPF(){
        int soma = 0;
        for (int x=0; x < this.cpf.length(); x++)
        {
            soma += Integer.parseInt(Character.toString(this.cpf.charAt(x)));
        }
        return soma;
    }

    public boolean validaCPF(String CPF){
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
            // converte o i-esimo caractere do CPF em um numero:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }
}
