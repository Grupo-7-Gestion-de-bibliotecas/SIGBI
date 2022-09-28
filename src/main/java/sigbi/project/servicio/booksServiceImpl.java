
package sigbi.project.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sigbi.project.dao.LibroDAO;
import sigbi.project.domain.Books;


@Service
public class booksServiceImpl implements booksService{

    @Autowired
    private LibroDAO libroDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Books> listarbooks() {
        
        return  (List<Books>) libroDao.findAll();
        
    }

    @Override
    @Transactional
    public void guardarbooks(Books libros) {
        libroDao.save(libros);
        
        
    }

    @Override
    @Transactional
    public void eliminarbooks(Books libros) {
        libroDao.delete(libros);
    }

    @Override
    @Transactional(readOnly=true)
    public Books encontrarboooks(Books libros) {
        
      return  libroDao.findById(libros.getBook_id()).orElse(null);
       
    }
    

}
