package com.example.rodrigo.navview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import  java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rodrigo.navview.Database.DatabaseHelper;

/**
 * Created by Rodrigo on 19/11/2017.
 */

public class AlimentacaoAdapter extends ArrayAdapter<Alimentacao> {


    public final Context context;
    public final ArrayList<Alimentacao> racao;
    public final ArrayList<Alimentacao> shoppingList = new ArrayList<>();
    DatabaseHelper mDatabaseHelper;

    public AlimentacaoAdapter(Context context, ArrayList<Alimentacao> racao) {
        super(context, R.layout.alimentacao, racao);
        this.context = context;
        this.racao = racao;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.alimentacao, parent, false);

        TextView nomeRacao = (TextView) rowView.findViewById(R.id.nomeracao);
        TextView descricao = (TextView) rowView.findViewById(R.id.descricao);
        TextView preco = (TextView) rowView.findViewById(R.id.preco);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);
        mDatabaseHelper = new DatabaseHelper(context);
        Button addali = (Button) rowView.findViewById(R.id.addalicar);
        addali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
                alerta.setTitle("Adicionar item ao carrinho?");
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Alimentacao a = new Alimentacao(racao.get(position).getNome(),racao.get(position).getDescricao(),
                                racao.get(position).getPreco(),racao.get(position).getImagem());
                        shoppingList.add(a);
                        toastMessage("Item adicionado ao carrinho.");
                    }
                });
                alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alerta.show();

            }
        });


        nomeRacao.setText(racao.get(position).getNome());
        descricao.setText(racao.get(position).getDescricao());
        preco.setText(racao.get(position).getPreco());
        imagem.setImageResource(racao.get(position).getImagem());


        return rowView;
    }


    private void toastMessage(String message){

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}