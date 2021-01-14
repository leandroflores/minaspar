package modelo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * <p>Classe de Persistencia <b>Dao</b>.</p>
 * <p>Classe responsavel por definir as operacoes envolvendo o <b>Banco de Dados</b>.</p>
 * @author Leandro
 * @since  02/12/2018
 * @param  <Entity> Classe de Entidade.
 */
public class Dao<Entity> {
    protected static final EntityManager MANAGER = Persistence.createEntityManagerFactory("UP").createEntityManager();
    protected static final Integer MAX = 5000;
    protected final Class  class_;
    protected final String name;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param class_ Classe de Persistencia.
     */
    public Dao(Class class_) {
        this.class_ = class_;
        this.name   = class_.getSimpleName();
    }
    
    /**
     * Metodo responsavel por inserir um Objeto no Banco de Dados.
     * @param  object Objeto a ser Inserido.
     * @return Objeto foi inserido.
     */
    public boolean insert(Entity object) {
        if (object != null) {
            MANAGER.getTransaction().begin();
                MANAGER.persist(object);
            MANAGER.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    /**
     * Metodo responsavel por atualizar um Objeto no Banco de Dados.
     * @param  object Objeto a ser Atualizado.
     * @return Objeto foi atualizado.
     */
    public boolean update(Entity object) {
        if (object != null) {
            MANAGER.getTransaction().begin();
                MANAGER.merge(object);
            MANAGER.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    /**
     * Metodo responsavel por remover um Objeto no Banco de Dados.
     * @param  id Chave Primaria do Objeto.
     * @return Objeto foi removido.
     */
    public boolean delete(Long id) {
        Entity object = get(id);
        if (object != null) {
            MANAGER.getTransaction().begin();
                MANAGER.remove(object);
            MANAGER.getTransaction().commit();
            return true;
        }
        return false;
    }
    
    /**
     * Metodo responsavel por encontrar um Objeto no Banco de Dados pelo seu Id. 
     * @param  id Chave Primaria do Objeto.
     * @return Objeto Encontrado.
     */
    public Entity get(Object id) {
        return (Entity) MANAGER.find(class_, id);
    }
    
    /**
     * Metodo responsavel por retornar o Primeiro Objeto da Query List.
     * @param  list Lista da Query.
     * @return Primeiro Objeto da Query List.
     */
    protected Entity get(List list) {
        return list.isEmpty() ? null : (Entity) list.get(0);
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Objetos do Banco de Dados.
     * @return Lista de Objetos encontrados.
     */
    public List<Entity> select() {
        return (List<Entity>) MANAGER.createQuery("SELECT e FROM " + name + " e").setMaxResults(MAX).getResultList();
    }
    
    /**
     * Metodo responsavel por retornar uma Lista de Objetos pela Condicao.
     * @param  query Condicao do WHERE.
     * @return Lista de Objetos encontrados.
     */
    public List<Entity> query(String query) {
        String script = "SELECT e FROM " + name + " e WHERE " + query;
        return (List) MANAGER.createQuery(script).setMaxResults(MAX).getResultList();
    }
}