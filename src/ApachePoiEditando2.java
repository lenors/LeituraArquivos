import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ApachePoiEditando2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Lenors\\IdeaProjects\\Arquivos\\arquivo_excel.xls");

        FileInputStream entrada = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /*Prepara a entrada do arquivo xls do excel*/

        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);/*pegando a planilha */
        Iterator<Row> linhaIterator = planilha.iterator();

        while (linhaIterator.hasNext()){/*Enquanto tiver linha*/
            Row linha = linhaIterator.next();/*Dados da pessoa na linha*/

         int numeroCelulas = linha.getPhysicalNumberOfCells();
         Cell cell = linha.createCell(numeroCelulas);
         cell.setCellValue("5.478,20");

        }
        entrada.close();
        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("Planilha atualizada");
    }
}
