package funct;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Classe de Biblioteca <b>FunctDate</b>.</p>
 * <p>Classe responsavel pelas operacoes envolvendo <b>Data</b> e <b>Hora</b>.</p>
 * @author Leandro
 * @since  20/11/2020
 * @see    java.util.Date
 * @see    java.sql.Time
 */
public class FunctDate {
    private final String[] MESES = {"JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", 
                                    "MAIO", "JUNHO", "JULHO", "AGOSTO", 
                                    "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"};
    private final String[] DIAS  = {"DOMINGO", "SEGUNDA-FEIRA", "TERÇA-FEIRA", "QUARTA-FEIRA",
                                    "QUINTA-FEIRA", "SEXTA-FEIRA", "SÁBADO"};
    
    /**
     * Metodo responsavel por retornar a data corrente do Sistema.
     * @return Data corrente do Sistema.
     */
    public Date getCurrentDate() {
        return new Date();
    }
    
    /**
     * Metodo responsavel por retornar a hora corrente do Sistema.
     * @return Hora corrente do Sistema.
     */
    public Time getCurrentTime() {
        return new Time(this.getCurrentDate().getTime());
    }
    
    /**
     * Metodo responsavel por criar um objeto Date no formato "dd/MM/yyyy".
     * @param  string Data em formato "dd/MM/yyyy".
     * @return Objeto Data.
     */
    public Date createDate(String string) {
        try {
            return new Date(new SimpleDateFormat("dd/MM/yyyy").parse(string).getTime());
        } catch (ParseException exception) {}
        return null;
    }
    
    /**
     * Metodo responsavel por criar um objeto Date no formato "dd/MM/yy"
     * @param  string Data em formato "dd/MM/yy".
     * @return Objeto Data.
     */
    public Date createDate2(String string) {
        try {
            return new Date(new SimpleDateFormat("dd/MM/yy").parse(string).getTime());
        } catch (ParseException exception) {}
        return null;
    }
    
    /**
     * Metodo responsavel por criar um objeto Time com os parametros horas, minutos e segundos.
     * @param  hour   Hora (0 - 23).
     * @param  minutes Minuto (0 - 59).
     * @param  seconds Segundo (0 - 59).
     * @return Objeto Time.
     */
    public Time createTime(int hour, int minutes, int seconds) {
        return new Time(hour, minutes, seconds);
    }
    
    /**
     * Metodo responsavel por retornar uma String com a data no formato "dd/MM/yyyy".
     * @param  date Data a ser formatada.
     * @return String no formato "dd/MM/yyyy".
     */
    public String getFormattedDate(Date date) {
        if (date != null)
            return new SimpleDateFormat("dd/MM/yyyy").format(date);
        return "";
    }
    
    
    /**
     * Metodo responsavel por retornar uma String com a data no formato "dd/MM/yy".
     * @param  date  Data a ser formatada.
     * @return String no formato "dd/MM/yy".
     */
    public String getFormattedDate2(Date date) {
        if (date != null)
            return new SimpleDateFormat("dd/MM/yy").format(date);
        return "";
    }
    
    /**
     * Metodo responsavel por retornar uma String com a data no formato "MMyyyy".
     * @param  date Data a ser formatada.
     * @return String no formato "MMyyyy".
     */
    public String getSemestreDate(Date date) {
        if (date != null)
            return new SimpleDateFormat("MMyyyy").format(date);
        return "";
    }
    
    /**
     * Metodo responsavel por retornar uma String com o ano da Data no formato "yyyy".
     * @param  date Data a ser formatada.
     * @return String com o Ano da Data.
     */
    public String getYear(Date date) {
        if (date != null)
            return new SimpleDateFormat("yyyy").format(date);
        return "";
    }
    
    /**
     * Metodo responsavel por retornar um Integer com o Ano da Data.
     * @param  date Data.
     * @return Integer com o Ano da Data.
     */
    public Integer getYearValue(Date date) {
        return Integer.parseInt(getYear(date));
    }
    
    /**
     * Metodo responsavel por retornar uma String com o mes da Data no formato "MM".
     * @param  date Data a ser formatada.
     * @return String com o Mes da Data.
     */
    public String getMonth(Date date) {
        if (date != null)
            return new SimpleDateFormat("MM").format(date);
        return "";
    }
    
    /**
     * Metodo responsavel por retornar uma String com o semestre da Data no formato "SSyyyy".
     * @param  date Data a ser formatada.
     * @return String com o Semestre da Data.
     */
    public String getSemestre(Date date) {
        if (getMonth(date).equals("")) 
            return "";
        int    mes      = Integer.parseInt(getMonth(date));
        String semestre = mes <= 6 ? "01" : "02";
        return semestre + getYear(date);
    }
    
    /**
     * Metodo responsavel por retornar a data por extenso.
     * @param  date Data a ser escrita por extenso.
     * @return String com a Data por extenso.
     */
    public String getDateName(Date date) {
        String string  = getDayName(date.getDay()) + ", ";
               string += date.getDate() + " DE ";
               string += getMonthName(date.getMonth()) + " DE ";
               string += date.getYear();
        return string;
    }
    
    /**
     * Metodo responsavel por retornar o nome do dia por extenso.
     * @param  day Dia da Semana (0 - 6)
     * @return String com nome do dia.
     */
    public String getDayName(Integer day) {
        if (day > -1 && day < 7) 
            return DIAS[day];
        return "";
    }
    
    /**
     * Metodo responsavel por retornar o nome por extenso do mes.
     * @param  month Mes do Ano (0 - 11)
     * @return String com o nome do mes.
     */
    public String getMonthName(Integer month) {
        if (month > -1 && month < 12) 
           return MESES[month];
        return "";
    }
    
    /**
     * Metodo responsavel por retornar uma String com a Data e Hora Atual.
     * @return Data e Hora Atual.
     */
    public String getInfo() {
        return getFormattedDate(new Date()).replace("/", "-") + "-" +
               getCurrentTime().toString().replace(":", "-");
    }
}