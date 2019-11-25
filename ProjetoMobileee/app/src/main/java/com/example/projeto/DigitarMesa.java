package com.example.projeto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DigitarMesa extends MainActivity {

        private EditText DigiteNumeroMesa;
        private Button btnConfMesa;
        private Button btnVoltarMesa;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                DigiteNumeroMesa = (EditText)findViewById(R.id.DigiteNumeroMesa);
                btnConfMesa = (Button)findViewById(R.id.btnConfMesa);
                btnVoltarMesa = (Button)findViewById(R.id.btnVoltarMesa);

                btnVoltarMesa.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                new MainActivity().setVisible(true);

                        }
                });
                btnConfMesa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
                });
        }


        }
