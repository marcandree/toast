package nova.ch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener
{
    Button btn_short,btn_long,btn_custom;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initalisation des boutons qui sont sur l'interface graphique
        btn_short = (Button) findViewById(R.id.btn_short);
        btn_long= (Button) findViewById(R.id.btn_long);
        btn_custom = (Button) findViewById(R.id.btn_custom);

        // initalisation de l'écoute sur les boutons
        btn_short.setOnClickListener(this);
        btn_long.setOnClickListener(this);
        btn_custom.setOnClickListener(this);


    }


    /** méthode réagissant au clique des boutons
     * pour détecter le bouton qui a été cliqué
     * on l'identifie grâce à son id
     *
     */
    @Override
    public void onClick(View view)
    {
        //recherche la correspondance des boutons
        if(view.getId()==R.id.btn_short)
        {
            Toast.makeText(this,"Le Toast est court",Toast.LENGTH_SHORT).show();
        }
        if (view.getId()==R.id.btn_long)
        {
            Toast.makeText(this,"Le Toast est long",Toast.LENGTH_LONG).show();
        }
        if(view.getId()==R.id.btn_custom)
        {
            showToastLayout();
        }
    }

    public void showToastLayout()
    {
        // appelle du layout personnalisé pour le Toast
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout_toast,(ViewGroup) findViewById(R.id.toast_layout_id));

        // initialisation du message
        TextView text = (TextView) layout.findViewById(R.id.txt_title);
        text.setText("Toast personnalisé");

        // configuration du Toast
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
