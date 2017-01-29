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
 * Created by Moises on 07/09/16.
 */
public class Natureza extends Fragment {
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

        nquestions = 45;
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

        disciplinaTextView.setText("Ciências da Natureza");

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
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q46);
            texto3TextView.setText("A explicação para a necessidade do uso da engrenagem com trava é:");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("O travamento do motor, para que ele não se solte aleatoriamente.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("A seleção da velocidade, controlada pela pressão nos dentes da engrenagem.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("O controle do sentido da velocidade tangencial, permitindo, inclusive, uma fácil leitura do seu valor.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("A determinação do movimento, devido ao caráter aleatório, cuja tendência é o equilíbrio.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("A escolha do ângulo a ser girado, sendo possível, inclusive, medi-lo pelo número de dentes da engrenagem.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 2) {
            texto1TextView.setText("Os personagens da figura estão representando uma situação hipotética de cadeia alimentar.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q47);
            texto3TextView.setText("Suponha que, em cena anterior à apresentada, o homem tenha se alimentado de frutas e grãos que conseguiu coletar. Na hipótese de, nas próximas cenas, o tigre ser bem-sucedido e, posteriormente, servir de alimento aos abutres, tigre e abutres ocuparão, respectivamente, os níveis tróficos de ");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("produtor e consumidor primário.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("consumidor primário e consumidor secundário.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("consumidor secundário e consumidor terciário.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("consumidor terciário e produtor.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("consumidor secundário e consumidor primário.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 3) {
            texto1TextView.setText("A produção de soro antiofídico é feita por meio da extração da peçonha de serpentes que, após tratamento é introduzida em um cavalo. Em seguida são feitas sangrias para avaliar a concentração de anticorpos produzidos pelo cavalo. Quando essa concentração atinge o valor desejado, é realizada a sangria final para obtenção do soro. As hemácias são devolvidas ao animal, por meio de uma técnica denominada plasmaferese, a fim de reduzir os efeitos colaterais provocados pela sangria.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A plasmaferese é importante, pois, se o animal ficar com uma baixa quantidade de hemácias, poderá apresentar");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("febre alta e constante.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("redução de imunidade.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("aumento da pressão arterial.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("quadro de leucemia profunda.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("problemas no transporte de oxigênio.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 4) {
            texto1TextView.setText("Um paciente deu entrada em um pronto-socorro apresentando os seguintes sintomas: cansaço, dificuldade em respirar e sangramento nasal. O médico solicitou um hemograma ao paciente para definir um diagnóstico. Os resultados estão dispostos na tabela:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q49);
            texto3TextView.setText("Relacionando os sintomas apresentados pelo paciente com os resultados de seu hemograma, constata-se que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o sangramento nasal é devido à baixa quantidade de plaquetas, que são responsáveis pela coagulação sanguínea.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o cansaço ocorreu em função da quantidade de glóbulos brancos, que são responsáveis pela coagulação sanguínea.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a dificuldade respiratória decorreu da baixa quantidade de glóbulos vermelhos, que são responsáveis pela defesa imunológica.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o sangramento nasal é decorrente da baixa quantidade de glóbulos brancos, que são responsáveis pelo transporte de gases no sangue.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a dificuldade respiratória ocorreu pela quantidade de plaquetas, que são responsáveis pelo transporte de oxigênio no sangue.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 5) {
            texto1TextView.setText("Um dos problemas dos combustíveis que contêm carbono é que sua queima produz dióxido de carbono. Portanto, uma característica importante, ao se escolher um combustível, é analisar seu calor de combustão (∆H0C), definido como a energia liberada na queima completa de um mol de combustível no estado padrão. O quadro seguinte relaciona algumas substâncias que contêm carbono e seu (∆H0C).");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q50);
            texto3TextView.setText("Neste contexto, qual dos combustíveis, quando queimado completamente, libera mais dióxido de carbono no ambiente pela mesma quantidade de energia produzida?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Benzeno.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Metano.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Glicose.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Octano.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Etanol.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 6) {
            texto1TextView.setText("Para evitar o desmatamento da Mata Atlântica nos arredores da cidade de Amargosa, no Recôncavo da Bahia, o Ibama tem atuado no sentido de fiscalizar, entre outras, as pequenas propriedades rurais que dependem da lenha proveniente das matas para a produção da farinha de mandioca, produto típico da região. Com isso, pequenos produtores procuram alternativas como o gás de cozinha, o que encarece a farinha.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Uma alternativa viável, em curto prazo, para os produtores de farinha em Amargosa, que não cause danos à Mata Atlântica nem encareça o produto é a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("construção, nas pequenas propriedades, de grandes fornos elétricos para torrar a mandioca.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("plantação, em suas propriedades, de árvores para serem utilizadas na produção de lenha.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("permissão, por parte do Ibama, da exploração da Mata Atlântica apenas pelos pequenos produtores.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("construção de biodigestores, para a produção de gás combustível a partir de resíduos orgânicos da região.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("coleta de carvão de regiões mais distantes, onde existe menor intensidade de fiscalização do Ibama.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 7) {
            texto1TextView.setText("Belém é cercada por 39 ilhas, e suas populações convivem com ameaças de doenças. O motivo, apontado por especialistas, é a poluição da água do rio, principal fonte de sobrevivência dos ribeirinhos. A diarreia é frequente nas crianças e ocorre como consequência da falta de saneamento básico, já que a população não tem acesso à água de boa qualidade. Como não há água potável, a alternativa é consumir a do rio.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O procedimento adequado para tratar a água dos rios, a fim de atenuar os problemas de saúde causados por microrganismos a essas populações ribeirinhas é a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("filtração.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("cloração.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("coagulação.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("fluoretação.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("decantação.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 8) {
            texto1TextView.setText("O vírus do papiloma humano (HPV, na sigla em inglês) causa o aparecimento de verrugas e infecção persistente, sendo o principal fator ambiental do câncer de colo de útero nas mulheres. O vírus pode entrar pela pele ou por mucosas do corpo, o qual desenvolve anticorpos contra a ameaça, embora em alguns casos a defesa natural do organismo não seja suficiente. Foi desenvolvida uma vacina contra o HPV, que reduz em até 90% as verrugas e 85,6% dos casos de infecção persistente em comparação com pessoas não vacinadas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O benefício da utilização dessa vacina é que pessoas vacinadas, em comparação com as não vacinadas, apresentam diferentes respostas ao vírus HPV em decorrência da");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("alta concentração de macrófagos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("elevada taxa de anticorpos específicos anti-HPV circulantes.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("aumento na produção de hemácias após a infecção por vírus HPV.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("rapidez na produção de altas concentrações de linfócitos matadores.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("presença de células de memória que atuam na resposta secundária.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 9) {
            texto1TextView.setText("Certas ligas estanho-chumbo com composição específica formam um estético simples, o que significa que uma liga com essas características se comporta como uma substância pura, com um ponto de fusão definido, no caso 183 ºC. Essa é uma temperatura inferior mesmo ao ponto de fusão dos metais que compõem esta liga (o estanho puro funde a 232 ºC e o chumbo puro a 320 ºC), o que justifica sua ampla utilização na soldagem de componentes eletrônicos, em que o excesso de aquecimento deve sempre ser evitado. De acordo com as normas internacionais, os valores mínimo e máximo das densidades para essas ligas são de 8,74 g/mL e 8,82 g/mL, respectivamente. As densidades do estanho e do chumbo são 7,3 g/mL e 11,3 g/mL, respectivamente.\nUm lote contendo 5 amostras de solda estanho-chumbo foi analisado por um técnico, por meio da determinação de sua composição percentual em massa, cujos resultados estão mostrados no quadro a seguir.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q54);
            texto3TextView.setText("Com base no texto e na análise realizada pelo técnico, as amostras que atendem às normas internacionais são");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("I e II.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("I e III.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("II e IV.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("III e V.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("IV e V.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 10) {
            texto1TextView.setText("No processo de industrialização da mamona, além do óleo que contém vários ácidos graxos, é obtida uma massa orgânica, conhecida como torta de mamona. Esta massa tem potencial para ser utilizada como fertilizante para o solo e como complemento em rações animais devido a seu elevado valor proteico. No entanto, a torta apresenta compostos tóxicos e alergênicos diferentemente do óleo da mamona. Para que a torta possa ser utilizada na alimentação animal, é necessário um processo de descontaminação.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A característica presente nas substâncias tóxicas e alergênicas, que inviabiliza sua solubilização no óleo de mamona, é a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("lipofilia.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("hidrofilia.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("hipocromia.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("cromatofilia.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("hiperpolarização.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 11) {
            texto1TextView.setText("O manual de funcionamento de um captador de guitarra elétrica apresenta o seguinte texto:\nEsse captador comum consiste de uma bobina, fios condutores enrolados em torno de um ímã permanente. O campo magnético do ímã induz o ordenamento dos pólos magnéticos na corda da guitarra, que está próxima a ele. Assim, quando a corda é tocada, as oscilações produzem variações, com o mesmo padrão, no fluxo magnético que atravessa a bobina. Isso induz uma corrente elétrica na bobina, que é transmitida até o amplificador, e daí, para o alto-falante.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Um guitarrista trocou as cordas originais de sua guitarra, que eram feitas de aço, por outras feitas de náilon. Com o uso dessas cordas, o amplificador ligado ao instrumento não emitia mais som, porque a corda de náilon");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("isola a passagem de corrente elétrica da bobina para o alto-falante.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("varia seu comprimento mais intensamente do que ocorre com o aço.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("apresenta uma magnetização desprezível sob a ação do ímã permanente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("induz correntes elétricas na bobina mais intensas que a capacidade do captador.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("oscila com uma frequência menor do que a que pode ser percebida pelo captador.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 12) {
            texto1TextView.setText("O controle biológico, técnica empregada no combate a espécies que causam danos e prejuízos aos seres humanos, é utilizado no combate à lagarta que se alimenta de folhas de algodoeiro. Algumas espécies de borboleta depositam seus ovos nessa cultura. A microvespa Trichogramma sp. introduz seus ovos nos ovos de outros insetos, incluindo os das borboletas em questão. Os embriões da vespa se alimentam do conteúdo desses ovos e impedem que as larvas de borboleta se desenvolvam. Assim, é possível reduzir a densidade populacional das borboletas até níveis que não prejudiquem a cultura.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A técnica de controle biológico realizado pela microvespa Trichogramma sp. consiste na");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("introdução de um parasita no ambiente da espécie que se deseja combater.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("introdução de um gene letal nas borboletas, a fim de diminuir o número de indivíduos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("competição entre a borboleta e a microvespa para a obtenção de recursos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("modificação do ambiente para selecionar indivíduos melhor adaptados.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("aplicação de inseticidas a fim de diminuir o número de indivíduos que se deseja combater.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 13) {
            texto1TextView.setText("A pele humana, quando está bem hidratada, adquire boa elasticidade e aspecto macio e suave. Em contrapartida, quando está ressecada, perde sua elasticidade e se apresenta opaca e áspera. Para evitar o ressecamento da pele é necessário, sempre que possível, utilizar hidratantes umectantes, feitos geralmente à base de glicerina e polietilenoglicol:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q58);
            texto3TextView.setText("A retenção de água na superfície da pele promovida pelos hidratantes é consequência da interação dos grupos hidroxila dos agentes umectantes com a umidade contida no ambiente por meio de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("ligações iônicas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("forças de London.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("ligações covalentes.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("forças dipolo-dipolo.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("ligações de hidrogênio.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 14) {
            texto1TextView.setText("A cal (óxido de cálcio, CaO), cuja suspensão em água é muito usada como uma tinta de baixo custo, dá uma tonalidade branca aos troncos de árvores. Essa é uma prática muito comum em praças públicas e locais privados, geralmente usada para combater a proliferação de parasitas. Essa aplicação, também chamada de caiação, gera um problema: elimina microrganismos benéficos para a árvore.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A destruição do microambiente, no tronco de árvores pintadas com cal, é devida ao processo de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("difusão, pois a cal se difunde nos corpos dos seres do microambiente e os intoxica.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("osmose, pois a cal retira água do microambiente, tornando-o inviável ao desenvolvimento de microrganismos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("oxidação, pois a luz solar que incide sobre o tronco ativa fotoquimicamente a cal, que elimina os seres vivos do microambiente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("aquecimento, pois a luz do Sol incide sobre o tronco e aquece a cal, que mata os seres vivos do microambiente. ");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("vaporização, pois a cal facilita a volatilização da água para a atmosfera, eliminando os seres vivos do microambiente.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 15) {
            texto1TextView.setText("Em um manual de um chuveiro elétrico são encontradas informações sobre algumas características técnicas, ilustradas no quadro, como a tensão de alimentação, a potência dissipada, o dimensionamento do disjuntor ou fusível, e a área da seção transversal dos condutores utilizados.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q60);
            texto3TextView.setText("Uma pessoa adquiriu um chuveiro do modelo A e, ao ler o manual l, verificou que precisava ligá-lo a um disjuntor de 50 amperes. No entanto, intrigou-se com o fato de que o disjuntor a ser utilizado para uma correta instalação de um chuveiro do modelo B devia possuir amperagem 40% menor.");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("Considerando-se os chuveiros de modelos A e B, funcionando à mesma potência de 4400 W, a razão entre as suas respectivas resistências elétricas, Ra e Rb , que justifica a diferença de dimensionamento dos disjuntores, é mais próxima de:");

            textoa1TextView.setText("0,3.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("0,6.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("0,8.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("1,7.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("3,0.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 16) {
            texto1TextView.setText("Nos dias de hoje, podemos dizer que praticamente todos os seres humanos já ouviram em algum momento falar sobre o DNA e seu papel na hereditariedade da maioria dos organismos. Porém, foi apenas em 1952, um ano antes da descrição do modelo do DNA em dupla hélice por Watson e Crick, que foi confirmado sem sombra de dúvidas que o DNA é material genético. No artigo em que Watson e Crick descreveram a molécula de DNA, eles sugeriram um modelo de como essa molécula deveria se replicar. Em 1958, Meselson e Stahl realizaram experimentos utilizando isótopos pesados de nitrogênio que foram incorporados às bases nitrogenadas para avaliar como se daria a replicação da molécula. A partir dos resultados, confirmaram o modelo sugerido por Watson e Crick, que tinha como premissa básica o rompimento das pontes de hidrogênio entre as bases nitrogenadas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Considerando a estrutura da molécula de DNA e a posição das pontes de hidrogênio na mesma, os experimentos realizados por Meselson e Stahl a respeito da replicação dessa molécula levaram à conclusão de que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a replicação do DNA é conservativa, isto é, a fita dupla filha é recém sintetizada e o filamento parental é conservado.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a replicação de DNA é dispersiva, isto é, as fitas filhas contêm DNA recém-sintetizado e parentais em cada uma das fitas.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a replicação é semiconservativa, isto é, as fitas filhas consistem de uma fita parental e uma recém-sintetizada.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a replicação do DNA é conservativa, isto é, as fitas filhas consistem de moléculas de DNA parental.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a replicação é semiconservativa, isto é, as fitas filhas consistem de uma fita molde e uma fita codificadora.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 17) {
            texto1TextView.setText("A eutrofização é um processo em que rios, lagos e mares adquirem níveis altos de nutrientes, especialmente fosfatos e nitratos, provocando posterior acúmulo de matéria orgânica em decomposição. Os nutrientes são assimilados pelos produtores primários e o crescimento desses é controlado pelo nutriente limítrofe, que é o elemento menos disponível em relação à abundância necessária à sobrevivência dos organismos vivos. O ciclo representado na figura seguinte reflete a dinâmica dos nutrientes em um lago.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q62);
            texto3TextView.setText("A análise da água de um lago que recebe a descarga de águas residuais provenientes de lavouras adubadas revelou as concentrações dos elementos carbono (21,2 mol/L), nitrogênio (1,2 mol/L) e fósforo (0,2 mol/L). Nessas condições, o nutriente limítrofe é o");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("C.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("N.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("P.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("CO2");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("PO43-");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 18) {
            texto1TextView.setText("Para que uma substância seja colorida ela deve absorver luz na região do visível. Quando uma amostra absorve luz visível, a cor que percebemos é a soma das cores restantes que são refletidas ou transmitidas pelo objeto. A Figura 1 mostra o espectro de absorção para uma substância e é possível observar que há um comprimento de onda em que a intensidade de absorção é máxima. Um observador pode prever a cor dessa substância pelo uso da roda de cores (Figura 2): o comprimento de onda correspondente à cor do objeto é encontrado no lado oposto ao comprimento de onda da absorção máxima.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q63);
            texto3TextView.setText("Qual a cor da substância que deu origem ao espectro da Figura 1?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Azul.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Verde.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Violeta.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Laranja.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Vermelho.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 19) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q64);
            texto3TextView.setText("O mapa mostra a área de ocorrência da malária no mundo. Considerando-se sua distribuição na América do Sul, a malária pode ser classificada como");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("endemia, pois se concentra em uma área geográfica restrita desse continente.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("peste, já que ocorre nas regiões mais quentes do continente.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("epidemia, já que ocorre na maior parte do continente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("surto, pois apresenta ocorrência em áreas pequenas.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("pandemia, pois ocorre em todo o continente.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 20) {
            texto1TextView.setText("Em 1999, a geneticista Emma Whitelaw desenvolveu um experimento no qual ratas prenhes foram submetidas a uma dieta rica em vitamina B12, ácido fólico e soja. Os filhotes dessas ratas, apesar de possuírem o gene para obesidade, não expressaram essa doença na fase adulta. A autora concluiu que a alimentação da mãe, durante a gestação, silenciou o gene da obesidade. Dez anos depois, as geneticistas Eva Jablonka e Gal Raz listaram 100 casos comprovados de traços adquiridos e transmitidos entre gerações de organismos, sustentando, assim, epigenética, que estuda as mudanças na atividade dos genes que não envolvem alterações na sequência do DNA.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Alguns cânceres esporádicos representam exemplos de alteração epigenética, pois são ocasionados por");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("aneuploidia do cromossomo sexual X.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("polipoidia dos cromossomos autossômicos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("mutação em genes autossômicos com expressão dominante.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("substituição no gene da cadeia beta da hemoglobina.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("inativação de genes por meio de modificações nas bases nitrogenadas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 21) {
            texto1TextView.setText("Um motor só poderá realizar trabalho se receber uma quantidade de energia de outro sistema. No caso, a energia armazenada no combustível é, em parte, liberada durante a combustão para que o aparelho possa funcionar. Quando o motor funciona, parte da energia convertida ou transformada na combustão não pode ser utilizada para a realização de trabalho. Isso significa dizer que há vazamento da energia em outra forma.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("De acordo com o texto, as transformações de energia que ocorrem durante o funcionamento do motor são decorrentes de a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("liberação de calor dentro do motor ser impossível.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("realização de trabalho pelo motor ser incontrolável.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("conversão integral de calor em trabalho ser impossível.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("transformação de energia térmica em cinética ser impossível.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("utilização de energia potencial do combustível ser incontrolável.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 22) {
            texto1TextView.setText("O processo de interpretação de imagens capturadas por sensores instalados a bordo de satélites que imageiam determinadas faixas ou bandas do espectro de radiação eletromagnética (REM) baseiam-se na interação dessa radiação com os objetos presentes sobre a superfície terrestre. Uma das formas de avaliar essa interação é por meio da quantidade de energia refletida pelos objetos. A relação entre a refletância de um dado objeto e o comprimento de onda da REM é conhecida como curva de comportamento espectral ou assinatura espectral do objeto, como mostrado na figura, para objetos comuns na superfície terrestre.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q67);
            texto3TextView.setText("De acordo com as curvas de assinatura espectral apresentadas na figura, para que se obtenha a melhor discriminação criminação dos alvos mostrados, convém selecionar a banda correspondente a que comprimento de onda em micrômetros (μm)?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("0,4 a 0,5.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("0,5 a 0,6.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("0,6 a 0,7.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("0,7 a 0,8.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("0,8 a 0,9.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 23) {
            texto1TextView.setText("Um instituto de pesquisa norte-americano divulgou recentemente ter criado uma “célula sintética”, uma bactéria chamada de Mycoplasma mycoides. Os pesquisadores montaram uma sequência de nucleotídeos, que formam o único cromossomo dessa bactéria, o qual foi introduzido em outra espécie de bactéria, a Mycoplasma capricolum. Após a introdução, o cromossomo da M. capricolum foi neutralizado e o e o cromossomo artificial da M. mycoides começou a gerenciar a célula, produzindo suas proteínas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A importância dessa inovação tecnológica para a comunidade científica se deve à");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("possibilidade de sequenciar os genomas de bactérias para serem usados como receptoras de cromossomos artificiais.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("capacidade de criação, pela ciência, de novas formas de vida, utilizando substâncias como carboidratos e lipídios.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("possibilidade de produção em massa da bactéria Mycoplasma capricolum para sua distribuição em ambientes naturais.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("possibilidade de programar geneticamente microrganismos ou seres mais complexos para produzir medicamentos, vacinas e combustíveis.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("capacidade da bactéria Mycoplasma capricolum de expressar suas proteínas na bactéria sintética e estas serem usadas na indústria.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 24) {
            texto1TextView.setText("Os sintomas mais sérios da Gripe A, causada pelo vírus H1N1, foram apresentados por pessoas mais idosas e por gestantes. O motivo aparente é a menor imunidade desses grupos contra o vírus. Para aumentar a imunidade populacional relativa ao vírus da gripe A, o governo brasileiro distribuiu vacinas para os grupos mais suscetíveis.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A vacina contra o H1N1, assim como qualquer outra vacina contra agentes causadores de doenças infecto-contagiosas aumenta a imunidade das pessoas porque");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("possui anticorpos contra o agente causador da doença.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("possui proteínas que eliminam o agente causador da doença.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("estimula a produção de glóbulos vermelhos pela medula óssea.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("possui linfócitos B e T que neutralizam o agente causador da doença.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("estimula a produção de anticorpos contra o agente causador da doença.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 25) {
            texto1TextView.setText("Um curioso estudante, empolgado com a aula de circuito elétrico que assistiu na escola, resolve desmontar sua lanterna. Utilizando-se da lâmpada e da pilha, retiradas do equipamento, e de um fio com as extremidades descascadas, faz as seguintes ligações com a intenção de acender a lâmpada:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q70);
            texto3TextView.setText("Tendo por base os esquemas mostrados, em quais casos a lâmpada acendeu?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("(1), (3), (6)");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("(3), (4), (5)");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("(1), (3), (5)");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("(1), (3), (7)");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("(1), (2), (5)");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 26) {
            texto1TextView.setText("Os biocombustíveis de primeira geração são derivados da soja, milho e cana-de-açúcar e sua produção ocorre através da fermentação. Biocombustíveis derivados de material celulósico ou biocombustíveis de segunda geração — coloquialmente chamados de “gasolina de capim” — são aqueles produzidos a partir de resíduos de madeira (serragem, por exemplo), talos de milho, palha de trigo ou capim de crescimento rápido e se apresentam como uma alternativa para os problemas enfrentados pelos de primeira geração, já que as matérias-primas são baratas e abundantes.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto mostra um dos pontos de vista a respeito do uso dos biocombustíveis na atualidade, os quais");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("são matrizes energéticas com menor carga de poluição para o ambiente e podem propiciar a geração de novos empregos, entretanto, para serem oferecidos com baixo custo, a tecnologia da degradação da celulose nos biocombustíveis de segunda geração deve ser extremamente eficiente.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("oferecem múltiplas dificuldades, pois a produção é de alto custo, sua implantação não gera empregos, e deve-se ter cuidado com o risco ambiental, pois eles oferecem os mesmos riscos que o uso de combustíveis fósseis.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("sendo de segunda geração, são produzidos por uma tecnologia que acarreta problemas sociais, sobretudo decorrente do fato de a matéria-prima ser abundante e facilmente encontrada, o que impede a geração de novos empregos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("sendo de primeira e segunda geração, são produzidos por tecnologias que devem passar por uma avaliação criteriosa quanto ao uso, pois uma enfrenta o problema da falta de espaço para plantio da matéria-prima e a outra impede a geração de novas fontes de emprego.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("sendo de primeira e segunda geração, são produzidos por tecnologias que devem passar por uma avaliação criteriosa quanto ao uso, pois uma enfrenta o problema da falta de espaço para plantio da matéria-prima e a outra impede a geração de novas fontes de emprego.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 27) {
            texto1TextView.setText("A bile é produzida pelo fígado, armazenada na vesícula biliar e tem papel fundamental na digestão de lipídeos. Os sais biliares são esteroides sintetizados no fígado a partir do colesterol, e sua rota de síntese envolve várias etapas. Partindo do ácido cólico representado na figura, ocorre a formação dos ácidos glicocólico e taurocólico; o prefixo glico- significa a presença de um resíduo do aminoácido glicina e o prefixo tauro-, do aminoácido taurina.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q72);
            texto3TextView.setText("A combinação entre o ácido cólico e a glicina ou taurina origina a função amida, formada pela reação entre o grupo amina desses aminoácidos e o grupo");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("carboxila do ácido cólico.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("aldeído do ácido cólico.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("hidroxila do ácido cólico.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("cetona do ácido cólico.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("éster do ácido cólico.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 28) {
            texto1TextView.setText("Em um experimento realizado para determinar a densidade da água de um lago, foram utilizados alguns materiais conforme ilustrado: um dinamômetro D com graduação de 0 N a 50 N e um cubo maciço e homogêneo de 10 cm de aresta e 3 kg de massa. Inicialmente, foi conferida a calibração do dinamômetro, constatando-se a leitura de 30 N quando o cubo era preso ao dinamômetro e suspenso no ar. Ao mergulhar o cubo na água do lago, até que metade do seu volume ficasse submersa, foi registrada a leitura de 24 N no dinamômetro.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q73);
            texto3TextView.setText("Considerando que a aceleração da gravidade local é de 10 m/s, a densidade da água do lago, em g/cm3, é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("0,6.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("1,2.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("1,5.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("2,4.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("4,8.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 29) {
            texto1TextView.setText("Uma equipe de cientistas lançará uma expedição ao Titanic para criar um detalhado mapa 3D que “vai tirar, virtualmente, o Titanic do fundo do mar para o público”. A expedição ao local, a 4 quilômetros de profundidade no Oceano Atlântico, está sendo apresentada como a mais sofisticada expedição científica ao Titanic. Ela utilizará tecnologias de imagem e sonar que nunca tinham sido aplicadas ao navio, para obter o mais completo inventário de seu conteúdo. Esta complementação é necessária em razão das condições do navio, naufragado há um século.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("No problema apresentado para gerar imagens através de camadas de sedimentos depositados no navio, o sonar é mais adequado, pois a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("propagação da luz na água ocorre a uma velocidade maior que a do som neste meio.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("absorção da luz ao longo de uma camada de água é facilitada enquanto a absorção do som não. ");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("refração da luz a uma grande profundidade acontece com uma intensidade menor que a do som.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("atenuação da luz nos materiais analisados é distinta da atenuação de som nestes mesmos materiais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("reflexão da luz nas camadas de sedimentos é menos intensa do que a reflexão do som neste material.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 30) {
            texto1TextView.setText("Os refrigerantes têm-se tornado cada vez mais o alvo de políticas públicas de saúde.  Os de cola apresentam ácido-fosfórico , substância prejudicial à fixação de cálcio, o mineral que é o principal componente da matriz dos dentes. A cárie é um processo dinâmico de desequilíbrio do processo de desmineralização dentária, perda de minerais em razão da acidez. Sabe-se que o principal componente do esmalte do dente é um sal denominado hidroxiapatita. O refrigerante, pela presença da sacarose, faz decrescer o pH do biofilme (placa bacteriana), provocando a desmineralização do esmalte dentário. Os mecanismos de defesa salivar levam de 20 a 30 minutos para normalizar o nível do pH, remineralizando o dente. A equação química seguinte representa esse processo:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q75);
            texto3TextView.setText("Considerando que uma pessoa consuma refrigerantes diariamente, poderá ocorrer um processo de desmineralização dentária, devido ao aumento da concentração de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("OH-, que reage com os íons Ca2+, deslocando o equilíbrio para a direita.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("H+, que reage com as hidroxilas OH-, deslocando o equilíbrio para a direita.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("OH-, que reage com os íons Ca2+, deslocando o equilíbrio para a esquerda.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("H+, que reage com as hidroxilas OH-, deslocando o equilíbrio para a esquerda");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Ca2+,  que reage com as hidroxilas OH-, deslocando o equilíbrio para a esquerda.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 31) {
            texto1TextView.setText("Diferente do que o senso comum acredita, as lagartas de borboletas não possuem voracidade generalizada. Um estudo mostrou que as borboletas de asas transparentes da família Ithomiinae, comuns na Floresta Amazônica e na Mata Atlântica, consomem, sobretudo, plantas da família Solanaceae, a mesma do tomate. Contudo, os ancestrais dessas borboletas consumiam espécies vegetais da família Apocinaceae, mas a quantidade dessas plantas parece não ter sido suficiente para garantir o suprimento alimentar dessas borboletas. Dessa forma, as solanáceas tornaram-se uma opção de alimento, pois são abundantes na Mata Atlântica e na Floresta Amazônica.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Nesse texto, a ideia do senso comum é confrontada com os conhecimentos científicos, ao se entender que as larvas das borboletas Ithomiinae encontradas atualmente na Mata Atlântica e na Floresta Amazônica, apresentam");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("facilidade em digerir todas as plantas desses locais.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("interação com as plantas hospedeiras da família Apocinaceae.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("adaptação para se alimentar de todas as plantas desses locais.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("voracidade indiscriminada por todas as plantas existentes nesses locais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("especificidade pelas plantas da família Solanaceae existentes nesses locais.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 32) {
            texto1TextView.setText("Para medir o tempo de reação de uma pessoa, pode-se realizar a seguinte experiência:\nI. Mantenha uma régua (com cerca de 30 cm) suspensa verticalmente, segurando-a pela extremidade superior,  de modo que o zero da régua esteja situado na extremidade inferior.\nII. A pessoa deve colocar os dedos de sua mão, em forma de pinça, próximos do zero da régua, sem tocá-la.\nIII. Sem aviso prévio, a pessoa que estiver segurando a régua deve soltá-la. A outra pessoa deve procurar segurá-la o mais rapidamente possível e observar a posição onde conseguiu segurar a régua, isto é, a distância que ela percorre durante a queda.\nO quadro seguinte mostra a posição em que três pessoas conseguiram segurar a régua e os respectivos tempos de reação.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q77);
            texto3TextView.setText("A distância percorrida pela régua aumenta mais rapidamente que o tempo de reação porque a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("energia mecânica da régua aumenta, o que a faz cair mais rápido.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("resistência do ar aumenta, o que faz a régua cair com menor velocidade.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("aceleração de queda da régua varia, o que provoca um movimento acelerado.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("força peso da régua tem valor constante, o que gera um movimento acelerado.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("velocidade da régua é constante, o que provoca uma passagem linear de tempo.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 33) {
            texto1TextView.setText("Um tipo de vaso sanitário que vem substituindo as válvulas de descarga está esquematizado na figura. Ao acionar a alavanca, toda a água do tanque é escoada e aumenta o nível no vaso, até cobrir o sifão. De acordo com o Teorema de Stevin, quanto maior a profundidade, maior a pressão. Assim, a água desce levando os rejeitos até o sistema de esgoto. A válvula da caixa de descarga se fecha e ocorre o seu enchimento. Em relação às válvulas de descarga, esse tipo de sistema proporciona maior economia de água.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q78);
            texto3TextView.setText("A característica de funcionamento que garante essa economia é devida");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("à altura do sifão de água.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("ao volume do tanque de água.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("à altura do nível de água no vaso.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("ao diâmetro do distribuidor de água.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("à eficiência da válvula de enchimento do tanque.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 34) {
            texto1TextView.setText("Moradores sobreviventes da tragédia que destruiu aproximadamente 60 casas no Morro do Bumba, na Zona Norte de Niterói (RJ), ainda defendem a hipótese de o deslizamento ter sido causado por uma explosão provocada por gás metano, visto que esse local foi um lixão entre os anos 1960 e 1980.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O gás mencionado no texto é produzido");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("como subproduto da respiração aeróbia bacteriana.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("pela degradação anaeróbia de matéria orgânica por bactérias.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("como produto da fotossíntese de organismos pluricelulares autotróficos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("pela transformação química do gás carbônico em condições anaeróbias.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("pela conversão, por oxidação química, do gás carbônico sob condições aeróbias.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 35) {
            texto1TextView.setText("Segundo dados do Balanço Energético Nacional de 2008, do Ministério das Minas e Energia, a matriz energética brasileira é composta por hidrelétrica (80%), termelétrica (19,9%) e eólica (0,1%). Nas termelétricas, esse percentual é dividido conforme o combustível usado, sendo: gás natural (6,6%), biomassa (5,3%), derivados de petróleo (3,3%), energia nuclear (3,1%) e carvão mineral (1,6%). Com a geração de eletricidade da biomassa, pode-se considerar que ocorre uma compensação do carbono liberado na queima do material vegetal pela absorção desse elemento no crescimento das plantas. Entretanto, estudos indicam que as emissões de metano (CH4) das hidrelétricas podem ser comparáveis às emissões de CO2 das termelétricas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("No Brasil, em termos do impacto das fontes de energia no crescimento do efeito estufa, quanto à emissão de gases, as hidrelétricas seriam consideradas como uma fonte");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("limpa de energia, contribuindo para minimizar os efeitos deste fenômeno.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("eficaz de energia, tomando-se o percentual de oferta e os benefícios verificados.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("limpa de energia, não afetando ou alterando os níveis dos gases do efeito estufa.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("poluidora, colaborando com níveis altos de gases de efeito estufa em função de seu potencial de oferta.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("alternativa, tomando-se por referência a grande emissão de gases de efeito estufa das demais fontes geradoras.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 36) {
            texto1TextView.setText("O peróxido de hidrogênio é comumente utilizado como antisséptico e alvejante. Também pode ser empregado em trabalhos de restauração de quadros enegrecidos e no clareamento de dentes. Na presença de soluções ácidas de oxidantes, como o permanganato de potássio, este óxido decompõe-se, conforme a equação a seguir:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q81);
            texto3TextView.setText("De acordo com a estequiometria da reação descrita, a quantidade de permanganato de potássio necessária para reagir completamente com 20,0 mL de uma solução 0,1 mol/L de peróxido de hidrogênio é igual a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("2,0×100 mol");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("2,0×10-1 mol ");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("8,0×10-1 mol ");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("8,0×10-4 mol ");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("5,0×10-3 mol ");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 37) {
            texto1TextView.setText("Os vaga-lumes machos e fêmeas emitem sinais luminosos para se atraírem para o acasalamento. O macho reconhece a fêmea de sua espécie e, atraído por ela, vai ao seu encontro. Porém, existe um tipo de vaga-lume, o Photuris, cuja fêmea engana e atrai os machos de outro tipo, o Photinus gênero. Quando o macho Photinus se aproxima da fêmea Photuris, muito maior que ele, é atacado e devorado por ela.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A relação descrita no texto, entre a fêmea do gênero Photuris e o macho do gênero Photinus, é um exemplo de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("comensalismo.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("inquilinismo.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("cooperação.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("predatismo.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("mutualismo.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 38) {
            texto1TextView.setText("O etanol é considerado um biocombustível promissor, pois, sob o ponto de vista do balanço de carbono, possui uma taxa de emissão praticamente igual a zero. Entretanto, esse não é o único ciclo biogeoquímico associado à produção de etanol. O plantio da cana-de-açúcar, matéria-prima para a produção de etanol, envolve a adição de macronutrientes como enxofre, nitrogênio, fósforo e potássio, principais elementos envolvidos no crescimento de um vegetal.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O nitrogênio incorporado ao solo, como consequência da atividade descrita anteriormente, é transformado em nitrogênio ativo e afetará o meio ambiente, causando");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o acúmulo de sais insolúveis, desencadeando um processo de salinificação do solo.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a eliminação de microorganismos existentes no solo responsáveis pelo processo de desnitrificação.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a contaminação de rios e lagos devido à alta solubilidade de íons como NO3- e NH4+ em água.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a contaminação de rios e lagos devido à alta solubilidade de íons como NH3, , que reage com a água, formando o NH4OH(aq).");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a diminuição da oxigenação do solo, uma vez que o nitrogênio ativo forma espécies químicas do tipo NO2, NO-, N2O.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 39) {
            texto1TextView.setText("Ao diminuir o tamanho de um orifício atravessado por um feixe de luz, passa menos luz por intervalo de tempo, e próximo da situação de completo fechamento do orifício, verifica-se que a luz apresenta um comportamento como o ilustrado nas figuras. Sabe-se que o som, dentro de suas particularidades, também pode se comportar dessa forma.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q84);
            texto3TextView.setText("Em qual das situações a seguir está representado o fenômeno descrito no texto?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Ao se esconder atrás de um muro, um menino ouve a conversa de seus colegas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Ao gritar diante de um desfiladeiro, uma pessoa ouve a repetição do seu próprio grito.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Ao encostar o ouvido no chão, um homem percebe o som de uma locomotiva antes de ouvi-lo pelo ar.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Ao ouvir uma ambulância se aproximando, uma pessoa percebe o som mais agudo do que quando aquela se afasta.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Ao emitir uma nota musical muito aguda, uma cantora de ópera faz com que uma taça de cristal se despedace.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 40) {
            texto1TextView.setText("Um dos processos usados no tratamento do lixo é a incineração, que apresenta vantagens e desvantagens. Em São Paulo, por exemplo, o lixo é queimado a altas temperaturas e parte da energia liberada é transformada em energia elétrica. No entanto, a incineração provoca a emissão de poluentes na atmosfera.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Uma forma de minimizar a desvantagem da incineração, destacada no texto, é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("aumentar o volume do lixo incinerado para aumentar a produção de energia elétrica.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("fomentar o uso de filtros nas chaminés dos incineradores para diminuir a poluição do ar.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("aumentar o volume do lixo para baratear os custos operacionais relacionados ao processo.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("fomentar a coleta seletiva de lixo nas cidades para aumentar o volume de lixo incinerado.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("diminuir a temperatura de incineração do lixo para produzir maior quantidade de energia elétrica.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 41) {
            texto1TextView.setText("Uma das modalidades presentes nas olimpíadas é o salto com vara. As etapas de um dos saltos de um atleta estão representadas na figura:");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q86);
            texto3TextView.setText("Desprezando-se as forças dissipativas (resistência do ar e atrito), para que o salto atinja a maior altura possível, ou seja, o máximo de energia seja conservada, é necessário que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a energia cinética, representada na etapa I, seja totalmente convertida em energia potencial elástica representada na etapa IV.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a energia cinética, representada na etapa II, seja totalmente convertida em energia potencial gravitacional, representada na etapa IV.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a energia cinética, representada na etapa I, seja totalmente convertida em energia potencial gravitacional, representada na etapa III.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a energia potencial gravitacional, representada na etapa II, seja totalmente convertida em energia potencial elástica, representada na etapa IV.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a energia potencial gravitacional, representada na etapa I, seja totalmente convertida em energia potencial elástica, representada na etapa III.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 42) {
            texto1TextView.setText("Os Bichinhos e O Homem\nArca de Noé\nToquinho & Vinicius de Moraes\nNossa irmã, a mosca\nÉ feia e tosca\nEnquanto que o mosquito\nÉ mais bonito\nNosso irmão besouro\nQue é feito de couro\nMal sabe voar\nNossa irmã, a barata\nBichinha mais chata\nÉ prima da borboleta\nQue é uma careta\nNosso irmão, o grilo\nQue vive dando estrilo\nSó pra chatear");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O poema acima sugere a existência de relações de afinidade entre os animais citados e nós, seres humanos. Respeitando a liberdade poética dos autores, a unidade taxonômica que expressa a afinidade existente entre nós e estes animais é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o filo.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o reino.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a classe.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a família.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a espécie.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 43) {
            texto1TextView.setText("Certas espécies de algas são capazes de absorver rapidamente compostos inorgânicos presentes na água, acumulando-os durante seu crescimento. Essa capacidade fez com que se pensasse em usá-las como biofiltros para a limpeza de ambientes aquáticos contaminados, removendo, por exemplo, nitrogênio e fósforo de resíduos orgânicos e metais pesados provenientes de rejeitos industriais lançados nas águas. Na técnica do cultivo integrado, animais e algas crescem de forma associada, promovendo um maior equilíbrio ecológico.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A utilização da técnica do cultivo integrado de animais e algas representa uma proposta favorável a um ecossistema mais equilibrado porque");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("os animais eliminam metais pesados, que são usados pelas algas para a síntese de biomassa.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("os animais fornecem excretas orgânicos nitrogenados, que são transformados em gás carbônico pelas algas.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("as algas usam os resíduos nitrogenados liberados pelos animais e eliminam gás carbônico na fotossíntese, usado na respiração aeróbica.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("as algas usam os resíduos nitrogenados provenientes do metabolismo dos animais e, durante a síntese de compostos orgânicos, liberam oxigênio para o ambiente.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("as algas aproveitam os resíduos do metabolismo dos animais e, durante a quimiossíntese de compostos orgânicos, liberam oxigênio para o ambiente.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 44) {
            texto1TextView.setText("Durante as estações chuvosas, aumentam no Brasil as campanhas de prevenção à dengue, que têm como objetivo a redução da proliferação do mosquito Aedes aegypti, transmissor do vírus da dengue.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Que proposta preventiva poderia ser efetivada para diminuir a reprodução desse mosquito?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Colocação de telas nas portas e janelas, pois o mosquito necessita de ambientes cobertos e fechados para a sua reprodução.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Substituição das casas de barro por casas de alvenaria, haja vista que o mosquito se reproduz na parede das casas de barro.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Remoção dos recipientes que possam acumular água, porque as larvas do mosquito se desenvolvem nesse meio.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Higienização adequada de alimentos, visto que as larvas do mosquito se desenvolvem nesse tipo de substrato.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Colocação de filtros de água nas casas, visto que a reprodução do mosquito acontece em águas contaminadas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 45) {
            texto1TextView.setText("De acordo com o relatório “A grande sombra da pecuária” (Livestock’s Long Shadow), feito pela Organização das Nações Unidas para a Agricultura e a Alimentação, o gado é responsável por cerca de 18% do aquecimento global, uma contribuição maior que a do setor de transportes.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nat2011d1q90);
            texto3TextView.setText("A criação de gado em larga escala contribui para o aquecimento global por meio da emissão de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("metano durante o processo de digestão.");
            fa1.setImageResource(R.drawable. nulo);
            textob1TextView.setText("óxido nitroso durante o processo de ruminação.");
            fb1.setImageResource(R.drawable. nulo);
            textoc1TextView.setText("clorofluorcarbono durante o transporte de carne.");
            fc1.setImageResource(R.drawable. nulo);
            textod1TextView.setText("óxido nitroso durante o processo respiratório.");
            fd1.setImageResource(R.drawable. nulo);
            textoe1TextView.setText("dióxido de enxofre durante o consumo de pastagens.");
            fe1.setImageResource(R.drawable. nulo);
            video = "";
            alt = R.id.a;
        }
        return alt;
    }
}

