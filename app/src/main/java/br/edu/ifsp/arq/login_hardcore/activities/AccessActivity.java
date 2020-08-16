package br.edu.ifsp.arq.login_hardcore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import br.edu.ifsp.arq.login_hardcore.R;

public class AccessActivity extends AppCompatActivity {
        private TextView resposta;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_access);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                resposta = findViewById(R.id.textView_resposta);

                String string = getIntent().getExtras().getString("Value");
                resposta.setText(string);
        }
}