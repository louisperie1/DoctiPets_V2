package com.example.doctipets_v2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.doctipets_v2.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Chargement initial du fragment Accueil
        replaceFragment(new AccueilFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.menu_Accueil) {
                replaceFragment(new AccueilFragment());
            } else if (itemId == R.id.menu_Rdv) {
                replaceFragment(new RdvFragment());
            } else if (itemId == R.id.menu_Actualites) {
                replaceFragment(new ActualitesFragment());
            } else if (itemId == R.id.menu_Urgences) {
                replaceFragment(new UrgencesFragment());
            } else if (itemId == R.id.menu_Compte) {
                replaceFragment(new CompteFragment());
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
