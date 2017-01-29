package losfreitasapps.com.enem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private ImageView hum;
    private ImageView nat;
    private ImageView mat;
    private TextView esp;
    private TextView ing;
    private TextView port;
    private String prova;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        hum = (ImageView) findViewById(R.id.hum);
        hum.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        Intent i = new Intent(v.getContext(), MainActivity.class);
                        i.putExtra("hum", prova);
                        startActivity(i);
                    }
                });
        nat = (ImageView) findViewById(R.id.nat);
        nat.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        Intent i = new Intent(v.getContext(), MainActivity.class);
                        i.putExtra("nat", prova);
                        startActivity(i);
                    }
                });
        mat = (ImageView) findViewById(R.id.mat);
        mat.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        Intent i = new Intent(v.getContext(), MainActivity.class);
                        i.putExtra("mat", prova);
                        startActivity(i);
                    }
                });
        esp = (TextView) findViewById(R.id.esp);
        esp.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        Intent i = new Intent(v.getContext(), MainActivity.class);
                        i.putExtra("esp", prova);
                        startActivity(i);
                    }
                });
        ing = (TextView) findViewById(R.id.ing);
        ing.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        Intent i = new Intent(v.getContext(), MainActivity.class);
                        i.putExtra("ing", prova);
                        startActivity(i);
                    }
                });
        port = (TextView) findViewById(R.id.port);
        port.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        Intent i = new Intent(v.getContext(), MainActivity.class);
                        i.putExtra("port", prova);
                        startActivity(i);
                    }
                });
    }
}
