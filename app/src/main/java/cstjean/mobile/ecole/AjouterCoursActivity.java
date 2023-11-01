package cstjean.mobile.ecole;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.google.android.material.textfield.TextInputEditText;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class AjouterCoursActivity extends AppCompatActivity {
    private TextInputEditText InputDepartement;
    private TextInputEditText inputNum;
    private Button btnAjouter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_departement);

        InputDepartement = findViewById(R.id.input_departement);
        inputNum = findViewById(R.id.input_numero);
        btnAjouter = findViewById(R.id.btn_ajouter);

        btnAjouter.setOnClickListener(v -> {
            CoursSession coursSession = new CoursSession(InputDepartement.getText().toString(),inputNum.getText().toString());
            SingletonEcole.getInstance().ajouter(coursSession);
            finish();
        });
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, AjouterCoursActivity.class);
        return intent;
    }
}
