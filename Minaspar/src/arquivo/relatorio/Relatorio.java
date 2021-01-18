package arquivo.relatorio;

import java.io.File;
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
    private String nome;
    private final HashMap parametros;
    
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
        return "src/arquivo/relatorio/url/jasper/";
    }
    
    /**
     * Metodo responsavel por retornar o Logo do Relatorio.
     * @return Logo do Relatorio.
     */
    public String getLogo() {
        return new File("src/arquivo/relatorio/imagens/logo.png").getAbsolutePath();
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
     * Metodo responsavel por adicionar um Parametro do Relatorio.
     * @param chave Chave do Parametro.
     * @param objeto Objeto do Parametro.
     */
    protected void addParametro(String chave, Object objeto) {
        parametros.put(chave, objeto);
    }
    
    /**
     * Metodo responsavel por definir o Nome do Relatorio.
     * @param nome Nome do Relatorio.
     */
    protected void setNome(String nome) {
        this.nome = nome;
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
        JasperReport report = JasperCompileManager.compileReport(getFolder() + nome);
	JasperPrint  print  = JasperFillManager.fillReport(report, parametros, getConnection());
        JasperViewer.viewReport(print, false);
    }
}