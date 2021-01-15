package arquivo.importacao;

import funct.FunctDate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import modelo.dao.estoque.DaoItem;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Item;
import modelo.entidade.estoque.Produto;

/**
 * <p>Classe de Importacao <b>ImportItem</b>.</p>
 * <p>Classe responsavel pela <b>Importacao dos Dados do Item</b> do Sistema.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Item
 */
public class ImportItem {
    private DaoItem dao;
    private FileReader file;
    private BufferedReader buffer;
    
    /**
     * Metodo responsavel por abrir o Arquivo de Importacao.
     */
    private void openFile() throws FileNotFoundException {
        String path   = "src/arquivo/itens.txt";
               file   = new FileReader(path);
               buffer = new BufferedReader(file);
    }
    
    /**
     * Metodo responsavel por ler os Registros do Arquivo de Importacao.
     * @throws FileNotFoundException Excecao na Abertura do Arquivo.
     * @throws IOException Excecao na Leitura do Arquivo.
     */
    public void readLines() throws FileNotFoundException, IOException {
        openFile();
        dao = new DaoItem();
        
        String line  = buffer.readLine();
        while (line != null) {
            importItem(line);
            line = buffer.readLine();
        }
        
        closeFile();
    }
    
    /**
     * Metodo responsavel por Importar o Item descrito na Linha.
     * @param line Linha importada do Arquivo.
     */
    private void importItem(String line) {
        if (!line.equals("") && line.contains("|")) {
            String[] values  = line.split("|");
            Produto  produto = new DaoProduto().find(values[1]);
            if (produto  != null) {
                Item item = new Item();
                     item.setProduto(produto);
                     item.setAno(Integer.parseInt(values[0]));
                     item.setQuantidade(Integer.parseInt(values[2]));
                     item.setValorUnitario(Float.parseFloat(values[3]));
                     item.setValorTotal(Float.parseFloat(values[4]));
                     item.setDataCadastro(new FunctDate().createDate(values[5]));
                new DaoItem().insert(item);
            }else {
                System.out.println("Cod.: " + values[1]);
            }
        }
    }
    
    /**
     * Metodo responsavel por Fechar o Arquivo de Importacao.
     */
    private void closeFile() throws FileNotFoundException, IOException {
        buffer.close();
        file.close();
    }
    
    /**
     * Metodo principal para a Importacao de Itens no BD.
     * @param args 
     */
    /*
    public static void main(String[] args) {
        ImportProduto importProdutos = new ImportProduto();
        try {
            importProdutos.readLines();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }*/
}