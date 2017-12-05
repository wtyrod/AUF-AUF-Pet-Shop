package com.example.rodrigo.navview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;


public class AcessoriosFragment extends ListFragment {


    private ArrayList<Acessorio> adicionarProduto(){
        ArrayList<Acessorio> produto = new ArrayList<Acessorio>();
        Acessorio a =  new Acessorio(R.drawable.coleira, "Coleira", "R$10,00");
        produto.add(a);
        a =  new Acessorio(R.drawable.coleira, "Coleira", "R$10,00");
        produto.add(a);
        a =  new Acessorio(R.drawable.coleira, "Coleira", "R$10,00");
        produto.add(a);
        a =  new Acessorio(R.drawable.coleira, "Coleira", "R$10,00");
        produto.add(a);
        a =  new Acessorio(R.drawable.coleira, "Coleira", "R$10,00");
        produto.add(a);
        a =  new Acessorio(R.drawable.coleira, "Coleira", "R$10,00");
        produto.add(a);
        return produto;
    }

    public AcessoriosFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_alimentacao, container, false);

        ListView lista =  (ListView) view.findViewById(list);
        ArrayList<Acessorio> produto = adicionarProduto();
        ArrayAdapter<Acessorio> adapter = new AcessorioAdapter(getContext(),
                produto);


        lista.setAdapter(adapter);

        return view;
    }


}
