
package sigbi.project.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sigbi.project.domain.Adm;


@Repository
public interface AdminDAO extends JpaRepository<Adm,Long>{

    Adm findByname(String name);
    Adm findBypsw(String psw);
    
    Adm findByNameContainingAndPswContaining(String name,String psw);
    
  

    
    
}

