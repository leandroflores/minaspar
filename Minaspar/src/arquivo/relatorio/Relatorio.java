package arquivo.relatorio;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * <p>Classe de Arquivo <b>Relatorio</b>.</p>
 * <p>Classe responsavel por definir o Modelo Abstrato para os <b>Relatorios</b> do Sistema.</p>
 * @author Leandro
 * @since  15/01/2021
 */
public abstract class Relatorio {
    protected String titulo;
    protected String nome;
    protected final HashMap parametros;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public Relatorio() {
        parametros = new HashMap();
    }
    
    /**
     * Metodo responsavel por retornar a URL do Relatorio.
     * @return URL do Relatorio.
     */
    protected String getUrl() {
        return "jdbc:mysql://localhost:3306/minaspar_final";
    }
    
    /**
     * Metodo responsavel por retornar o User do Relatorio.
     * @return User do Relatorio.
     */
    protected String getUser() {
        return "root";
    }
    
    /**
     * Metodo responsavel por retornar o Password do Relatorio.
     * @return Password do Relatorio.
     */
    protected String getPassword() {
        return "root";
    }
    
    /**
     * Metodo responsavel por retornar o Folder do Relatorio.
     * @return Folder do Relatorio.
     */
    protected String getFolder() {
        return "/arquivo/jasper/";
    }
    
    /**
     * Metodo responsavel por retornar o Logo do Relatorio.
     * @return Logo do Relatorio.
     */
    public InputStream getLogo() {
        return getClass().getResourceAsStream("/arquivo/relatorio/_logo/logo.png");
    }
    
    /**
     * Metodo responsavel por retornar a Conexao com o Banco de Dados.
     * @return Conexao com o Banco de Dados.
     * @throws SQLException Excecao para Criar a Conexao.
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(getUrl(), getUser(), getPassword());
    }
    
    /**
     * Metodo responsavel por criar o Relatorio.
     * @throws net.sf.jasperreports.engine.JRException
     * @throws java.sql.SQLException
     */
    public abstract void create() throws JRException, SQLException;
    
    /**
     * Metodo responsavel por compilar e mostrar o Relatorio.
     * @throws JRException Erro no Jasper Report.
     * @throws SQLException Erro no comando SQL.
     */
    protected void show() throws JRException, SQLException {
        parametros.put("logo", getLogo());
        InputStream  stream = getClass().getResourceAsStream(getFolder() + nome);
        JasperReport report = JasperCompileManager.compileReport(stream);
	JasperPrint  print  = JasperFillManager.fillReport(report, parametros, getConnection());
        JasperViewer viewer = new JasperViewer(print, false);
                     viewer.setTitle("Minaspar - " + titulo);
                     viewer.setFocusable(true);
                     viewer.setVisible(true);
    }
}