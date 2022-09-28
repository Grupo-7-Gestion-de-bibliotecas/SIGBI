
package sigbi.project.dao;

// vamos a crear nuestra clase repositorio va a utilizar objetos de tipo persona

import org.springframework.data.repository.CrudRepository;
import sigbi.project.domain.Usuarios;


public interface UsuarioDAO extends CrudRepository<Usuarios,Long>{
    
       
}
