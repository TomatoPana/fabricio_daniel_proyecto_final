package com.fabricio_daniel.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    TextView textView;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textView = findViewById(R.id.textView);
        editText1 = findViewById(R.id.EditText1);
        editText2 = findViewById(R.id.EditText2);
        editText3 = findViewById(R.id.EditText3);
        editText4 = findViewById(R.id.EditText4);
        editText5 = findViewById(R.id.EditText5);
        editText6 = findViewById(R.id.EditText6);
        button = findViewById(R.id.button);

        Intent intent = getIntent();
        String origen = intent.getExtras().getString("Origen");
        int id = intent.getExtras().getInt("ID");

        switch (origen) {
            case "Clientes":
                setClientes(id);
                break;
            case "Directores":
                setDirectores(id);
                break;
            case "Distribuidores":
                setDistribuidores(id);
                break;
            case "Empleados":
                setEmpleados(id);
                break;
            case "Peliculas":
                setPeliculas(id);
                break;
            case "Prestamos":
                setPrestamos(id);
                break;
            default:
                finish();
                break;
        }

    }

    private void setClientes(int id) {
        textView.setText("Mostrando elemento Clientes");
        editText1.setHint("Nombre");
        editText2.setHint("Apellido Paterno");
        editText3.setHint("Apellido Materno");
        editText4.setHint("Domicilio");
        editText5.setHint("Telefono");
        editText6.setVisibility(View.INVISIBLE);

        Clientes dato;
        ClientesDB database = new ClientesDB();
        dato = database.getCliente(id);


        editText1.setText(dato.getNombre());
        editText2.setText(dato.getApellido_paterno());
        editText3.setText(dato.getApellido_materno());
        editText4.setText(dato.getDomicilio());
        editText5.setText(dato.getTelefono());

        button.setOnClickListener(v -> {

            finish();

        });
    }

    private void setDirectores(int id) {
        textView.setText("Mostrando elemento Directores");
        editText1.setHint("Nombre");
        editText2.setHint("Apellido Paterno");
        editText3.setHint("Apellido Materno");
        editText4.setHint("ID Pelicula");
        editText5.setVisibility(View.INVISIBLE);
        editText6.setVisibility(View.INVISIBLE);

        Directores dato;
        DirectoresDB database = new DirectoresDB();
        dato = database.getDirector(id);


        editText1.setText(dato.getNombre());
        editText2.setText(dato.getApellido_paterno());
        editText3.setText(dato.getApellido_materno());
        editText4.setText(String.valueOf(dato.getPeliculas_id()));


        button.setOnClickListener(v -> {

            finish();

        });
    }

    private void setDistribuidores(int id) {
        textView.setText("Mostrando elemento Distribuidores");
        editText1.setHint("Nombre");
        editText2.setHint("Telefono");
        editText3.setHint("E-mail");
        editText4.setHint("ID Pelicula");
        editText5.setVisibility(View.INVISIBLE);
        editText6.setVisibility(View.INVISIBLE);

        Distribuidores dato;
        DistribuidoresDB database = new DistribuidoresDB();
        dato = database.getDistribuidor(id);


        editText1.setText(dato.getNombre());
        editText2.setText(dato.getTelefono());
        editText3.setText(dato.getEmail());
        editText4.setText(String.valueOf(dato.getPeliculas_id()));

        button.setOnClickListener(v -> {

            finish();

        });
    }

    private void setEmpleados(int id) {
        textView.setText("Mostrando elemento Empleados");
        editText1.setHint("Nomina");
        editText2.setHint("Nombre");
        editText3.setHint("Apellido Paterno");
        editText4.setHint("Apellido Materno");
        editText5.setHint("Horario");
        editText6.setHint("Telefono");

        Empleados dato;
        EmpleadosDB database = new EmpleadosDB();
        dato = database.getEmpleado(id);


        editText1.setText(dato.getNomina());
        editText2.setText(dato.getNombre());
        editText3.setText(dato.getApellido_paterno());
        editText4.setText(dato.getApellido_materno());
        editText5.setText(dato.getHorario());
        editText6.setText(dato.getTelefono());

        button.setOnClickListener(v -> {

            finish();

        });
    }



    private void setPeliculas(int id) {
        textView.setText("Mostrando elemento Peliculas");
        editText1.setHint("Codigo de la Pelicula");
        editText2.setHint("Fecha de la Publicacion");
        editText3.setHint("Nombre");
        editText4.setVisibility(View.INVISIBLE);
        editText5.setVisibility(View.INVISIBLE);
        editText6.setVisibility(View.INVISIBLE);

        Peliculas dato;
        PeliculasDB database = new PeliculasDB();
        dato = database.getPelicula(id);


        editText1.setText(dato.getCodigo_pelicula());
        editText2.setText(dato.getFecha_publicacion());
        editText3.setText(dato.getNombre());

        button.setOnClickListener(v -> {

            finish();

        });
    }


    private void setPrestamos(int id) {
        textView.setText("Mostrando elemento Prestamos");
        editText1.setHint("Fecha de entrega");
        editText2.setHint("Fecha de salida");
        editText3.setVisibility(View.INVISIBLE);
        editText4.setVisibility(View.INVISIBLE);
        editText5.setVisibility(View.INVISIBLE);
        editText6.setVisibility(View.INVISIBLE);

        Prestamos dato;
        PrestamosDB database = new PrestamosDB();
        dato = database.getPrestamo(id);


        editText1.setText(dato.getFecha_entrega());
        editText2.setText(dato.getFecha_salida());

        button.setOnClickListener(v -> {

            finish();

        });
    }
}