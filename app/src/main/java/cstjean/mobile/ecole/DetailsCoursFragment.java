package cstjean.mobile.ecole;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.app.R;
import com.google.android.material.textfield.TextInputEditText;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;
import cstjean.mobile.ecole.travail.rapport.RapportTravaux;

public class DetailsCoursFragment extends Fragment {
    interface Callbacks {
        int getIndexCourant();
    }

    private TextView txtDepartement;
    private TextView txtNumero;
    private TextView txtTravaux;
    private Callbacks callbacks = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_cours, container, false);

        txtDepartement = view.findViewById(R.id.txt_departement);
        txtNumero = view.findViewById(R.id.txt_numero);
        txtTravaux = view.findViewById(R.id.txt_travaux);

        int indexCourant = callbacks.getIndexCourant();

        CoursSession coursSession = SingletonEcole.getCoursSession(indexCourant);

        txtDepartement.setText(coursSession.getDepartement());
        txtNumero.setText(coursSession.getNumero());
        txtTravaux.setText(RapportTravaux.getRapportTravaux(coursSession));

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }
}
