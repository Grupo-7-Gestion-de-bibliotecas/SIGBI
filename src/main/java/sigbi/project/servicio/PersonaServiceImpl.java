
package sigbi.project.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sigbi.project.domain.Usuarios;
import sigbi.project.dao.UsuarioDAO;

@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private UsuarioDAO personaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Usuarios> listarPersonas() {
        return (List<Usuarios>) personaDao.findAll();
        
    }

    @Override
    @Transactional
    public void guardar(Usuarios persona) {
        personaDao.save(persona);
        
        }

    @Override
    @Transactional
    public void eliminar(Usuarios persona)  {
        personaDao.delete(persona);
    }


    @Override
    @Transactional(readOnly=true)
    public Usuarios encontrarPersona(Usuarios persona) {
        
        return personaDao.findById(persona.getUsuario_id()).orElse(null);
    }
    
}
