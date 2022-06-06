
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.LinkedList;

public class TabDicionario {

    public static final int MAXTAB = 990000;
    Dicionario[] tab = new Dicionario[MAXTAB];
    int size = 0;

    /**
     * Função h retorna a posição para inserir o registro na tabela hash
     *
     * @param s
     * @return
     */
    public int h(String s) {
        LocalTime time = LocalTime.now();

        int soma = 0;
        
        for (int i = 0; i < s.length(); i++) {
            soma += (int) s.charAt(i);
        }
        
        soma += (int) time.toString().charAt(time.toString().length() - 1);

        return soma % MAXTAB;
    }

    /**
     * Carrega um arquivo na tabela
     *
     * @param nomearq
     */
    public void load(String nomearq) {
        LinkedList<Dicionario> listDic = new LinkedList<>();
        
        BufferedReader buffreader;
        Dicionario d;
        
        int posicao;
        int i = 0;
        int qtd_col = 0;
        int qtd_inst = 0;


        try {
            buffreader = new BufferedReader(new InputStreamReader( new FileInputStream(nomearq), "UTF-16"));
            String entrada;

            while ((entrada = buffreader.readLine()) != null) {

                d = new Dicionario();
                d.setPalavra(entrada);
                
                posicao = h(entrada);

                try{
                    listDic.get(0).imprime();
                    qtd_col++;

                } catch (Exception e) {
                    qtd_inst++;
                    listDic.add(posicao, d);
                    i++;
                }
            }

            this.size = i;
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado");
        }
        
        System.out.println("Quantidade de colisões: " + qtd_col);
        System.out.println("Quantidade de inserções: " + qtd_inst);
        System.out.println("Percentual de colisões: " + ((float ) qtd_col/(qtd_col + qtd_inst) * 100.0) + "%");
    }

    public void dump() {
        int i;
        for (i = 0; i < TabDicionario.MAXTAB; i++) {
            if (this.tab[i] != null) {
                System.out.println("Registro inserido na posição " + i);
                this.tab[i].imprime();
            }
        }
    }
}
