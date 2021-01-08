package modelo.entidade;

import funct.FunctDate;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

/**
 * <p>Classe de Modelo <b>Entidade</b>.</p>
 * <p>Classe responsavel por definir um modelo para as <b>Classes de Entidade</b>.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    java.io.Serializable
 */
@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    protected Long    id;
    @Column (name = "ativo")
    protected boolean ativo;
    @Column (name = "data_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date    dataCadastro;
    @Column (name = "hora_cadastro")
    protected Time    horaCadastro;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public Entidade() {
        id           = null;
        ativo        = true;
        dataCadastro = new FunctDate().getCurrentDate();
        horaCadastro = new FunctDate().getCurrentTime();
    }
    
    /**
     * Metodo responsavel por retornar o Id da Entidade.
     * @return Id da Entidade.
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo responsavel por definir o Id da Entidade.
     * @param id Id da Entidade.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo responsavel por retornar a Flag Ativo da Entidade.
     * @return Flag Ativo da Entidade.
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Metodo responsavel por definir a Flag Ativo da Entidade.
     * @param ativo Flag Ativo da Entidade.
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    /**
     * Metodo responsavel por retornar a Data de Cadastro da Entidade.
     * @return Data de Cadastro da Entidade.
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * Metodo responsavel por retornar a Data de Cadastro Formatada da Entidade.
     * @return Data de Cadastro Formatada da Entidade.
     */
    public String getDataCadastroFormatada() {
        return new FunctDate().getFormattedDate(dataCadastro);
    }
    
    /**
     * Metodo responsavel por definir a Data de Cadastro da Entidade.
     * @param dataCadastro Data de Cadastro da Entidade.
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * Metodo responsavel por retornar a Hora de Cadastro da Entidade.
     * @return Hora de Cadastro da Entidade.
     */
    public Time getHoraCadastro() {
        return horaCadastro;
    }
    
    /**
     * Metodo responsavel por retornar a Hora de Cadastro Formatada da Entidade.
     * @return Hora de Cadastro Formatada da Entidade.
     */
    public String getHoraCadastroFormatada() {
        return horaCadastro.toString();
    }

    /**
     * Metodo responsavel por definir a Hora de Cadastro da Entidade.
     * @param horaCadastro Hora de Cadastro da Entidade.
     */
    public void setHoraCadastro(Time horaCadastro) {
        this.horaCadastro = horaCadastro;
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Dados de Pesquisa da Entidade.
     * @return Lista de Dados de Pesquisa da Entidade.
     */
    public abstract String[] getDadosPesquisa();
    
    /**
     * Metodo responsavel por retornar a Lista de Dados da Entidade.
     * @return Lista de Dados da Entidade.
     */
    public abstract String[] getDados();

    @Override
    public int hashCode() {
        int    hash  = 0;
               hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object objeto) {
        if (!objeto.getClass().equals(Entidade.class))
            return false;
        return Objects.equals(id, ((Entidade) objeto).getId());
    }
}