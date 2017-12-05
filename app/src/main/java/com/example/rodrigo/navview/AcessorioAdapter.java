package com.example.rodrigo.navview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import  java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;
/**
 * Created by Rodrigo on 19/11/2017.
 */

public class AcessorioAdapter extends ArrayAdapter<Acessorio> {


    public final Context context;
    public final ArrayList<Acessorio> produto;

    public AcessorioAdapter(Context context, ArrayList<Acessorio> produto){
        super(context, R.layout.acessorio, produto);
        this.context=context;
        this.produto=produto;
    }


    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.acessorio, parent, false);

        TextView nomeProduto = (TextView) rowView.findViewById(R.id.nomeproduto);
        TextView preco = (TextView) rowView.findViewById(R.id.preco);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);

        nomeProduto.setText(produto.get(position).getNome());
        preco.setText(produto.get(position).getPreco());
        imagem.setImageResource(produto.get(position).getImagem());

        return rowView;
    }

}
