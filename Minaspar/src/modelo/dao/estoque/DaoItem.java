package modelo.dao.estoque;

import java.util.List;
import javax.persistence.Query;
import modelo.dao.Dao;
import modelo.entidade.estoque.Item;
import modelo.entidade.estoque.Produto;

/**
 * <p>Classe de Persistencia <b>DaoItem</b>.</p>
 * <p>Classe responsavel por pela ligacao entre o BD e a Classe de Entidade <b>Item</b>.</p>
 * @author Leandro
 * @since  12/01/2021
 * @see    modelo.dao.Dao
 * @see    modelo.entidade.estoque.Item
 */
public class DaoItem extends Dao<Item> {
    private final DaoProduto dao;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public DaoItem() {
        super(Item.class);
        dao = new DaoProduto();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Itens do Produto. 
     * @param  produto Produto.
     * @return Lista de Itens do Produto.
     */
    public List<Item> find(Produto produto) {
        String script = "SELECT e FROM " + name + " e WHERE e.produto = :produto ORDER BY e.ano, e.produto.tipo, e.produto.descricao";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("produto", produto);
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Itens pelo Ano de Referencia. 
     * @param  ano Ano de Referencia.
     * @return Lista de Itens pelo Ano de Referencia.
     */
    public List<Item> find(Integer ano) {
        String script = "SELECT e FROM " + name + " e WHERE e.ano = :ano ORDER BY e.produto.tipo, e.produto.descricao";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("ano", ano);
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Entradas por Produto e Ano de Referencia.
     * @param  ano Ano de Referencia.
     * @param  produto Produto.
     * @return Lista de Itens filtrados.
     */
    public List<Item> filter(Integer ano, String produto) {
        String script = "SELECT e FROM " + name + " e WHERE e.ano = :ano AND (e.produto.descricao LIKE :produto OR e.produto.codigoBarras LIKE :produto) ORDER BY e.ano, e.produto.tipo, e.produto.descricao";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("ano", ano);
               query.setParameter("produto", "%" + produto + "%");
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Entradas por Produto, Ano de Referencia e Tipo.
     * @param  ano Ano de Referencia.
     * @param  tipo Tipo do Produto.
     * @param  produto Produto.
     * @return Lista de Itens filtrados.
     */
    public List<Item> filter(Integer ano, String tipo, String produto) {
        String script = "SELECT e FROM " + name + " e WHERE e.ano = :ano AND e.produto.tipo = :tipo AND (e.produto.descricao LIKE :produto OR e.produto.codigoBarras LIKE :produto) ORDER BY e.ano, e.produto.tipo, e.produto.descricao";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("ano", ano);
               query.setParameter("tipo", tipo);
               query.setParameter("produto", "%" + produto + "%");
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por remover a Lista de Itens do Produto.
     * @param produto Produto.
     */
    public void delete(Produto produto) {
        for (Item item : find(produto))
            delete(item.getId());
    }
}