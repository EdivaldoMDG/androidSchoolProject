package com.example.android.teste;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int USER_PASS_REQUEST = 1;
    Button bt_continuar;
    public static String nome="";
    public static String dataNasc="";
    public static String email="";
    public static String pass="";
    public static String telefone="";
    public static String sexo="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_continuar = findViewById(R.id.bt_continue);

        bt_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerForContextMenu(bt_continuar);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == USER_PASS_REQUEST){
            if (resultCode == RESULT_OK){

                String nomeR = data.getStringExtra("nome1");
                String dataNascR = data.getStringExtra("apelido1");
                String emailR= data.getStringExtra("email1");
                String passR = data.getStringExtra("pass1");
                String telefoneR = data.getStringExtra("telefone1");
                String sexoR= data.getStringExtra("sexo1");

                nome=nomeR;
                dataNasc=dataNascR;
                email=emailR;
                pass=passR;
                telefone=telefoneR;
                sexo=sexoR;
            }
        }


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contexto,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.login_item:
                return true;
            case R.id.register_item:
                Intent registar = new Intent(getApplicationContext(),Registar.class);
                startActivityForResult(registar,USER_PASS_REQUEST);
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }
}