package arquivo.exportacao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import modelo.dao.estoque.DaoItem;
import modelo.entidade.estoque.Item;

/**
 * <p>Classe de Exportacao <b>ExportItem</b>.</p>
 * <p>Classe responsavel pela <b>Exportacao dos Dados do Item</b> do Sistema.</p>
 * @author Leandro
 * @since  15/01/2021
 * @see    modelo.dao.estoque.DaoItem
 * @see    modelo.entidade.estoque.Item
 */
public class ExportItem {
    private FileWriter file;
    private PrintWriter writer;
    private DaoItem dao;
    
    /**
     * Metodo responsavel por Criar o Arquivo de Exportacao.
     * @throws IOException Excecao na Criacao do Arquivo.
     */
    private void createFile() throws IOException {
        String path   = "src/arquivo/exportacao/itens.txt";
               file   = new FileWriter(path);
               writer = new PrintWriter(file);
    }
    
    /**
     * Metodo responsavel por escrever os Registros do Arquivo de Importacao.
     * @throws IOException Excecao na Leitura do Arquivo.
     */
    public void writeItens() throws IOException {
        createFile();
        dao = new DaoItem();
        for (Item item : dao.select())
            writer.println(item.getToken());
        closeFile();
    }
    
    /**
     * Metodo responsavel por Fechar o Arquivo de Exportacao.
     * @throws IOException Excecao no Fechamento do Arquivo.
     */
    private void closeFile() throws IOException {
        writer.close();
        file.close();
    }
    
    /*
    public static void main(String[] args) {
        ExportItem importProdutos = new ExportItem();
        try {
            importProdutos.writeItens();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }*/
}