package com.example.doctipets_v2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.doctipets_v2.R;
import com.example.doctipets_v2.RdvPasserFragment;

public class RdvFragment extends Fragment {

    // ... Votre code existant ...

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rdv, container, false);

        // Récupérer le bouton
        Button btnRdv = rootView.findViewById(R.id.btn_rdv);

        // Ajouter un écouteur d'événements pour le clic sur le bouton
        btnRdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remplacer le fragment actuel par le fragment "AccueilFragment"
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new AccueilFragment()); // Remplacez AccueilFragment par le nom de votre fragment "AccueilFragment"
                transaction.addToBackStack(null);  // Permet d'ajouter la transaction à la pile de retour
                transaction.commit();
            }
        });
        // Récupérer le bouton
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnRdvPasser = rootView.findViewById(R.id.btn_rdvpasser);

        // Ajouter un écouteur d'événements pour le clic sur le bouton
        btnRdvPasser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remplacer le fragment actuel par le fragment "rdvpasser"
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new RdvPasserFragment()); // Remplacez RdvPasserFragment par le nom de votre fragment "rdvpasser"
                transaction.addToBackStack(null);  // Permet d'ajouter la transaction à la pile de retour
                transaction.commit();
            }
        });

        return rootView;
    }
}
