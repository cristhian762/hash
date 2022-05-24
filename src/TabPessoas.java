
import java.io.BufferedReader;
import java.io.FileReader;

public class TabPessoas {

    public static final int MAXTAB = 2999;
    Pessoa[] tab = new Pessoa[MAXTAB];
    int size = 0;

    public TabPessoas() {

    }

    /**
     * Fun��o h retorna a posi��o para inserir o registro na tabela hash
     *
     * @param s
     * @return
     */
    public int h(String s) {

        int i, soma = 0;
        for (i = 0; i < s.length(); i++) {
            soma += (int) s.charAt(i);

        }
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
                    System.out.println("Houve uma colisão na posição " + posicao);
                } else {
                    this.tab[posicao] = p;
                    i++;
                }
            }
            this.size = i;
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado");
            //e.printStackTrace();
        }
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
