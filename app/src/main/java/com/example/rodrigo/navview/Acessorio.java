package com.example.rodrigo.navview;

/**
 * Created by Rodrigo on 22/11/2017.
 */

public class Acessorio {

    public int imagem;
    public String nome;
    public String preco;

    public int getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public Acessorio(int imagem, String nome, String preco) {
        this.imagem = imagem;
        this.nome = nome;
        this.preco = preco;
    }
}
