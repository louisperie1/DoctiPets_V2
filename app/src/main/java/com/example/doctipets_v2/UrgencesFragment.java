package com.example.doctipets_v2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.doctipets_v2.R;

public class UrgencesFragment extends Fragment {

    // ... Autres méthodes et membres ...

    public UrgencesFragment() {
        // Constructeur vide requis.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_urgences, container, false);

        Button btnCallEmergency = rootView.findViewById(R.id.bouton_urgences);

        // Assurez-vous que le bouton n'est pas nul avant de définir le clic
        if (btnCallEmergency != null) {
            btnCallEmergency.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showConfirmationDialog(v);
                }
            });
        }

        // ... Initialiser d'autres éléments de l'interface utilisateur ...

        return rootView;
    }

    // Méthode appelée lorsque le bouton est cliqué
    public void showConfirmationDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Confirmation d'appel")
                .setMessage("Êtes-vous sûr de vouloir appeler le numéro d'urgence?")
                .setPositiveButton("Appeler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                        dialIntent.setData(Uri.parse("APPELEZ:3115"));
                        startActivity(dialIntent);
                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // L'utilisateur a annulé l'appel
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
