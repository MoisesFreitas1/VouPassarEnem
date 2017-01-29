package losfreitasapps.com.enem;

import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Moises on 06/09/16.
 */
public class Humanas extends Fragment {
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

        nquestions = 60;
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

        disciplinaTextView.setText("Ciências Humanas");
        if (savedInstanceState != null){
            nquestion = savedInstanceState.getIntArray("questoes");
        } else {
            nquestion = new int[10];
        }
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

//        Log.d("Sorteio",nquestion[0] + " " + nquestion[1] + " " + nquestion[2]);

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

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putIntArray("questoes",nquestion);
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
            figura1ImageView.setImageResource(R.drawable.hum2010d1q1);
            texto3TextView.setText("A tirinha mostra que o ser humano, na busca de atender suas necessidades e de se apropriar dos espaços,");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("adotou a acomodação evolucionária como forma de sobrevivência ao se dar conta de suas deficiências impostas pelo meio ambiente.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("utilizou o conhecimento e a técnica para criar equipamentos que lhe permitiram compensar as suas limitações físicas.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("levou vantagens em relação aos seres de menor estatura, por possuir um físico bastante desenvolvido, que lhe permitia muita agilidade");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("dispensou o uso da tecnologia por ter um organismo adaptável aos diferentes tipos de meio ambiente");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("sofreu desvantagens em relação a outras espécies, por utilizar os recursos naturais como forma de se apropriar dos diferentes espaços. ");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }

        if (question == 2) {
            texto1TextView.setText("Se, por um lado, o ser humano, como animal, é parte integrante da natureza e necessita dela para continuar sobrevivendo, por outro, como ser social, cada dia mais sofistica os mecanismos de extrair da natureza recursos que, ao serem aproveitados, podem alterar de modo profundo a funcionalidade harmônica dos ambientes naturais.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A relação entre a sociedade e a natureza vem sofrendo profundas mudanças em razão do conhecimento técnico. A partir da leitura do texto, identifique a possível consequência do avanço da técnica sobre o meio natural.");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("A sociedade aumentou o uso de insumos químicos – agrotóxicos e fertilizantes – e, assim, os riscos de contaminação.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("O homem, a partir da evolução técnica, conseguiu explorar a natureza e difundir harmonia na vida social.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("As degradações produzidas pela exploração dos recursos naturais são reversíveis, o que, de certa forma, possibilita a recriação da natureza.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("O desenvolvimento técnico, dirigido para a recomposição de áreas degradadas, superou os efeitos negativos da degradação.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("As mudanças provocadas pelas ações humanas sobre a natureza foram mínimas, uma vez que os recursos utilizados são de caráter renovável.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }

        if (question == 3) {
            texto1TextView.setText("Um fenômeno importante que vem ocorrendo nas últimas quatro décadas é o baixo crescimento populacional na Europa, principalmente em alguns países como Alemanha e Áustria, onde houve uma brusca queda na taxa de natalidade. Esse fenômeno é especialmente preocupante pelo fato de a maioria desses países já ter chegado a um índice ao ‘nível de renovação da população’, estimado em 2,1 filhos por mulher. A diminuição da natalidade europeia tem várias causas, algumas de caráter demográfico, outras de caráter cultural e socioeconômico.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("As tendências populacionais nesses países estão relacionadas a uma transformação");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("na estrutura familiar dessas sociedades, impactada por mudanças nos projetos de vida das novas gerações.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("no comportamento das mulheres mais jovens, que têm imposto seus planos de maternidade aos homens.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("no número de casamentos, que cresceu nos últimos anos, reforçando a estrutura familiar tradicional.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("no fortalecimento de pensões de aposentadoria, em queda diante de uma população de maioria jovem.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("na taxa de mortalidade infantil europeia, em contínua ascensão, decorrente de pandemias na primeira infância.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 4) {
            texto1TextView.setText("A bandeira da Europa não é apenas o símbolo da União Europeia, mas também da unidade e da identidade da Europa em sentido mais lato. O círculo de estrelas douradas representa a solidariedade e a harmonia entre os povos da Europa.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A que se pode atribuir a contradição intrínseca entre o que propõe a bandeira da Europa e o cotidiano vivenciado pelas nações integrantes da União Europeia?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Ao context da década de 1930, no qual a bandeira foi forjada e em que se pretendia a fraternidade entre os povos traumatizados pela Primeira Guerra Mundial.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Ao fato de que o ideal de equilíbrio implícito na bandeira nem sempre se coaduna com os conflitos e rivalidades regionais tradicionais.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Ao fato de que Alemanha e Itália ainda são vistas com desconfiança por Inglaterra e França mesmo após décadas do final da Segunda Guerra Mundial.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Ao fato de que a bandeira foi concebida por portugueses e espanhóis, que possuem uma convivência mais harmônica do que as demais nações europeias.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Ao fato de que a bandeira representa as aspirações religiosas dos países de vocação católica, contrapondo-se ao cotidiano das nações protestantes.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 5) {
            texto1TextView.setText("O crescimento rápido das cidades nem sempre é acompanhado, no mesmo ritmo, pelo atendimento de infraestrutura para a melhoria da qualidade de vida. A deficiência de redes de água tratada, de coleta e tratamento de esgoto, de pavimentação de ruas, de galerias de águas pluviais, de áreas de lazer, de áreas verdes, de núcleos de formação educacional e professional, de núcleos de atendimento medico-sanitário é comum nessas cidades.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Sabendo que o acelerado crescimento populacional urbano está articulado com a escassez de recursos financeiros e a dificuldade de implementação de leis de proteção ao meio ambiente, pode-se estabelecer o estímulo a uma relação sustentável entre conservação e produção a partir");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("do aumento do consumo, pela população mais pobre, de produtos industrializados para o equilibrio da capacidade de consumo entre as classes.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("da seleção e recuperação do lixo urbano, que já é uma prática rotineira nos grandes centros urbanos dos países em desenvolvimento.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("da diminuição acelerada do uso de recursos naturais, ainda que isso represente perda da qualidade de vida de milhões de pessoas.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("da fabricação de produtos reutilizáveis e biodegradáveis, evitando-se substituições e descartes, como medidas para a redução da degradação ambiental.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("da transferência dos aterros sanitários para as partes mais periféricas das grandes cidades, visando-se à preservação dos ambientes naturais.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 6) {
            texto1TextView.setText("O volume de matéria-prima recuperado pela reciclagem do lixo está muito abaixo das necessidades da indústria. No entanto, mais que uma forma de responder ao aumento da demanda industrial por matérias-primas e energia, a reciclagem é uma forma de reintroduzir o lixo no processo industrial.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A prática abordada no texto corresponde, no contexto global, a uma situação de sustentabilidade que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("reduz o buraco na camada de ozônio nos distritos industriais.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("ameniza os efeitos das chuvas ácidas nos polos petroquímicos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("diminui os efeitos da poluição atmosférica das indústrias siderúrgicas.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("diminui a possibilidade de formação das ilhas de calor nas áreas urbanas.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("reduz a utilização de matérias-primas nas indústrias de bens de consumo.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 7) {
            texto1TextView.setText("");
            texto2TextView.setText("O mapa mostra a distribuição de bovinos no bioma amazônico, cuja ocupação foi responsável pelo desmatamento de significativas extensões de terra na região. Verifica-se que existem municípios com grande contingente de bovinos, nas áreas mais escuras do mapa, entre 750 001 e 1 500 000 cabeças de bovinos.");
            figura1ImageView.setImageResource(R.drawable.hum2010d1q7);
            texto3TextView.setText("A análise do mapa permite concluir que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("os estados do Pará, Mato Grosso e Rondônia detêm a maior parte de bovinos em relação ao bioma amazônico.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("os municípios de maior extensão são responsáveis pela maior produção de bovinos, segundo mostra a legenda.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a criação de bovinos é a atividade econômica principal nos municípios mostrados no mapa.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o efetivo de cabeças de bovinos se distribui amplamente pelo bioma amazônico.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("as terras florestadas são as áreas mais favoráveis ao desenvolvimento da criação de bovinos.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 8) {
            texto1TextView.setText("De fato, que alternativa restava aos portugueses, ao se verem diante de uma mata virgem e necessitando de terra para cultivo, a não ser derrubar a mata e atear-lhe fogo? Seria, pois, injusto reprová-los por terem começado dessa maneira. Toda via, podemos culpar os seus descendentes, e com razão, por continuarem a queimar as florestas quando há agora, no início do século XIX, tanta terra limpa e pronta para o cultivo à sua disposição.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("No texto, há informações sobre a prática da queimada em diferentes períodos da história do Brasil. Segundo a análise apresentada, os portugueses");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("evitaram emitir juízo de valor sobre a prática da queimada.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("consideraram que a queimada era necessária em certas circunstâncias.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("concordaram quanto à queimada ter sido uma prática agrícola insuficiente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("entenderam que a queimada era uma prática necessária no início do séc. XIX.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("relacionaram a queimada ao descaso dos agricultores da época com a terra.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 9) {
            texto1TextView.setText("No século XIX, para alimentar um habitante urbano, eram necessárias cerca de 60 pessoas trabalhando no campo. Essa proporção foi se modificando ao longo destes dois séculos. Em certos países, hoje, há um habitante rural para cada dez urbanos.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O autor expõe uma tendência de aumento de produtividade agrícola por trabalhador rural, na qual menos pessoas produzem mais alimentos, que pode ser explicada");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("pela exigência de abastecimento das populações urbanas, que trabalham majoritariamente no setor primário da economia.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("pela imposição de governos que criam políticas econômicas para o favorecimento do crédito agrícola.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("pela incorporação homogênea dos agricultores às técnicas de modernização, sobretudo na relação latifúndio-minifúndio.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("pela dinamização econômica desse setor e utilização de novas técnicas e equipamentos de produção pelos agricultores.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("pelo acesso às novas tecnologias, o que fez com que áreas em altas latitudes, acima de 66°, passassem a ser grandes produtoras agrícolas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 10) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2010d1q10);
            texto3TextView.setText("A interpretação do mapa indica que, entre 1990 e 2006, a expansão territorial da produção brasileira de soja ocorreu da região");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Sul em direção às regiões Centro-Oeste e Nordeste.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Sudeste em direção às regiões Sul e Centro-Oeste.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Centro-Oeste em direção às regiões Sudeste e Nordeste.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Norte em direção às regiões Sul e Nordeste.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Nordeste em direção às regiões Norte e Centro-Oeste.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 11) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2010d1q11e12);
            texto3TextView.setText("O gráfico mostra a relação da produção de cereais, leguminosas e oleaginosas com a área plantada no Brasil, no period de 1980 a 2008. Verifca-se uma grande variação da produção em comparação à area plantada, o que caracteriza o crescimento da");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("economia.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("área plantada.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("produtividade.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("sustentabilidade.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("racionalização.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 12) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2010d1q11e12);
            texto3TextView.setText("Que transformação ocorrida na agricultura brasileira, nas últimas décadas, justifica as variações apresentadas no gráfico?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("O aumento do número de trabalhadores e menor necessidade de investimentos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("O progressivo direcionamento da produção de grãos para o mercado interno.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("A introdução de novas técnicas e insumos agrícolas, como fertilizantes e sementes geneticamente modificadas.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("A introdução de métodos de plantio orgânico, altamente produtivos, voltados para a exportação em larga escala.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("O aumento no crédito rural voltado para a produção de grãos por camponeses da agricultura extensive.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 13) {
            texto1TextView.setText("Os últimos séculos marcam, para a atividade agrícola, com a humanização e mecanização do espaço geográfico, uma considerável mudança em termos de produtividade: chegou-se, recentemente, à constituição de um meio técnico-científico-informacional, característico não apenas da vida urbana, mas também do mundo rural, tanto nos países avançados como nas regiões mais desenvolvidas dos países pobres.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A modernização da agricultura está associada ao desenvolvimento científico e tecnológico no processo produtivo em diferentes países. Ao considerar as novas relações tecnológicas no campo, verifica-se que a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("introdução de tecnologia equilibrou o desenvolvimento econômico entre o campo e a cidade, refletindo diretamente na humanização do espaço geográfico nos países mais pobres.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("tecnificação do espaço geográfico marco o modelo produtivo dos países ricos, uma vez que pretendem transferir gradativamente as unidades industriais para o espaço rural.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("contrução de uma infraestrutura científica e tecnológica promoveu um conjunto de relações que geraram novas interações socioespaciais entre o campo e a cidade.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("aquisição de máquinas e implementos industriais, incorporados ao campo, proporcionou o aumento da produtividade, libertando o campo da subordinação à cidade.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("incorporação de novos elementos produtivos oriundos da atividade rural resultou em uma relação com a cadeia produtiva industrial, subordinando a cidade ao campo.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 14) {
            texto1TextView.setText("Responda sem pestanejar: que país ocupa a liderança mundial no mercado de etanol? Para alguns, a resposta óbivia é o Brasil. Afinal, o país tem o menor preço de produção do mercado, além de vastas áreas disponíveis para o plantio de matéria-prima. Outros dirão que são os EUA, donos da maior produção anual. Nos próximos anos, essa pergunta não deve gerar mais dúvida, pois a disputa não se dará em plantações de cana-de-açúcar ou nas usinas, mas nos laboratórios altamente sofisticados.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A biotecnologia propicia, entre outras coisas, a produção dos biocombustíveis, que vêm se configurando em importantes formas de energias alternativas. Que impacto possíveis pesquisas em laboratórios podem provocar na produção de etanol no Brasil e nos EUA?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Aumento na utilização de novos tipos de matériasprimas para a produção do etanol, elevando a produtividade.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Crescimento da produção desse combustível, causando, porém, danos graves ao meio ambiente pelo excess de plantações de cana-de-açucar.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Estagnação no processo produtivo do etanol brasileiro, já que o país deixou de investor nesse tipo de tecnologia.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Elevação nas exportações de etanol para os EUA, já que a produção interna brasileira é maior que a procura, e o produto tem qualidade superior.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Aumento da fome em ambos os países, em virtude da produção de cana-de-açucar prejudicar a produção de alimentos.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 15) {
            texto1TextView.setText("O movimento operário ofereceu uma nova resposta ao grito do homem miserável no princípio do século XIX. A resposta foi a consciência de classe e a ambição de classe. Os pobres então se organizavam em uma classe específica, a classe operaria, diferente da classe dos patrões (ou capitalistas). A Revolução Francesa lhes deu confiança; a Revolução Industrial trouxe necessidade da mobilização permanente.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("No texto, analisa-se o impacto das Revoluções Francesa e Industrial para a organização da classe operária. Enquanto a ‘confiança’ dada pela Revolução Francesa era originária do significado da vitória revolucionária sobre as classes dominantes, a “necessidade da mobilização permanente”, trazida pela Revolução Industrial, decorria da compreensão de que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a competitividade do trabalho industrial exigia um permanente esforço de qualificação para o enfrentamento do desemprego.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a completa transformação da economia capitalista seria fundamental para a emancipação dos operários.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a introdução das máquinas no processo produtivo diminuía as possibilidades de ganho material para os operários.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o progresso tecnológico geraria a distribuição de riquezas para aqueles que estivessem adaptados aos novos tempos industriais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a melhoria das condições de vida dos operários seria conquistada com as manifestações coletivas em favor dos direitos trabalhistas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 16) {
            texto1TextView.setText("No mundo árabe, países governados há décadas por regimes políticos centralizadores contabilizam metade da população com menos de 30 anos; desses, 56% têm acesso à internet. Sentindo-se sem perspectivas de futuro e diante da estagnação da economia, esses jovens incubam vírus sedentos por modernidade e democracia. Em meados de dezembro, um tunisiano de 26 anos, vendedor de frutas, põe fogo no próprio corpo em protesto por trabalho, justiça e liberdade. Uma série de manifestações eclode na Tunísia e, como uma epidemia, o vírus libertário começa a se espalhar pelos países vizinhos, derrubando em seguida o presidente do Egito, Hosni Mubarak. Sites e redes sociais – como o Facebook e o Twitter ajudaram a mobilizar manifestantes do norte da África a ilhas do Golfo Pérsico.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Considerando os movimentos políticos mencionados no texto, o acesso à internet permitiu aos jovens árabes");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("reforçar a atuação dos regimes políticos existentes");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("tomar conhecimento dos fatos sem se envolver.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("manter o distanciamento necessário à sua segurança.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("disseminar vírus capazes de destruir programas dos computadores.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("difundir ideias revolucionárias que mobilizaram a população.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 17) {
            texto1TextView.setText("O brasileiro tem noção clara dos comportamentos éticos e morais adequados, mas vive sob o espectro da corrupção, revela pesquisa. Se o país fosse resultado dos padrões morais que as pessoas dizem aprovar, pareceria mais com a Escandinávia do que com Bruzundanga (corrompida nação fictícia de Lima Barreto).");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O distanciamento entre “reconhecer” e “cumprir” efetivamente o que é moral constitui uma ambiguidade inerente ao humano, porque as normas morais são");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("decorrentes da vontade divina e, por esse motivo, utópicas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("parâmetros idealizados, cujo cumprimento é destituído de obrigação.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("amplas e vão além da capacidade de o indivíduo conseguir cumpri-las integralmente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("criadas pelo homem, que concede a si mesmo a lei à qual deve se submeter");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("cumpridas por aqueles que se dedicam inteiramente a observar as normas jurídicas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 18) {
            texto1TextView.setText("Movimento dos Caras-Pintadas");
            texto2TextView.setText("O movimento representado na imagem, do início dos anos de 1990, arrebatou milhares de jovens no Brasil.");
            figura1ImageView.setImageResource(R.drawable.hum2011d1q3);
            texto3TextView.setText("Nesse contexto, a juventude, movida por um forte sentimento cívico,");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("aliou-se aos partidos de oposição e organizou a campanha Diretas Já.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("manifestou-se contra a corrupção e pressionou pela aprovação da Lei da Ficha Limpa.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("engajou-se nos protestos relâmpago e utilizou a internet para agendar suas manifestações.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("espelhou-se no movimento estudantil de 1968 e protagonizou ações revolucionárias armadas.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("tornou-se porta-voz da sociedade e influenciou no processo de impeachment do então presidente Collor.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 19) {
            texto1TextView.setText("A Floresta Amazônica, com toda a sua imensidão, não vai estar aí para sempre. Foi preciso alcançar toda essa taxa de desmatamento de quase 20 mil quilômetros quadrados ao ano, na última década do século XX, para que uma pequena parcela de brasileiros se desse conta de que o maior patrimônio natural do país está sendo torrado.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Um processo econômico que tem contribuído na atualidade para acelerar o problema ambiental descrito é: ");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Expansão do Projeto Grande Carajás, com incentivos à chegada de novas empresas mineradoras.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Difusão do cultivo da soja com a implantação de monoculturas mecanizadas.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Construção da rodovia Transamazônica, com o objetivo de interligar a região Norte ao restante do país.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Criação de áreas extrativistas do látex das seringueiras para os chamados povos da floresta.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Ampliação do polo industrial da Zona Franca de Manaus, visando atrair empresas nacionais e estrangeiras.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 20) {
            texto1TextView.setText("O Centro-Oeste apresentou-se como extremamente receptivo aos novos fenômenos da urbanização, já que era praticamente virgem, não possuindo infraestrutura de monta, nem outros investimentos fixos vindos do passado. Pôde, assim, receber uma infraestrutura nova, totalmente a serviço de uma economia moderna. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto trata da ocupação de uma parcela do território brasileiro. O processo econômico diretamente associado a essa ocupação foi o avanço da");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("industrialização voltada para o setor de base.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("economia da borracha no sul da Amazônia.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("fronteira agropecuária que degradou parte do cerrado.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("exploração mineral na Chapada dos Guimarães.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("extrativismo na região pantaneira.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 21) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2011d1q6);
            texto3TextView.setText("O gráfico relaciona diversas variáveis ao processo de formação do solo. A interpretação dos dados mostra que a água é um dos importantes fatores de pedogênese, pois nas áreas");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("de clima temperado ocorrem alta pluviosidade e grande profundidade de solos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("tropicais ocorre menor pluviosidade, o que se relaciona com a menor profundidade das rochas inalteradas.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("de latitudes em torno de 30° ocorrem as maiores profundidades de solo, visto que há maior umidade.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("tropicais a profundidade do solo é menor, o que evidencia menor intemperismo químico da água sobre as rochas.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("de menor latitude ocorrem as maiores precipitações, assim como a maior profundidade dos solos.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 22) {
            texto1TextView.setText("Uma empresa norte-americana de bioenergia está expandindo suas operações para o Brasil para explorar o mercado de pinhão manso. Com sede na Califórnia, a empresa desenvolveu sementes híbridas de pinhão manso, oleaginosa utilizada hoje na produção de biodiesel e de querosene de aviação.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A partir do texto, a melhoria agronômica das sementes de pinhão manso abre para o Brasil a oportunidade econômica de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("ampliar as regiões produtoras pela adaptação do cultivo a diferentes condições climáticas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("beneficiar os pequenos produtores camponeses de óleo pela venda direta ao varejo. ");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("abandonar a energia automotiva derivada do petróleo em favor de fontes alternativas.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("baratear cultivos alimentares substituídos pelas culturas energéticas de valor econômico superior.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("reduzir o impacto ambiental pela não emissão de gases do efeito estufa para a atmosfera.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 23) {
            texto1TextView.setText("Um dos principais objetivos de se dar continuidade às pesquisas em erosão dos solos é o de procurar resolver os problemas oriundos desse processo, que, em última análise, geram uma série de impactos ambientais. Além disso, para a adoção de técnicas de conservação dos solos, é preciso conhecer como a água executa seu trabalho de remoção, transporte e deposição de sedimentos. A erosão causa, quase sempre, uma série de problemas ambientais, em nível local ou até mesmo em grandes áreas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A preservação do solo, principalmente em áreas de encostas, pode ser uma solução para evitar catástrofes em função da intensidade de fluxo hídrico. A prática humana que segue no caminho contrário a essa solução é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a aração.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o terraceamento. ");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o pousio.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a drenagem.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o desmatamento.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 24) {
            texto1TextView.setText("O fenômeno de ilha de calor é o exemplo mais marcante da modificação das condições iniciais do clima pelo processo de urbanização, caracterizado pela modificação do solo e pelo calor antropogênico, o qual inclui todas as atividades humanas inerentes à sua vida na cidade.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto exemplifica uma importante alteração socioambiental, comum aos centros urbanos. A maximização desse fenômeno ocorre");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("pela reconstrução dos leitos originais dos cursos d’água antes canalizados.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("pela recomposição de áreas verdes nas áreas centrais dos centros urbanos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("pelo uso de materiais com alta capacidade de reflexão no topo dos edifícios.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("pelo processo de impermeabilização do solo nas áreas centrais das cidades.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("pela construção de vias expressas e gerenciamento de tráfego terrestre.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 25) {
            texto1TextView.setText("O professor Paulo Saldiva pedala 6 km em 22 minutos de casa para o trabalho, todos os dias. Nunca foi atingido por um carro. Mesmo assim, é vítima diária do trânsito de São Paulo: a cada minuto sobre a bicicleta, seus pulmões são envenenados com 3,3 microgramas de poluição particulada – poeira, fumaça, fuligem, partículas de metal em suspensão, sulfatos, nitratos, carbono, compostos orgânicos e outras substâncias nocivas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A população de uma metrópole brasileira que vive nas mesmas condições socioambientais das do professor citado no texto apresentará uma tendência de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("ampliação da taxa de fecundidade");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("diminuição da expectativa de vida.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("elevação do crescimento vegetativo.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("aumento na participação relativa de idosos.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("redução na proporção de jovens na sociedade.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 26) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2011d1q11);
            texto3TextView.setText("A imagem retrata a araucária, árvore que faz parte de um importante bioma brasileiro que, no entanto, já foi bastante degradado pela ocupação humana. Uma das formas de intervenção humana relacionada à degradação desse bioma foi");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o avanço do extrativismo de minerais metálicos voltados para a exportação na região Sudeste.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a contínua ocupação agrícola intensiva de grãos na região Centro-Oeste do Brasil.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o processo de desmatamento motivado pela expansão da atividade canavieira no Nordeste brasileiro.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o avanço da indústria de papel e celulose a partir da exploração da madeira, extraída principalmente no Sul do Brasil.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o adensamento do processo de favelização sobre áreas da Serra do Mar na região Sudeste.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 27) {
            texto1TextView.setText("SOBRADINHO\nO homem chega, já desfaz a natureza\nTira gente, põe represa, diz que tudo vai mudar\nO São Francisco lá pra cima da Bahia\nDiz que dia menos dia vai subir bem devagar\nE passo a passo vai cumprindo a profecia do beato que dizia que o Sertão ia alagar");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O trecho da música faz referência a uma importante obra na região do rio São Francisco. Uma consequência socioespacial dessa construção foi");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a migração forçada da população ribeirinha.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o rebaixamento do nível do lençol freático local.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a preservação da memória histórica da região.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a ampliação das áreas de clima árido.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a redução das áreas de agricultura irrigada.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 28) {
            texto1TextView.setText("Como os combustíveis energéticos, as tecnologias da informação são, hoje em dia, indispensáveis em todos os setores econômicos. Através delas, um maior número de produtores é capaz de inovar e a obsolescência de bens e serviços se acelera. Longe de estender a vida útil dos equipamentos e a sua capacidade de reparação, o ciclo de vida desses  produtos diminui, resultando em maior necessidade de matéria-prima para a fabricação de novos.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A postura consumista de nossa sociedade indica a crescente produção de lixo, principalmente nas áreas urbanas, o que, associado a modos incorretos de deposição,");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("provoca a contaminação do solo e do lençol freático, ocasionando assim graves problemas socioambientais, que se adensarão com a continuidade da cultura do consumo desenfreado.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("produz efeitos perversos nos ecossistemas, que são sanados por cadeias de organismos decompositores que assumem o papel de eliminadores dos resíduos depositados em lixões.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("multiplica o número de lixões a céu aberto, considerados atualmente a ferramenta capaz de resolver de forma simplificada e barata o problema de deposição de resíduos nas grandes cidades.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("estimula o empreendedorismo social, visto que um grande número de pessoas, os catadores, têm livre acesso aos lixões, sendo assim incluídos na cadeia produtiva dos resíduos tecnológicos.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("possibilita a ampliação da quantidade de rejeitos que podem ser destinados a associações e cooperativas de catadores de materiais recicláveis, financiados por instituições da sociedade civil ou pelo poder público.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 29) {
            texto1TextView.setText("O espaço mundial sob a “nova des-ordem” é um emaranhado de zonas, redes e “aglomerados”, espaços hegemônicos e contra-hegemônicos que se cruzam de forma complexa na face da Terra. Fica clara, de saída, a polêmica que envolve uma nova regionalização mundial. Como regionalizar um espaço tão heterogêneo e, em parte, fluido, como é o espaço mundial contemporâneo?");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2011d1q14);
            texto3TextView.setText("O mapa procura representar a lógica espacial do mundo contemporâneo pós-União Soviética, no contexto de avanço da globalização e do neoliberalismo, quando a divisão entre países socialistas e capitalistas se desfez e as categorias de “primeiro” e “terceiro” mundo perderam sua validade explicativa.");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("Considerando esse objetivo interpretativo, tal distribuição espacial aponta para");

            textoa1TextView.setText("a estagnação dos Estados com forte identidade cultural.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o alcance da racionalidade anticapitalista.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a influência das grandes potências econômicas.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a dissolução de blocos políticos regionais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o alargamento da força econômica dos países islâmicos.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 30) {
            texto1TextView.setText("Em 1872, Robert Angus Smith criou o termo “chuva ácida”, descrevendo precipitações ácidas em Manchester após a Revolução Industrial. Trata-se do acúmulo demasiado de dióxido de carbono e enxofre na atmosfera que, ao reagirem com compostos dessa camada, formam gotículas de chuva ácida e partículas de aerossóis. A chuva ácida não necessariamente ocorre no local poluidor, pois tais poluentes, ao serem lançados na atmosfera, são levados pelos ventos, podendo provocar a reação em regiões distantes. A água de forma pura apresenta pH 7, e, ao contatar agentes poluidores, reage modificando seu pH para 5,6 e até menos que isso, o que provoca reações, deixando consequências. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto aponta para um fenômeno atmosférico causador de graves problemas ao meio ambiente: a chuva ácida (pluviosidade com pH baixo). Esse fenômeno tem como consequência");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a corrosão de metais, pinturas, monumentos históricos, destruição da cobertura vegetal e acidificação dos lagos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a diminuição do aquecimento global, já que esse tipo de chuva retira poluentes da atmosfera.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a destruição da fauna e da flora, a redução dos recursos hídricos, com o assoreamento dos rios.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("as enchentes, que atrapalham a vida do cidadão urbano, corroendo, em curto prazo, automóveis e fios de cobre da rede elétrica.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a degradação da terra nas regiões semiáridas, localizadas, em sua maioria, no Nordeste do nosso país.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 31) {
            texto1TextView.setText("Estamos testemunhando o reverso da tendência histórica da assalariação do trabalho e socialização da produção, que foi característica predominante na era industrial. A nova organização social e econômica baseada nas tecnologias da informação visa à administração descentralizadora, ao trabalho individualizante e aos mercados personalizados. As novas tecnologias da informação possibilitam, ao mesmo tempo, a descentralização das tarefas e sua coordenação em uma rede interativa de comunicação em tempo real, seja entre continentes, seja entre os andares de um mesmo edifício.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("No contexto descrito, as sociedades vivenciam mudanças constantes nas ferramentas de comunicação que afetam os processos produtivos nas empresas. Na esfera do trabalho, tais mudanças têm provocado");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o aprofundamento dos vínculos dos operários com as linhas de montagem sob influência dos modelos orientais de gestão. ");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o aumento das formas de teletrabalho como solução de larga escala para o problema do desemprego crônico.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o avanço do trabalho flexível e da terceirização como respostas às demandas por inovação e com vistas à mobilidade dos investimentos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a autonomização crescente das máquinas e computadores em substituição ao trabalho dos especialistas técnicos e gestores.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o fortalecimento do diálogo entre operários, gerentes, executivos e clientes com a garantia de harmonização das relações de trabalho.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 32) {
            texto1TextView.setText("Completamente analfabeto, ou quase, sem assistência médica, não lendo jornais, nem revistas, nas quais se limita a ver as figuras, o trabalhador rural, a não ser em casos esporádicos, tem o patrão na conta de benfeitor. No plano político, ele luta com o 'coronel' e pelo 'coronel'. Aí estão os votos de cabresto, que resultam, em grande parte, da nossa organização econômica rural. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O coronelismo, fenômeno político da Primeira República (1889-1930), tinha como uma de suas principais características o controle do voto, o que limitava, portanto, o exercício da cidadania. Nesse período, esta prática estava vinculada a uma estrutura social");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("igualitária, com um nível satisfatório de distribuição da renda.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("estagnada, com uma relativa harmonia entre as classes.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("tradicional, com a manutenção da escravidão nos engenhos como forma produtiva típica.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("ditatorial, perturbada por um constante clima de opressão mantido pelo exército e polícia.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("agrária, marcada pela concentração da terra e do poder político local e regional.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 33) {
            texto1TextView.setText("Na década de 1990, os movimentos sociais camponeses e as ONGs tiveram destaque, ao lado de outros sujeitos coletivos. Na sociedade brasileira, a ação dos movimentos sociais vem construindo lentamente um conjunto de práticas democráticas no interior das escolas, das comunidades, dos grupos organizados e na interface da sociedade civil com o Estado. O diálogo, o confronto e o conflito têm sido os motores no processo de construção democrática.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Segundo o texto, os movimentos sociais contribuem para o processo de construção democrática, porque");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("determinam o papel do Estado nas transformações socioeconômicas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("aumentam o clima de tensão social na sociedade civil.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("pressionam o Estado para o atendimento das demandas da sociedade.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("privilegiam determinadas parcelas da sociedade em detrimento das demais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("propiciam a adoção de valores éticos pelos órgãos do Estado.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 34) {
            texto1TextView.setText("Art. 92. São excluídos de votar nas Assembleias Paroquiais:\nI. Os menores de vinte e cinco anos, nos quais não se compreendam os casados, e Oficiais Militares, que forem maiores de vinte e um anos, os Bacharéis Formados e Clérigos de Ordens Sacras. \nIV. Os Religiosos, e quaisquer que vivam em Comunidade claustral. \nV. Os que não tiverem de renda líquida anual cem mil réis por bens de raiz, indústria, comércio ou empregos. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A legislação espelha os conflitos políticos e sociais do contexto histórico de sua formulação. A Constituição de 1824 regulamentou o direito de voto dos “cidadãos brasileiros“ com o objetivo de garantir");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o fim da inspiração liberal sobre a estrutura política brasileira");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a ampliação do direito de voto para maioria dos brasileiros nascidos livres.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a concentração de poderes na região produtora de café, o Sudeste brasileiro.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o controle do poder político nas mãos dos grandes proprietários e comerciantes.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a diminuição da interferência da Igreja Católica nas decisões político-administrativas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 35) {
            texto1TextView.setText("Embora o Brasil seja signatário das convenções e tratados internacionais contra a tortura e tenha incorporado em seu ordenamento jurídico uma lei tipificando o crime, ele continua a ocorrer em larga escala. Mesmo que a lei que tipifica a tortura esteja vigente desde 1997, até o ano 2000 não se conhece nenhum caso de condenação de torturadores julgado em última instância, embora tenham sido registrados nesse período centenas de casos, além de numerosos outros presumíveis mas não registrados.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto destaca a questão da tortura no país, apontando que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a justiça brasileira, por meio de tratados e leis, tem conseguido inibir e, inclusive, extinguir a prática da tortura.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a existência da lei não basta como garantia de justiça para as vítimas e testemunhas dos casos de tortura.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("as denúncias anônimas dificultam a ação da justiça, impedindo que torturadores sejam reconhecidos e identificados pelo crime cometido.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a falta de registro da tortura por parte das autoridades policiais, em razão do desconhecimento da tortura como crime, legitima a impunidade.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a justiça tem esbarrado na precária existência de jurisprudência a respeito da tortura, o que a impede de atuar nesses casos.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 36) {
            texto1TextView.setText("TEXTO I\nA ação democrática consiste em todos tomarem parte do processo decisório sobre aquilo que terá consequência na vida de toda coletividade.\nTEXTO II\nÉ necessário que haja liberdade de expressão, fiscalização sobre órgãos governamentais e acesso por parte da população às informações trazidas a público pela imprensa. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Partindo da perspectiva de democracia apresentada no Texto I, os meios de comunicação, de acordo com o Texto II, assumem um papel relevante na sociedade por");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("orientarem os cidadãos na compra dos bens necessários à sua sobrevivência e bem-estar.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("fornecerem informações que fomentam o debate político na esfera pública.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("apresentarem aos cidadãos a versão oficial dos fatos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("propiciarem o entretenimento, aspecto relevante para conscientização política.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("promoverem a unidade cultural, por meio das transmissões esportivas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 37) {
            texto1TextView.setText("Até que ponto, a partir de posturas e interesses diversos, as oligarquias paulista e mineira dominaram a cena política nacional na Primeira República? A união de ambas foi um traço fundamental, mas que não conta toda a história do período. A união foi feita com a preponderância de uma ou de outra das duas frações. Com o tempo, surgiram as discussões e um grande desacerto final.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Para a caracterização do processo político durante a Primeira República, utiliza-se com frequência a expressão Política do Café com Leite. No entanto, os textos apresentam a seguinte ressalva a sua utilização:");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("A riqueza gerada pelo café dava à oligarquia paulista a prerrogativa de indicar os candidatos à presidência, sem necessidade de alianças.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("As divisões políticas internas de cada estado da federação invalidavam o uso do conceito de aliança entre estados para este período.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("As disputas políticas do período contradiziam a suposta estabilidade da aliança entre mineiros e paulistas.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("A centralização do poder no executivo federal impedia a formação de uma aliança duradoura entre as oligarquias.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("A diversificação da produção e a preocupação com o mercado interno unificavam os interesses das oligarquias.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 38) {
            texto1TextView.setText("O acidente nuclear de Chernobyl revela brutalmente os limites dos poderes técnico-científicos da humanidade e as ”marchas-à-ré“ que a ”natureza“ nos pode reservar. É evidente que uma gestão mais coletiva se impõe para orientar as ciências e as técnicas em direção a finalidades mais humanas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto trata do aparato técnico-científico e as suas consequências para a humanidade, propondo que esse desenvolvimento");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("defina seus projetos a partir dos interesses coletivos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("guie-se por interesses econômicos, prescritos pela lógica do mercado.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("priorize a evolução da tecnologia, se apropriando da natureza.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("promova a separação entre natureza e sociedade tecnológica.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("tenha gestão própria, com o objetivo de melhor apropriação da natureza.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 39) {
            texto1TextView.setText("A introdução de novas tecnologias desencadeou uma série de efeitos sociais que afetaram os trabalhadores e sua organização. O uso de novas tecnologias trouxe a diminuição do trabalho necessário que se traduz na economia líquida do tempo de trabalho, uma vez que, com a presença da automação microeletrônica, começou a ocorrer a diminuição dos coletivos operários e uma mudança na organização dos processos de trabalho.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A utilização de novas tecnologias tem causado inúmeras alterações no mundo do trabalho. Essas mudanças são observadas em um modelo de produção caracterizado");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("pelo uso intensivo do trabalho manual para desenvolver produtos autênticos e personalizados.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("pelo ingresso tardio das mulheres no mercado de trabalho no setor industrial.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("pela participação ativa das empresas e dos próprios trabalhadores no processo de qualificação laboral.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("pelo aumento na oferta de vagas para trabalhadores especializados em funções repetitivas.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("pela manutenção de estoques de larga escala em função da alta produtividade.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 40) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2011d1q25);
            texto3TextView.setText("A análise da tabela permite identificar um intervalo de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("1940-1950 – direito de voto para os ex-escravos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("1950-1960 – fim do voto secreto.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("1960-1970 – direito de voto para as mulheres.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("1970-1980 - fim do voto obrigatório.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("1980-1996 – direito de voto para os analfabetos.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 41) {
            texto1TextView.setText("É difícil encontrar um texto sobre a Proclamação da República no Brasil que não cite a afirmação de Aristides Lobo, no Diário Popular de São Paulo, de que “o povo assistiu àquilo bestializado”. Essa versão foi relida pelos enaltecedores da Revolução de 1930, que não descuidaram da forma republicana, mas realçaram a exclusão social, o militarismo e o estrangeirismo da fórmula implantada em 1889. Isto porque o Brasil brasileiro teria nascido em 1930");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto defende que a consolidação de uma determinada memória sobre a Proclamação da República no Brasil teve, na Revolução de 1930, um de seus momentos mais importantes. Os defensores da Revolução de 1930 procuraram construir uma visão negativa para os eventos de 1889, porque esta era uma maneira de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("valorizar as propostas políticas democráticas e liberais vitoriosas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("resgatar simbolicamente as figuras políticas ligadas à Monarquia.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("criticar a política educacional adotada durante a República Velha.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("legitimar a ordem política inaugurada com a chegada desse grupo ao poder.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("destacar a ampla participação popular obtida no processo da Proclamação.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 42) {
            texto1TextView.setText("Um volume imenso de pesquisas tem sido produzido para tentar avaliar os efeitos dos programas de televisão. A maioria desses estudos diz respeito às crianças — o que é bastante compreensível pela quantidade de tempo que elas passam em frente ao aparelho e pelas possíveis implicações desse comportamento para a socialização. Dois dos tópicos mais pesquisados são o impacto da televisão no âmbito do crime e da violência e a natureza das notícias exibidas na televisão.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto indica que existe uma significativa produção científica sobre os impactos socioculturais da televisão na vida do ser humano. E as crianças, em particular, são as mais vulneráveis a essas influências, porque");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("codificam informações transmitidas nos programas infantis por meio da observação.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("adquirem conhecimentos variados que incentivam o processo de interação social.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("interiorizam padrões de comportamento e papéis sociais com menor visão crítica.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("observam formas de convivência social baseadas na tolerância e no respeito.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("apreendem modelos de sociedade pautados na observância das leis.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 43) {
            texto1TextView.setText("Subindo morros, margeando córregos ou penduradas em palafitas, as favelas fazem parte da paisagem de um terço dos municípios do país, abrigando mais de 10 milhões de pessoas, segundo dados do Instituto Brasileiro de Geografia e Estatística (IBGE).");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A situação das favelas no país reporta a graves problemas de desordenamento territorial. Nesse sentido, uma característica comum a esses espaços tem sido");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o planejamento para a implantação de infraestruturas urbanas necessárias para atender as necessidades básicas dos moradores.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a organização de associações de moradores interessadas na melhoria do espaço urbano e financiadas pelo poder público.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a presença de ações referentes à educação ambiental com consequente preservação dos espaços naturais circundantes.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a ocupação de áreas de risco suscetíveis a enchentes ou desmoronamentos com consequentes perdas materiais e humanas.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o isolamento socioeconômico dos moradores ocupantes desses espaços com a resultante multiplicação de políticas que tentam reverter esse quadro.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 44) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2011d1q29);
            texto3TextView.setText("Que aspecto histórico da escravidão no Brasil do séc. XIX pode ser identificado a partir da análise do vestuário do casal retratado acima?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("O uso de trajes simples indica a rápida incorporação dos ex-escravos ao mundo do trabalho urbano.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("A presença de acessórios como chapéu e sombrinha aponta para a manutenção de elementos culturais de origem africana.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("O uso de sapatos é um importante elemento de diferenciação social entre negros libertos ou em melhores condições na ordem escravocrata.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("A utilização do paletó e do vestido demonstra a tentativa de assimilação de um estilo europeu como forma de distinção em relação aos brasileiros.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("A adoção de roupas próprias para o trabalho doméstico tinha como finalidade demarcar as fronteiras da exclusão social naquele contexto.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 45) {
            texto1TextView.setText("Os três tipos de poder representam três diversos tipos de motivações: no poder tradicional, o motivo da obediência é a crença na sacralidade da pessoa do soberano; no poder racional, o motivo da obediência deriva da crença na racionalidade do comportamento conforme a lei; no poder carismático, deriva da crença nos dotes extraordinários do chefe.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Os três tipos de poder representam três diversos tipos de motivações: no poder tradicional, o motivo da obediência");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("República Federalista Norte-Americana.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("República Fascista Italiana no século XX.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Monarquia Teocrática do Egito Antigo.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Monarquia Absoluta Francesa no século XVII.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Monarquia Constitucional Brasileira no século XIX.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 46) {
            texto1TextView.setText("Em geral, os nossos tupinambás ficam bem admirados ao ver os franceses e os outros dos países longínquos terem tanto trabalho para buscar o seu arabotã, isto é, pau-brasil. Houve uma vez um ancião da tribo que me fez esta pergunta: “Por que vindes vós outros, mairs e perós (franceses e portugueses), buscar lenha de tão longe para vos aquecer? Não tendes madeira em vossa terra?”");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O viajante francês Jean de Léry (1534-1611) reproduz um diálogo travado, em 1557, com um ancião tupinambá, o qual demonstra uma diferença entre a sociedade europeia e a indígena no sentido");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("do destino dado ao produto do trabalho nos seus sistemas culturais.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("da preocupação com a preservação dos recursos ambientais.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("do interesse de ambas em uma exploração comercial mais lucrativa do pau-brasil.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("da curiosidade, reverência e abertura cultural recíprocas.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("da preocupação com o armazenamento de madeira para os períodos de inverno.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 47) {
            texto1TextView.setText("A Lei 10.639, de 9 de janeiro de 2003, inclui no currículo dos estabelecimentos de ensino fundamental e médio, oficiais e particulares, a obrigatoriedade do ensino sobre História e Cultura Afro-Brasileira e determina que o conteúdo programático incluirá o estudo da História da África e dos africanos, a luta dos negros no Brasil, a cultura negra brasileira e o negro na formação da sociedade nacional, resgatando a contribuição do povo negro nas áreas social, econômica e política pertinentes à História do Brasil, além de instituir, no calendário escolar, o dia 20 de novembro como data comemorativa do “Dia da Consciência Negra”.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A referida lei representa um avanço não só para a educação nacional, mas também para a sociedade brasileira, porque");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("legitima o ensino das ciências humanas nas escolas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("divulga conhecimentos para a população afro-brasileira.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("reforça a concepção etnocêntrica sobre a África e sua cultura.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("garante aos afrodescendentes a igualdade no acesso à educação.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("impulsiona o reconhecimento da pluralidade étnico-racial do país.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 48) {
            texto1TextView.setText("O açúcar e suas técnicas de produção foram levados à Europa pelos árabes no século VIII, durante a Idade Média, mas foi principalmente a partir das Cruzadas (séculos XI e XIII) que a sua procura foi aumentando. Nessa época passou a ser importado do Oriente Médio e produzido em pequena escala no sul da Itália, mas continuou a ser um produto de luxo, extremamente caro, chegando a figurar nos dotes de princesas casadoiras.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Considerando o conceito do Antigo Sistema Colonial, o açúcar foi o produto escolhido por Portugal para dar início à colonização brasileira, em virtude de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o lucro obtido com o seu comércio ser muito vantajoso.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("os árabes serem aliados históricos dos portugueses.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a mão de obra necessária para o cultivo ser insuficiente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("as feitorias africanas facilitarem a comercialização desse produto.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("os nativos da América dominarem uma técnica de cultivo semelhante.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 49) {
            texto1TextView.setText("No clima das ideias que se seguiram à revolta de São Domingos, o descobrimento de planos para um levante armado dos artífices mulatos na Bahia, no ano de 1798, teve impacto muito especial; esses planos demonstravam aquilo que os brancos conscientes tinham já começado a compreender: as ideias de igualdade social estavam a propagar-se numa sociedade em que só um terço da população era de brancos e iriam inevitavelmente ser interpretados em termos raciais.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O temor do radicalismo da luta negra no Haiti e das propostas das lideranças populares da Conjuração Baiana (1798) levaram setores da elite colonial brasileira a novas posturas diante das reivindicações populares. No período da Independência, parte da elite participou  ativamente do processo, no intuito de ");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("instalar um partido nacional, sob sua liderança, garantindo participação controlada dos afro-brasileiros e inibindo novas rebeliões de negros.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("atender aos clamores apresentados no movimento baiano, de modo a inviabilizar novas rebeliões, garantindo o controle da situação.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("firmar alianças com as lideranças escravas, permitindo a promoção de mudanças exigidas pelo povo sem a profundidade proposta inicialmente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("impedir que o povo conferisse ao movimento um teor libertário, o que terminaria por prejudicar seus interesses e seu projeto de nação.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("rebelar-se contra as representações metropolitanas, isolando politicamente o Príncipe Regente, instalando um governo conservador para controlar o povo.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 50) {
            texto1TextView.setText("Se a mania de fechar, verdadeiro habitus da mentalidade medieval nascido talvez de um profundo sentimento de insegurança, estava difundida no mundo rural, estava do mesmo modo no meio urbano, pois que uma das características da cidade era de ser limitada por portas e por uma muralha. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("As práticas e os usos das muralhas sofreram importantes mudanças no final da Idade Média, quando elas assumiram a função de pontos de passagem ou pórticos. Este processo está diretamente relacionado com");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o crescimento das atividades comerciais e urbanas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a migração de camponeses e artesãos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a expansão dos parques industriais e fabris.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o aumento do número de castelos e feudos.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a contenção das epidemias e doenças.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 51) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2011d1q36);
            texto3TextView.setText("Uma explicação de caráter histórico para o percentual da religião com maior número de adeptos declarados no Brasil foi a existência, no passado colonial e monárquico, da");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("incapacidade do cristianismo de incorporar aspectos de outras religiões.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("incorporação da ideia de liberdade religiosa na esfera pública.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("permissão para o funcionamento de igrejas não cristãs.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("relação de integração entre Estado e Igreja.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("influência das religiões de origem africana.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 52) {
            texto1TextView.setText("No Estado de São Paulo, a mecanização da colheita da cana-de-açúcar tem sido induzida também pela legislação ambiental, que proíbe a realização de queimadas em áreas próximas aos centros urbanos. Na região de Ribeirão Preto, principal polo sucroalcooleiro do país, a mecanização da colheita já é realizada em 516 mil dos 1,3 milhão de hectares cultivados com cana-de-açúcar. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto aborda duas questões, uma ambiental e outra socioeconômica, que integram o processo de modernização da produção canavieira. Em torno da associação entre elas, uma mudança decorrente desse processo é a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("perda de nutrientes do solo devido à utilização constante de máquinas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("eficiência e racionalidade no plantio com maior produtividade na colheita.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("ampliação da oferta de empregos nesse tipo de ambiente produtivo.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("menor compactação do solo pelo uso de maquinário agrícola de porte.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("poluição do ar pelo consumo de combustíveis fósseis pelas máquinas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 53) {
            texto1TextView.setText("Acompanhando a intenção da burguesia renascentista de ampliar seu domínio sobre a natureza e sobre o espaço geográfico, através da pesquisa científica e da invenção tecnológica, os cientistas também iriam se atirar nessa aventura, tentando conquistar a forma, o movimento, o espaço, a luz, a cor e mesmo a expressão e o sentimento.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto apresenta um espírito de época que afetou também a produção artística, marcada pela constante relação entre");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("fé e misticismo.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("ciência e arte.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("cultura e comércio.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("política e economia.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("astronomia e religião.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 54) {
            texto1TextView.setText("Os chineses não atrelam nenhuma condição para efetuar investimentos nos países africanos. Outro ponto interessante é a venda e compra de grandes somas de áreas, posteriormente cercadas. Por se tratar de países instáveis e com governos ainda não consolidados, teme-se que algumas nações da África tornem-se literalmente protetorados. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A presença econômica da China em vastas áreas do globo é uma realidade do século XXI. A partir do texto, como é possível caracterizar a relação econômica da China com o continente africano?");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("Pela presença de órgãos econômicos internacionais como o Fundo Monetário Internacional (FMI) e o Banco Mundial, que restringem os investimentos chineses, uma vez que estes não se preocupam com a preservação do meio ambiente.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("Pela presença de órgãos econômicos internacionais como o Fundo Monetário Internacional (FMI) e o Banco Mundial, que restringem os investimentos chineses, uma vez que estes não se preocupam com a preservação do meio ambiente.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("Pela aliança com os capitais e investimentos diretos realizados pelos países ocidentais, promovendo o crescimento econômico de algumas regiões desse continente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("Pela presença cada vez maior de investimentos diretos, o que pode representar uma ameaça à soberania dos países africanos ou manipulação das ações destes governos em favor dos grandes projetos.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("Pela presença de um número cada vez maior de diplomatas, o que pode levar à formação de um Mercado Comum Sino-Africano, ameaçando os interesses ocidentais.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 55) {
            texto1TextView.setText("O café tem origem na região onde hoje se encontra a Etiópia, mas seu cultivo e consumo se disseminaram a partir da Península Árabe. Aportou à Europa por Constantinopla e, finalmente, em 1615, ganhou a cidade de Veneza. Quando o café chegou à região europeia, alguns clérigos sugeriram que o produto deveria ser excomungado, por ser obra do diabo. O papa Clemente VIII (1592-1605), contudo, resolveu provar a bebida. Tendo gostado do sabor, decidiu que ela deveria ser batizada para que se tornasse uma ‘bebida verdadeiramente cristã’.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A postura dos clérigos e do papa Clemente VIII diante da introdução do café na Europa Ocidental pode ser explicada pela associação dessa bebida ao");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("ateísmo.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("judaísmo.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("hinduísmo.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("islamismo.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("protestantismo.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 56) {
            texto1TextView.setText("A consolidação do regime democrático no Brasil contra os extremismos da esquerda e da direita exige ação enérgica e permanente no sentido do aprimoramento das instituições políticas e da realização de reformas corajosas no terreno econômico, financeiro e social.\nMensagem programática da União Democrática Nacional (UDN) — 1957.\nOs trabalhadores deverão exigir a constituição de um governo nacionalista e democrático, com participação dos trabalhadores para a realização das seguintes medidas: a) Reforma bancária progressista; b)Reforma agrária que extinga o latifúndio; c) Regulamentação da Lei de Remessas de Lucros.\nManifesto do Comando Geral dos Trabalhadores (CGT) — 1962.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Nos anos 1960 eram comuns as disputas pelo significado de termos usados no debate político, como democracia e reforma. Se, para os setores aglutinados em torno da UDN, as reformas deveriam assegurar o livre mercado, para aqueles organizados no CGT, elas deveriam resultar em");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("fim da intervenção estatal na economia.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("crescimento do setor de bens de consumo.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("controle do desenvolvimento industrial.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("atração de investimentos estrangeiros.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("limitação da propriedade privada.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 57) {
            texto1TextView.setText("Em meio às turbulências vividas na primeira metade dos anos 1960, tinha-se a impressão de que as tendências de esquerda estavam se fortalecendo na área cultural. O Centro Popular de Cultura (CPC) da União Nacional dos Estudantes (UNE) encenava peças de teatro que faziam agitação e propaganda em favor da luta pelas reformas de base e satirizavam o “imperialismo” e seus “aliados internos”.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("No início da década de 1960, enquanto vários setores da esquerda brasileira consideravam que o CPC da UNE era uma importante forma de conscientização das classes trabalhadoras, os setores conservadores e de direita (políticos vinculados à União Democrática Nacional - UDN -, Igreja Católica, grandes empresários etc.) entendiam que esta organização");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("constituía mais uma ameaça para a democracia brasileira, ao difundir a ideologia comunista.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("contribuía com a valorização da genuína cultura nacional, ao encenar peças de cunho popular");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("realizava uma tarefa que deveria ser exclusiva do Estado, ao pretender educar o povo por meio da cultura.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("prestava um serviço importante à sociedade brasileira, ao incentivar a participação política dos mais pobres.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("diminuía a força dos operários urbanos, ao substituir os sindicatos como instituição de pressão política sobre o governo.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 58) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2011d1q43);
            texto3TextView.setText("A imagem representa as manifestações nas ruas da cidade do Rio de Janeiro, na primeira década do século XX, que integraram a Revolta da Vacina. Considerando o contexto político-social da época, essa revolta revela");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a insatisfação da população com os benefícios de uma modernização urbana autoritária.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a consciência da população pobre sobre a necessidade de vacinação para a erradicação das epidemias.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a garantia do processo democrático instaurado com a República, através da defesa da liberdade de expressão da população.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o planejamento do governo republicano na área de saúde, que abrangia a população em geral.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o apoio ao governo republicano pela atitude de vacinar toda a população em vez de privilegiar a elite.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 59) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.hum2011d1q44);
            texto3TextView.setText("O organograma apresenta os diversos atores que integram uma cadeia agroindustrial e a intensa relação entre os setores primário, secundário e terciário. Nesse sentido, a disposição dos atores na cadeia agroindustrial demonstra");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a autonomia do setor primário.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a importância do setor financeiro.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o distanciamento entre campo e cidade.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a subordinação da indústria à agricultura.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a horizontalidade das relações produtivas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 60) {
            texto1TextView.setText("As migrações tradicionais, intensificadas e generalizadas nas últimas décadas do século XX, expressam aspectos particularmente importantes da problemática racial, visto como dilema também mundial. Deslocam-se indivíduos, famílias e coletividades para lugares próximos e distantes, envolvendo mudanças mais ou menos drásticas nas condições de vida e trabalho, em padrões e valores socioculturais. Deslocam-se para sociedades semelhantes ou radicalmente distintas, algumas vezes compreendendo culturas ou mesmo civilizações totalmente diversas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A mobilidade populacional da segunda metade do século XX teve um papel importante na formação social e econômica de diversos estados nacionais. Uma razão para os movimentos migratórios nas últimas décadas e uma política migratória atual dos países desenvolvidos são");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a busca de oportunidades de trabalho e o aumento de barreiras contra a imigração.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a necessidade de qualificação profissional e a abertura das fronteiras para os imigrantes.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o desenvolvimento de projetos de pesquisa e o acautelamento dos bens dos imigrantes.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a expansão da fronteira agrícola e a expulsão dos imigrantes qualificados.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a fuga decorrente de conflitos políticos e o fortalecimento de políticas sociais.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
            return alt;
    }
}

