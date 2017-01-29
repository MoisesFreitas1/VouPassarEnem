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
public class Matematica extends Fragment {
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

        nquestions = 43;
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

        disciplinaTextView.setText("Matemática");

        nquestion = new int[10];
        int tquestions [];
        int aux;
        Random random  = new Random();
        tquestions = new int[nquestions];
        for(int b=0;b<nquestions;b++){
            tquestions[b]=b+1;
        }
        for (int n=0;n<10;n++){
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
            texto1TextView.setText("O dono de uma oficina mecânica precisa de um pistão das partes de um motor, de 68 mm de diâmetro, para o conserto de um carro. Para conseguir um, esse dono vai até um ferro-velho e lá encontra pistões com diâmetros iguais a 68,21 mm; 68,102 mm; 68,001 mm; 68,02 mm e 68,012 mm. Para colocar o pistão no motor que está sendo consertado, o dono da oficina terá de adquirir aquele que tenha o diâmetro mais próximo do que precisa.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Nessa condição, o dono da oficina deverá comprar o pistão de diâmetro");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("68,21 mm.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("68,102 mm.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("68,02 mm.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("68,012 mm.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("68,001 mm.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 2) {
            texto1TextView.setText("A Escala e Magnitude de Momento (abreviada como MMS e denotada como Mw),  introduzida em 1979 por Thomas Haks e Hiroo Kanamori, substituiu a Escala de Richter para medir a magnitude dos terremotos em termos de energia liberada. Menos conhecida pelo público, a MMS é, no entanto, a escala usada para estimar as magnitudes de todos os grandes terremotos da atualidade. Assim como a escala Richter, a MMS é uma escala logarítmica. Mw e Mo se relacionam pela fórmula: ");
            texto2TextView.setText("Texto2 ");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q137);
            texto3TextView.setText("Onde Mo é o momento sísmico (usualmente estimado a partir dos registros de movimento da superfície, através dos sismogramas), cuja unidade é o dina ⋅ cm. O terremoto de Kobe, acontecido no dia 17 de janeiro de 1995, foi um dos terremotos que causaram maior impacto no Japão e na comunidade científica internacional. Teve magnitude Mw = 7,3.");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("Mostrando que é possível determinar a medida por meio de conhecimentos matemáticos, qual foi o momento sísmico Mo do terremoto de Kobe (em dina ⋅ cm)?");

            textoa1TextView.setText("");
            fa1.setImageResource(R.drawable.mat2011d2q137a);
            textob1TextView.setText("");
            fb1.setImageResource(R.drawable.mat2011d2q137b);
            textoc1TextView.setText("");
            fc1.setImageResource(R.drawable.mat2011d2q137c);
            textod1TextView.setText("");
            fd1.setImageResource(R.drawable.mat2011d2q137d);
            textoe1TextView.setText("");
            fe1.setImageResource(R.drawable.mat2011d2q137e);
            video = "";
            alt = R.id.e;
        }
        if (question == 3) {
            texto1TextView.setText("Um mecânico de uma equipe de corrida necessita que as seguintes medidas realizadas em um carro sejam obtidas em metros:\na) distância a entre os eixos dianteiro e traseiro;\nb) altura b entre o solo e o encosto do piloto.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q138);
            texto3TextView.setText("Ao optar pelas medidas a e b em metros, obtêm-se, respectivamente,");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("0,23 e 0,16.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("2,3 e 1,6.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("23 e 16.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("230 e 160.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("2 300 e 1 600.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 4) {
            texto1TextView.setText("O medidor de energia elétrica de uma residência, conhecido por “relógio de luz”, é constituído de quatro pequenos relógios, cujos sentidos de rotação estão indicados conforme a figura:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q139);
            texto3TextView.setText("A medida é expressa em kWh. O número obtido na leitura é composto por 4 algarismos. Cada posição do número é formada pelo último algarismo ultrapassado pelo ponteiro.");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("O número obtido pela leitura em kWh, na imagem, é");

            textoa1TextView.setText("2 614.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("3 624.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("2 715.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("3 725.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("4 162.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 5) {
            texto1TextView.setText("Em uma certa cidade, os moradores de um bairro carente de espaços de lazer reivindicam à prefeitura municipal a construção de uma praça. A prefeitura concorda com a solicitação e afirma que irá construí-la em formato retangular devido às características técnicas do terreno. Restrições de natureza orçamentária impõem que sejam gastos, no máximo, 180 m de tela para cercar a praça. A prefeitura apresenta aos moradores desse bairro as medidas dos terrenos disponíveis para a construção da praça:\nTerreno 1: 55 m por 45 m\nTerreno 2: 55 m por 55 m\nTerreno 3: 60 m por 30 m\nTerreno 4: 70 m por 20 m\nTerreno 5: 95 m por 85 m");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Para optar pelo terreno de maior área, que atenda às restrições impostas pela prefeitura, os moradores deverão escolher o terreno. ");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("1");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("2");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("3");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("4");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("5");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 6) {
            texto1TextView.setText("Você pode adaptar as atividades do seu dia a dia de uma forma que possa queimar mais calorias do que as gastas normalmente, conforme a relação seguinte:\n– Enquanto você fala ao telefone, faça agachamentos: 100 calorias gastas em 20 minutos.\n– Meia hora de supermercado: 100 calorias.\n– Cuidar do jardim por 30 minutos: 200 calorias.\n– Passear com o cachorro: 200 calorias em 30 minutos.\n– Tirar o pó dos móveis: 150 calorias em 30 minutos.\n– Lavar roupas por 30 minutos: 200 calorias.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Uma pessoa deseja executar essas atividades, porém, ajustando o tempo para que, em cada uma, gaste igualmente 200 calorias. A partir dos ajustes, quanto tempo a mais será necessário para realizar todas as atividades?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("50 minutos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("60 minutos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("80 minutos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("120 minutos.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("170 minutos.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 7) {
            texto1TextView.setText("Uma equipe de especialistas do centro meteorológico de uma cidade mediu a temperatura do ambiente, sempre no mesmo horário, durante 15 dias intercalados, a partir do primeiro dia de um mês. Esse tipo de procedimento é frequente, uma vez que os dados coletados servem de referência para estudos e verificação de tendências climáticas ao longo dos meses e anos.\nAs medições ocorridas nesse período estão indicadas no quadro:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q142);
            texto3TextView.setText("Em relação à temperatura, os valores da média, mediana e moda são, respectivamente, iguais a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("17°C, 17°C e 13,5°C.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("17°C, 18°C e 13,5°C.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("17°C, 13,5°C e 18°C.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("17°C, 18°C e 21,5°C.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("17°C, 13,5°C e 21,5°C.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 8) {
            texto1TextView.setText("Para uma atividade realizada no laboratório de Matemática, um aluno precisa construir uma maquete da quadra de esportes da escola que tem 28 m de comprimento por 12 m de largura. A maquete deverá ser construída na escala de 1 : 250.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Que medidas de comprimento e largura, em cm, o aluno utilizará na construção da maquete?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("4,8 e 11,2");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("7,0 e 3,0");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("11,2 e 4,8");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("28,0 e 12,0");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("30,0 e 70,0");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 9) {
            texto1TextView.setText("Uma indústria fabrica brindes promocionais em forma de pirâmide. A pirâmide é obtida a partir de quatro cortes em um sólido que tem a forma de um cubo. No esquema, estão indicados o sólido original (cubo) e a pirâmide obtida a partir dele.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q144);
            texto3TextView.setText("Os pontos A, B, C, D e O do cubo e da pirâmide são os mesmos. O ponto O é central na face superior do cubo. Os quatro cortes saem de O em direção às arestas AD, BC, AB e CD, nessa ordem. Após os cortes, são descartados quatro sólidos.");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("Os formatos dos sólidos descartados são");

            textoa1TextView.setText("todos iguais.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("todos diferentes.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("três iguais e um diferente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("apenas dois iguais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("iguais dois a dois.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 10) {
            texto1TextView.setText("Café no Brasil\nO consumo atingiu o maior nível da história no ano passado: os brasileiros beberam o equivalente a 331 bilhões de xícaras.\n");
            texto2TextView.setText("Considere que a xícara citada na notícia seja equivalente a, aproximadamente, 120 mL de café. Suponha que em 2010 os brasileiros bebam ainda mais café, aumentando o consumo em 1/5 do que foi consumido no ano anterior.");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("De acordo com essas informações, qual a previsão mais aproximada para o consumo de café em 2010?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("8 bilhões de litros.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("16 bilhões de litros.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("32 bilhões de litros.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("40 bilhões de litros.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("48 bilhões de litros.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 11) {
            texto1TextView.setText("Sabe-se que a distância real, em linha reta, de uma cidade A, localizada no estado de São Paulo, a uma cidade B, localizada no estado de Alagoas, é igual a 2 000 km. Um estudante, ao analisar um mapa, verificou com sua régua que a distância entre essas duas cidades, A e B, era 8 cm.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Os dados nos indicam que o mapa observado pelo estudante está na escala de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("1 : 250.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("1 : 2 500.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("1 : 25 000.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("1 : 250 000.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("1 : 25 000 000.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 12) {
            texto1TextView.setText("A figura seguinte mostra um modelo de sombrinha muito usado em países orientais.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q147);
            texto3TextView.setText("Esta figura é uma representação de uma superfície de revolução chamada de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("pirâmide.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("semiesfera.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("cilindro.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("tronco de cone.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("cone.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 13) {
            texto1TextView.setText("Em 2010, um caos aéreo afetou o continente europeu, devido à quantidade de fumaça expelida por um vulcão na Islândia, o que levou ao cancelamento de inúmeros voos.\nCinco dias após o início desse caos, todo o espaço aéreo europeu acima de 6000 metros estava liberado, com exceção do espaço aéreo da Finlândia. Lá, apenas voos internacionais acima de 31 mil pés estavam liberados.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Considere que 1 metro equivale a aproximadamente 3,3 pés. Qual a diferença, em pés, entre as altitudes liberadas na Finlândia e no restante do continente europeu cinco dias após o início do caos?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("3 390 pés.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("9 390 pés.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("11 200 pés.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("19 800 pés.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("50 800 pés.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 14) {
            texto1TextView.setText("Um bairro de uma cidade foi planejado em uma região plana, com ruas paralelas e perpendiculares, delimitando  quadras de mesmo tamanho. No plano de coordenadas cartesianas seguinte, esse bairro localiza-se no segundo quadrante, e as distâncias nos eixos são dadas em quilômetros.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q150);
            texto3TextView.setText("A reta de equação y = x + 4 representa o planejamento do percurso da linha do metrô subterrâneo que atravessará o bairro e outras regiões da cidade. No ponto P = (–5, 5), localiza-se um hospital público. A comunidade solicitou ao comitê de planejamento que fosse prevista uma estação do metrô de modo que sua distância ao hospital, medida em linha reta, não fosse maior que 5 km.");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("Atendendo ao pedido da comunidade, o comitê argumentou corretamente que isso seria automaticamente satisfeito, pois já estava prevista a construção de uma estação no ponto");

            textoa1TextView.setText("(–5, 0).");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("(–3, 1).");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("(–2, 1).");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("(0, 4).");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("(2, 6).");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 15) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q151);
            texto3TextView.setText("O polígono que dá forma a essa calçada é invariante por rotações, em torno de seu centro, de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("45°.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("60°.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("90°.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("120°.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("180°.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 16) {
            texto1TextView.setText("As frutas que antes se compravam por dúzias, hoje em dia, podem ser compradas por quilogramas, existindo também a variação dos preços de acordo com a época de produção. Considere que, independente da época ou variação de preço, certa fruta custa R$ 1,75 o quilograma.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Dos gráficos a seguir, o que representa o preço m pago em reais pela compra de n quilogramas desse produto é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("");
            fa1.setImageResource(R.drawable.mat2011d2q152a);
            textob1TextView.setText("");
            fb1.setImageResource(R.drawable.mat2011d2q152b);
            textoc1TextView.setText("");
            fc1.setImageResource(R.drawable.mat2011d2q152c);
            textod1TextView.setText("");
            fd1.setImageResource(R.drawable.mat2011d2q152d);
            textoe1TextView.setText("");
            fe1.setImageResource(R.drawable.mat2011d2q152e);
            video = "";
            alt = R.id.e;
        }
        if (question == 17) {
            texto1TextView.setText("Observe as dicas para calcular a quantidade certa de alimentos e bebidas para as festas de fim de ano:\n• Para o prato principal, estime 250 gramas de carne para cada pessoa.\n• Um copo americano cheio de arroz rende o suficiente para quatro pessoas.\n• Para a farofa, calcule quatro colheres de sopa por convidado.\n• Uma garrafa de vinho serve seis pessoas.\n• Uma garrafa de cerveja serve duas.\n• Uma garrafa de espumante serve três convidados.\nQuem organiza festas faz esses cálculos em cima do total de convidados, independente do gosto de cada um.\nQuantidade certa de alimentos e bebidas evita o desperdício da ceia.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Um anfitrião decidiu seguir essas dicas ao se preparar para receber 30 convidados para a ceia de Natal. Para seguir essas orientações à risca, o anfitrião deverá dispor de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("120 kg de carne, 7 copos americanos e meio de arroz, 120 colheres de sopa de farofa, 5 garrafas de vinho, 15 de cerveja e 10 de espumante.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("120 kg de carne, 7 copos americanos e meio de arroz, 120 colheres de sopa de farofa, 5 garrafas de vinho, 30 de cerveja e 10 de espumante.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("75 kg de carne, 7 copos americanos e meio de arroz, 120 colheres de sopa de farofa, 5 garrafas de vinho, 15 de cerveja e 10 de espumante.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("7,5 kg de carne, 7 copos americanos, 120 colheres de sopa de farofa, 5 garrafas de vinho, 30 de cerveja e  10 de espumante.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("7,5 kg de carne, 7 copos americanos e meio de arroz, 120 colheres de sopa de farofa, 5 garrafas de vinho, 15 de cerveja e 10 de espumante.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 18) {
            texto1TextView.setText("A participação dos estudantes na Olimpíada Brasileira de Matemática das Escolas Públicas (OBMEP) aumenta a cada ano. O quadro indica o percentual de medalhistas de ouro, por região, nas edições da OBMEP de 2005 a 2009:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q154);
            texto3TextView.setText("Em relação às edições de 2005 a 2009 da OBMEP, qual o percentual médio de medalhistas de ouro da região Nordeste?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("14,6%");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("18,2%");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("18,4%");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("19,0%");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("21,0%");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 19) {
            texto1TextView.setText("Para determinar a distância de um barco até a praia, um navegante utilizou o seguinte procedimento: a partir de um ponto A, mediu o ângulo visual α fazendo mira em um ponto fixo P da praia. Mantendo o barco no mesmo sentido, ele seguiu até um ponto B de modo que fosse possível ver o mesmo ponto P da praia, no entanto sob um ângulo visual 2α. A figura ilustra essa situação:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q155);
            texto3TextView.setText("Suponha que o navegante tenha medido o ângulo ");
            figura2ImageView.setImageResource(R.drawable.mat2011d2q155f2);
            texto4TextView.setText("e, ao chegar ao ponto B, verificou que o barco havia percorrido a distância AB = 2 000 m. Com base nesses dados e mantendo a mesma trajetória, a menor distância do barco até o ponto fixo P será ");

            textoa1TextView.setText("");
            fa1.setImageResource(R.drawable.mat2011d2q155a);
            textob1TextView.setText("");
            fb1.setImageResource(R.drawable.mat2011d2q155b);
            textoc1TextView.setText("");
            fc1.setImageResource(R.drawable.mat2011d2q155c);
            textod1TextView.setText("");
            fd1.setImageResource(R.drawable.mat2011d2q155d);
            textoe1TextView.setText("");
            fe1.setImageResource(R.drawable.mat2011d2q155e);
            video = "";
            alt = R.id.b;
        }
        if (question == 20) {
            texto1TextView.setText("O saldo de contratações no mercado formal no setor varejista da região metropolitana de São Paulo registrou alta. Comparando as contratações deste setor no mês de fevereiro com as de janeiro deste ano, houve incremento de 4 300 vagas no setor, totalizando 880 605 trabalhadores com carteira assinada.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Suponha que o incremento de trabalhadores no setor varejista seja sempre o mesmo nos seis primeiros meses do ano. Considerando-se que y e x representam, respectivamente, as quantidades de trabalhadores no setor varejista e os meses, janeiro sendo o primeiro, fevereiro, o segundo, e assim por diante, a expressão algébrica que relaciona essas quantidades nesses meses é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("y = 4300x");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("y = 884905x");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("y = 872005 + 4300x");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("y = 876305 + 4300x");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("y = 880605 + 4300x");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 21) {
            texto1TextView.setText("Um jovem investidor precisa escolher qual investimento lhe trará maior retorno financeiro em uma aplicação de R$ 500,00. Para isso, pesquisa o rendimento e o imposto a ser pago em dois investimentos: poupança e CDB (certificado de depósito bancário). As informações obtidas estão resumidas no quadro:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q157);
            texto3TextView.setText("Para o jovem investidor, ao final de um mês, a aplicação mais vantajosa é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a poupança, pois totalizará um montante de R$ 502,80.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a poupança, pois totalizará um montante de R$ 500,56.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o CDB, pois totalizará um montante de R$ 504,38.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o CDB, pois totalizará um montante de R$ 504,21.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o CDB, pois totalizará um montante de R$ 500,87.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 22) {
            texto1TextView.setText("O prefeito de uma cidade deseja construir uma rodovia para dar acesso a outro município. Para isso, foi aberta uma licitação na qual concorreram duas empresas. A primeira cobrou R$ 100 000,00 por km construído (n), acrescidos de um valor fixo de R$ 350 000,00, enquanto a segunda cobrou R$ 120 000,00 por km construído (n), acrescidos de um valor fixo de R$ 150 000,00. As duas empresas apresentam o mesmo padrão de qualidade dos serviços prestados, mas apenas uma delas poderá ser contratada.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Do ponto de vista econômico, qual equação possibilitaria encontrar a extensão da rodovia que tornaria indiferente para a prefeitura escolher qualquer uma das propostas apresentadas?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("100n + 350 = 120n + 150");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("100n + 150 = 120n + 350");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("100(n + 350) = 120(n + 150)");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("100(n + 350 000) = 120(n + 150 000)");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("350(n + 100 000) = 150(n + 120 000)");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 23) {
            texto1TextView.setText("Uma pessoa aplicou certa quantia em ações. No primeiro mês, ela perdeu 30% do total do investimento e, no segundo mês, recuperou 20% do que havia perdido. Depois desses dois meses, resolveu tirar o montante de R$ 3 800,00 gerado pela aplicação.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A quantia inicial que essa pessoa aplicou em ações corresponde ao valor de ");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("R$4.222,22.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("R$4.523,80.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("R$5.000,00.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("R$13.300,00.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("R$17.100,00.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 24) {
            texto1TextView.setText("Cerca de 20 milhões de brasileiros vivem na região coberta pela caatinga, em quase 800 mil km2 de área. Quando não chove, o homem do sertão e sua família precisam caminhar quilômetros em busca da água dos açudes. A irregularidade climática é um dos fatores que mais interferem na vida do sertanejo.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Segundo este levantamento, a densidade demográfica da região coberta pela caatinga, em habitantes por km2,  é de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("250.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("25.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("2,5.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("0,25.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("0,025.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 25) {
            texto1TextView.setText("O número mensal de passagens de uma determinada empresa aérea aumentou no ano passado nas seguintes condições: em janeiro foram vendidas 33 000 passagens; em fevereiro, 34 500; em março, 36 000. Esse padrão de crescimento se mantém para os meses subsequentes.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Quantas passagens foram vendidas por essa empresa em julho do ano passado?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("38 000");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("40 500");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("41 000");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("42 000");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("48 000");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 26) {
            texto1TextView.setText("Rafael mora no Centro de uma cidade e decidiu se mudar, por recomendações médicas, para uma das regiões: Rural, Comercial, Residencial Urbano ou Residencial Suburbano. A principal recomendação médica foi com as temperaturas das “ilhas de calor” da região, que deveriam ser inferiores a 31ºC. Tais temperaturas são apresentadas por gráfico: ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q163);
            texto3TextView.setText("Escolhendo, aleatoriamente, uma das outras regiões para morar, a probabilidade de ele escolher uma região que seja adequada às recomendações médicas é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("1/5");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("1/4");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("2/5");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("3/5");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("3/4");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 27) {
            texto1TextView.setText("Muitas medidas podem ser tomadas em nossas casas visando à utilização racional de energia elétrica. Isso deve ser uma atitude diária de cidadania. Uma delas pode ser a redução do tempo no banho. Um chuveiro com potência de 4 800 W consome 4,8 kW por hora.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Uma pessoa que toma dois banhos diariamente, de 10 minutos cada, consumirá, em sete dias, quantos kW?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("0,8");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("1,6");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("5,6");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("11,2");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("33,6");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 28) {
            texto1TextView.setText("O atletismo é um dos esportes que mais se identificam com o espírito olímpico. A figura ilustra uma pista de atletismo. A pista é composta por oito raias e tem largura de 9,76 m. As raias são numeradas do centro da pista para a extremidade e são construídas do centro da pista para a extremidade e são construídas de segmentos de retas paralelas e arcos de circunferência. Os dois semicírculos da pista são iguais.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q165);
            texto3TextView.setText("Se os atletas partissem do mesmo ponto, dando uma volta completa, em qual das raias o corredor estaria sendo beneficiado?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("1");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("4");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("5");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("7");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("8");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 29) {
            texto1TextView.setText("Nos últimos cinco anos, 32 mil mulheres de 20 a 24 anos foram internadas nos hospitais do SUS por causa de AVC. Entre os homens da mesma faixa etária, houve 28 mil internações pelo mesmo motivo.");
            texto2TextView.setText("Suponha que, nos próximos cinco anos, haja um acréscimo de 8 mil internações de mulheres e que o acréscimo de internações de homens por AVC ocorra na mesma proporção.");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("De acordo com as informações dadas, o número de homens que seriam internados por AVC, nos próximos cinco anos, corresponderia a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("4 mil.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("9 mil.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("21 mil.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("35 mil.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("39 mil.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 30) {
            texto1TextView.setText("É possível usar água ou comida para atrair as aves e observá-las. Muitas pessoas costumam usar água com açúcar, por exemplo, para atrair beija-flores. Mas é importante saber que, na hora de fazer a mistura, você deve sempre usar uma parte de açúcar para cinco partes de água. Além disso, em dias quentes, precisa trocar a água de duas a três vezes, pois com o calor ela pode fermentar e, se for ingerida pela ave, pode deixá-la doente. O excesso de açúcar, ao cristalizar, também pode manter o bico da ave fechado, impedindo-a de se alimentar. Isso pode até matá-la.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Pretende-se encher completamenmte um copo com a mistura para atrair beija-flores. O copo tem formato cilíndrico, e suas medidas são 10 cm de altura e 4 cm de diâmetro. A quantidade de água que deve ser utilizada na mistura é cerca de (utilize π = 3)");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("20 mL.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("24 mL.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("100 mL.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("120 mL");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("600 mL.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 31) {
            texto1TextView.setText("Em um jogo disputado em uma mesa de sinuca, há 16 bolas: 1 branca e 15 coloridas, as quais, de acordo com a coloração, valem de 1 a 15 pontos (um valor para cada bola colorida).\nO jogador acerta o taco na bola branca de forma que esta acerte as outras, com o objetivo de acertar duas das quinze bolas em quaisquer caçapas. Os valores dessas duas bolas são somados e devem resultar em um valor escolhido pelo jogador antes do início da jogada Arthur, Bernardo e Caio escolhem os números 12, 17 e 22 como sendo resultados de suas respectivas somas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Com essa escolha, quem tem a maior probabilidade de ganhar o jogo é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Arthur, pois a soma que escolheu é a menor.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Bernardo, pois há 7 possibilidades de compor a soma escolhida por ele, contra 4 possibilidades para a escolha de Arthur e 4 possibilidades para a escolha de Caio.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Bernardo, pois há 7 possibilidades de compor a soma escolhida por ele, contra 5 possibilidades para a escolha de Arthur e 4 possibilidades para a escolha de Caio.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Caio, pois há 10 possibilidades de compor a soma escolhida por ele, contra 5 possibilidades para a escolha de Arthur e 8 possibilidades para a escolha de Bernardo.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Caio, pois a soma que escolheu é a maior.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 32) {
            texto1TextView.setText("A figura apresenta informações biométricas de um homem (Duílio) e de uma mulher (Sandra) que estão buscando alcançar seu peso ideal a partir das atividades físicas (corrida). Para se verificar a escala de obesidade, foi desenvolvida a fórmula que permite verificar o Índice de Massa Corporal (IMC). Esta fórmula é apresentada como IMC = m/h2, onde m é a massa em quilogramas e h é altura em metros.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q169f1);
            texto3TextView.setText("No quadro é apresentada a Escala de Índice de Massa Corporal com as respectivas categorias relacionadas aos pesos.");
            figura2ImageView.setImageResource(R.drawable.mat2011d2q169f2);
            texto4TextView.setText("A partir dos dados biométricos de Duílio e Sandra e da Escala de IMC, o valor IMC e a categoria em que cada uma das pessoas se posiciona na Escala são");

            textoa1TextView.setText("Duílio tem o IMC 26,7 e Sandra tem o IMC 26,6, estando ambos na categoria de sobrepeso.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Duílio tem o IMC 27,3 e Sandra tem o IMC 29,1, estando ambos na categoria de sobrepeso.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Duílio tem o IMC 27,3 e Sandra tem o IMC 26,6, estando ambos na categoria de sobrepeso.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Duílio tem o IMC 25,6, estando na categoria de sobrepeso, e Sandra tem o IMC 24,7, estando na categoria de peso normal.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Duílio tem o IMC 25,1, estando na categoria de sobrepeso, e Sandra tem o IMC 22,6, estando na categoria de peso normal.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 33) {
            texto1TextView.setText("Todo o país passa pela primeira fase de campanha de vacinação contra a gripe suína (H1N1). Segundo um médico infectologista do Instituto Emílio Ribas, de São Paulo, a imunização ‘‘deve mudar’’, no país, a história da epidemia. Com a vacina, de acordo com ele, o Brasil tem a chance de barrar uma tendência do crescimento da doença, que já matou 17 mil no mundo. A tabela apresenta dados específicos de um único posto de vacinação.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q170);
            texto3TextView.setText("Escolhendo-se aleatoriamente uma pessoa atendida nesse posto de vacinação, a probabilidade de ela ser portadora de doença crônica é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("8%.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("9%.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("11%.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("12%.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("22%.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 34) {
            texto1TextView.setText("O gráfico mostra a velocidade de conexão à internet utilizada em domicílios no Brasil. Esses dados são resultado da mais recente pesquisa, de 2009, realizada pelo Comitê Gestor da Internet (CGI).");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q171);
            texto3TextView.setText("Escolhendo-se, aleatoriamente, um domicílio pesquisado, qual a chance de haver banda larga de conexão de pelo menos 1 Mbps neste domicílio?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("0,45");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("0,42");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("0,30");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("0,22");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("0,15");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 35) {
            texto1TextView.setText("Um técnico em refrigeração precisa revisar todos os pontos de saída de ar de um escritório com várias salas. Na imagem apresentada, cada ponto indicado por uma letra é a saída do ar, e os segmentos são as tubulações.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q172);
            texto3TextView.setText("Iniciando a revisão pelo ponto K e terminando em F, sem passar mais de uma vez por cada ponto, o caminho será passando pelos pontos");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("K, I e F.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("K, J, I, G, L e F.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("K, L, G, I, J, H e F.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("K, J, H, I, G, L e F.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("K, L, G, I, H, J e F.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 36) {
            texto1TextView.setText("O termo agronegócio não se refere apenas à agricultura e à pecuária, pois as atividades ligadas a essa produção incluem fornecedores de equipamentos, serviços para a zona rural, industrialização e comercialização dos produtos.\nO gráfico seguinte mostra a participação percentual do agronegócio no PIB brasileiro:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q173);
            texto3TextView.setText("Esse gráfico foi usado em uma palestra na qual o orador ressaltou uma queda da participação do agronegócio no PIB brasileiro e a posterior recuperação dessa participação, em termos percentuais. Segundo o gráfico, o período de queda ocorreu entre os anos de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("1998 e 2001.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("2001 e 2003.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("2003 e 2006.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("2003 e 2007.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("2003 e 2008.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 37) {
            texto1TextView.setText("O setor de recursos humanos de uma empresa vai realizar uma entrevista com 120 candidatos a uma vaga de contador. Por sorteio, eles pretendem atribuir a cada candidato um número, colocar a lista de números em ordem numérica crescente e usá-la para convocar os interessados. Acontece que, por um defeito do computador, foram gerados números com 5 algarismos distintos e, em nenhum deles, apareceram dígitos pares.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Em razão disso, a ordem de chamada do candidato que tiver recebido o número 75 913 é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("24");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("31");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("32");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("88");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("89");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 38) {
            texto1TextView.setText("Uma enquete, realizada em março de 2010, perguntava aos internautas se eles acreditavam que as atividades humanas provocam o aquecimento global. Eram três as alternativas possíveis e 279 internautas responderam à enquete, como mostra o gráfico.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q175);
            texto3TextView.setText("Analisando os dados do gráfico, quantos internautas responderam “NÃO” à enquete?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Menos de 23.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Mais de 23 e menos de 25.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Mais de 50 e menos de 75.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Mais de 100 e menos de 190.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Mais de 200.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 39) {
            texto1TextView.setText("A cor de uma estrela tem relação com a temperatura em sua superfície. Estrelas não muito quentes (cerca de 3 000 K) nos parecem avermelhadas. Já as estrelas amarelas, como o Sol, possuem temperatura em torno dos 6 000 K; as mais quentes são brancas ou azuis porque sua temperatura fica acima dos 10 000 K.\nA tabela apresenta uma classificação espectral e outros dados para as estrelas dessas classes.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q176);
            texto3TextView.setText("Se tomarmos uma estrela que tenha temperatura 5 vezes maior que a temperatura do Sol, qual será a ordem de grandeza de sua luminosidade?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("20 000 vezes a luminosidade do Sol.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("28 000 vezes a luminosidade do Sol.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("28 850 vezes a luminosidade do Sol.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("30 000 vezes a luminosidade do Sol.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("50 000 vezes a luminosidade do Sol.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 40) {
            texto1TextView.setText("Considere que uma pessoa decida investir uma determinada quantia e que lhe sejam apresentadas possibilidades de investimento, com rentabilidades líquidas garantidas pelo período de um ano, conforme descritas:\nInvestimento A: 3% ao mês\nInvestimento B: 36% ao ano\nInvestimento C: 18% ao semestre\nAs rentabilidades, para esses investimentos, incidem sobre o valor do período anterior. O quadro fornece algumas aproximações para a análise das rentabilidades:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q177);
            texto3TextView.setText("Para escolher o investimento com a maior rentabilidade anual, essa pessoa deverá");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("escolher qualquer um dos investimentos A, B ou C, pois as suas rentabilidades anuais são iguais a 36%.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("escolher os investimentos A ou C, pois suas rentabilidades anuais são iguais a 39%.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("escolher o investimento A, pois a sua rentabilidade anual é maior que as rentabilidades anuais dos investimentos B e C.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("escolher o investimento B, pois sua rentabilidade de 36% é maior que as rentabilidades de 3% do investimento A e de 18% do investimento C.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("escolher o investimento C, pois sua rentabilidade de 39% ao ano é maior que a rentabilidade de 36% ao ano dos investimentos A e B.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 41) {
            texto1TextView.setText("A resistência das vigas de dado comprimento é diretamente proporcional à largura (b) e ao quadrado da altura (d), conforme a figura. A constante de proporcionalidade k varia de acordo com o material utilizado na sua construção.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.mat2011d2q178);
            texto3TextView.setText("Considerando-se S como a resistência, a representação algébrica que exprime essa relação é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("");
            fa1.setImageResource(R.drawable.mat2011d2q178a);
            textob1TextView.setText("");
            fb1.setImageResource(R.drawable.mat2011d2q178b);
            textoc1TextView.setText("");
            fc1.setImageResource(R.drawable.mat2011d2q178c);
            textod1TextView.setText("");
            fd1.setImageResource(R.drawable.mat2011d2q178d);
            textoe1TextView.setText("");
            fe1.setImageResource(R.drawable.mat2011d2q178e);
            video = "";
            alt = R.id.c;
        }
        if (question == 42) {
            texto1TextView.setText("Uma empresa de telefonia fixa oferece dois planos aos seus clientes: no plano K, o cliente paga R$ 29,90 por 200 minutos mensais e R$ 0,20 por cada minuto excedente; no plano Z, paga R$ 49,90 por 300 minutos mensais e R$ 0,10 por cada minuto excedente.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O gráfico que representa o valor pago, em reais, nos dois planos em função dos minutos utilizados é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("Texto4");

            textoa1TextView.setText("");
            fa1.setImageResource(R.drawable.mat2011d2q179a);
            textob1TextView.setText("");
            fb1.setImageResource(R.drawable.mat2011d2q179b);
            textoc1TextView.setText("");
            fc1.setImageResource(R.drawable.mat2011d2q179c);
            textod1TextView.setText("");
            fd1.setImageResource(R.drawable.mat2011d2q179d);
            textoe1TextView.setText("");
            fe1.setImageResource(R.drawable.mat2011d2q179e);
            video = "";
            alt = R.id.d;
        }
        if (question == 43) {
            texto1TextView.setText("Uma indústria fabrica um único tipo de produto e sempre vende tudo o que produz. O custo total para fabricar uma quantidade q de produtos é dado por uma função, simbolizada por CT, enquanto o faturamento que a empresa obtém com a venda da quantidade q também é uma função, simbolizada por FT. O lucro total (LT) obtido pela venda da quantidade q de produtos é dado pela expressão LT(q) = FT(q) – CT(q).");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Considerando-se as funções FT(q) = 5q e CT(q) = 2q + 12 como faturamento e custo, qual a quantidade mínima de produtos que a indústria terá de fabricar para não ter prejuízo?");
            figura2ImageView.setImageResource(R.drawable. nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("0");
            fa1.setImageResource(R.drawable. nulo);
            textob1TextView.setText("1");
            fb1.setImageResource(R.drawable. nulo);
            textoc1TextView.setText("3");
            fc1.setImageResource(R.drawable. nulo);
            textod1TextView.setText("4");
            fd1.setImageResource(R.drawable. nulo);
            textoe1TextView.setText("5");
            fe1.setImageResource(R.drawable. nulo);
            video = "";
            alt = R.id.d;
        }
        return alt;
    }
}

