
package sigbi.project.servicio;

import java.util.List;
import sigbi.project.domain.Books;



public interface booksService {
    
    public List<Books> listarbooks();
    
    public void guardarbooks (Books libros);
    
    public void eliminarbooks (Books libros);
    
    public Books encontrarboooks(Books libros);
    
}
