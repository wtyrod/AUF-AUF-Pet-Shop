package com.example.rodrigo.navview;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rodrigo.navview.Dao.PessoaDAO;
import com.example.rodrigo.navview.Database.DatabaseHelper;
import com.example.rodrigo.navview.Entidade.Pessoa;
import com.example.rodrigo.navview.Mensagem.mensagens;

/**
 * Created by Rodrigo on 04/12/2017.
 */

public class cadastro extends AppCompatActivity{
    private SQLiteDatabase conexao;
    private DatabaseHelper databaseHelper;
    private EditText nome, senha, email;
    private Button cadastrar;
    private PessoaDAO pessoaDAO;
    private Button irLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText)findViewById(R.id.nome);
        senha = (EditText)findViewById(R.id.senha);
        email = (EditText)findViewById(R.id.email);
        irLogin = (Button)findViewById(R.id.irLogar);

        cadastrar = (Button)findViewById(R.id.cadastrar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    abrirConexao();

                    Pessoa p = new Pessoa(email.getText().toString(), senha.getText().toString(), nome.getText().toString());
                    pessoaDAO.cadastrarPessoa(p);

                    mensagens.toast(cadastro.this,"Dados Cadastrados porra!");
                    fechaConexao();
                    Intent intent = new Intent(cadastro.this, MainActivity.class);
                    startActivity(intent);
                }catch (SQLException e){
                    mensagens.alertaDialog(cadastro.this,"Falha ao cadastrar:"+e.getMessage(),"Error");
                }

            }
        });

        irLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastro.this, login.class);
                startActivity(intent);
            }
        });



        /*botaoListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String msg = "";
                    abrirConexao();
                    List<Pessoa> list = pessoaDAO.listarPessoa();

                    for(Pessoa p: list){
                        msg += "email"+p.getEmail()+"\n";
                        msg += "senha"+p.getSenha()+"\n";
                        msg += "nome"+p.getNome()+"\n";
                    }
                    mensagens.alertaDialog(cadastro.this, msg, "Lista Cadastro");
                }catch (SQLException ex){
                    mensagens.alertaDialog(cadastro.this, "Falha ao listar:"+ex.getMessage(), "Error");
                }
            }
        });*/

    }


    public SQLiteDatabase abrirConexao(){
        databaseHelper = new DatabaseHelper(cadastro.this);
        conexao = databaseHelper.getWritableDatabase();
        pessoaDAO = new PessoaDAO(conexao);

        return conexao;
    }

    public void fechaConexao(){
        conexao.close();
    }

}
