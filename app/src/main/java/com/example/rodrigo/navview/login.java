package com.example.rodrigo.navview;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rodrigo.navview.Dao.PessoaDAO;
import com.example.rodrigo.navview.Database.DatabaseHelper;

public class login extends AppCompatActivity {
    private SQLiteDatabase conexao;
    private DatabaseHelper databaseHelper;
    private EditText senha, email;
    private Button entrarJa;
    private PessoaDAO pessoaDAO;
    private Button irCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        senha = (EditText)findViewById(R.id.senha);
        email = (EditText)findViewById(R.id.email);
        irCadastro = (Button)findViewById(R.id.irCadastrar);

        entrarJa = (Button)findViewById(R.id.entrar);

        irCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, cadastro.class);
                startActivity(intent);
            }
        });

        entrarJa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public SQLiteDatabase abrirConexao(){
        databaseHelper = new DatabaseHelper(login.this);
        conexao = databaseHelper.getWritableDatabase();
        pessoaDAO = new PessoaDAO(conexao);

        return conexao;
    }
}
