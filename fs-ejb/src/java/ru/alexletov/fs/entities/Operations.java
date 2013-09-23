/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Максим
 */
@Entity
@Table(name = "operations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operations.findAll", query = "SELECT o FROM Operations o"),
    @NamedQuery(name = "Operations.findById", query = "SELECT o FROM Operations o WHERE o.id = :id"),
    @NamedQuery(name = "Operations.findByCount", query = "SELECT o FROM Operations o WHERE o.count = :count"),
    @NamedQuery(name = "Operations.findByDate", query = "SELECT o FROM Operations o WHERE o.date = :date")})
public class Operations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count")
    private int count;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "id_account_f", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BancAccount idAccountF;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;

    public Operations() {
    }

    public Operations(Integer id) {
        this.id = id;
    }

    public Operations(Integer id, int count, Date date) {
        this.id = id;
        this.count = count;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BancAccount getIdAccountF() {
        return idAccountF;
    }

    public void setIdAccountF(BancAccount idAccountF) {
        this.idAccountF = idAccountF;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operations)) {
            return false;
        }
        Operations other = (Operations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.alexletov.fs.entities.Operations[ id=" + id + " ]";
    }
    
}
