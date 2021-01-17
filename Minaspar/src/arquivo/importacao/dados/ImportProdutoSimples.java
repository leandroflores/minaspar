package arquivo.importacao.dados;

import funct.FunctString;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import modelo.dao.estoque.DaoProduto;
import modelo.entidade.estoque.Produto;

/**
 * <p>Classe de Importacao <b>ImportProdutoSimples</b>.</p>
 * <p>Classe responsavel pela <b>Importacao dos Dados do Produto</b> do Sistema.</p>
 * @author Leandro
 * @since  16/01/2021
 * @see    modelo.dao.estoque.DaoProduto
 * @see    modelo.entidade.estoque.Produto
 */
public class ImportProdutoSimples {
    private DaoProduto dao;
    private FileReader file;
    private BufferedReader buffer;
    
    /**
     * Metodo responsavel por abrir o Arquivo de Importacao.
     */
    private void openFile() throws FileNotFoundException {
        String path   = "src/arquivo/dados/dados_produtos.txt";
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
        dao = new DaoProduto();
        
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
        if (!line.equals("") && line.contains("|") && checkProduto(line))
            dao.insert(getProduto(line));
    }
    
    /**
     * Metodo responsavel por checar se o Produto nao foi inserido.
     * @param  line String com a Linha.
     * @return Codigo de Barras nao inserido no Banco de Dados.
     */
    private boolean checkProduto(String line) {
        return dao.find(line.split("\\|")[0]) == null;
    }
    
    /**
     * Metodo responsavel por retornar o Produto.
     * @param linha Linha com os Dados do Produto.
     * @return Produto.
     */
    private Produto getProduto(String linha) {
        String[] valores = linha.split("\\|");
        Produto  produto = new Produto();
                 produto.setDescricao(new FunctString().removeCharEspeciais(valores[1].toUpperCase().trim()));
                 produto.setCodigoBarras(valores[0].trim());
                 produto.setValorUnitario(Float.parseFloat(valores[2]));
        return   produto;
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
    
    public static void main(String[] args) {
        ImportProdutoSimples import_ = new ImportProdutoSimples();
        try {
            import_.readLines();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}