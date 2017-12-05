package com.example.rodrigo.navview.Entidade;

/**
 * Created by Rodrigo on 04/12/2017.
 */

public class Pessoa {
    private String nome;
    private String email;
    private String senha;

    public Pessoa(String email, String senha, String nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
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
