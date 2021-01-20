package arquivo.relatorio.produto;

import arquivo.relatorio.Relatorio;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 * <p>Classe de Arquivo <b>RelatorioProduto</b>.</p>
 * <p>Classe responsavel por definir o <b>Relatorio do Produto</b>.</p>
 * @author Leandro
 * @since  19/01/2021
 * @see    arquivo.relatorio.Relatorio
 */
public class RelatorioProduto extends Relatorio {
    private final Long produto;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param produto Id do Produto.
     */
    public RelatorioProduto(Long produto) {
        super();
        this.produto = produto;
    }
    
    @Override
    public void create() throws JRException, SQLException {
        titulo = "Relatório de Produto";
        nome   = "produto/ficha_produto.jrxml";
        parametros.put("produto", produto);
        show();
    }
}