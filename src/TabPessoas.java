
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.Random;

public class TabPessoas {

    public static final int MAXTAB = 9999;
    Pessoa[] tab = new Pessoa[MAXTAB];
    int size = 0;

    public TabPessoas() {

    }

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
        BufferedReader buffreader;
        Pessoa p;
        int posicao;
        int i = 0;
        int qtd_col = 0;
        int qtd_inst = 0;

        try {
            buffreader = new BufferedReader(new FileReader(nomearq));
            String entrada, reg[];
            while ((entrada = buffreader.readLine()) != null) {

                reg = entrada.split("\\s*,\\s*");
                p = new Pessoa();
                p.setNome(reg[0]);
                p.setFone(reg[1]);
                p.setCidade(reg[2]);
                p.setPais(reg[3]);
                posicao = h(p.getNome());
                if (this.tab[posicao] != null) {
//                    System.out.println("Houve uma colisão na posição " + posicao);
                    qtd_col++;
                } else {
                    qtd_inst++;
                    this.tab[posicao] = p;
                    i++;
                }
            }
            this.size = i;
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado");
            //e.printStackTrace();
        }
        
        System.out.println("Quantidade de colisões: " + qtd_col);
        System.out.println("Quantidade de inserções: " + qtd_inst);
        System.out.println("Percentual de colisões: " + ((float ) qtd_col/(qtd_col + qtd_inst) * 100.0) + "%");
    }

    /**
     * mostra o conteudo da tabela no console
     */
    public void dump() {
        int i;
        for (i = 0; i < TabPessoas.MAXTAB; i++) {
            if (this.tab[i] != null) {
                System.out.println("Registro inserido na posição " + i);
                this.tab[i].imprime();
            }
        }
    }
}
