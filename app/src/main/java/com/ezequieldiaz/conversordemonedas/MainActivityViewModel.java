package com.ezequieldiaz.conversordemonedas;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Double> valor = new MutableLiveData<>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Double> getValor(){
        return valor;
    }

    public void convertirDolares(String dato){
        valor.setValue(Double.parseDouble(dato)*0.92445);
    }

    public void convertirEuros(String dato){
        valor.setValue(Double.parseDouble(dato)*1.08160);
    }

}
