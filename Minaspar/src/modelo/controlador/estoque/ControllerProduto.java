package modelo.controlador.estoque;

import modelo.controlador.ControllerEntidade;

/**
 * <p>Classe de Controle <b>ControllerProduto</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador</b> da Classe de Entidade <b>Produto</b>.</p>
 * @author Leandro
 * @since  13/01/2021
 * @see    modelo.controlador.ControllerEntidade
 * @see    modelo.entidade.estoque.Produto
 */
public class ControllerProduto extends ControllerEntidade {
    
    /**
     * Metodo responsavel por retornar a Lista de Tipos do Produto.
     * @return Lista de Tipos do Produto.
     */
    public String[] getTipos() {
        return new String[]{"MEDICAMENTO", "PERFUMARIA", "OUTROS"};
    }
}