package com.example.rodrigo.navview;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.rodrigo.navview.Dao.PessoaDAO;
import com.example.rodrigo.navview.Database.DatabaseHelper;
import com.example.rodrigo.navview.Entidade.Pessoa;
import com.example.rodrigo.navview.Mensagem.mensagens;




public class ContaFragment extends Fragment {
    private SQLiteDatabase conexao;
    private DatabaseHelper databaseHelper;
    private EditText senha, nome, email;
    private PessoaDAO pessoaDAO;
    private Button alteracao, excluir;


    public ContaFragment(){


    }

    public View onCreateView(View v, @Nullable Bundle savedInstanceState){

        senha = (EditText)getView().findViewById(R.id.senha);
        nome = (EditText)getView().findViewById(R.id.nome);
        email = (EditText)getView().findViewById(R.id.email);
        alteracao = (Button)getView().findViewById(R.id.alterar);
        excluir = (Button)getView().findViewById(R.id.Excluir);

        alteracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    abrirConexao();

                    Pessoa p = new Pessoa(email.getText().toString(), senha.getText().toString(), nome.getText().toString());

                    pessoaDAO.updatePessoa(p);
                    mensagens.toast(getActivity(), "Dados modificados com sucesso!");
                    fechaConexao();
                }catch (SQLException ex){
                    mensagens.alertaDialog(getActivity(),"Falha ao atualizar:"+ex.getMessage(), "Error");
                }
            }
        });

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirConexao();

                Pessoa p = new Pessoa(email.getText().toString(), null,null);
                pessoaDAO.deletarPessoa(p);
                mensagens.toast(getActivity(), "Usuario excluido. Tchauuu");
                fechaConexao();
                Intent intent = new Intent(getActivity(), cadastro.class);
                startActivity(intent);
            }
        });
        return v;
    }


    public SQLiteDatabase abrirConexao(){
        databaseHelper = new DatabaseHelper(getActivity());
        conexao = databaseHelper.getWritableDatabase();
        pessoaDAO = new PessoaDAO(conexao);

        return conexao;
    }

    public void fechaConexao(){

        conexao.close();
    }

}



