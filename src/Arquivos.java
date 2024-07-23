import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEmail("pessoa1@gmail.com");
        pessoa1.setNome("Leno");
        pessoa1.setIdade(27);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEmail("pessoa2@gmail.com");
        pessoa2.setNome("Rafael");
        pessoa2.setIdade(40);
        Pessoa pessoa3 = new Pessoa();

        pessoa3.setEmail("pessoa3@gmail.com");
        pessoa3.setNome("Alex");
        pessoa3.setIdade(44);

        List<Pessoa> pessoas= new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);



        File arquivo = new File("C:\\Users\\Lenors\\IdeaProjects\\Arquivos\\arquivo.txt");
        if (!arquivo.exists()){
            arquivo.createNewFile();
        }
        FileWriter escrever_no_arquivo = new FileWriter(arquivo);

        escrever_no_arquivo.write("Meu Texto do arquivo");
        escrever_no_arquivo.write("\n");
        escrever_no_arquivo.write("Minha Segunda Linha");

        for (Pessoa pessoa : pessoas){
            escrever_no_arquivo.write(pessoa.getNome() + ";" + pessoa.getEmail() + ";" + pessoa.getIdade() + "\n");

        }
        escrever_no_arquivo.flush();
        escrever_no_arquivo.close();
    }
}
