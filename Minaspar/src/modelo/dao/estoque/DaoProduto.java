package modelo.dao.estoque;

import java.util.List;
import javax.persistence.Query;
import modelo.dao.Dao;
import modelo.entidade.estoque.Produto;

/**
 * <p>Classe de Persistencia <b>DaoProduto</b>.</p>
 * <p>Classe responsavel por pela ligacao entre o BD e a Classe de Entidade <b>Produto</b>.</p>
 * @author Leandro
 * @since  12/01/2021
 * @see    modelo.dao.Dao
 * @see    modelo.entidade.estoque.Produto
 */
public class DaoProduto extends Dao<Produto> {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public DaoProduto() {
        super(Produto.class);
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Produtos pelo Nome.
     * @param  pesquisa Valor da Pesquisa.
     * @return Lista de Produtos filtrados.
     */
    public List<Produto> filter(String pesquisa) {
        String script = "SELECT e FROM " + name + " e WHERE (e.descricao LIKE :pesquisa OR e.codigoBarras LIKE :pesquisa) AND e.ativo=true ORDER BY e.tipo, e.descricao";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("pesquisa", "%" + pesquisa + "%");
               query.setMaxResults(MAX);
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Produtos pela Descricao e Tipo.
     * @param  pesquisa Valor da Pesquisa.
     * @param  tipo Tipo do Produto.
     * @return Lista de Produtos filtrados.
     */
    public List<Produto> filter(String pesquisa, String tipo) {
        String script = "SELECT e FROM " + name + " e WHERE (e.descricao LIKE :pesquisa OR e.codigoBarras LIKE :pesquisa) AND e.tipo LIKE :tipo AND e.ativo=true ORDER BY e.tipo, e.descricao";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("pesquisa", "%" + pesquisa + "%");
               query.setParameter("tipo",     "%" + tipo     + "%");
               query.setMaxResults(MAX);
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Produtos pelo Codigo de Barras.
     * @param  pesquisa Valor da Pesquisa.
     * @return Lista de Produtos filtrados.
     */
    public List<Produto> filterCodigoBarras(String pesquisa) {
        String script = "SELECT e FROM " + name + " e WHERE e.codigoBarras LIKE :pesquisa AND e.ativo=true ORDER BY e.tipo, e.descricao";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("pesquisa", "%" + pesquisa + "%");
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar o Produto pelo Codigo de Barras.
     * @param  codigo Codigo de Barras do Produto.
     * @return Produto encontrado.
     */
    public Produto find(String codigo) {
        String script = "SELECT e FROM " + name + " e WHERE e.codigoBarras LIKE :codigo";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("codigo", codigo);
        return get(query);
    }
}