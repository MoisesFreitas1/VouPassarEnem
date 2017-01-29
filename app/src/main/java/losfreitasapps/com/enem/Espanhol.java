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
public class Espanhol extends Fragment {
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

        disciplinaTextView.setText("Espanhol");

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
            texto1TextView.setText("‘Desmachupizar‘ el turismo\nEs ya un lugar común escuchar aquello de que hay que desmachupizar el turismo en Perú y buscar visitantes en las demás atracciones (y son muchas) que tiene el país, naturales y arqueológicas, pero la ciudadela inca tiene un imán innegable. La Cámara Nacional de Turismo considera que Machu Picchu significa el 70% de los ingressos por turismo en Perú, ya que cada turista que tiene como primer destino la ciudadela inca visita entre tres y cinco lugares más (la ciudad de Cuzco, la de Arequipa, las líneas de Nazca, el Lago Titicaca y la selva) y dela en el país un promedio de 2 200 dólares (unos 1 538 euros).\nCarlos Canales, presidente de Canatur, señaló que la ciudadela tiene capacidad para recibir más visitantes que en la actualidad (un máximo de 3 000) con un sistema planificado de horarios y rutas, pero no quiso avanzar una cifra. Sin embargo, la Unesco ha advertido en varias ocasiones que el monumento se encuentra cercano al punto de saturación y el Gobierno no debe emprender ninguna política de captación de nuevos visitantes, algo con lo que coincide el viceministro Roca Rey. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A reportagem do jornal espanhol mostra a preocupação diante de um problema no Peru, que pode ser resumido pelo vocábulo “desmachupizar”, referindo-se");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("à escassez de turistas no país.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("ao difícil acesso ao lago Titicaca.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("à destruição da arqueologia no país.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("ao excesso de turistas na terra dos incas.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("à falta de atrativos turísticos em Arequipa.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 2) {
            texto1TextView.setText("Los fallos de software em aparatos médicos, como marcapasos, van a ser uma creciente amenaza para La salud pública, según el informe de Software Freedom Law Center (SFLC) que há sido presentado hoy em Portland (EEUU), em la Open Source Convention (OSCON).\nLa ponencia “Muerto por el codigo: transparência de software em los dispositivos médicos implantables” aborda el riesgo potencialmente mortal de los defectos informáticos em los aparatos médicos implantados em lãs personas.\nSegún SFLC, millones de personas com condiciones crônicas del corazón, epilepsia, diabetes, obesidad e, incluso, la depresión dependen de implantes, pero el software permanece oculto a los pacientes y sus médicos.\nLa SFLC recuerda graves fallos informáticos ocurridos em otros campos, como em elecciones, en la fabricación de coches, em las líneas aéreas comerciales o en los mercados financieros. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O título da palestra, citado no texto, antecipa o tema que será tratado e mostra que o autor tem a intenção de:");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("relatar novas experiências em tratamento de saúde.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("alertar sobre os riscos mortais de determinados softwares de uso médico para o ser humano.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("denunciar falhas médicas na implantação de softwares em seres humanos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("divulgar novos softwares presentes em aparelhos médicos lançados no mercado.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("apresentar os defeitos mais comuns de softwares em aparelhos médicos.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 3) {
            texto1TextView.setText("Bienvenido a Brasília\nEl Gobierno de Brasil, por medio del Ministerio de la Cultura y del Instituto del Patrimonio Histórico y Artístico Nacional (IPHAN), da la bienvenida a los participantes de la 34ª Sesión del Comité del Patrimonio Mundial, encuentro realizado por la Organización de las Naciones Unidas para la Educación, la Ciencia y la Cultura (UNESCO).\nRespaldado por la Convención del Patrimonio Mundial, de 1972, el Comité reúne en su 34ª sesión más de 180 delegaciones nacionales para deliberar sobre las nuevas candidaturas y el estado de conservación y de riesgo de los bienes ya declarados Patrimonio Mundial, con base en los análisis del Consejo Internacional de Monumentos y Sitios (Icomos), del Centro Internacional para el Estudio de la Preservación y la Restauración del Patrimonio Cultural (ICCROM) y de la Unión Internacional para la Conservación de la Naturaleza (IUCN). ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O Comitê do Patrimônio Mundial reúne-se regularmente para deliberar sobre ações que visem à conservação e à preservação do patrimônio mundial. Entre as tarefas atribuídas às delegações nacionais que participaram da 34ª Sessão do Comitê do Patrimônio Mundial, destaca-se a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a participação em reuniões do Conselho Internacional de Monumentos e Sítios.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("realização da cerimônia de recepção da Convenção do Patrimônio Mundial.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("organização das análises feitas pelo Ministério da Cultura brasileiro.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("discussão sobre o estado de conservação dos bens já declarados patrimônios mundiais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("estruturação da próxima reunião do Comitê do Patrimônio Mundial.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 4) {
            texto1TextView.setText("El tango\nYa sea como danza, música, poesía o cabal expresión de una filosofía de vida, el tango posee una larga y valiosa trayectoria, jalonada de encuentros y desencuentros, amores y odios, nacida desde lo más hondo de la historia argentina.\nEl nuevo ambiente es el cabaret, su nuevo cultor la clase media porteña, que ameniza sus momentos de diversión con nuevas composiciones, sustituyendo el carácter malevo del tango primitivo por una nueva poesía más acorde con las concepciones estéticas provenientes de Londres y París.\nYa en la ‘década del 20’ el tango se anima incluso a traspasar las fronteras del país, recalando en lujosos salones parisinos donde es aclamado por públicos selectos que adhieren entusiastas a la sensualidad del nuevo baile. Ya no es privativo de los bajos en salones elegantes, clubs y casas particulares.\nEl tango revive con juveniles fuerzas en ajironadas versiones de grupos rockeros, presentaciones en elegantes reductos de San Telmo, Barracas y La Boca y películas foráneas que lo divulgan por el mundo entero. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Sabendo-se que a produção cultural de um país pode influenciar, retratar ou, inclusive, ser reflexo de acontecimentos de sua história, o tango, dentro do contexto histórico argentino, é reconhecido por");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("manter-se inalterado ao longo de sua história no país.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("influenciar os subúrbios, sem chegar a outras regiões.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("sobreviver e se difundir, ultrapassando as fronteiras do país.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("manifestar seu valor primitivo nas diferentes camadas sociais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("ignorar a influência de países europeus, como Inglaterra e França.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 5) {
            texto1TextView.setText("Es posible reducir la basura\nEn México se producen más de 10 millones de m³ de basura mensualmente, depositados en más de 50 mil tiraderos de basura legales y clandestinos, que afectan de manera directa nuestra calidad de vida, pues nuestros recursos naturales son utilizados desproporcionalmente, como materias primas que luego desechamos y tiramos convirtiéndolos en materiales inútiles y focos de infección.\nTodo aquello que compramos y consumimos tiene una relación directa con lo que tiramos. Consumiendo racionalmente, evitando el derroche y usando sólo lo indispensable, directamente colaboramos con el cuidado del ambiente.\nSi la basura se compone de varios desperdicios y si como desperdicios no fueron basura, si los separamos adecuadamente, podremos controlarlos y evitar posteriores problemas. Reciclar se traduce en importantes ahorros de energía, ahorro de agua potable, ahorro de materias primas, menor impacto en los ecosistemas y sus recursos naturales y ahorro de tiempo, dinero y esfuerzo.\nEs necesário saber para empezar a actuar… ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A partir do que se afirma no último parágrafo: ''Es necesario saber para empezar a actuar...'', pode-se  constatar que o texto foi escrito com a intenção de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("informar o leitor a respeito da importância da reciclagem para a conservação do meio ambiente.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("indicar os cuidados que se deve ter para não consumir alimentos que podem ser focos de infecção.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("denunciar o quanto o consumismo é nocivo, pois é o gerador dos dejetos produzidos no México.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("ensinar como economizar tempo, dinheiro e esforço a partir dos cinquenta mil depósitos de lixo legalizados.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("alertar a população mexicana para os perigos causados pelos consumidores de matéria-prima reciclável.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        return alt;
    }
}

