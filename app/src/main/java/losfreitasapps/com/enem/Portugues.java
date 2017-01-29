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
 * Created by Moises on 09/09/16.
 */
public class Portugues extends Fragment {
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

        nquestions = 40;
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

        disciplinaTextView.setText("Português");

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
            texto1TextView.setText("Na modernidade, o corpo foi descoberto, despido e modelado pelos exercícios físicos da moda. Novos espaços e práticas esportivas e de ginástica passaram a convocar as pessoas a modelarem seus corpos. Multiplicaram-se as academias de ginástica, as salas de musculação e o número de pessoas correndo pelas ruas.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Diante do exposto, é possível perceber que houve um aumento da procura por");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("exercícios físicos aquáticos (natação/hidroginástica), que são exercícios de baixo impacto, evitando o atrito (não prejudicando as articulações), e que previnem o envelhecimento precoce e melhoram a qualidade de vida.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("mecanismos que permitem combinar alimentação e exercício físico, que permitem a aquisição e manutenção de níveis adequados de saúde, sem a preocupação com padrões de beleza instituídos socialmente. ");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("programas saudáveis de emagrecimento, que evitam os prejuízos causados na regulação metabólica, função imunológica, integridade óssea e manutenção da capacidade funcional ao longo do envelhecimento.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("exercícios de relaxamento, reeducação postural e alongamentos, que permitem um melhor funcionamento do organismo como um todo, bem como uma dieta alimentar e hábitos saudáveis com base em produtos naturais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("dietas que preconizam a ingestão excessiva ou restrita de um ou mais macronutrientes (carboidratos, gorduras ou proteínas), bem como exercícios que permitem um aumento de massa muscular e/ou modelar o corpo. ");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 2) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q97);
            texto3TextView.setText("Os amigos são um dos principais indicadores de bem-estar na vida social das pessoas. Da mesma forma que em outras áreas, a internet também inovou as maneiras de vivenciar a amizade. Da leitura do infográfico, depreendem-se dois tipos de amizade virtual, a simétrica e a assimétrica, ambas com seus prós e contras. Enquanto a primeira se baseia na relação de reciprocidade, a segunda");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("reduz o número de amigos virtuais, ao limitar o acesso à rede.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("parte do anonimato obrigatório para se difundir.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("reforça a configuração de laços mais profundos de amizade.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("facilita a interação entre pessoas em virtude de interesses comuns.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("tem a responsabilidade de promover a proximidade física.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 3) {
            texto1TextView.setText("O hipertexto refere-se à escritura eletrônica não sequencial e não linear, que se bifurca e permite ao leitor o acesso a um número praticamente ilimitado de outros textos a partir de escolhas locais e sucessivas, em tempo real. Assim, o leitor tem condições de definir interativamente o fluxo de sua leitura a partir de assuntos tratados no texto sem se prender a uma sequência fixa ou a tópicos estabelecidos por um autor. Trata-se de uma forma de estruturação textual que faz do leitor simultaneamente coautor do texto final. O hipertexto se caracteriza, pois, como um processo de escritura / leitura eletrônica multilinearizado, multisequencial e indeterminado, realizado em um novo espaço de escrita. Assim, ao permitir vários níveis de tratamento de um tema, o hipertexto oferece a possibilidade de múltiplos graus de profundidade simultaneamente, já que não tem sequência definida, mas liga textos não necessariamente correlacionados. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O computador mudou nossa maneira de ler e escrever, e o hipertexto pode ser considerado como um novo espaço de escrita e leitura. Definido como um conjunto de blocos autônomos de texto, apresentado em meio eletrônico computadorizado e no qual há remissões associando entre si diversos elementos, o hipertexto");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("é uma estratégia que, ao possibilitar caminhos totalmente abertos, desfavorece o leitor, ao confundir os conceitos cristalizados tradicionalmente.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("é uma forma artificial de produção da escrita, que, ao desviar o foco da leitura, pode ter como consequência o menosprezo pela escrita tradicional.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("exige do leitor um maior grau de conhecimentos prévios, por isso deve ser evitado pelos estudantes nas suas pesquisas escolares.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("facilita a pesquisa, pois proporciona uma informação específica, segura e verdadeira, em qualquer site de busca ou blog oferecidos na internet.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("possibilita ao leitor escolher seu próprio percurso de leitura, sem seguir sequência predeterminada, constituindo-se em atividade mais coletiva e colaborativa.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 4) {
            texto1TextView.setText("TEXTO I\n\nO meu nome é Severino,\nnão tenho outro de pia.\nComo há muitos Severinos,\nque é santo de romaria,\nderam então de me chamar\nSeverino de Maria;\ncomo há muitos Severinos\ncom mães chamadas Maria,\nfiquei sendo o da Maria\ndo finado Zacarias,\nmas isso ainda diz pouco:\nhá muitos na freguesia,\npor causa de um coronel\nque se chamou Zacarias\ne que foi o mais antigo\nsenhor desta sesmaria.\nComo então dizer quem fala\nora a Vossas Senhorias? \n\nTEXTO II\n\nJoão Cabral, que já emprestara sua voz ao rio, transfere-a, aqui, ao retirante Severino, que, como o Capibaribe, também segue no caminho do Recife. A autoapresentação do personagem, na fala inicial do texto, nos mostra um Severino que, quanto mais se define, menos se individualiza, pois seus traços biográficos são sempre partilhados por outros homens.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Com base no trecho de Morte e Vida Severina (Texto I) e na análise crítica (Texto II), observa-se que a relação entre o texto poético e o contexto social a que ele faz referência aponta para um problema social expresso literariamente pela pergunta ‘Como então dizer quem fala / ora a Vossas Senhorias?’. A resposta à pergunta expressa no poema é dada por meio da");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("descrição minuciosa dos traços biográficos do personagem-narrador.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("construção da figura do retirante nordestino como um homem resignado com a sua situação.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("representação, na figura do personagem-narrador, de outros Severinos que compartilham sua condição.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("apresentação do personagem-narrador como uma projeção do próprio poeta, em sua crise existencial.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("descrição de Severino, que, apesar de humilde, orgulha-se de ser descendente do coronel Zacarias.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 5) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q100);
            texto3TextView.setText("O anúncio publicitário está intimamente ligado ao ideário de consumo quando sua função é vender um produto. No texto apresentado, utilizam-se elementos linguísticos e extralinguísticos para divulgar a atração “Noites do Terror”, de um parque de diversões. O entendimento da propaganda requer do leitor ");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a identificação com o público-alvo a que se destina o anúncio.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a avaliação da imagem como uma sátira às atrações de terror.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a atenção para a imagem da parte do corpo humano selecionada aleatoriamente.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o reconhecimento do intertexto entre a publicidade e um dito popular.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a percepção do sentido literal da expressão “noites do terror”, equivalente à expressão “noites de terror”.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 6) {
            texto1TextView.setText("TEXTO I\n\nOnde está a honestidade?\nVocê tem palacete reluzente\nTem joias e criados à vontade\nSem ter nenhuma herança ou parente\nSó anda de automóvel na cidade...\nE o povo pergunta com maldade:\nOnde está a honestidade?\nOnde está a honestidade?\nO seu dinheiro nasce de repente\nE embora não se saiba se é verdade\nVocê acha nas ruas diariamente\nAnéis, dinheiro e felicidade... \nVassoura dos salões da sociedade\nQue varre o que encontrar em sua frente\nPromove festivais de caridade\nEm nome de qualquer defunto ausente... \n\nTEXTO II\n\nUm vulto da história da música popular brasileira, reconhecido nacionalmente, é Noel Rosa. Ele nasceu em 1910, no Rio de Janeiro; portanto, se estivesse vivo, estaria completando 100 anos. Mas faleceu aos 26 anos de idade, vítima de tuberculose, deixando um acervo de grande valor para o patrimônio cultural brasileiro. Muitas de suas letras representam a sociedade contemporânea, como se tivessem sido escritas no século XXI.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Um texto pertencente ao patrimônio literário-cultural brasileiro é atualizável, na medida em que ele se refere a valores e situações de um povo. A atualidade da canção Onde está a honestidade?, de Noel Rosa, evidencia-se por meio");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("da ironia, ao se referir ao enriquecimento de origem duvidosa de alguns.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("da crítica aos ricos que possuem joias, mas não têm herança.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("da maldade do povo a perguntar sobre a honestidade.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("do privilégio de alguns em clamar pela honestidade.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("da insistência em promover eventos beneficentes.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 7) {
            texto1TextView.setText("Quem é pobre, pouco se apega, é um giro-o-giro no vago dos gerais, que nem os pássaros de rios e lagoas. O senhor vê: o Zé-Zim, o melhor meeiro meu aqui, risonho e habilidoso. Pergunto: — Zé-Zim, por que é que você não cria galinhas-d‘angola, como todo o mundo faz? — Quero criar nada não... — me deu resposta: — Eu gosto muito de mudar... [...] Belo um dia, ele tora. Ninguém discrepa. Eu, tantas, mesmo digo. Eu dou proteção. [...] Essa não faltou também à minha mãe, quando eu era menino, no sertãozinho de minha terra. [...] Gente melhor do lugar eram todos dessa família Guedes, Jidião Guedes; quando saíram de lá, nos trouxeram junto, minha mãe e eu. Ficamos existindo em território baixio da Sirga, da outra banda, ali onde o de-Janeiro vai no São Francisco, o senhor sabe. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Na passagem citada, Riobaldo expõe uma situação decorrente de uma desigualdade social típica das áreas rurais brasileiras marcadas pela concentração de terras e pela relação de dependência entre agregados e fazendeiros. No texto, destaca-se essa relação porque o personagem-narrador");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("relata a seu interlocutor a história de Zé-Zim, demonstrando sua pouca disposição em ajudar seus agregados, uma vez que superou essa condição graças à sua força de trabalho.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("descreve o processo de transformação de um meeiro — espécie de agregado — em proprietário de terra.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("denuncia a falta de compromisso e a desocupação dos moradores, que pouco se envolvem no trabalho da terra.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("mostra como a condição material da vida do sertanejo é dificultada pela sua dupla condição de homem livre e, ao mesmo tempo, dependente.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("mantém o distanciamento narrativo condizente com sua posição social, de proprietário de terras.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 8) {
            texto1TextView.setText("A discussão sobre “o fim do livro de papel” com a chegada da mídia eletrônica me lembra a discussão idêntica sobre a obsolescência do folheto de cordel. Os folhetos talvez não existam mais daqui a 100 ou 200 anos, mas, mesmo que isso aconteça, os poemas de Leandro Gomes de Barros ou Manuel Camilo dos Santos continuarão sendo publicados e lidos — em CD-ROM, em livro eletrônico, em ‘chips quânticos’, sei lá o quê. O texto é uma espécie de alma imortal, capaz de reencarnar em corpos variados: página impressa, livro em Braille, folheto, ‘coffee-table book’ , cópia manuscrita, arquivo PDF... Qualquer texto pode se reencarnar nesses (e em outros) formatos, não importa se é Moby Dick ou Viagem a São Saruê , se é Macbeth ou O livro de piadas de Casseta & Planeta. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Ao refletir sobre a possível extinção do livro impresso e o surgimento de outros suportes em via eletrônica, o cronista manifesta seu ponto de vista, defendendo que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o cordel é um dos gêneros textuais, por exemplo, que será extinto com o avanço da tecnologia.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o livro impresso permanecerá como objeto cultural veiculador de impressões e de valores culturais.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o surgimento da mídia eletrônica decretou o fim do prazer de se ler textos em livros e suportes impressos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("os textos continuarão vivos e passíveis de reprodução em novas tecnologias, mesmo que os livros desapareçam.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("os livros impressos desaparecerão e, com eles, a possibilidade de se ler obras literárias dos mais diversos gêneros.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 9) {
            texto1TextView.setText("Não tem tradução\n\n[...]\nLá no morro, se eu fizer uma falseta\nA Risoleta desiste logo do francês e do inglês\nA gíria que o nosso morro criou\nBem cedo a cidade aceitou e usou\n[...]\nEssa gente hoje em dia que tem mania de exibição\nNão entende que o samba não tem tradução no idioma francês\nTudo aquilo que o malandro pronuncia\nCom voz macia é brasileiro, já passou de português\nAmor lá no morro é amor pra chuchu\nAs rimas do samba não são I love you\nE esse negócio de alô, alô boy e alô Johnny\nSó pode ser conversa de telefone");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("As canções de Noel Rosa, compositor brasileiro de Vila Isabel, apesar de revelarem uma aguçada preocupação do artista com seu tempo e com as mudanças político-culturais no Brasil, no início dos anos 1920, ainda são modernas. Nesse fragmento do samba Não tem tradução, por meio do recurso da metalinguagem, o poeta propõe");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("incorporar novos costumes de origem francesa e americana, juntamente com vocábulos estrangeiros.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("respeitar e preservar o português padrão como forma de fortalecimento do idioma do Brasil.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("valorizar a fala popular brasileira como patrimônio linguístico e forma legítima de identidade nacional.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("mudar os valores sociais vigentes à época, com o advento do novo e quente ritmo da música popular brasileira.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("ironizar a malandragem carioca, aculturada pela invasão de valores étnicos de sociedades mais desenvolvidas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 10) {
            texto1TextView.setText("A dança é um importante componente cultural da humanidade. O folclore brasileiro é rico em danças que representam as tradições e a cultura de várias regiões do país. Estão ligadas aos aspectos religiosos, festas, lendas, fatos históricos, acontecimentos do cotidiano e brincadeiras e caracterizam-se pelas músicas animadas (com letras simples e populares), figurinos e cenários representativos. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A dança, como manifestação e representação da cultura rítmica, envolve a expressão corporal própria de um povo. Considerando-a como elemento folclórico, a dança revela");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("manifestações afetivas, históricas, ideológicas, intelectuais e espirituais de um povo, refletindo seu modo de expressar-se no mundo.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("aspectos eminentemente afetivos, espirituais e de entretenimento de um povo, desconsiderando fatos históricos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("acontecimentos do cotidiano, sob influência mitológica e religiosa de cada região, sobrepondo aspectos políticos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("tradições culturais de cada região, cujas manifestações rítmicas são classificadas em um ranking das mais originais.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("lendas, que se sustentam em inverdades históricas, uma vez que são inventadas, e servem apenas para a vivência lúdica de um povo.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 11) {
            texto1TextView.setText("Cultivar um estilo de vida saudável é extremamente importante para diminuir o risco de infarto, mas tam - bém de problemas como morte súbita e derrame. Significa que manter uma alimentação saudável e praticar atividade física regularmente já reduz, por si só, as chances de desenvolver vários problemas. Além disso, é importante para o controle da pressão arterial, dos níveis de colesterol e de glicose no sangue. Também ajuda a diminuir o estresse e aumentar a capacidade física, fatores que, somados, reduzem as chances de infarto. Exercitar-se, nesses casos, com acompanhamento médico e moderação, é altamente recomendável. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("As ideias veiculadas no texto se organizam estabelecendo relações que atuam na construção do sentido. A esse respeito, identifica-se, no fragmento, que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a expressão ‘Além disso’ marca uma sequenciação de ideias.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o conectivo ‘mas também’ inicia oração que exprime ideia de contraste.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o termo ‘como’, em ‘como morte súbita e derrame’, introduz uma generalização.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o termo ‘Também’ exprime uma justificativa.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o termo ‘fatores’ retoma coesivamente ‘níveis de colesterol e de glicose no sangue’.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 12) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q107);
            texto3TextView.setText("Utilizadas desde a Antiguidade, as colunas, elementos verticais de sustentação, foram sofrendo modificações e incorporando novos materiais com ampliação de possibilidades. Ainda que as clássicas colunas gregas sejam retomadas, notáveis inovações são percebidas, por exemplo, nas obras de Oscar Niemeyer, arquiteto brasileiro nascido no Rio de Janeiro em 1907. No desenho de Niemeyer, das colunas do Palácio da Alvorada, observa-se");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a presença de um capitel muito simples, reforçando a sustentação.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o traçado simples de amplas linhas curvas opostas, resultando em formas marcantes.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a disposição simétrica das curvas, conferindo saliência e distorção à base.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a oposição de curvas em concreto, configurando certo peso e rebuscamento.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o excesso de linhas curvas, levando a um exagero na ornamentação.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 13) {
            texto1TextView.setText("Conceitos e importância das lutas Antes de se tornarem esporte, as lutas ou as artes marciais tiveram duas conotações principais: eram praticadas com o objetivo guerreiro ou tinham um apelo filosófico como concepção de vida bastante significativo. Atualmente, nos deparamos com a grande expansão das artes marciais em nível mundial. As raízes orientais foram se disseminando, ora pela necessidade de luta pela sobrevivência ou para a “defesa pessoal”, ora pela possibilidade de ter as artes marciais como própria filosofia de vida. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Um dos problemas da violência que está presente principalmente nos grandes centros urbanos são as brigas e os enfrentamentos de torcidas organizadas, além da formação de gangues, que se apropriam de gestos das lutas, resultando, muitas vezes, em fatalidades. Portanto, o verdadeiro objetivo da aprendizagem desses movimentos foi mal compreendido, afinal as lutas");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("se tornaram um esporte, mas eram praticadas com o objetivo guerreiro a fim de garantir a sobrevivência.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("apresentam a possibilidade de desenvolver o autocontrole, o respeito ao outro e a formação do caráter.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("possuem como objetivo principal a “defesa pessoal” por meio de golpes agressivos sobre o adversário.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("sofreram transformações em seus princípios filosóficos em razão de sua disseminação pelo mundo.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("se disseminaram pela necessidade de luta pela sobrevivência ou como filosofia pessoal de vida.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 14) {
            texto1TextView.setText("O tema da velhice foi objeto de estudo de brilhantes filósofos ao longo dos tempos. Um dos melhores livros sobre o assunto foi escrito pelo pensador e orador romano Cícero: A Arte do Envelhecimento . Cícero nota, primeiramente, que todas as idades têm seus encantos e suas dificuldades. E depois aponta para um paradoxo da humanidade. Todos sonhamos ter uma vida longa, o que significa viver muitos anos. Quando realizamos a meta, em vez de celebrar o feito, nos atiramos a um estado de melancolia e amargura. Ler as palavras de Cícero sobre envelhecimento pode ajudar a aceitar melhor a passagem do tempo. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O autor discute problemas relacionados ao envelhecimento, apresentando argumentos que levam a inferir que seu objetivo é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("esclarecer que a velhice é inevitável.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("contar fatos sobre a arte de envelhecer.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("defender a ideia de que a velhice é desagradável.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("influenciar o leitor para que lute contra o envelhecimento.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("mostrar às pessoas que é possível aceitar, sem angústia, o envelhecimento.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 15) {
            texto1TextView.setText("Nessa estranha dignidade e nesse abandono, o objeto foi exaltado de maneira ilimitada e ganhou um significado que se pode considerar mágico. Daí sua “vida inquietante e absurda”. Tornou-se ídolo e, ao mesmo tempo, objeto de zombaria. Sua realidade intrínseca foi anulada. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q110);
            texto3TextView.setText("A relação observada entre a imagem e o texto apresentados permite o entendimento da intenção de um artista contemporâneo. Neste caso, a obra apresenta características");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("funcionais e de sofisticação decorativa.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("futuristas e do abstrato geométrico.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("construtivistas e de estruturas modulares.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("abstracionistas e de releitura do objeto.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("figurativas e de representação do cotidiano.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 16) {
            texto1TextView.setText("O Adãozinho, meu cumpade, enquanto esperava pelo delegado, olhava para um quadro, a pintura de uma senhora. Ao entrar a autoridade e percebendo que o cabôco admirava tal figura, perguntou: ‘Que tal? Gosta desse quadro?’ E o Adãozinho, com toda a sinceridade que Deus dá ao cabôco da roça: ‘Mas pelo amor de Deus, hein, dotô! Que muié feia! Parece fiote de cruis-credo, parente do deus-me-livre, mais horríver que briga de cego no escuro.’ Ao que o delegado não teve como deixar de confessar, um pouco secamente: ‘É a minha mãe.’ E o cabôco, em cima da bucha, não perde a linha: ‘Mais dotô, inté que é uma feiura caprichada.’ ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Por suas características formais, por sua função e uso, o texto pertence ao gênero");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("anedota, pelo enredo e humor característicos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("crônica, pela abordagem literária de fatos do cotidiano.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("depoimento, pela apresentação de experiências pessoais.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("relato, pela descrição minuciosa de fatos verídicos.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("reportagem, pelo registro impessoal de situações reais.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 17) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q112);
            texto3TextView.setText("O grafite contemporâneo, considerado em alguns momentos como uma arte marginal, tem sido comparado às pinturas murais de várias épocas e às escritas pré-históricas. Observando as imagens apresentadas, é possível reconhecer elementos comuns entre os tipos de pinturas murais, tais como");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a preferência por tintas naturais, em razão de seu efeito estético.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a inovação na técnica de pintura, rompendo com modelos estabelecidos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o registro do pensamento e das crenças das sociedades em várias épocas.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a repetição dos temas e a restrição de uso pelas classes dominantes.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o uso exclusivista da arte para atender aos interesses da elite.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 18) {
            texto1TextView.setText("Estrada\n\nEsta estrada onde moro, entre duas voltas do caminho,\nInteressa mais que uma avenida urbana.\nNas cidades todas as pessoas se parecem.\nTodo mundo é igual. Todo mundo é toda a gente.\nAqui, não: sente-se bem que cada um traz a sua alma.\nCada criatura é única.\nAté os cães.\nEstes cães da roça parecem homens de negócios:\nAndam sempre preocupados.\nE quanta gente vem e vai!\nE tudo tem aquele caráter impressivo que faz meditar:\nEnterro a pé ou a carrocinha de leite puxada por um bodezinho manhoso.\nNem falta o murmúrio da água, para sugerir, pela voz dos símbolos,\nQue a vida passa! que a vida passa!\nE que a mocidade vai acabar.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A lírica de Manuel Bandeira é pautada na apreensão de significados profundos a partir de elementos do cotidiano. No poema Estrada, o lirismo presente no contraste entre campo e cidade aponta para");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o desejo do eu lírico de resgatar a movimentação dos centros urbanos, o que revela sua nostalgia com relação à cidade.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a percepção do caráter efêmero da vida, possibilitada pela observação da aparente inércia da vida rural.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a opção do eu lírico pelo espaço bucólico como possibilidade de meditação sobre a sua juventude.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a visão negativa da passagem do tempo, visto que esta gera insegurança.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a profunda sensação de medo gerada pela reflexão acerca da morte.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 19) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q114);
            texto3TextView.setText("O pintor espanhol Pablo Picasso (1881–1973), um dos mais valorizados no mundo artístico, tanto em termos financeiros quanto históricos, criou a obra Guernica em protesto ao ataque aéreo à pequena cidade basca de mesmo nome. A obra, feita para integrar o Salão Internacional de Artes Plásticas de Paris, percorreu toda a Europa, chegando aos EUA e instalando-se no MoMA, de onde sairia apenas em 1981. Essa obra cubista apre - senta elementos plásticos identificados pelo");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("painel ideográfico, monocromático, que enfoca várias dimensões de um evento, renunciando à realidade, colocando-se em plano frontal ao espectador.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("horror da guerra de forma fotográfica, com o uso da perspectiva clássica, envolvendo o espectador nesse exemplo brutal de crueldade do ser humano.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("uso das formas geométricas no mesmo plano, sem emoção e expressão, despreocupado com o volume, a perspectiva e a sensação escultórica.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("esfacelamento dos objetos abordados na mesma narrativa, minimizando a dor humana a serviço da objetividade, observada pelo uso do claro-escuro.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("uso de vários ícones que representam personagens fragmentados bidimensionalmente, de forma fotográfica livre de sentimentalismo.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 20) {
            texto1TextView.setText("No Brasil, a condição cidadã, embora dependa da leitura e da escrita, não se basta pela enunciação do direito, nem pelo domínio desses instrumentos, o que, sem dúvida, viabiliza melhor participação social. A condição cidadã depende, seguramente, da ruptura com o ciclo da pobreza, que penaliza um largo contingente populacional");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Ao argumentar que a aquisição das habilidades de leitura e escrita não são suficientes para garantir o exercício da cidadania, o autor");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("critica os processos de aquisição da leitura e da escrita.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("fala sobre o domínio da leitura e da escrita no Brasil.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("incentiva a participação efetiva na vida da comunidade.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("faz uma avaliação crítica a respeito da condição cidadã do brasileiro.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("define instrumentos eficazes para elevar a condição social da população do Brasil.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 21) {
            texto1TextView.setText("Lépida e leve\n\nLíngua do meu Amor velosa e doce,\nque me convences de que sou frase,\nque me contornas, que me vestes quase,\ncomo se o corpo meu de ti vindo me fosse.\nLíngua que me cativas, que me enleias\nos surtos de ave estranha,\nem linhas longas de invisíveis teias,\nde que és, há tanto, habilidosa aranha...\n[...]\nAmo-te as sugestões gloriosas e funestas,\namo-te como todas as mulheres\nte amam, ó língua-lama, ó língua-resplendor,\npela carne de som que à ideia emprestas\ne pelas frases mudas que proferes\nnos silêncios de Amor!...");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A poesia de Gilka Machado identifica-se com as concepções artísticas simbolistas. Entretanto, o texto selecionado incorpora referências temáticas e formais modernistas, já que, nele, a poeta");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("procura desconstruir a visão metafórica do amor e abandona o cuidado formal.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("concebe a mulher como um ser sem linguagem e questiona o poder da palavra.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("questiona o trabalho intelectual da mulher e antecipa a construção do verso livre.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("propõe um modelo novo de erotização na lírica amorosa e propõe a simplificação verbal.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("explora a construção da essência feminina, a partir da polissemia de “língua“, e inova o léxico.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 22) {
            texto1TextView.setText("Abatidos pelo fadinho harmonioso e nostálgico dos desterrados, iam todos, até mesmo os brasileiros, se concentrando e caindo em tristeza; mas, de repente, o cavaquinho de Porfiro, acompanhado pelo violão do Firmo, romperam vibrantemente com um chorado baiano. Nada mais que os primeiros acordes da música crioula para que o sangue de toda aquela gente despertasse logo, como se alguém lhe fustigasse o corpo com urtigas bravas. E seguiram-se outra notas, e outras, cada vez mais ardentes e mais delirantes. Já não eram dois instrumentos que soavam, eram lúbricos gemidos e suspiros soltos em torrente, a correrem serpenteando, como cobras numa floresta incendiada; eram ais convulsos, chorados em frenesi de amor: música feita de beijos e soluços gostosos; carícia de fera, carícia de doer, fazendo estalar de gozo.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("No romance O Cortiço (1890), de Aluísio Azevedo, as personagens são observadas como elementos coletivos caracterizados por condicionantes de origem social, sexo e etnia. Na passagem transcrita, o confronto entre brasileiros e portugueses revela prevalência do elemento brasileiro, pois");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("destaca o nome de personagens brasileiras e omite o de personagens portuguesas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("exalta a força do cenário natural brasileiro e considera o do português inexpressivo.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("mostra o poder envolvente da música brasileira, que cala o fado português.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("destaca o sentimentalismo brasileiro, contrário à tristeza dos portugueses.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("atribui aos brasileiros uma habilidade maior com instrumentos musicais.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 23) {
            texto1TextView.setText("Guardar\n\nGuardar uma coisa não é escondê-la ou trancá-la.\nEm cofre não se guarda coisa alguma.\nEm cofre perde-se a coisa à vista.\nGuardar uma coisa é olhá-la, fitá-la, mirá-la por\nadmirá-la, isto é, iluminá-la ou ser por ela iluminado.\nGuardar uma coisa é vigiá-la, isto é, fazer vigília por\nela, isto é, velar por ela, isto é, estar acordado por ela,\nisto é, estar por ela ou ser por ela.\nPor isso melhor se guarda o voo de um pássaro\nDo que um pássaro sem voos.\nPor isso se escreve, por isso se diz, por isso se publica,\npor isso se declara e declama um poema:\nPara guardá-lo:\nPara que ele, por sua vez, guarde o que guarda:\nGuarde o que quer que guarda um poema:\nPor isso o lance do poema:\nPor guardar-se o que se quer guardar.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A memória é um importante recurso do patrimônio cultural de uma nação. Ela está presente nas lembranças do passado e no acervo cultural de um povo. Ao tratar o fazer poético como uma das maneiras de se guardar o que se quer, o texto");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("ressalta a importância dos estudos históricos para a construção da memória social de um povo.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("valoriza as lembranças individuais em detrimento das narrativas populares ou coletivas.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("reforça a capacidade da literatura em promover a subjetividade e os valores humanos.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("destaca a importância de reservar o texto literário àqueles que possuem maior repertório cultural.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("revela a superioridade da escrita poética como forma ideal de preservação da memória cultural.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 24) {
            texto1TextView.setText("Quando os portugueses se instalaram no Brasil, o país era povoado de índios. Importaram, depois, da África, grande número de escravos. O Português, o Índio e o Negro constituem, durante o período colonial, as três bases da população brasileira. Mas no que se refere à cultura, a contribuição do Português foi de longe a mais notada. Durante muito tempo o português e o tupi viveram lado a lado como línguas de comunicação. Era o tupi que utilizavam os bandeirantes nas suas expedições. Em 1694, dizia o Padre Antônio Vieira que ‘’as famílias dos portugueses e índios em São Paulo estão tão ligadas hoje umas com as outras, que as mulheres e os filhos se criam mística e domesticamente, e a língua que nas ditas famílias se fala é a dos Índios, e a portuguesa a vão os meninos aprender à escola.’’");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("A identidade de uma nação está diretamente ligada à cultura de seu povo. O texto mostra que, no período colonial brasileiro, o Português, o Índio e o Negro formaram a base da população e que o patrimônio linguístico brasileiro é resultado da");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("contribuição dos índios na escolarização dos brasileiros.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("diferença entre as línguas dos colonizadores e as dos indígenas.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("importância do Padre Antônio Vieira para a literatura de língua portuguesa.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("origem das diferenças entre a língua portuguesa e as línguas tupi.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("interação pacífica no uso da língua portuguesa e da língua tupi.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 25) {
            texto1TextView.setText("Pequeno concerto que virou canção\n\nNão, não há por que mentir ou esconder\nA dor que foi maior do que é capaz meu coração\nNão, nem há por que seguir cantando só para explicar\nNão vai nunca entender de amor quem nunca soube amar\nAh, eu vou voltar pra mim\nSeguir sozinho assim\nAté me consumir ou consumir toda essa dor\nAté sentir de novo o coração capaz de amor");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Na canção de Geraldo Vandré, tem-se a manifestação da função poética da linguagem, que é percebida na elaboração artística e criativa da mensagem, por meio de combinações sonoras e rítmicas. Pela análise do texto, entretanto, percebe-se, também, a presença marcante da função emotiva ou expressiva, por meio da qual o emissor");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("imprime à canção as marcas de sua atitude pessoal, seus sentimentos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("transmite informações objetivas sobre o tema de que trata a canção.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("busca persuadir o receptor da canção a adotar um certo comportamento.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("procura explicar a própria linguagem que utiliza para construir a canção.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("objetiva verificar ou fortalecer a eficiência da mensagem veiculada.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 26) {
            texto1TextView.setText("É água que não acaba mais\n\nDados preliminares divulgados por pesquisadores da Universidade Federal do Pará (UFPA) apontaram o Aquífero Alter do Chão como o maior depósito de água potável do planeta. Com volume estimado em 86 000 quilômetros cúbicos de água doce, a reserva subterrânea está localizada sob os estados do Amazonas, Pará e Amapá. ‘’Essa quantidade de água seria suficiente para abastecer a população mundial durante 500 anos’’, diz Milton Matta, geólogo da UFPA. Em termos comparativos, Alter do Chão tem quase o dobro do volume de água do Aquífero Guarani (com 45 000 quilômetros cúbicos). Até então, Guarani era a maior reserva subterrânea do mundo, distribuída por Brasil, Argentina, Paraguai e Uruguai.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Essa notícia, publicada em uma revista de grande circulação, apresenta resultados de uma pesquisa científica realizada por uma universidade brasileira. Nessa situação específica de comunicação, a função referencial da linguagem predomina, porque o autor do texto prioriza");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("as suas opiniões, baseadas em fatos.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("os aspectos objetivos e precisos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("os elementos de persuasão do leitor.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("os elementos estéticos na construção do texto.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("os aspectos subjetivos da mencionada pesquisa.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 27) {
            texto1TextView.setText("Nós adoraríamos dizer que somos perfeitos. Que somos infalíveis. Que não cometemos nem mesmo o menor deslize. E só não falamos isso por um pequeno detalhe: seria uma mentira. Aliás, em vez de usar a palavra ‘’mentira’’, como acabamos de fazer, poderíamos optar por um eufemismo. ‘’Meia-verdade’’, por exemplo, seria um termo muito menos agressivo. Mas nós não usamos esta palavra simplesmente porque não acreditamos que exista uma ‘’Meia-verdade’’. Para o Conar, Conselho Nacional de Autorregulamentação Publicitária, existem a verdade e a mentira. Existem a honestidade e a desonestidade. Absolutamente nada no meio. O Conar nasceu há 29 anos (viu só? não arredondamos para 30) com a missão de zelar pela ética na publicidade. Não fazemos isso porque somos bonzinhos (gostaríamos de dizer isso, mas, mais uma vez, seria mentira). Fazemos isso porque é a única forma da propaganda ter o máximo de credibilidade. E, cá entre nós, para que serviria a propaganda se o consumidor não acreditasse nela? Qualquer pessoa que se sinta enganada por uma peça publicitária pode fazer uma reclamação ao Conar. Ele analisa cuidadosamente todas as denúncias e, quando é o caso, aplica a punição. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q122e123);
            texto3TextView.setText("O recurso gráfico utilizado no anúncio publicitário — de destacar a potencial suporessão de trecho do texto — reforça a eficácia pretendida, revelada na estratégia de");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("ressaltar a informação no título, em detrimento do restante do conteúdo associado.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("incluir o leitor por meio do uso da 1 pessoa do plural no discurso.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("contar a história da criação do órgão como argumento de autoridade.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("subverter o fazer publicitário pelo uso de sua metalinguagem.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("impressionar o leitor pelo jogo de palavras no texto.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 28) {
            texto1TextView.setText("Nós adoraríamos dizer que somos perfeitos. Que somos infalíveis. Que não cometemos nem mesmo o menor deslize. E só não falamos isso por um pequeno detalhe: seria uma mentira. Aliás, em vez de usar a palavra ‘’mentira’’, como acabamos de fazer, poderíamos optar por um eufemismo. ‘’Meia-verdade’’, por exemplo, seria um termo muito menos agressivo. Mas nós não usamos esta palavra simplesmente porque não acreditamos que exista uma ‘’Meia-verdade’’. Para o Conar, Conselho Nacional de Autorregulamentação Publicitária, existem a verdade e a mentira. Existem a honestidade e a desonestidade. Absolutamente nada no meio. O Conar nasceu há 29 anos (viu só? não arredondamos para 30) com a missão de zelar pela ética na publicidade. Não fazemos isso porque somos bonzinhos (gostaríamos de dizer isso, mas, mais uma vez, seria mentira). Fazemos isso porque é a única forma da propaganda ter o máximo de credibilidade. E, cá entre nós, para que serviria a propaganda se o consumidor não acreditasse nela? Qualquer pessoa que se sinta enganada por uma peça publicitária pode fazer uma reclamação ao Conar. Ele analisa cuidadosamente todas as denúncias e, quando é o caso, aplica a punição. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q122e123);
            texto3TextView.setText("Considerando a autoria e a seleção lexical desse texto, bem como os argumentos nele mobilizados, constata-se que o objetivo do autor do texto é");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("informar os consumidores em geral sobre a atuação do Conar.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("conscientizar publicitários do compromisso ético ao elaborar suas peças publicitárias.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("alertar chefes de família, para que eles fiscalizem o conteúdo das propagandas veiculadas pela mídia.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("chamar a atenção de empresários e anunciantes em geral para suas responsabilidades ao contratarem publicitários sem ética.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("chamar a atenção de empresas para os efeitos nocivos que elas podem causar à sociedade, se compactuarem com propagandas enganosas.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 29) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q124);
            texto3TextView.setText("O produtor de anúncios publicitários utiliza-se de estratégias persuasivas para influenciar o comportamento de seu leitor. Entre os recursos argumentativos mobilizados pelo autor para obter a adesão do público à campanha, destaca-se nesse texto");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a oposição entre individual e coletivo, trazendo um ideário populista para o anúncio.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a utilização de tratamento informal com o leitor, o que suaviza a seriedade do problema.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("o emprego de linguagem figurada, o que desvia a atenção da população do apelo financeiro.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o uso dos numerais ‘’milhares’’ e ‘’milhões’’, responsável pela supervalorização das condições dos necessitados.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o jogo de palavras entre ‘’acordar’’ e ‘’dormir’’, o que relativiza o problema do leitor em relação ao dos necessitados.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 30) {
            texto1TextView.setText("Entre ideia e tecnologia\n\nO grande conceito por trás do Museu da Língua é apresentar o idioma como algo vivo e fundamental para o entendimento do que é ser brasileiro. Se nada nos define com clareza, a forma como falamos o português nas mais diversas situações cotidianas é talvez a melhor expressão da brasilidade.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O texto propõe uma reflexão acerca da língua portuguesa, ressaltando para o leitor a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("inauguração do museu e o grande investimento em cultura no país.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("importância da língua para a construção da identidade nacional.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("afetividade tão comum ao brasileiro, retratada através da língua.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("relação entre o idioma e as políticas públicas na área de cultura.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("diversidade étnica e linguística existente no território nacional.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 31) {
            texto1TextView.setText("TEXTO I\n\nO Brasil sempre deu respostas rápidas através da solidariedade do seu povo. Mas a mesma força que nos motiva a ajudar o próximo deveria também nos motivar a ter atitudes cidadãs. Não podemos mais transferir a culpa para quem é vítima ou até mesmo para a própria natureza, como se essa seguisse a lógica humana. Sobram desculpas esfarrapadas e falta competência da classe política.\n\nTEXTO II\n\nNão podemos negar ao povo sofrido todas as hipóteses de previsão dos desastres. Demagogos culpam os moradores; o governo e a prefeitura apelam para as pessoas saírem das áreas de risco e agora dizem que será compulsória a realocação. Então temos a realocar o Brasil inteiro! Criemos um serviço, similar ao SUS, com alocação obrigatória de recursos orçamentários com rede de atendimento preventivo, onde participariam arquitetos, engenheiros, geólogos. Bem ou mal, esse “SUS” organizaria brigadas nos locais. Nos casos da dengue, por exemplo, poderia verificar as condições de acontecer epidemias. Seriam boas ações preventivas. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Os textos apresentados expressam opiniões de leitores acerca de relevante assunto para a sociedade brasileira. Os autores dos dois textos apontam para a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("necessidade de trabalho voluntário contínuo para a resolução das mazelas sociais.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("importância de ações preventivas para evitar catástrofes, indevidamente atribuídas aos políticos.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("incapacidade política para agir de forma diligente na resolução das mazelas sociais.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("urgência de se criarem novos órgãos públicos com as mesmas características do SUS.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("impossibilidade de o homem agir de forma eficaz ou preventiva diante das ações da natureza.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 32) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q127);
            texto3TextView.setText("O texto é uma propaganda de um adoçante que tem o seguinte mote: ‘’Mude sua embalagem’’. A estratégia que o autor utiliza para o convencimento do leitor baseia-se no emprego de recursos expressivos, verbais e não verbais, com vistas a");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("ridicularizar a forma física do possível cliente do produto anunciado, aconselhando-o a uma busca de mudanças estéticas.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("enfatizar a tendência da sociedade contemporânea de buscar hábitos alimentares saudáveis, reforçando tal postura.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("criticar o consumo excessivo de produtos industrializados por parte da população, propondo a redução desse consumo.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("associar o vocábulo ‘’açúcar’’ à imagem do corpo fora de forma, sugerindo a substituição desse produto pelo adoçante.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("relacionar a imagem do saco de açúcar a um corpo humano que não desenvolve atividades físicas, incentivando a prática esportiva.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.d;
        }
        if (question == 33) {
            texto1TextView.setText("Motivadas ou não historicamente, normas prestigiadas ou estigmatizadas pela comunidade sobrepõem-se ao longo do território, seja numa relação de oposição, seja de complementaridade, sem, contudo, anular a interseção de usos que configuram uma norma nacional distinta da do português europeu. Ao focalizar essa ao longo do território, seja numa relação de oposição, seja de complementaridade, sem, contudo, anular a interseção de usos que configuram uma norma nacional distinta da do português europeu. Ao focalizar essa a pensar na bifurcação das variantes continentais, ora em consequência de mudanças ocorridas no Brasil, ora em Portugal, ora, ainda, em ambos os territórios. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O português do Brasil não é uma língua uniforme. A variação linguística é um fenômeno natural, ao qual todas as línguas estão sujeitas. Ao considerar as variedades linguísticas, o texto mostra que as normas podem ser aprovadas ou condenadas socialmente, chamando a atenção do leitor para");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("desconsideração da existência das normas populares pelos falantes da norma culta.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("difusão do português de Portugal em todas as regiões do Brasil só a partir do século XVIII.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("existência de usos da língua que caracterizam uma norma nacional do Brasil, distinta da de Portugal.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("inexistência de normas cultas locais e populares ou vernáculas em um determinado país.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("necessidade de se rejeitar a ideia de que os usos frequentes de uma língua devem ser aceitos.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 34) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q129);
            texto3TextView.setText("O humor da tira decorre da reação de uma das cobras com relação ao uso de pronome pessoal reto, em vez de pronome oblíquo. De acordo com a norma-padrão da língua, esse uso é inadequado, pois");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("contraria o uso previsto para o registro oral da língua.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("contraria a marcação das funções sintáticas de sujeito e objeto.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("gera inadequação na concordância com o verbo.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("gera ambiguidade na leitura do texto.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("apresenta dupla marcação de sujeito.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 35) {
            texto1TextView.setText("MANDIOCA — mais um presente da Amazônia\n\nAipim, castelinha, macaxeira, maniva, maniveira. As designações de Manihot utilissima podem variar de região, no Brasil, mas uma delas deve ser levada em conta em todo o território nacional: pão-de-pobre - e por motivos óbvios. Rica em fécula, a mandioca - uma planta rústica e nativa da Amazônia disseminada no mundo inteiro, especialmente pelos colonizadores portugueses - é a base de sustento de muitos brasileiros e o único alimento disponível para mais de 600 milhões de pessoas em vários pontos do planeta, e em particular em algumas regiões da África.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("De acordo com o texto, há no Brasil uma variedade de nomes para a Manihot utilissima, nome científico da mandioca. Esse fenômeno revela que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("existem variedades regionais para nomear uma mesma espécie de planta.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("mandioca é nome específico para a espécie existente na região amazônica.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("’’pão-de-pobre’’ é designação específica para a planta da região amazônica.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("os nomes designam espécies diferentes da planta, conforme a região.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a planta é nomeada conforme as particularidades que apresenta.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 36) {
            texto1TextView.setText("Há certos usos consagrados na fala, e até mesmo na escrita, que, a depender do estrato social e do nível de escolaridade do falante, são, sem dúvida, previsíveis. Ocorrem até mesmo em falantes que dominam a variedade padrão, pois, na verdade, revelam tendências existentes na língua em seu processo de mudança que não podem ser bloqueadas em nome de um “ideal linguístico” que estaria representado pelas regras da gramática normativa. Usos como ter por haver em construções existentes (tem muitos livros na estante), o do pronome objeto na posição de sujeito (para mim fazer o trabalho), a não-concordância das passivas com se (aluga-se casas) são indícios da existência, não de uma norma única, mas de uma pluralidade de normas, entendida, mais uma vez, norma como conjunto de hábitos linguísticos, sem implicar juízo de valor. ");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("Considerando a reflexão trazida no texto a respeito da multiplicidade do discurso, verifica-se que:");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("estudantes que não conhecem as diferenças entre língua escrita e língua falada empregam, indistintamente, usos aceitos na conversa com amigos quando vão elaborar um texto escrito.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("falantes que dominam a variedade padrão do português do Brasil demonstram usos que confirmam a diferença entre a norma idealizada e a efetivamente praticada, mesmo por falantes mais escolarizados.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("moradores de diversas regiões do país enfrentam dificuldades ao se expressar na escrita revelam a constante modificação das regras de empregos de pronomes e os casos especiais de concordância.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("pessoas que se julgam no direito de contrariar a gramática ensinada na escola gostam de apresentar usos não aceitos socialmente para esconderem seu desconhecimento da norma padrão.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("usuários que desvendam os mistérios e sutilezas da língua portuguesa empregam forma do verbo ter quando, na verdade, deveriam usar formas do verbo haver, contrariando as regras gramaticais.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.b;
        }
        if (question == 37) {
            texto1TextView.setText("Palavra indígena\n\nA história da tribo Sapucaí, que traduziu para o idioma guarani os artefatos da era da computação que ganharam importância em sua vida, como mouse (que eles chamam de angojhá) e windows (oventã). Quando a internet chegou àquela comunidade, que abriga em torno de 400 guaranis, há quatro anos, por meio de um projeto do Comitê para Democratização da Informática (CDI), em parceria com a ONG Rede Povos da Floresta e com antena cedida pela Star One (da Embratel), Potty e sua aldeia logo vislumbraram as possibilidades de comunicação que a web traz. Ele conta que usam a rede, por enquanto, somente para preparação e envio de documentos, mas perceberam que ela pode ajudar na preservação da cultura indígena. A apropriação da rede se deu de forma gradual, mas os guaranis já incorporaram a novidade tecnológica ao seu estilo de vida. A importância da internet e da computação para eles está expressa num caso de rara incorporação: a do vocabulário.\n— Um dia, o cacique da aldeia Sapucaí me ligou. ‘’A gente não está querendo chamar computador de ‘’computador’’. Sugeri a eles que criassem uma palavra em guarani. E criaram aiú irú rive, ‘’caixa pra acumular a língua’’. Nós, brancos, usamos mouse, windows e outros termos, que eles começaram a adaptar para o idioma deles, como angojhá (rato) e oventã (janela) — conta Rodrigo Baggio, diretor do CDI.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O uso das novas tecnologias de informação e comunicação fez surgir uma série de novos termos que foram acolhidos na sociedade brasileira em sua forma original, como: mouse, windows, download, site, homepage, entre outros. O texto trata da adaptação de termos da informática à língua indígena como uma reação da tribo Sapucaí, o que revela");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a possibilidade que o índio Potty vislumbrou em relação à comunicação que a web pode trazer a seu povo e à facilidade no envio de documentos e na conversação em tempo real.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("o uso da internet para preparação e envio de documentos, bem como a contribuição para as atividades relacionadas aos trabalhos da cultura índigena.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a preservação da identidade, demonstrada pela conservação do idioma, mesmo com a utilização de novas tecnologias características da cultura de outros grupos sociais.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("adesão ao projeto do Comitê para Democratização da Informática (CDI), que, em parceria com a ONG Rede Povos da Floresta, possibilitou o acesso à web, mesmo em ambiente inóspito.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a apropriação da nova tecnologia de forma gradual, evidente quando os guaranis incorporaram a novidade tecnológica ao seu estilo de vida com a possibilidade de acesso à internet.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.c;
        }
        if (question == 38) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q133e134);
            texto3TextView.setText("O homem evoluiu. Independentemente de teoria, essa evolução ocorreu de várias formas. No que concerne à evolução digital, o homem percorreu longo trajeto da pedra lascada ao mundo virtual. Tal fato culminou em um problema físico habitual, ilustrado na imagem, que propicia uma piora na qualidade de vida do usuário, uma vez que");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("a evolução ocorreu e com ela evoluíram as dores de cabeça, o estresse e a falta de atenção à família.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a vida sem computador tornou-se quase inviável, mas se tem diminuído problemas de visão cansada.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a utilização em demasiada do computador tem proporcionado o surgimento de cientistas que apresentam lesão por esforço repetitivo.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("o homem criou o computador, que evoluiu, e hoje opera várias ações antes feitas pelas pessoas, tornando-as sedentárias ou obesas.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("o uso contínuo do computador de forma inadequada tem ocasionado má postura corporal.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.e;
        }
        if (question == 39) {
            texto1TextView.setText("");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.port2011d2q133e134);
            texto3TextView.setText("O argumento presente na charge consiste em uma metáfora relativa à teoria evolucionista e ao desenvolvimento tecnológico. Considerando o contexto apresentado, verifica-se que o impacto tecnológico pode ocasionar");
            figura2ImageView.setImageResource(R.drawable.nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("o surgimento de um homem dependente de um novo modelo tecnológico.");
            fa1.setImageResource(R.drawable.nulo);
            textob1TextView.setText("a mudança do homem em razão dos novos inventos que destroem sua realidade.");
            fb1.setImageResource(R.drawable.nulo);
            textoc1TextView.setText("a problemática social de grande exclusão digital a partir da interferência da máquina.");
            fc1.setImageResource(R.drawable.nulo);
            textod1TextView.setText("a invenção de equipamentos que dificultam o trabalho do homem, em sua esfera social.");
            fd1.setImageResource(R.drawable.nulo);
            textoe1TextView.setText("a invenção de equipamentos que dificultam o trabalho do homem, em sua esfera social.");
            fe1.setImageResource(R.drawable.nulo);
            video = "";
            alt = R.id.a;
        }
        if (question == 40) {
            texto1TextView.setText("O que é possível dizer em 140 caracteres?\n\nSucesso do Twitter no Brasil é oportunidade única de compreender a importância da concisão nos gêneros de escrita A máxima “menos é mais” nunca fez tanto sentido como no caso do microblog Twitter, cuja premissa é dizer algo — não importa o quê — em 140 caracteres. Desde que o serviço foi criado, em 2006, o número de usuários da ferramenta é cada vez maior, assim como a diversidade de usos que se faz dela. Do estilo “querido diário” à literatura concisa, passando por aforismo, citações, jornalismo, fofoca, humor etc., tudo ganha o espaço de um tweet (“pio” em inglês), e entender seu sucesso pode indicar um caminho para o aprimoramentode um recurso vital à escrita: a concisão.");
            texto2TextView.setText("");
            figura1ImageView.setImageResource(R.drawable.nulo);
            texto3TextView.setText("O Twitter se presta a diversas finalidades, entre elas, à comunicação concisa, por isso essa rede social");
            figura2ImageView.setImageResource(R.drawable. nulo);
            texto4TextView.setText("");

            textoa1TextView.setText("é um recurso elitizado, cujo público precisa dominar a língua padrão.");
            fa1.setImageResource(R.drawable. nulo);
            textob1TextView.setText("constitui recurso próprio para a aquisição da modalidade escrita da língua.");
            fb1.setImageResource(R.drawable. nulo);
            textoc1TextView.setText("é restrita à divulgação de textos curtos e pouco significativos e, portanto, é pouco útil.");
            fc1.setImageResource(R.drawable. nulo);
            textod1TextView.setText("interfere negativamente no processo de escrita e acaba por revelar uma cultura pouco reflexiva.");
            fd1.setImageResource(R.drawable. nulo);
            textoe1TextView.setText("estimula a produção de frases com clareza e objetividade, fatores que potencializam a comunicação interativa.");
            fe1.setImageResource(R.drawable. nulo);
            video = "";
            alt = R.id.e;
        }
        return alt;
    }
}

