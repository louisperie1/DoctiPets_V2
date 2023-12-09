package com.example.doctipets_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctipets_v2.adapter.RechercheAdapter;
import com.example.doctipets_v2.databinding.FragmentRechercheBinding;

public class RechercheFragment extends Fragment {

    private FragmentRechercheBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRechercheBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        // Utilisez le ViewBinding pour récupérer le RecyclerView
        RecyclerView recyclerViewRecherche = binding.recyclerViewRecherche;
        recyclerViewRecherche.setAdapter(new RechercheAdapter());

        // Retournez la vue créée avec le ViewBinding
        return rootView;
    }
}
