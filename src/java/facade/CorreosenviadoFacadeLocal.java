/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import correos.Correosenviado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface CorreosenviadoFacadeLocal {

    void create(Correosenviado correosenviado);

    void edit(Correosenviado correosenviado);

    void remove(Correosenviado correosenviado);

    Correosenviado find(Object id);

    List<Correosenviado> findAll();

    List<Correosenviado> findRange(int[] range);

    int count();
    
}
