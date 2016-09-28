/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correos;


import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ismael
 */
@Named(value = "emailController")
@RequestScoped
public class EmailController {

    private Email email;
    private Correosenviado correo;
    private String asunto; 
    private String contenido;
  
    public EmailController() {
        email = new Email();
        correo= new Correosenviado();
    }

    public Correosenviado getCorreo() {
        return correo;
    }

    public void setCorreo(Correosenviado correo) {
        this.correo = correo;
    }
    
        public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    

       
    
    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

   
    public String enviarMensaje(){
        if(email.enviar(asunto,contenido)){
            return "index";
        } else{
            return "error";
        }
    }
}
