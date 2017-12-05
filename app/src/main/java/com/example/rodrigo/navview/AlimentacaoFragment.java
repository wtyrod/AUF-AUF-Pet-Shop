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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import static android.R.id.list;


public class AlimentacaoFragment extends ListFragment {


    private ArrayList<Alimentacao> adicionarRacao(){
        ArrayList<Alimentacao> racao = new ArrayList<Alimentacao>();
        Alimentacao a = new Alimentacao("Kanina", "Filhote 2Kg", "R$25,00", R.drawable.comidinha1);
        racao.add(a);
        a =  new Alimentacao("Kanina", "Media 4Kg", "R$50,00", R.drawable.comidinha1);
        racao.add(a);
        a =  new Alimentacao("Kanina", "Adulto 6Kg", "R$75,00", R.drawable.comidinha1);
        racao.add(a);
        a =  new Alimentacao("Kanina", "Familia 8Kg", "R$100,00", R.drawable.comidinha1);
        racao.add(a);
        return racao;
    }

    public AlimentacaoFragment() {
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
        ArrayList<Alimentacao> racao = adicionarRacao();
        ArrayAdapter<Alimentacao> adapter = new AlimentacaoAdapter(getContext(),
                racao);


        lista.setAdapter(adapter);

        return view;
    }


}
