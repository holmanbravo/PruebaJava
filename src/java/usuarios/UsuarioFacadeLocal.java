/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;


import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);
    Usuario login(Usuario us);
    void edit(Usuario usuario);

    void remove(Usuario usuario);
    
    Usuario buscarPorIdentificacion(String identificacion);
    
    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
}
