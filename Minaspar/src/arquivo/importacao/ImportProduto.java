package arquivo.importacao;

import funct.FunctString;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Produto;

/**
 * <p>Classe de Importacao <b>ImportProduto</b>.</p>
 * <p>Classe responsavel pela <b>Importacao dos Dados do Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  12/01/2021
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Produto
 */
public class ImportProduto {
    private DaoProduto dao;
    private FileReader file;
    private BufferedReader buffer;
    
    /**
     * Metodo responsavel por abrir o Arquivo de Importacao.
     */
    private void openFile() throws FileNotFoundException {
        String path   = "src/arquivo/produtos.txt";
               dao    = new DaoProduto();
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
        String line  = buffer.readLine();
        while (line != null) {
            importProduto(line);
            line = buffer.readLine();
        }
        closeFile();
    }
    
    /**
     * Metodo responsavel por Importar o Produto descrito na Linha.
     * @param line Linha importada do Arquivo.
     */
    private void importProduto(String line) {
        if (!line.equals("") && checkProduto(line)) 
            dao.insert(getProduto(line));
    }
    
    /**
     * Metodo responsavel por checar se a Linha inicia com Numeros.
     * @param  line String com a Linha.
     * @return Linha contem um Produto.
     */
    private boolean checkProduto(String line) {
        return Character.isDigit(line.trim().charAt(0));
    }
    
    /**
     * Metodo responsavel por retornar o Produto.
     * @param linha Linha com os Dados do Produto.
     * @return Produto.
     */
    private Produto getProduto(String linha) {
        Produto produto = new Produto();
                produto.setDescricao(new FunctString().removeCharEspeciais(getDescricao(linha)));
                produto.setCodigoBarras(getCodigoBarras(linha));
                produto.setValorUnitario(getValorUnitario(linha));
        return  produto;
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
     * Metodo responsavel por Fechar o Arquivo de Importacao.
     */
    private void closeFile() throws FileNotFoundException, IOException {
        buffer.close();
        file.close();
    }
    
    
    /**
     * Metodo principal para a Importacao de Produtos no BD.
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