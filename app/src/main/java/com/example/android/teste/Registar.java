package com.example.android.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Registar extends AppCompatActivity {
EditText etNome, etEmail, etPassword, etDataNasc, etTelefone;
RadioGroup rgSexo;
RadioButton rbSexo;
Button btRegistar, btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        etNome = findViewById(R.id.et_nome);
        etEmail = findViewById(R.id.et_email);
        etTelefone = findViewById(R.id.et_telefone);
        etDataNasc = findViewById(R.id.et_dataNasc);
        etPassword = findViewById(R.id.et_pass);
        rgSexo = findViewById(R.id.rg_sexo);
        btCancelar = findViewById(R.id.bt_cancelar);
        btRegistar = findViewById(R.id.bt_register);

        int sexoId=rgSexo.getCheckedRadioButtonId();
        rbSexo = findViewById(sexoId);

        String nome1 = etNome.getText().toString();
        String dataNasc1 = etDataNasc.getText().toString();
        String email1 = etEmail.getText().toString();
        String pass1 = etPassword.getText().toString();
        String telefone1 = etTelefone.getText().toString();
        String sexo1 = rbSexo.getText().toString();

        btRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntend = new Intent();
                returnIntend.putExtra("nome1", nome1);
                returnIntend.putExtra("dataNasc1", dataNasc1);
                returnIntend.putExtra("email1", email1);
                returnIntend.putExtra("pass1", pass1);
                returnIntend.putExtra("telefone1", telefone1);
                returnIntend.putExtra("sexo1", sexo1);

                setResult(RESULT_OK, returnIntend);
                finish();

                Intent IrWelcom = new Intent(getApplicationContext(), Welcome.class);
                startActivity(IrWelcom);
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelar = new Intent();
                setResult(RESULT_OK, cancelar);
                finish();
            }
        });
    }

    public void RadioGroupSexo(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.rb_men:
                if (checked)
                    break;
            case R.id.rb_woman:
                if (checked)
                    break;
        }
    }
}
