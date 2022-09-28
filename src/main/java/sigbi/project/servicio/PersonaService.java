
package sigbi.project.servicio;

import java.util.List;
import sigbi.project.domain.Usuarios;


public interface PersonaService {
    
    public List<Usuarios> listarPersonas();
    
    public void guardar (Usuarios personas);
    
    public void eliminar (Usuarios personas);
    
    public Usuarios encontrarPersona(Usuarios personas);
    
}
