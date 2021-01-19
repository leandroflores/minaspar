package arquivo.relatorio.balanco;

import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import arquivo.relatorio.Relatorio;

/**
 * <p>Classe de Arquivo <b>RelatorioBalanco</b>.</p>
 * <p>Classe responsavel por definir o <b>Relatorio do Balanco</b>.</p>
 * @author Leandro
 * @since  15/01/2021
 * @see    arquivo.relatorio.Relatorio
 */
public class RelatorioBalanco extends Relatorio {
    
    @Override
    public void create() throws JRException, SQLException {
        setNome("balanco/balanco.jrxml");
        show();
    }
}