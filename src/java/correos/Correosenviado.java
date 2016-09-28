/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correos;

import usuarios.Usuario;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "correosenviado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correosenviado.findAll", query = "SELECT c FROM Correosenviado c"),
    @NamedQuery(name = "Correosenviado.findByIdCorreo", query = "SELECT c FROM Correosenviado c WHERE c.idCorreo = :idCorreo"),
    @NamedQuery(name = "Correosenviado.findByAsunto", query = "SELECT c FROM Correosenviado c WHERE c.asunto = :asunto"),
    @NamedQuery(name = "Correosenviado.findByMensaje", query = "SELECT c FROM Correosenviado c WHERE c.mensaje = :mensaje")})
public class Correosenviado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCorreo")
    private Integer idCorreo;
    @Size(max = 50)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 800)
    @Column(name = "mensaje")
    private String mensaje;
    @JoinColumn(name = "destinatario", referencedColumnName = "identificacion")
    @ManyToOne
    private Usuario destinatario;
    @JoinColumn(name = "remitente", referencedColumnName = "identificacion")
    @ManyToOne
    private Usuario remitente;

    public Correosenviado() {
    }

    public Correosenviado(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public Integer getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorreo != null ? idCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correosenviado)) {
            return false;
        }
        Correosenviado other = (Correosenviado) object;
        if ((this.idCorreo == null && other.idCorreo != null) || (this.idCorreo != null && !this.idCorreo.equals(other.idCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Correosenviado[ idCorreo=" + idCorreo + " ]";
    }
    
}
