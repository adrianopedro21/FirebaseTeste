package com.adrlabs.firebaseteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = databaseReferencia.child("usuario");
    //private DatabaseReference produtoReferencia = databaseReferencia.child("produto");
    private DatabaseReference produtoReferencia = databaseReferencia.child("produto").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //usuarioReferencia.child("001").child("nome").setValue("Salaman Bayeko"); //inserir direto no banco
        //usuarioReferencia.child("002").child("nome").setValue("Rokan Sarbub"); //inserir direto no banco

        //fazer insert abaixo: || p/ update: basta substituir o 'value' de determinada coluna dentro do ponto

        /*
        Usuario usuario = new Usuario();
        usuario.setNome("Adriano Pedro");
        usuario.setSobrenome("B Carvalho");
        usuario.setSexo("Masculino");
        usuario.setIdade(30);
        usuarioReferencia.child("001").setValue(usuario);

        usuario.setNome("Fernanda Santos");
        usuario.setSobrenome("O Carvalho");
        usuario.setSexo("Feminino");
        usuario.setIdade(26);
        usuarioReferencia.child("002").setValue(usuario);

        Produto produto = new Produto();
        produto.setDescricao("Iphone");
        produto.setCor("Preto");
        produto.setFabricante("Apple");
        produtoReferencia.child("001").setValue(produto);

        produto.setDescricao("Galaxy");
        produto.setCor("Branco");
        produto.setFabricante("Samsung");
        produtoReferencia.child("002").setValue(produto);

        produto.setDescricao("Mi 6");
        produto.setCor("Preto");
        produto.setFabricante("Xiaomi");
        produtoReferencia.child("003").setValue(produto);
        */

        //fazer consultas:
        produtoReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Log.i("Firebase", dataSnapshot.getValue().toString()); //recuperar direto da variavel

                String child = dataSnapshot.getValue().toString();
                Log.i("Firebase - Child: ", child);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
