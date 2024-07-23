import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoi {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Lenors\\IdeaProjects\\Arquivos\\arquivo_excel.xls");
        if (file.exists()){
            file.createNewFile();
        }
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

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /* Metodo usado para escrever na planilha do excel*/
        HSSFSheet linhaPessoa = hssfWorkbook.createSheet("Planilha de Pessoa JdevTreinamentos");/*Criar a planilha*/
    int numeroLinha = 0;
        for(Pessoa p: pessoas){
        Row linha = linhaPessoa.createRow(numeroLinha++);
        int celula = 0;
            Cell celNome = linha.createCell(celula++);/*Celula 1*/
            celNome.setCellValue(p.getNome());

            Cell celemail = linha.createCell(celula++);/*Celula 2*/
            celemail.setCellValue(p.getEmail());

            Cell celIdade = linha.createCell(celula++);/*Celula 3*/
            celIdade.setCellValue(p.getIdade());

        }
        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();
        System.out.println("Tomara que de certo jesus!!!");
    }
}
