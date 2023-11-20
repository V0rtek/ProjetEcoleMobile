package cstjean.mobile.ecole;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;

import java.util.List;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class ListeCoursFragment extends Fragment {
    private ImageButton btnAjouter;
    private RecyclerView recyclerViewCours;
    private CoursSessionListAdapter adapterCoursSession;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liste_cours, container, false);
        btnAjouter = view.findViewById(R.id.btn_ajouter);
        btnAjouter.setOnClickListener(v -> {
            Intent intent = AjouterCoursActivity.newIntent(getActivity());
            startActivity(intent);
        });

        recyclerViewCours = view.findViewById(R.id.recycler_view_cours);
        recyclerViewCours.setLayoutManager(new LinearLayoutManager(getActivity()));

        SingletonEcole singletonEcole = SingletonEcole.getInstance();
        List<CoursSession> listeCoursSession = singletonEcole.getListeCoursSession();

        adapterCoursSession = new CoursSessionListAdapter(listeCoursSession);
        recyclerViewCours.setAdapter(adapterCoursSession);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SingletonEcole singletonEcole = SingletonEcole.getInstance();
        List<CoursSession> listeCoursSession = singletonEcole.getListeCoursSession();
        adapterCoursSession = new CoursSessionListAdapter(listeCoursSession);
        recyclerViewCours.setAdapter(adapterCoursSession);
    }

}

/*
public class ListeCoursFragment extends Fragment {
    private static final String KEY_INDEXCOURANT = "indexcourant";
    private int indexCourant = 0;

    private ImageButton btnVoir;
    private ImageButton btnSuivant;
    private ImageButton btnPrecedent;
    private TextView txtDepartement;
    private ImageButton btnAjouter;

    public void updateDepartement() {
        Log.d("UPDATE","UPDATE");
        String departement =
                SingletonEcole
                        .getInstance()
                        .getCoursSession(indexCourant)
                        .getDepartementNumero();
        txtDepartement.setText(departement);
        btnSuivant.setEnabled(indexCourant <
                (SingletonEcole
                        .getInstance()
                        .getNbCoursSession() - 1));
        btnPrecedent.setEnabled(indexCourant > 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ListeCoursFragment", "create");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("ListeCoursFragment", "createView");

        if (savedInstanceState != null) {
            indexCourant = savedInstanceState.getInt(KEY_INDEXCOURANT, 0);
        }

        View view = inflater.inflate(R.layout.fragment_liste_cours, container, false);

        btnVoir = view.findViewById(R.id.btn_voir);
        btnPrecedent = view.findViewById(R.id.btn_precedent);
        btnSuivant = view.findViewById(R.id.btn_suivant);
        txtDepartement = view.findViewById(R.id.txt_departement);
        btnAjouter = view.findViewById(R.id.btn_ajouter);

        btnPrecedent.setOnClickListener(v -> {
            indexCourant -= 1;
            updateDepartement();
        });
        btnSuivant.setOnClickListener(v ->{
            indexCourant += 1;
            updateDepartement();
        });

        btnVoir.setOnClickListener(v -> {
            Intent intent = DetailsCoursActivity.newIntent(getActivity(), indexCourant);
            startActivity(intent);
        });
        btnAjouter.setOnClickListener(v -> {
            Intent intent = AjouterCoursActivity.newIntent(getActivity());
            startActivity(intent);
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateDepartement();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ProjetEcole", "onSaveInstanceState");
        outState.putInt(KEY_INDEXCOURANT, indexCourant);
    }

}

 */