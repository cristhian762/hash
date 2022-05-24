import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Testes {

	public static void teste1() {
		BufferedReader buffreader;
		int i=0;
		String name, nomearq;
		 String firstName;
		 String lastName;
		 String city;
		 String country;
		 String phone, registro;
		 Pessoa p=null;
		 Scanner leitor = new Scanner(System.in);
		 
		System.out.print("Nome do Arquivo de entrada: "); 
		nomearq = leitor.next();  
			try {
				buffreader = new BufferedReader(new FileReader(nomearq));
				String entrada,reg[];
				while((entrada = buffreader.readLine())!=null) {
					reg = entrada.split("\\s*,\\s*");
					p = new Pessoa();
					p.setNome(reg[0]);
					p.setFone(reg[1]);
					p.setCidade(reg[2]);
					p.setPais(reg[3]);
					 p.imprime();
	             }
			}	
			catch(Exception e) {
				System.out.println("Arquivo não encdontrado");
				//e.printStackTrace();
			}
		
				
		
	
	}   


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		teste1();

	}

}
