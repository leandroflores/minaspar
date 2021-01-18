package arquivo.relatorio.balanco;

import arquivo.relatorio.Relatorio;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;

/**
 * <p>Classe de Arquivo <b>RelatorioBalancoAno</b>.</p>
 * <p>Classe responsavel por definir o <b>Relatorio do Balanco pelo Ano</b>.</p>
 * @author Leandro
 * @since  15/01/2021
 * @see    arquivo.relatorio.Relatorio
 */
public class RelatorioBalancoAno extends Relatorio {
    private final Integer ano;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param ano Ano de Referencia.
     */
    public RelatorioBalancoAno(Integer ano) {
        super();
        this.ano = ano;
    }
    
    @Override
    public void create() throws JRException, SQLException {
        setNome("balanco_ano.jrxml");
        addParametro("ano", ano);
        show();
    }
}