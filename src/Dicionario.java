public class Dicionario {
    private String palavra;

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void imprime() {
        System.out.println("palavra: " + getPalavra());
    }
}
