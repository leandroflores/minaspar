package arquivo.importacao;

import funct.FunctString;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Produto;

/**
 * <p>Classe de Importacao <b>ImportProdutos</b>.</p>
 * <p>Classe responsavel pela <b>Importacao dos Dados do Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  12/01/2021
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Produto
 */
public class ImportProdutos {
    private DaoProduto dao;
    private FileReader file;
    private BufferedReader buffer;
    
    /**
     * Metodo responsavel por abrir o Arquivo de Importacao.
     */
    private void openFiles() throws FileNotFoundException {
        String path   = "src/arquivo/PRODUTOS.txt";
               file   = new FileReader(path);
               buffer = new BufferedReader(file);
    }
    
    /**
     * Metodo responsavel por ler os Registros do Arquivo de Importacao.
     * @throws FileNotFoundException Excecao na Abertura do Arquivo.
     * @throws IOException Excecao na Leitura do Arquivo.
     */
    public void readLines() throws FileNotFoundException, IOException {
        openFiles();
        dao = new DaoProduto();
        
        String line  = buffer.readLine();
        while (line != null) {
            readHeader();
            readProdutos();
            line = buffer.readLine();
        }
    }
    
    /**
     * Metodo responsavel por Ler o Header da Pagina (Fixado em 7 Linhas).
     * @throws IOException 
     */
    private void readHeader() throws IOException {
        for (int i = 1; i <= 7; i++)
            buffer.readLine();
    }
    
    /**
     * Metodo responsavel por Ler os Produtos da Pagina (Fixado em 39 Linhas).
     * @throws IOException 
     */
    private void readProdutos() throws IOException {
        for (int i = 1; i <= 54; i++) {
            //Produto produto = getProduto(buffer.readLine());
            System.out.println(getProduto(buffer.readLine()));
            //dao.insert(produto);
        }
    }
    
    /**
     * Metodo responsavel por retornar o Produto.
     * @param linha Linha com os Dados do Produto.
     * @return Produto.
     */
    private String getProduto(String linha) {
        //Produto produto = new Produto();
        //        produto.setDescricao(new FunctString().removeCharEspeciais(getDescricao(linha)));
        //        produto.setCodigoBarras(getCodigoBarras(linha));
        //        produto.setValorUnitario(getValorUnitario(linha));
        //return  produto;
        return " Codigo     = " + this.getCodigoBarras(linha) 
             + " Descricao  = " + this.getDescricao(linha) 
             + " Valor      = " + this.getValorUnitario(linha);
    }
    
    /**
     * Metodo responsavel por retornar o Codigo de Barras do Produto.
     * @param  linha Linha com os Dados do Produto.
     * @return Codigo de Barras do Produto.
     */
    private String getCodigoBarras(String linha) {
        return linha.substring(7, 22).trim();
    }
    
    /**
     * Metodo responsavel por retornar a Descricao do Produto.
     * @param  linha Linha com os Dados do Produto.
     * @return Descricao do Produto.
     */
    private String getDescricao(String linha) {
        return linha.substring(22, 50).toUpperCase().trim();
    }
    
    /**
     * Metodo responsavel por retornar o Valor Unitario do Produto.
     * @param  linha Linha com os Dados do Produto.
     * @return Valor Unitario do Produto.
     */
    private Float getValorUnitario(String linha) {
        return Float.parseFloat(linha.substring(61, 70).trim());
    }
    
    /**
    public static void main(String[] args) {
        ImportProdutos importProdutos = new ImportProdutos();
        try {
            importProdutos.readLines();
        } catch (IOException ex) {
            Logger.getLogger(ImportProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}