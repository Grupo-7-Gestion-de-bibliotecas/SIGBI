
package sigbi.project.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


// @ Data crea setter and getters
@Data
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;
    
    
    private String usuario_name;
    private String usuario_apellido;
    private String usuario_ocu;
       
    
}
