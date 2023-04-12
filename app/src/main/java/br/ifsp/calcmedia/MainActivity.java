package br.ifsp.calcmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtNota1;
    private EditText txtNota2;
    private TextView lblMedia;
    private Button btnCalcula;
    private Button btnExibe;
    private Button btnSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        lblMedia = findViewById(R.id.lblMedia);
        btnCalcula = findViewById(R.id.btnCalcula);
        btnExibe = findViewById(R.id.btnExibe);
        btnSair = findViewById(R.id.btnSair);

        btnCalcula.setOnClickListener(new EscutadorBotaoCalcula());
        btnExibe.setOnClickListener(new EscutadorBotaoExibe());
        btnSair.setOnClickListener(new EscutadorBotaoSair());
    }

    class EscutadorBotaoSair implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            System.exit(0);
        }
    }

    // Classe interna para o objeto que vai escutar cliques no botão EXIBE:
    class EscutadorBotaoExibe implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // Criando uma string, que vai ser exibida na tela:
            String msg = "";

            // Pegando o texto digitado na caixa txtNome,
            // e colocando em msg, com um pulo de linha no final:
            msg = msg + txtNome.getText() + "\n";

            // Pegando o texto digitado na caixa txtEmail,
            // e colocando em msg, com um pulo de linha no final:
            msg = msg + txtEmail.getText() + "\n";

            // Pegando as notas digitadas em suas caixas,
            // e colocando em msg:
            msg = msg + "Notas: " + txtNota1.getText() + " e " + txtNota2.getText();

            // Finalmente, exibindo msg em um toast:
            Toast.makeText( getApplicationContext(), msg , Toast.LENGTH_LONG ).show();
        }
    }



    // Classe interna para o objeto que vai escutar cliques no botão CALCULA:
    class EscutadorBotaoCalcula implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // Criando variáveis para fazer as contas:
            double n1, n2, media;

            // Pegando e convertendo o valor digitado em txtNota1.
            // ATENÇÃO!!!
            // O método getText() "quase" devolve uma string,
            // mas não é uma string de verdade.
            // Então, em alguns momentos, teremos que forçar a conversão
            // para uma string "de verdade". Se não fizer isso,
            // ele não deixa usar o método para converter para double.
            n1 = Double.parseDouble( txtNota1.getText().toString() );

            // Pegando e convertendo o valor em txtNota2:
            n2 = Double.parseDouble( txtNota2.getText().toString() );

            // Calculando a média:
            media = (n1 + n2)/2;

            // Colocando a media na tela, em lblMedia.
            // (tem que converter para string antes!!!)
            lblMedia.setText( Double.toString( media ) );
        }
    }
}