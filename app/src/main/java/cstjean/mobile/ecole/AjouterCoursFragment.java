package cstjean.mobile.ecole;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.app.R;
import com.google.android.material.textfield.TextInputEditText;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class AjouterCoursFragment extends Fragment {
    private static final String KEY_INDEXCOURANT = "indexcourant";
    private int indexCourant = 0;

    private TextInputEditText InputDepartement;
    private TextInputEditText inputNum;
    private Button btnAjouter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            indexCourant = savedInstanceState.getInt(KEY_INDEXCOURANT, 0);
        }

        View view = inflater.inflate(R.layout.fragment_ajouter_cours, container, false);

        InputDepartement = view.findViewById(R.id.input_departement);
        inputNum = view.findViewById(R.id.input_numero);
        btnAjouter = view.findViewById(R.id.btn_ajouter);

        btnAjouter.setOnClickListener(v -> {
            CoursSession coursSession = new CoursSession(InputDepartement.getText().toString(),inputNum.getText().toString());
            SingletonEcole.getInstance().ajouter(coursSession);
            getActivity().finish();
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEXCOURANT, indexCourant);
    }
}
