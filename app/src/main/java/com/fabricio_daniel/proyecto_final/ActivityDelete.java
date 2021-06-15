package com.fabricio_daniel.proyecto_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityDelete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        Intent intent = getIntent();
        String origen = intent.getExtras().getString("Origen");
        int idElemento = intent.getExtras().getInt("ID");



        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Estás seguro de continuar? La acción no se puede deshacer")

        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                switch (origen) {
                    case "Clientes":
                        ClientesDB database = new ClientesDB();
                        database.deleteCliente(idElemento);
                        break;
                    case "Directores":
                        DirectoresDB database2 = new DirectoresDB();
                        database2.deleteDirector(idElemento);
                        break;
                    case "Distribuidores":
                        DistribuidoresDB database3 = new DistribuidoresDB();
                        database3.deleteDistribuidor(idElemento);
                        break;
                    case "Empleados":
                        EmpleadosDB database4 = new EmpleadosDB();
                        database4.deleteEmpleado(idElemento);
                        break;
                    case "Peliculas":
                        PeliculasDB database5 = new PeliculasDB();
                        database5.deletePelicula(idElemento);
                        break;
                    case "Prestamos":
                        PrestamosDB database6 = new PrestamosDB();
                        database6.deletePrestamo(idElemento);
                        break;
                    default:
                        finish();
                        break;
                }

                Toast.makeText(ActivityDelete.this, "Elemento eliminado correctamente", Toast.LENGTH_LONG).show();
                finish();
            }
        })

        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();

    }
}