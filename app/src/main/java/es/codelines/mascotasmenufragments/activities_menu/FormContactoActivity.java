package es.codelines.mascotasmenufragments.activities_menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import es.codelines.mascotasmenufragments.R;
import es.codelines.mascotasmenufragments.email_send.EmailSender;

/**
 * Created by abraham on 21/2/17.
 */

public class FormContactoActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private Button btnEnviarComentario;
    private Button btnUploadFile;
    private static final int FILE_CHOOSER = 100;
    private TextInputEditText etFile;
    private ImageView imgvImagen;
    public Uri uri;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case FILE_CHOOSER:
                String TAG = "Tag";
                Log.d(TAG, "onActivityResult: FILE_CHOOSER =" + FILE_CHOOSER);
                if (resultCode == RESULT_OK) {
                    uri = data.getData(); //obtener el uri content
                    Log.d(TAG, "uri: " + uri.toString());
                    etFile.setText(uri.toString());
                    imgvImagen.setImageURI(uri);
                } else {
                    //if (resultCode == RESULT_CANCELED) {
                    Log.w(TAG, "Cancelado por el usuario");
                }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contacto);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnEnviarComentario = (Button) findViewById(R.id.btnEnviarComentario);
        btnUploadFile = (Button) findViewById(R.id.btnUploadFile);
        etFile = (TextInputEditText) findViewById(R.id.etFile);
        imgvImagen = (ImageView) findViewById(R.id.imgvImagen);

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action on click

                TextInputEditText name = (TextInputEditText) findViewById(R.id.etName);
                TextInputEditText email = (TextInputEditText) findViewById(R.id.etEmail);
                TextInputEditText message = (TextInputEditText) findViewById(R.id.etMessage);

                EmailSender emailSender = new EmailSender();

                emailSender.execute("admin@avic-placaestaciofigueres.com", "Admin*16", email.getText().toString(), name.getText().toString(), message.getText().toString(), "/storage/emulated/0/DCIM/100ANDRO/DSC_0001.JPG");

                Toast.makeText(FormContactoActivity.this, name.getText().toString() + email.getText().toString() + message.getText().toString(), Toast.LENGTH_LONG).show();
                if (uri != null) {
                    Toast.makeText(FormContactoActivity.this, uri.toString(), Toast.LENGTH_LONG).show();
                }
                //EmailSender emailSender2=new EmailSender();

                //emailSender.execute(emailSenderData.getAddress(), emailSenderData.getPassword(), arrayRecipients, "Novedad - " + format.format(newDate), emailBody, _fullThumbFileName);
            }
        });
        // selecciono el archivo
        btnUploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Selecciona Archivo"), FILE_CHOOSER);
            }
        });

    }
}
