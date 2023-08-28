package com.ezequieldiaz.conversordemonedas;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ezequieldiaz.conversordemonedas.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityViewModel mavm = ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(getApplication())
                .create(MainActivityViewModel
                        .class);
        ActivityMainBinding bind = ActivityMainBinding
                .inflate(getLayoutInflater());
        setContentView(bind
                .getRoot());
        mavm.getValor()
                .observe(this, new Observer<Double>() {
                    @Override
                    public void onChanged(Double aDouble) {
                        String total = String.format("%.2f", aDouble);
                        if (bind.rbConvertirDolares.isChecked()) {
                            bind.tvMontoConvertido.setText("La conversión dá un total de: " + total + " Dolares.");
                        }
                        if (bind.rbConvertirEuros.isChecked()) {
                            bind.tvMontoConvertido.setText("La conversión dá un total de: " + total + " Euros.");
                        }
                    }
                });

        bind.rbConvertirDolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bind.etIngresarValor.getText().toString().isEmpty()) {
                    Toast.makeText(view.getContext(), "Por favor, ingrese un monto a convertir", LENGTH_LONG).show();
                } else {
                    mavm.convertirDolares(bind.etIngresarValor.getText().toString());
                }
            }
        });

        bind.rbConvertirEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bind.etIngresarValor.getText().toString().isEmpty()) {
                    Toast.makeText(view.getContext(), "Por favor, ingrese un monto a convertir", LENGTH_LONG).show();
                } else {
                    mavm.convertirEuros(bind.etIngresarValor.getText().toString());
                }
            }
        });
    }
}
