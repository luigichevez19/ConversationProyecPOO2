/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "usuario", catalog = "proyecto_poo2", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsua", query = "SELECT u FROM Usuario u WHERE u.idUsua = :idUsua")
    , @NamedQuery(name = "Usuario.findByUserName", query = "SELECT u FROM Usuario u WHERE u.userName = :userName")
    , @NamedQuery(name = "Usuario.findByContr", query = "SELECT u FROM Usuario u WHERE u.contr = :contr")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usua")
    private Integer idUsua;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "contr")
    private String contr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuaUno")
    private Collection<Conversacion> conversacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuaDos")
    private Collection<Conversacion> conversacionCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsua")
    private Collection<Mensajes> mensajesCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsua) {
        this.idUsua = idUsua;
    }

    public Usuario(Integer idUsua, String userName, String contr) {
        this.idUsua = idUsua;
        this.userName = userName;
        this.contr = contr;
    }

    public Integer getIdUsua() {
        return idUsua;
    }

    public void setIdUsua(Integer idUsua) {
        this.idUsua = idUsua;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContr() {
        return contr;
    }

    public void setContr(String contr) {
        this.contr = contr;
    }

    @XmlTransient
    public Collection<Conversacion> getConversacionCollection() {
        return conversacionCollection;
    }

    public void setConversacionCollection(Collection<Conversacion> conversacionCollection) {
        this.conversacionCollection = conversacionCollection;
    }

    @XmlTransient
    public Collection<Conversacion> getConversacionCollection1() {
        return conversacionCollection1;
    }

    public void setConversacionCollection1(Collection<Conversacion> conversacionCollection1) {
        this.conversacionCollection1 = conversacionCollection1;
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
        hash += (idUsua != null ? idUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsua == null && other.idUsua != null) || (this.idUsua != null && !this.idUsua.equals(other.idUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Usuario[ idUsua=" + idUsua + " ]";
    }
    
}
