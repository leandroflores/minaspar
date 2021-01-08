package visao.interfaces;

/**
 * <p>Interface <b>Viewable</b>.</p>
 * <p>Interface responsavel por descrever as <b>Operacoes Padroes</b> para as Views do SGBov.</p>
 * @author Leandro
 * @since  15/12/2020
 */
public interface Viewable {
    
    /**
     * Metodo responsavel por definir as Propriedades da View.
     */
    public void setProperties();
     
    /**
     * Metodo responsavel por adicionar os Componentes da View.
     */
    public void addComponents();
    
    /**
     * Metodo responsavel por adicionar o Cabecalho da View.
     */
    public void addHeader();
    
    /**
     * Metodo responsavel por adicionar o Corpo Principal da View.
     */
    public void addBody();
    
    /**
     * Metodo responsavel por adicionar o Rodape da View.
     */
    public void addFooter();
}