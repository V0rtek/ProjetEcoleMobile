package cstjean.mobile.ecole;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

import cstjean.mobile.ecole.travail.CoursSession;
import cstjean.mobile.ecole.travail.SingletonEcole;

public class ListeCoursActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_liste_cours);
        SingletonEcole.getInstance().getListeCoursSession().add(new CoursSession("Philo", "101"));
        SingletonEcole.getInstance().getListeCoursSession().add(new CoursSession("Philo", "210"));
        SingletonEcole.getInstance().getListeCoursSession().add(new CoursSession("Math", "101"));
        SingletonEcole.getInstance().getListeCoursSession().add(new CoursSession("Français", "101"));
        SingletonEcole.getInstance().getListeCoursSession().get(0).getDepartementNumero();

        Log.d("ProjetEcole", "onCreate");
        /* Erreur : Log.e(...)
           Avertissement : Log.w(...)
           Information : Log.i(...)
           Debug : Log.d(...)
           Verbose (en développement seulement) : Log.v(...)*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ProjetEcole", "onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ProjetEcole", "onRestart");
    }
    // ...
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ProjetEcole", "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ProjetEcole", "onDestroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ProjetEcole", "onPause");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ProjetEcole", "onResume");
    }
}