package br.edu.ifsp.arq.login_hardcore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.arq.login_hardcore.R;
import br.edu.ifsp.arq.login_hardcore.model.CampoVazioException;
import br.edu.ifsp.arq.login_hardcore.model.Login;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button tecla_login;
    private EditText prontuarioEditText;
    private EditText senhaEditText;
    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Views*/
        tecla_login = findViewById(R.id.button_login);
        prontuarioEditText = findViewById(R.id.editText_prontuario);
        senhaEditText = findViewById(R.id.editText_senha);

        /*onClick()*/
        tecla_login.setOnClickListener(this);

        /*Inicializar*/
        login = inicializar();
    }

    @Override
    public void onClick(View view) {
        int user, senha;
        Intent intent = new Intent(this, AccessActivity.class);

        try {
            user = converteDados(prontuarioEditText);
            senha = converteDados(senhaEditText);

            if (login.fazerLogin(user, senha)) {
                String result = "Bem vindo " + user;
                intent.putExtra("Value", result);
                startActivity(intent);
            } else {
                String result = "Erro no Login";
                intent.putExtra("Value", result);
                startActivity(intent);
            }
        }catch (CampoVazioException cve){
            Toast.makeText(this, "Os campos usuário e senha devem ser preenchidos!", Toast.LENGTH_SHORT).show();
        }
    }

    private int converteDados(EditText texto) throws CampoVazioException{
        int nro = 0;

        if (texto.getText().toString().matches("")){
            throw new CampoVazioException();
        } else{
            nro = Integer.valueOf(texto.getText().toString());
        }

        return nro;
    }

    private Login inicializar() {
        Login l = Login.getInstance();

        return l;
    }
}