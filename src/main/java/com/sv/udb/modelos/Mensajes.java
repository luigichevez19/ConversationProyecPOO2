/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "mensajes", catalog = "proyecto_poo2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m")
    , @NamedQuery(name = "Mensajes.findByIdMens", query = "SELECT m FROM Mensajes m WHERE m.idMens = :idMens")
    , @NamedQuery(name = "Mensajes.findByFecha", query = "SELECT m FROM Mensajes m WHERE m.fecha = :fecha")})
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mens")
    private Integer idMens;
    @Basic(optional = false)
   @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "mens")
    private String mens;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_conv", referencedColumnName = "id_conv")
    @ManyToOne(optional = false)
    private Conversacion idConv;
    @JoinColumn(name = "id_usua", referencedColumnName = "id_usua")
    @ManyToOne(optional = false)
    private Usuario idUsua;

    public Mensajes() {
    }

    public Mensajes(Integer idMens) {
        this.idMens = idMens;
    }

    public Mensajes(Integer idMens, String mens, Date fecha) {
        this.idMens = idMens;
        this.mens = mens;
        this.fecha = fecha;
    }

    public Integer getIdMens() {
        return idMens;
    }

    public void setIdMens(Integer idMens) {
        this.idMens = idMens;
    }

    public String getMens() {
        return mens;
    }

    public void setMens(String mens) {
        this.mens = mens;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Conversacion getIdConv() {
        return idConv;
    }

    public void setIdConv(Conversacion idConv) {
        this.idConv = idConv;
    }

    public Usuario getIdUsua() {
        return idUsua;
    }

    public void setIdUsua(Usuario idUsua) {
        this.idUsua = idUsua;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMens != null ? idMens.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.idMens == null && other.idMens != null) || (this.idMens != null && !this.idMens.equals(other.idMens))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Mensajes[ idMens=" + idMens + " ]";
    }
    
}
