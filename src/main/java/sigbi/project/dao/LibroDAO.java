
package sigbi.project.dao;



import org.springframework.data.repository.CrudRepository;
import sigbi.project.domain.Books;


   
public interface LibroDAO extends CrudRepository<Books,Long> {
    
}
