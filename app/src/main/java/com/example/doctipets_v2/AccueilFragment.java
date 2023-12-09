package com.example.doctipets_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.doctipets_v2.databinding.FragmentAccueilBinding;

public class AccueilFragment extends Fragment {

    private FragmentAccueilBinding binding;
    private View rootView;
    public AccueilFragment() {
        // Constructeur vide requis.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAccueilBinding.inflate(inflater, container, false);
        rootView = binding.getRoot();

        Button btnGoToRecherche = rootView.findViewById(R.id.bouton_recherche);
        Button btnGotoParametre = rootView.findViewById(R.id.btnParametre);

        CheckBox checkBox_accueil = binding.checkBoxAccueil;
        CheckBox checkBox2_accueil = binding.checkBox2Accueil;
        RadioGroup radioGroupOptions = binding.radioGroup;

        EditText editTextNature = rootView.findViewById(R.id.NatureBesoin);
        EditText editTextLocalisation = rootView.findViewById(R.id.Localisation);

        // Assurez-vous que le bouton n'est pas nul avant de définir le clic
        if (btnGoToRecherche != null) {
            btnGoToRecherche.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToRechercheFragment();
                }
            });
        }

        // Assurez-vous que le bouton n'est pas nul avant de définir le clic
        if (btnGotoParametre != null) {
            btnGotoParametre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToParametreFragment();
                }
            });
        }

        // Ajouter un écouteur pour le changement d'état des CheckBox
        checkBox_accueil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Option 1 est cochée, décocher Option 2
                    checkBox2_accueil.setChecked(false);
                }
            }
        });

        checkBox2_accueil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Option 2 est cochée, décocher Option 1
                    checkBox_accueil.setChecked(false);
                }
            }
        });

        editTextNature.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                handleEditTextFocusChange(editTextNature, hasFocus, "Nature");
            }
        });

        editTextLocalisation.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                handleEditTextFocusChange(editTextLocalisation, hasFocus, "Localisation");
            }
        });

        return rootView;
    }

    // Méthode appelée lorsque le bouton est cliqué pour accéder à RechercheFragment
    public void goToRechercheFragment() {
        // Remplacez le fragment actuel par le fragment RechercheFragment
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new RechercheFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void goToParametreFragment() {
        // Remplacez le fragment actuel par le fragment RechercheFragment
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new ParametreFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }


    // Méthode pour gérer le changement de focus des EditText
    private void handleEditTextFocusChange(EditText editText, boolean hasFocus, String placeholder) {
        if (hasFocus) {
            // Le champ de texte a le focus, effacer le texte de préremplissage
            editText.setText("");
        } else {
            // Le champ de texte a perdu le focus, restaurer le texte de préremplissage si nécessaire
            if (editText.getText().toString().isEmpty()) {
                editText.setText(placeholder);
            }
        }
    }
}
