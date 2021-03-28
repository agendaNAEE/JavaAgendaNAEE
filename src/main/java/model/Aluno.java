/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pfsta
 */
public class Aluno {
     private int id;
    private String nome;
    private Long ra;
    private String email;
    private String curso;
    private String periodo_ano;
    private String senha;
    
    public Aluno(){
        
    }

    public Aluno(int id, String nome, Long ra, String email, String curso, String periodo_ano, String senha) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.email = email;
        this.curso = curso;
        this.periodo_ano = periodo_ano;
        this.senha = senha;
    }
    /*

    public Aluno(String nome, String email, Long ra, String senha) {
        this.nome = nome;
        this.email = email;
        this.ra = ra;
        this.senha = senha;
    }
    */

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPeriodo_ano() {
        return periodo_ano;
    }

    public void setPeriodo_ano(String periodo_ano) {
        this.periodo_ano = periodo_ano;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
