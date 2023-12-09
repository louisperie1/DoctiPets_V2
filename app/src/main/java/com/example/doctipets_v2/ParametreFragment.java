package com.example.doctipets_v2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ParametreFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_parametre, container, false);

        // Récupérer le bouton de retour
        Button btnRetourAccueil = rootView.findViewById(R.id.btnRetourAccueil);
        Button boutonActivationNotifications = rootView.findViewById(R.id.btnNotificationsPush);
        // Récupérer les boutons
        Button btnQui = rootView.findViewById(R.id.btn_qui);
        Button btnReseaux = rootView.findViewById(R.id.btn_reseaux);
        Button btnContacter = rootView.findViewById(R.id.btn_contacter);

        // Ajouter un écouteur de clic pour le bouton de retour
        btnRetourAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retourAccueil();
            }
        });

        // Ajouter un écouteur d'événements pour le clic sur le bouton
        btnQui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remplacer le fragment actuel par le fragment "rdvpasser"
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new QuiFragment()); // Remplacez RdvPasserFragment par le nom de votre fragment "rdvpasser"
                transaction.addToBackStack(null);  // Permet d'ajouter la transaction à la pile de retour
                transaction.commit();
            }
        });

        // Ajouter un écouteur d'événements pour le clic sur le bouton
        btnReseaux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remplacer le fragment actuel par le fragment "rdvpasser"
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new ReseauxFragment()); // Remplacez RdvPasserFragment par le nom de votre fragment "rdvpasser"
                transaction.addToBackStack(null);  // Permet d'ajouter la transaction à la pile de retour
                transaction.commit();
            }
        });


        // Ajouter un écouteur d'événements pour le clic sur le bouton
        btnContacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remplacer le fragment actuel par le fragment "rdvpasser"
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, new ContacterFragment()); // Remplacez RdvPasserFragment par le nom de votre fragment "rdvpasser"
                transaction.addToBackStack(null);  // Permet d'ajouter la transaction à la pile de retour
                transaction.commit();
            }
        });


        // Ajouter un écouteur de clic au bouton
        boutonActivationNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Afficher une boîte de dialogue demandant la permission
                afficherBoiteDialogueActivationNotifications();
            }
        });

        return rootView;
    }


    // Méthode pour afficher la boîte de dialogue demandant la permission
    private void afficherBoiteDialogueActivationNotifications() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Activation des notifications");
        builder.setMessage("Voulez-vous activer les notifications push ?");

        // Ajouter un bouton "Oui"
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Ici, vous pouvez implémenter le code pour demander la permission des notifications push
                // Cela dépend de la façon dont vous implémentez les notifications push dans votre application
                // Vous pouvez utiliser Firebase Cloud Messaging (FCM) ou une autre bibliothèque.

                // Par exemple (utilisation fictive):
                demanderPermissionNotifications();
            }
        });

        // Ajouter un bouton "Non"
        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // L'utilisateur a choisi de ne pas activer les notifications
                dialogInterface.dismiss();
            }
        });

        // Afficher la boîte de dialogue
        builder.show();
    }

    // Méthode pour vérifier si les notifications sont déjà activées
    private boolean notificationsSontDejaActivees() {
        // Vous devez implémenter cette méthode en fonction de la logique de votre application
        // Par exemple, en vérifiant les paramètres de l'application ou l'état de FCM.
        // Retourne true si les notifications sont déjà activées, sinon false.
        return false;
    }

    // Méthode pour demander la permission des notifications
    private void demanderPermissionNotifications() {
        // Vous devez implémenter cette méthode en fonction de la logique de votre application
        // Cela peut inclure l'utilisation de Firebase Cloud Messaging (FCM) pour enregistrer l'appareil
        // et activer les notifications. Consultez la documentation FCM pour plus de détails.

        // Exemple fictif avec FCM :
        // FirebaseMessaging.getInstance().getToken()
        // Enregistrez le jeton sur votre serveur pour activer les notifications.

        afficherMessage("Demande de permission des notifications en cours...");
    }

    // Méthode pour afficher un message à l'utilisateur
    private void afficherMessage(String message) {
        // Vous pouvez afficher le message comme vous le souhaitez
        // Par exemple, à l'aide d'un Toast ou d'une autre vue.
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    // Méthode pour retourner à l'accueil
    private void retourAccueil() {
        // Remplacez le fragment actuel par le fragment AccueilFragment
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new AccueilFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
