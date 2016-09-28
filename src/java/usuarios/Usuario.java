/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import correos.Correosenviado;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Usuario
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByIdentificacion", query = "SELECT u FROM Usuario u WHERE u.identificacion = :identificacion"),
    @NamedQuery(name = "Usuario.findByNombreCompleto", query = "SELECT u FROM Usuario u WHERE u.nombreCompleto = :nombreCompleto")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "idusuario")
    private String idusuario;
    @Size(max = 50)
    @Column(name = "contrasena")
    private String contrasena;
    @Size(max = 30)
    @Column(name = "correo")
    private String correo;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "identificacion")
    private String identificacion;
    @Size(max = 80)
    @Column(name = "nombreCompleto")
    private String nombreCompleto;
    @OneToMany(mappedBy = "destinatario")
    private List<Correosenviado> correosenviadoList;
    @OneToMany(mappedBy = "remitente")
    private List<Correosenviado> correosenviadoList1;

    public Usuario() {
    }

    public Usuario(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @XmlTransient
    public List<Correosenviado> getCorreosenviadoList() {
        return correosenviadoList;
    }

    public void setCorreosenviadoList(List<Correosenviado> correosenviadoList) {
        this.correosenviadoList = correosenviadoList;
    }

    @XmlTransient
    public List<Correosenviado> getCorreosenviadoList1() {
        return correosenviadoList1;
    }

    public void setCorreosenviadoList1(List<Correosenviado> correosenviadoList1) {
        this.correosenviadoList1 = correosenviadoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return correo;
    }

    Object getRolList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
