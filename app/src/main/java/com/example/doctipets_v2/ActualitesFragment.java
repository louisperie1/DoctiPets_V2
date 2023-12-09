package com.example.doctipets_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctipets_v2.adapter.ActualitesAdapter;
import com.example.doctipets_v2.databinding.FragmentActualitesBinding;

public class ActualitesFragment extends Fragment {

    private FragmentActualitesBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentActualitesBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        // Utilisez le ViewBinding pour récupérer le RecyclerView
        RecyclerView recyclerViewActualites = binding.recyclerViewActualites;
        recyclerViewActualites.setAdapter(new ActualitesAdapter());

        Button btnAjouterActualites = binding.btnAjouterActualites;

        // Assurez-vous que le bouton n'est pas nul avant de définir le clic
        if (btnAjouterActualites != null) {
            btnAjouterActualites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoAjoutFragment();
                }
            });
        }

        return rootView;
    }

    // Méthode appelée lorsque le bouton est cliqué pour accéder à AjoutFragment
    public void gotoAjoutFragment() {
        // Remplacez le fragment actuel par le fragment AjoutFragment
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new AjoutFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
