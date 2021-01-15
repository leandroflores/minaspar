package modelo.controlador.estoque;

import java.util.List;
import modelo.controlador.ControllerEntidade;
import modelo.entidade.estoque.Item;

/**
 * <p>Classe de Controle <b>ControllerItem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador</b> da Classe de Entidade <b>Item</b>.</p>
 * @author Leandro
 * @since  14/01/2021
 * @see    modelo.controlador.ControllerEntidade
 * @see    modelo.entidade.estoque.Item
 */
public class ControllerItem extends ControllerEntidade {

    /**
     * Metodo responsavel por retornar o Valor Total de uma Lista de Itens.
     * @param  list Lista de Itens.
     * @return Valor Total de uma Lista de Itens.
     */
    public Float getTotal(List<Item> list) {
        Float  total  = 0.0f;
        for (Item item : list)
               total += item.getValorTotal();
        return total;
    }
}