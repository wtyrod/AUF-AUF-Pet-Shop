package com.example.rodrigo.navview;

/**
 * Created by Rodrigo on 08/11/2017.
 */


        import android.widget.ImageView;
        import android.widget.TextView;

/**
 * Created by Rodrigo on 06/11/2017.
 */

public class Alimentacao {


    public String nome;
    public String preco;
    public String descricao;
    public int imagem;


    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Alimentacao(String nome, String preco, String descricao, int imagem) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
    }
}
