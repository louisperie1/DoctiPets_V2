package com.example.doctipets_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class QuiFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_qui, container, false);

        // Récupérer le bouton de retour
        Button btnRetourParametre = rootView.findViewById(R.id.btnRetourParametre);

        // Ajouter un écouteur de clic pour le bouton de retour
        btnRetourParametre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retourParametre();
            }
        });

        return rootView;
    }

    // Méthode pour retourner au fragment ParametreFragment
    private void retourParametre() {
        // Remplacez le fragment actuel par le fragment ParametreFragment
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new ParametreFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
