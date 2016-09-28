/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import correos.Correosenviado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class CorreosenviadoFacade extends AbstractFacade<Correosenviado> implements CorreosenviadoFacadeLocal {

    @PersistenceContext(unitName = "envioCorreosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreosenviadoFacade() {
        super(Correosenviado.class);
    }
    
}
