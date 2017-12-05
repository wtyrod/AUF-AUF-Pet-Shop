package com.example.rodrigo.navview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;


public class AdocaoFragment extends Fragment {

    GridLayout mainGrid;
    public AdocaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_adocao, container, false);
        mainGrid= (GridLayout) view.findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
        return view;
    }

    private void setSingleEvent(final GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (finalI == 0) {
                        Intent intent = new Intent(getActivity(), AnimalUm.class);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        Intent intent = new Intent(getActivity(), AnimalDois.class);
                        startActivity(intent);
                    } else if (finalI == 2) {
                        Intent intent = new Intent(getActivity(), AnimalTres.class);
                        startActivity(intent);
                    } else if (finalI == 3) {
                        Intent intent = new Intent(getActivity(), AnimalQuatro.class);
                        startActivity(intent);
                    } else if (finalI == 4) {
                        Intent intent = new Intent(getActivity(), AnimalCinco.class);
                        startActivity(intent);
                    } else if (finalI == 5) {
                        Intent intent = new Intent(getActivity(), AnimalSeis.class);
                        startActivity(intent);
                    }
                }
            });

        }
    }

}
