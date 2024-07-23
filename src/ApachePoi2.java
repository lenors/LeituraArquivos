import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePoi2 {
    public static void main(String[] args) throws IOException {
        FileInputStream entrada = new FileInputStream(new File("C:\\Users\\Lenors\\IdeaProjects\\Arquivos\\arquivo_excel.xls"));
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/*Prepara a entrada do arquivo excel para ler*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /*Pegar a primeira Planilha do nosso arquivo excel*/

        Iterator<Row> linhaIterator = planilha.iterator();
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (linhaIterator.hasNext()){ /*Enquanto tiver linha no arquivo excel*/
            Row linha = linhaIterator.next();
            Iterator<Cell> celulas = linha.iterator();
            Pessoa pessoa = new Pessoa();

            while (celulas.hasNext()){/*Percorrer as celular*/
                Cell cell = celulas.next();
                switch (cell.getColumnIndex()){
                    case 0:
                    pessoa.setNome(cell.getStringCellValue());
                    break;
                    case 1:
                        pessoa.setEmail(cell.getStringCellValue());
                        break;
                    case 2:
                        pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                        break;
                }
            }
            pessoas.add(pessoa);

        }
    entrada.close();
        for (Pessoa pessoa : pessoas){
            System.out.println(pessoa);
        }
    }
}