package br.senac.pi.calculoimc;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.BLUE);
        toolbar.setLogo(R.drawable.imc);
        toolbar.setTitle("Calculo IMC");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        findViewById(R.id.btn_calcular).setOnClickListener(calcular());


    }

    View.OnClickListener calcular(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               double resultado;
                EditText edtPeso= (EditText) findViewById(R.id.edtPeso);
                EditText edtAltura= (EditText) findViewById(R.id.edtAltura);
                TextView txtResultado= (TextView) findViewById(R.id.txtResultado);
               double altura=Double.parseDouble(edtAltura.getText().toString());
                double peso=Double.parseDouble(edtPeso.getText().toString());

                resultado=peso/(altura*altura);

                if(resultado<=18.5){
                    txtResultado.setText("IMC="+resultado+"\n"+getString(R.string.Abaixo));

                }if(resultado>=18.6 && resultado<=24.9){
                    txtResultado.setText("IMC="+resultado+"\n"+getString(R.string.ideal));
                }if(resultado>=25.0 && resultado<=29.9){
                    txtResultado.setText("IMC="+resultado+"\n"+getString(R.string.levemente));
                }if(resultado>=30 && resultado<=34.9){
                    txtResultado.setText("IMC="+resultado+"\n"+getString(R.string.grau1));
                }if(resultado>=35 && resultado<=39.9){
                    txtResultado.setText("IMC="+resultado+"\n"+getString(R.string.grau2));
                }if(resultado>=40){
                    txtResultado.setText("IMC="+resultado + "\n"+getString(R.string.grau2));
                }





            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
