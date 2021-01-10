package edu.upc.dsa.minim2_museus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MuseumDetail extends AppCompatActivity {

    TextView textName, textDescrip, textDirecc, textPostal, textMun, textEmail, textTelf, textHab, textExt, textAlt;
    ImageView imagenMuseo, imagenEscudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum_detail);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String descripcion = intent.getStringExtra("descripcion");
        String direccionGrupo = intent.getStringExtra("direccionGrupo");
        String postalGrupo = intent.getStringExtra("postalGrupo");
        String municipio = intent.getStringExtra("municipio");
        String email = intent.getStringExtra("email");
        String telefono = intent.getStringExtra("telefono");
        String urlEscudo = intent.getStringExtra("urlEscudo");
        String urlBandera = intent.getStringExtra("urlBandera");
        String urlMuseo = intent.getStringExtra("urlMuseo");
        String numeroHab = intent.getStringExtra("numeroHabitantes");
        String extension = intent.getStringExtra("extension");
        String altitud = intent.getStringExtra("altitud");

        textName = findViewById(R.id.nombreText);
        textDescrip = findViewById(R.id.DescripcionText);
        textDirecc = findViewById(R.id.direccionText);
        textPostal = findViewById(R.id.postalText);
        textMun = findViewById(R.id.municipioText);
        textEmail = findViewById(R.id.emailText);
        textTelf = findViewById(R.id.telefonoText);
        textHab = findViewById(R.id.habitantesText);
        textExt = findViewById(R.id.extensionText);
        textAlt = findViewById(R.id.altitudText);
        imagenMuseo = findViewById(R.id.museoImagen);
        imagenEscudo = findViewById(R.id.escudoImagen);

        textName.setText(nombre);
        textDescrip.setText(descripcion);
        textDirecc.setText(direccionGrupo);
        textPostal.setText("Código Postal: " + postalGrupo);
        textMun.setText(municipio);
        textEmail.setText(email);
        textTelf.setText("Teléfono: " + telefono);
        textHab.setText("Habitantes: " + numeroHab);
        textExt.setText("Extensión: " + extension);
        textAlt.setText("Altitud: " + altitud);
        Picasso.with(getApplicationContext()).load(urlMuseo).into(imagenMuseo);
        Picasso.with(getApplicationContext()).load(urlEscudo).into(imagenEscudo);
    }
}