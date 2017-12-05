package com.example.rodrigo.navview.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rodrigo.navview.Entidade.Pessoa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo on 04/12/2017.
 */

public class PessoaDAO {
    private SQLiteDatabase conexao;

    public PessoaDAO(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void cadastrarPessoa(Pessoa p){
        ContentValues values = new ContentValues();

        values.put("email", p.getEmail());
        values.put("senha", p.getSenha());
        values.put("nome", p.getNome());

        conexao.insertOrThrow("cadastro", null, values);
        conexao.close();
    }

    public List<Pessoa> listarPessoa(){
        List<Pessoa> list= new ArrayList<>();

        Cursor cursor = conexao.query("cadastro", null, null, null, null, null, null);
        if(cursor.getCount() > 0){
            do{
                Pessoa p = new Pessoa(null, null, null);
                p.setEmail(cursor.getString(0));
                p.setSenha(cursor.getString(1));
                p.setNome(cursor.getString(2));
                list.add(p);
            }while(cursor.moveToNext());

        }
        cursor.close();

        return list;
    }

    public void updatePessoa(Pessoa pessoa){
        ContentValues valores = new ContentValues();

        valores.put("senha", pessoa.getSenha());
        valores.put("nome", pessoa.getNome());

        conexao.update("cadastro", valores, "email = ?", new String[]{String.valueOf(pessoa.getEmail())});
        conexao.close();
    }

    public void deletarPessoa(Pessoa p){
        conexao.delete("cadastro", "email = ?", new String[]{String.valueOf(p.getEmail())});
        conexao.close();
    }
}
