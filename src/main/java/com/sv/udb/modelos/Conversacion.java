/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "conversacion", catalog = "proyecto_poo2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversacion.findAll", query = "SELECT c FROM Conversacion c")
    , @NamedQuery(name = "Conversacion.findByIdConv", query = "SELECT c FROM Conversacion c WHERE c.idConv = :idConv")
    , @NamedQuery(name = "Conversacion.findByFechInic", query = "SELECT c FROM Conversacion c WHERE c.fechInic = :fechInic")})
public class Conversacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conv")
    private Integer idConv;
    @Basic(optional = false)
    @Column(name = "fech_inic")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechInic;
    @JoinColumn(name = "id_usua_uno", referencedColumnName = "id_usua")
    @ManyToOne(optional = false)
    private Usuario idUsuaUno;
    @JoinColumn(name = "id_usua_dos", referencedColumnName = "id_usua")
    @ManyToOne(optional = false)
    private Usuario idUsuaDos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConv")
    private Collection<Mensajes> mensajesCollection;

    public Conversacion() {
    }

    public Conversacion(Integer idConv) {
        this.idConv = idConv;
    }

    public Conversacion(Integer idConv, Date fechInic) {
        this.idConv = idConv;
        this.fechInic = fechInic;
    }

    public Integer getIdConv() {
        return idConv;
    }

    public void setIdConv(Integer idConv) {
        this.idConv = idConv;
    }

    public Date getFechInic() {
        return fechInic;
    }

    public void setFechInic(Date fechInic) {
        this.fechInic = fechInic;
    }

    public Usuario getIdUsuaUno() {
        return idUsuaUno;
    }

    public void setIdUsuaUno(Usuario idUsuaUno) {
        this.idUsuaUno = idUsuaUno;
    }

    public Usuario getIdUsuaDos() {
        return idUsuaDos;
    }

    public void setIdUsuaDos(Usuario idUsuaDos) {
        this.idUsuaDos = idUsuaDos;
    }

    @XmlTransient
    public Collection<Mensajes> getMensajesCollection() {
        return mensajesCollection;
    }

    public void setMensajesCollection(Collection<Mensajes> mensajesCollection) {
        this.mensajesCollection = mensajesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConv != null ? idConv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversacion)) {
            return false;
        }
        Conversacion other = (Conversacion) object;
        if ((this.idConv == null && other.idConv != null) || (this.idConv != null && !this.idConv.equals(other.idConv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Conversacion[ idConv=" + idConv + " ]";
    }
    
}
