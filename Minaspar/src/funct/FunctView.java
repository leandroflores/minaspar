package funct;

import javax.swing.ImageIcon;

/**
 * <p>Classe de Biblioteca <b>FunctView</b>.</p>
 * <p>Classe responsavel pelas operacoes envolvendo <b>Views</b> e <b>Images</b>.</p>
 * @author Leandro
 * @since  12/12/2020
 * @see    javax.swing.ImageIcon
 */
public class FunctView {
    private static final String DIRETORIO = "/imagens/";
    
    /**
     * Metodo responsavel por retornar uma ImageIcon pela sua URL.
     * @param   urlImage URL da Imagem.
     * @return  Nova ImageIcon.
     */
    public ImageIcon createImage(String urlImage) {
         return new ImageIcon(getClass().getResource(DIRETORIO + urlImage + ".png"));
    }
}