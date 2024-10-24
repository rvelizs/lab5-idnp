package com.mv.lab05_idnp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Botones de la actividad principal
        Button btnCatedral = findViewById(R.id.button);
        Button btnClaustro = findViewById(R.id.button2);

        // Configuración de eventos onClick para cada botón
        btnCatedral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar el fragmento de la Catedral
                loadFragment(new fragmentCatedral());
            }
        });

        btnClaustro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar el fragmento de Claustro
                loadFragment(new claustro());
            }
        });
    }

    // Método para cargar el fragmento
    private void loadFragment(Fragment fragment) {
        // Reemplazar el contenido del FragmentContainerView con el nuevo fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.addToBackStack(null); // Agrega la transacción a la pila de retroceso
        transaction.commit();
    }
}