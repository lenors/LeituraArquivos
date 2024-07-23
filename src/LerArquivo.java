import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivo {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream entradaArquivo = new FileInputStream
                (new File("C:\\Users\\Lenors\\IdeaProjects\\Arquivos\\arquivo.txt"));
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Scanner lerARquivo = new Scanner(entradaArquivo, "UTF-8");

        while (lerARquivo.hasNext()){
            String linha = lerARquivo.nextLine();

            if (linha != null && !linha.isEmpty()){

                String[] dados = linha.split("\\;");
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(dados[0]);
                pessoa.setEmail(dados[1]);
                pessoa.setIdade(Integer.parseInt(dados[2]));
                pessoas.add(pessoa);
            }

        }
        System.out.println(pessoas);
    }
}
