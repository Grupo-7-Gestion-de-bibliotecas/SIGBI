
package sigbi.project.servicio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sigbi.project.domain.Usuarios;
import sigbi.project.dao.AdminDAO;
import sigbi.project.domain.Adm;


@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDAO adminDAO;
    
    
    @Override
    @Transactional()
    public void guardar(Adm adm) {
        adminDAO.save(adm);
        
    }

    @Override
    @Transactional()
    public void eliminar(Adm adm) {
        
    adminDAO.delete(adm);
    }

 


 
    
 

  }
