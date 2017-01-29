package losfreitasapps.com.enem;

import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Moises on 09/09/16.
 */
public class Ingles extends Fragment {
    private TextView texto1TextView;
    private TextView texto2TextView;
    private TextView texto3TextView;
    private TextView texto4TextView;
    private TextView textoa1TextView;
    private TextView textob1TextView;
    private TextView textoc1TextView;
    private TextView textod1TextView;
    private TextView textoe1TextView;
    private TextView disciplinaTextView;
    private TextView textView;
    private ImageView figura1ImageView;
    private ImageView figura2ImageView;
    private ImageView fa1;
    private ImageView fb1;
    private ImageView fc1;
    private ImageView fd1;
    private ImageView fe1;
    private String video;
    private LinearLayout a;
    private LinearLayout b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private int opcao;
    private int tentativas;
    private int alternativa;
    int[] nquestion;
    int nquestions;
    int m;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.content_enem,container,false);

        nquestions = 5;
        m=0;
        tentativas=0;
        textView = (TextView) view.findViewById(R.id.textView);
        disciplinaTextView = (TextView) view.findViewById(R.id.disciplinaTextView);
        texto1TextView = (TextView) view.findViewById(R.id.texto1TextView);
        texto2TextView = (TextView) view.findViewById(R.id.texto2TextView);
        texto3TextView = (TextView) view.findViewById(R.id.texto3TextView);
        texto4TextView = (TextView) view.findViewById(R.id.texto4TextView);

        figura1ImageView = (ImageView) view.findViewById(R.id.figura1ImageView);
        figura2ImageView = (ImageView) view.findViewById(R.id.figura2ImageView);

        fa1 = (ImageView) view.findViewById(R.id.fa1);
        fb1 = (ImageView) view.findViewById(R.id.fb1);
        fc1 = (ImageView) view.findViewById(R.id.fc1);
        fd1 = (ImageView) view.findViewById(R.id.fd1);
        fe1 = (ImageView) view.findViewById(R.id.fe1);

        textoa1TextView = (TextView) view.findViewById(R.id.textoa1TextView);
        textob1TextView = (TextView) view.findViewById(R.id.textob1TextView);
        textoc1TextView = (TextView) view.findViewById(R.id.textoc1TextView);
        textod1TextView = (TextView) view.findViewById(R.id.textod1TextView);
        textoe1TextView = (TextView) view.findViewById(R.id.textoe1TextView);

        a = (LinearLayout)view.findViewById(R.id.a);
        b = (LinearLayout)view.findViewById(R.id.b);
        c = (LinearLayout)view.findViewById(R.id.c);
        d = (LinearLayout)view.findViewById(R.id.d);
        e = (LinearLayout)view.findViewById(R.id.e);

        disciplinaTextView.setText("Inglês");

        nquestion = new int[5];
        int tquestions [];
        int aux;
        Random random  = new Random();
        tquestions = new int[nquestions];
        for(int b=0;b<nquestions;b++){
            tquestions[b]=b+1;
        }
        for (int n=0;n<5;n++){
            do{
                aux=random.nextInt(nquestions);
                nquestion[n]=tquestions[aux];
            }while(tquestions[aux]==0);
            tquestions[aux]=0;
        }

        Log.d("Sorteio",nquestion[0] + " " + nquestion[1] + " " + nquestion[2]);

        alternativa=update(nquestion[m]);
        textView.setText((m + 1) + " de "+nquestion.length);

        a.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        a.setBackgroundColor(Color.parseColor("#FFFF00"));
                        b.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        c.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        d.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        e.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        opcao = R.id.a;
                    }
                });
        b.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        a.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        b.setBackgroundColor(Color.parseColor("#FFFF00"));
                        c.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        d.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        e.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        opcao = R.id.b;
                    }
                });
        c.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        a.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        b.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        c.setBackgroundColor(Color.parseColor("#FFFF00"));
                        d.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        e.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        opcao = R.id.c;
                    }
                });
        d.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        a.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        b.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        c.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        d.setBackgroundColor(Color.parseColor("#FFFF00"));
                        e.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        opcao = R.id.d;
                    }
                });
        e.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        a.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        b.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        c.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        d.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        e.setBackgroundColor(Color.parseColor("#FFFF00"));
                        opcao = R.id.e;
                    }
                });



        ImageView button1 = (ImageView)view.findViewById(R.id.button1);
        button1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        alternativa = update(nquestion[m]);
                        textView.setText((m + 1) + " de "+nquestion.length);
                        if (opcao != alternativa) {
                            tentativas = tentativas + 1;
                            AlertDialog.Builder mensagem = new AlertDialog.Builder(getActivity());
                            mensagem.setTitle("Atenção!");
                            mensagem.setMessage("Alternativa incorreta");
                            mensagem.setNeutralButton("OK", null);
                            mensagem.show();
                        }

                        if (opcao == alternativa) {
                            if (m == (nquestion.length-1)) {
                                tentativas = tentativas + 1;

                                AlertDialog.Builder mensagem1 = new AlertDialog.Builder(getActivity());
                                mensagem1.setTitle("   ESTATÍSTICAS");
                                mensagem1.setMessage(tentativas + " tentativas para responder " + nquestion.length + " questões");
                                mensagem1.setPositiveButton("Finalizar", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                    }
                                });
                                mensagem1.show();
                            }

                            if (m < (nquestion.length-1)) {
                                tentativas = tentativas + 1;
                                optionNull();
                                AlertDialog.Builder mensagem = new AlertDialog.Builder(getActivity());
                                mensagem.setTitle("Parabéns!");
                                mensagem.setMessage("Alternativa correta");
//                                mensagem.setNegativeButton("Ver comentário", new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int id) {
//                                        //Assistir video no youtube
//                                    }
//                                });
                                mensagem.setNeutralButton("OK", null);
                                mensagem.show();
                                m = m + 1;
                                alternativa = update(nquestion[m]);
                                textView.setText((m + 1) + " de " + nquestion.length);
                            }
                        }
                    }
                });
        ImageView button2 = (ImageView)view.findViewById(R.id.button2);
        button2.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        if(m>0) {
                            m = m - 1;
                            alternativa = update(nquestion[m]);
                            textView.setText((m + 1) + " de "+nquestion.length);
                        }else{
                            Toast.makeText(getActivity(), "Início do Teste", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
        return view;
    }

    private void optionNull(){
        opcao = 0;
    }

    private int update(int question) {
        int alt = -1;
        a.setBackgroundColor(Color.parseColor("#FFFFFF"));
        b.setBackgroundColor(Color.parseColor("#FFFFFF"));
        c.setBackgroundColor(Color.parseColor("#FFFFFF"));
        d.setBackgroundColor(Color.parseColor("#FFFFFF"));
        e.setBackgroundColor(Color.parseColor("#FFFFFF"));
        if (question == 1) {
            texto1TextView.setText("Going to university seems to reduce the risk of dying from coronary heart disease. An American study that involved 10 000 patients from around the world has found that people who leave school before the age of 16 are five times more likely to suffer a heart attack and die than university graduates. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Em relação às pesquisas, a utilização da expressão university graduates evidencia a intenção de informar que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("as doenças do coração atacam dez mil pacientes. ");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("as doenças do coração ocorrem na faixa dos dezesseis anos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("as pesquisas sobre doenças são divulgadas no meio acadêmico.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("jovens americanos são alertados dos riscos de doenças do coração.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("maior nível de estudo reduz riscos de ataques do coração.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 2) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.ing2011d2q92);
            texto3TextView.setText("Na fase escolar, é prática comum que os professores passem atividades extraclasse e marquem uma data para que as mesmas sejam entregues para correção. No caso da cena da charge, a professora ouve uma estudante apresentando argumentos para");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("discutir sobre o conteúdo do seu trabalho já entregue.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("elogiar o tema proposto para o relatório solicitado.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("sugerir temas para novas pesquisas e relatórios. ");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("reclamar do curto prazo para entrega do trabalho.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("convencer de que fez o relatório solicitado.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 3) {
            texto1TextView.setText("For an interesting attempt to measure cause and effect try Mappiness, a project run by the London School of Economics, which offers a phone app that prompts you to record your mood and situation.\nThe Mappiness website says: ''We're particulary interested in how people' s happiness is affected by their local environment -air pollution, noise, green spacess, absolutely great for investigating. ''\nWill it work? With enough people, it might. But there are other problems. We've benn using happiness and well-being interchangeably. It that ok? The difference comes out in a sentiment like: '' We were happier during the war.'' But was our well-being also greater then? ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.ing2011d2q93);
            texto3TextView.setText("O projeto Mappiness, idealizado pela London School of Economics, ocupa-se do tema relacionado");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("ao nível de felicidade das pessoas em tempos de guerra.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("à dificuldade de medir o nível de felicidade das pessoas a partir de seu humor.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("ao nível de felicidade das pessoas enquanto falam ao celular com seus familiares.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("à relação entre o nível de felicidade das pessoas e o ambiente no qual se encontram.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("à influência das imagens grafitadas pelas ruas no aumento do nível de felicidade das pessoas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 4) {
            texto1TextView.setText("War\nUntil the philosophy which holds one race superior\nAnd another inferior\nIs finally and permanently discredited and abandoned,Everywhere - May say war.\n\nThat until there is no longer\nFirst class and second class citizens of any nation,\nUntil the color of a man's skin\nIs of no more significance than the color of his eyes -\nMe say war. \n[…]\n\nAnd until the ignoble and unhappy regimes\nthat hold our brothers in Angola, in Mozambique,\nSouth Africa, sub-human bondage have been toppled,\nUtterly destroyed -\nWell everywhere is war - Me say war. \n\nWar in the east, war in the west,\nWar up north, war down south -\nWar - war - Rumors of war.\nAnd until that day, the African continent will not know peace.\nWe, Africans, will fight - we find it necessary -And we know we shall win\nAs we are confident in the victory.\n[…]");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Bob Marley foi um artista popular e atraiu muitos fãs com suas canções. Ciente de sua influência social na música War, o cantor se utiliza de sua arte para alertar sobre");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a inércia do continente africano diante das injustiças sociais.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a persistência da guerra enquanto houver diferenças raciais e sociais.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("as acentuadas diferenças culturais entre os países africanos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("as discrepâncias sociais entre os moçambicanos e angolanos como causas de conflitos.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a fragilidade das diferenças raciais e sociais como justificativas para o início de uma guerra.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 5) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable. ing2011d2q95);
            texto3TextView.setText("A tira, definida como um segmento de história em quadrinhos, pode transmitir uma mensagem com efeito de humor. A presença desse efeito no diálogo entre John e Garfield acontece porque");
            figura2ImageView.setImageResource(R.drawable. nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("John pensa que sua es namorada é maluca e que Garfield não sabia disso.");
            fa1.setImageResource(R.drawable. nulo);
            textob1TextView.setText("Jodell é a única namorada maluca que John teve, e Garfield acha isso estranho.");
            fb1.setImageResource(R.drawable. nulo);
            textoc1TextView.setText("Garfield tem certeza de que a ex-namorada de John é sensata, o maluco é o amigo.");
            fc1.setImageResource(R.drawable. nulo);
            textod1TextView.setText("Garfield conhece as ex-namoradas de John e considera mais de uma como maluca.");
            fd1.setImageResource(R.drawable. nulo);
            textoe1TextView.setText("John caracteriza a ex-namorada como maluca e não entende a cara de Garfield.");
            fe1.setImageResource(R.drawable. nulo);
            video = "";
            alt = R.id.d;
        }
        return alt;
    }
}

