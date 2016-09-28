/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import facade.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "envioCorreosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario login(Usuario us) {
        Usuario usuario=null;
        String consulta;
        try {
            consulta="SELECT u FROM Usuario u WHERE u.correo=?1 AND u.contrasena=?2";
            Query query=em.createQuery(consulta);
            query.setParameter(1, us.getCorreo());
            query.setParameter(2, us.getContrasena());
            List<Usuario> lista=query.getResultList();
            if (!lista.isEmpty()) {
                usuario=lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuario;
}

    @Override
        public Usuario buscarPorIdentificacion(String identificacion){
          
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.identificacion =?1");
        q.setParameter(1, identificacion);
        return (Usuario) q.getResultList().get(0);

    }
        
        
}    
