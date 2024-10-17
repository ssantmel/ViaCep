import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {


        Scanner leitura  =  new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        System.out.println("Digite seu CEP: ");
        var sep = leitura.nextLine();

        try {
            Endereco novoEndereco = consultaCep.buscaEndereço("09781500");
            System.out.println(novoEndereco);
            GeradorDeArquivos gerador = new GeradorDeArquivos();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("finalizar a aplicação");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}