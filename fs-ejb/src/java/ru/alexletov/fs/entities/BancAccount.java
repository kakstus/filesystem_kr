/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alexletov.fs.entities;

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
 * @author Максим
 */
@Entity
@Table(name = "banc_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BancAccount.findAll", query = "SELECT b FROM BancAccount b"),
    @NamedQuery(name = "BancAccount.findById", query = "SELECT b FROM BancAccount b WHERE b.id = :id"),
    @NamedQuery(name = "BancAccount.findByCreateDate", query = "SELECT b FROM BancAccount b WHERE b.createDate = :createDate"),
    @NamedQuery(name = "BancAccount.findByStatus", query = "SELECT b FROM BancAccount b WHERE b.status = :status"),
    @NamedQuery(name = "BancAccount.findByAmount", query = "SELECT b FROM BancAccount b WHERE b.amount = :amount")})
public class BancAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "status")
    private Integer status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idClient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAccountF")
    private Collection<Operations> operationsCollection;

    public BancAccount() {
    }

    public BancAccount(Integer id) {
        this.id = id;
    }

    public BancAccount(Integer id, Date createDate, int amount) {
        this.id = id;
        this.createDate = createDate;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getIdClient() {
        return idClient;
    }

    public void setIdClient(User idClient) {
        this.idClient = idClient;
    }

    @XmlTransient
    public Collection<Operations> getOperationsCollection() {
        return operationsCollection;
    }

    public void setOperationsCollection(Collection<Operations> operationsCollection) {
        this.operationsCollection = operationsCollection;
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
        if (!(object instanceof BancAccount)) {
            return false;
        }
        BancAccount other = (BancAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.alexletov.fs.entities.BancAccount[ id=" + id + " ]";
    }
    
}
