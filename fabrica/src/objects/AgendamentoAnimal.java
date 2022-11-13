/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author gabri
 */
public class AgendamentoAnimal {
    
    String Animal;
    String nomeAnimal;
    String nomeDono;
    String telefone;
    String dia;
    String servico;

    public AgendamentoAnimal(String Animal, String nomeAnimal, String nomeDono, String telefone, String dia, String servico) {
        this.Animal = Animal;
        this.nomeAnimal = nomeAnimal;
        this.nomeDono = nomeDono;
        this.telefone = telefone;
        this.dia = dia;
        this.servico = servico;
    }

    public AgendamentoAnimal() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getAnimal() {
        return Animal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDia() {
        return dia;
    }

    public String getServico() {
        return servico;
    }

    public void setAnimal(String Animal) {
        this.Animal = Animal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
}
   