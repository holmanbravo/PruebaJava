/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;
import com.wellbeing.controladores.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {
    
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private Usuario usuario;
    private int selectedItemUsuario;
    private String redireccion;
    private String identificacionUsuario;



    @PostConstruct    
    public void init() {
        usuario = new Usuario();       
    }
    
        public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

   public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
 public String getRedireccion() {
        return redireccion;
    }

    public void setRedireccion(String redireccion) {
        this.redireccion = redireccion;
    }
   
    public List<Usuario> listarUsuario() {
        return usuarioFacade.findAll();
    }
    
    public Usuario getSelected() {
        if (usuario == null) {
            usuario = new Usuario();
            selectedItemUsuario =-1;
        }
        return usuario;
    }
    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(usuarioFacade.findAll(),false);
    }
    
     public Usuario getUsuario(java.lang.Integer id) {
        return usuarioFacade.find(id);
    }
     
     @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControladorConvertidor implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioControlador controlador = (UsuarioControlador) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioControlador");
            return controlador.getUsuario(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return o.getIdusuario();
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName()+ "; expected type: " + Usuario.class.getName());
            }
        }

      }
     
        public String loguear(){
        
       
        Usuario u = null;
        redireccion = null;
        try {
             
            u = usuarioFacade.login(usuario);
            if (u != null) {
                if ("12".equals(u.getIdusuario())) {

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
                redireccion = "usuarios/creacionDeUsuarios?faces-redirect=true";    
                }else{
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);

                    redireccion = "usuarios/enviarCorreo?faces-redirect=true";
                }                
            } else {
                
                
                }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No se puede iniciar sesión"));
        }
        return redireccion;

    }

    public void crearUsuario(){
        
       
       usuarioFacade.create(usuario);
    
    }
    
    
    public void actualizarDatosUsuario(){
    try {    
    usuarioFacade.edit(usuario);
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización","Se ha actualizado correctamente el registro"));
    }catch(Exception e){
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error","No se pudo actualizar correctamente el registro"));
    }
   
    }
    
       public String consultarUsuarioPorIdentificacion() {
        try {
        this.usuario=(Usuario) usuarioFacade.buscarPorIdentificacion(this.identificacionUsuario);
        
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización","Se ha actualizado correctamente el registro"));
        }catch(Exception e){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error","No se pudo actualizar correctamente el registro"));
        }
        return " ";
        
     }
       
       
      public String borrarUsuario(){
      
          usuarioFacade.remove(usuario);
          
          return "";
       }
    
    
}
     
   