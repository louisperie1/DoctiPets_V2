package com.example.doctipets_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.doctipets_v2.AccueilFragment;
import com.example.doctipets_v2.R;

public class RdvPasserFragment extends Fragment {

    // ... Votre code existant ...

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rdv_passer, container, false);

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

        return rootView;
    }
}
