package com.example.projeto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    private ImageButton lerQrcode;
    private ImageButton digitarMesa;
    private Button voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lerQrcode = (ImageButton)findViewById(R.id.btnQrcode);
        final Activity activity = this;
        digitarMesa = (ImageButton)findViewById(R.id.btnDigitar);
        voltar = (Button)findViewById(R.id.btnVoltar);

        lerQrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Leitor QRCODE");
                integrator.setCameraId(0);
                integrator.initiateScan();


            }
        });

        digitarMesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DigitarMesa().setVisible(true);

            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null){
            if(result.getContents()!= null){
                alert(result.getContents());
            }
            else{
                alert("Scan Cancelado ");
            }
        }else{
        super.onActivityResult(requestCode, resultCode, data);
    }
}
private void alert(String msg){
    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
}
}

