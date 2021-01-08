package funct;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * <p>Classe de Biblioteca <b>FunctString</b>.</p>
 * <p>Classe responsavel pelas operacoes envolvendo <b>String</b>.</p>
 * @author Leandro
 * @since  20/11/2020
 * @see    java.lang.String
 */
public class FunctString {
    
    /**
     * Metodo responsavel por retornar uma String com um determinado tamanho contendo o char.
     * @param  character Caractere do Conteudo.
     * @param  size Tamanho da String.
     * @return String composta pelo caracter.
     */
    public String getString(Character character, Integer size) {
        return size > 0 ? new String(new char[size]).replaceAll("\0", Character.toString(character)) : "";
    }
    
    /**
     * Metodo responsavel por retornar uma String contendo espacos.
     * @param  size Tamanho esperado.
     * @return String contendo espaços.
     */
    public String getEspacos(Integer size) {
        return this.getString(' ', size);
    }
    
    /**
     * Metodo responsavel por retornar uma String alinhada a direita.
     * @param  string Cadeia de caracteres inicial.
     * @param  size Tamanho desejado.
     * @return String alinhada a direita.
     */
    public String toRight(String string, Integer size) {
        if (string.length() > size) 
            return string;
        return this.getEspacos(size - string.length()) + string;
    }
    
    /**
     * Metodo responsavel por retornar uma String alinhada a esquerda.
     * @param  string Cadeia de caracteres inicial.
     * @param  size Tamanho desejado.
     * @return String alinhada a esquerda.
     */
    public String toLeft(String string, Integer size) {
        if (string.length() > size) 
            return string;
        return string + this.getEspacos(size - string.length());
    }
    
    /**
     * Metodo responsavel por retornar uma String centralizada.
     * @param  string Cadeia de caracteres inicial.
     * @param  size Tamanho desejado.
     * @return String centralizada.
     */
    public String toCenter(String string, Integer size) {
        if (string.length() > size) 
            return string;
        Integer diff   = size - string.length();
        String  spaces = this.getEspacos(diff / 2);
        String  extra  = diff % 2 == 0 ? "" : " ";
        return  spaces + string + spaces + extra;
    }
    
    /**
     * Metodo responsavel por retornar o numero de vezes que um char aparece em uma String.
     * @param  string String a ser percorrida.
     * @param  character Caracter a ser contado.
     * @return Quantidade de Char na String.
     */
    public Long countChar(String string, Character character) {
        return string.codePoints().filter(current -> current == character).count();
    }
    
    /**
     * Metodo responsavel por retornar a String em ordem inversa.
     * @param  string Cadeia de caracteres inicial.
     * @return String em ordem inversa.
     */
    public String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }
    
    /**
     * Metodo responsavel por retornar uma String com o primeiro char maiusculo.
     * @param  string String inicial.
     * @return String com o primeiro char maiusculo.
     */
    public String initUpperCase(String string) {
        if (string.length() == 0) 
            return "";
        return   string.substring(0, 1).toUpperCase() 
               + string.substring(1).toLowerCase();
    }
    
    /**
     * Metodo responsavel por retornar as iniciais maiusculas de uma String.
     * @param  string String inicial.
     * @return String com as iniciais maiusculas.
     */
    public String getInitUpperCase(String string) {
        String upper  = "";
        for (String current : string.split(" "))
               upper += initUpperCase(current) + " ";
        return upper.trim();
    }
    
    /**
     * Metodo responsavel por retornar uma String apenas com os numeros da String passada como parametro.
     * @param  string String inicial.
     * @return String apenas com os numeros.
     */
    public String getNumeros(String string) {
        return string.replaceAll("\\D+", "");
    }
    
    /**
     * Metodo responsavel por remover os caracteres especiais de uma String.
     * @param  string String inicial.
     * @return String sem caracteres especiais.
     */
    public String removeCharEspeciais(String string) {
        String  normalized = Normalizer.normalize(string, Normalizer.Form.NFD);
        Pattern pattern    = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return  pattern.matcher(normalized).replaceAll("");
    }
    
    /**
     * Metodo responsavel por retornar uma String criptografada pelo algoritmo MD5.
     * @param  string String inicial.
     * @return String criptografada pelo algoritmo MD5.
     */
    public String md5(String string) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
                          digest.update(string.getBytes(), 0, string.length());
            return new BigInteger(1, digest.digest()).toString(16);
        }catch (NoSuchAlgorithmException exception) {
            return null;
        }
    }
}