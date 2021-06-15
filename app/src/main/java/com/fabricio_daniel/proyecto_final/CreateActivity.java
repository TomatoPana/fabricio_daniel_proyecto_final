package com.fabricio_daniel.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_create);
        
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

        switch (origen) {
            case "Clientes":
                setClientes();
                break;
            case "Directores":
                setDirectores();
                break;
            case "Distribuidores":
                setDistribuidores();
                break;
            case "Empleados":
                setEmpleados();
                break;
            case "Peliculas":
                setPeliculas();
                break;
            case "Prestamos":
                setPrestamos();
                break;
            default:
                finish();
                break;
        }

    }

    private void setClientes() {
        textView.setText("Creando nuevo elemento Clientes");
        editText1.setHint("Nombre");
        editText2.setHint("Apellido Paterno");
        editText3.setHint("Apellido Materno");
        editText4.setHint("Domicilio");
        editText5.setHint("Telefono");
        editText6.setVisibility(View.INVISIBLE);

        button.setOnClickListener(v -> {
            Clientes dato = new Clientes();

            dato.setNombre(editText1.getText().toString());
            dato.setApellido_paterno(editText2.getText().toString());
            dato.setApellido_materno(editText3.getText().toString());
            dato.setDomicilio(editText4.getText().toString());
            dato.setTelefono(editText5.getText().toString());

            ClientesDB database = new ClientesDB();

            database.insertCliente(dato);

            Toast.makeText(this, "Elemento insertado correctamente", Toast.LENGTH_LONG).show();

            finish();

        });
    }

    private void setDirectores() {
        textView.setText("Creando nuevo elemento Directores");
        editText1.setHint("Nombre");
        editText2.setHint("Apellido Paterno");
        editText3.setHint("Apellido Materno");
        editText4.setHint("ID Pelicula");
        editText5.setVisibility(View.INVISIBLE);
        editText6.setVisibility(View.INVISIBLE);

        button.setOnClickListener(v -> {
            Directores dato = new Directores();

            dato.setNombre(editText1.getText().toString());
            dato.setApellido_paterno(editText2.getText().toString());
            dato.setApellido_materno(editText3.getText().toString());
            dato.setPeliculas_id(Integer.parseInt(editText4.getText().toString()));

            DirectoresDB database = new DirectoresDB();

            database.insertDirector(dato);

            Toast.makeText(this, "Elemento insertado correctamente", Toast.LENGTH_LONG).show();

            finish();

        });
    }

    private void setDistribuidores() {
        textView.setText("Creando nuevo elemento Distribuidores");
        editText1.setHint("Nombre");
        editText2.setHint("Telefono");
        editText3.setHint("E-mail");
        editText4.setHint("ID Pelicula");
        editText5.setVisibility(View.INVISIBLE);
        editText6.setVisibility(View.INVISIBLE);

        button.setOnClickListener(v -> {
            Distribuidores dato = new Distribuidores();

            dato.setNombre(editText1.getText().toString());
            dato.setTelefono(editText2.getText().toString());
            dato.setEmail(editText3.getText().toString());
            dato.setPeliculas_id(Integer.parseInt(editText4.getText().toString()));

            DistribuidoresDB database = new DistribuidoresDB();

            database.insertDistribuidor(dato);

            Toast.makeText(this, "Elemento insertado correctamente", Toast.LENGTH_LONG).show();

            finish();

        });
    }

    private void setEmpleados() {
        textView.setText("Creando nuevo elemento Empleados");
        editText1.setHint("Nomina");
        editText2.setHint("Nombre");
        editText3.setHint("Apellido Paterno");
        editText4.setHint("Apellido Materno");
        editText5.setHint("Horario");
        editText6.setHint("Telefono");

        button.setOnClickListener(v -> {
            Empleados dato = new Empleados();

            dato.setNomina(editText1.getText().toString());
            dato.setNombre(editText2.getText().toString());
            dato.setApellido_paterno(editText3.getText().toString());
            dato.setApellido_materno(editText4.getText().toString());
            dato.setHorario(editText5.getText().toString());
            dato.setTelefono(editText6.getText().toString());

            EmpleadosDB database = new EmpleadosDB();

            database.insertEmpleado(dato);

            Toast.makeText(this, "Elemento insertado correctamente", Toast.LENGTH_LONG).show();

            finish();

        });
    }

    private void setPeliculas() {
        textView.setText("Creando nuevo elemento Peliculas");
        editText1.setHint("Codigo de la Pelicula");
        editText2.setHint("Fecha de Publicacion");
        editText3.setHint("Nombre");

        editText4.setVisibility(View.INVISIBLE);
        editText5.setVisibility(View.INVISIBLE);
        editText6.setVisibility(View.INVISIBLE);

        button.setOnClickListener(v -> {
            Peliculas dato = new Peliculas();

            dato.setCodigo_pelicula(editText1.getText().toString());
            dato.setFecha_publicacion(editText2.getText().toString());
            dato.setNombre(editText3.getText().toString());

            PeliculasDB database = new PeliculasDB();

            database.insertPelicula(dato);

            Toast.makeText(this, "Elemento insertado correctamente", Toast.LENGTH_LONG).show();

            finish();

        });
    }

    private void setPrestamos() {
        textView.setText("Creando nuevo elemento Prestamos");

        editText1.setHint("Fecha de Entrega");
        editText2.setHint("Fecha de Salida");

        editText3.setVisibility(View.INVISIBLE);
        editText4.setVisibility(View.INVISIBLE);
        editText5.setVisibility(View.INVISIBLE);
        editText6.setVisibility(View.INVISIBLE);

        button.setOnClickListener(v -> {
            Prestamos dato = new Prestamos();

            dato.setFecha_entrega(editText1.getText().toString());
            dato.setFecha_salida(editText2.getText().toString());

            PrestamosDB database = new PrestamosDB();

            if(database.insertPrestamo(dato)) {
                Toast.makeText(this, "Elemento insertado correctamente", Toast.LENGTH_LONG).show();

                finish();
            } else {
                Toast.makeText(this, "Ocurrió un error", Toast.LENGTH_LONG).show();
            }


        });
    }

}