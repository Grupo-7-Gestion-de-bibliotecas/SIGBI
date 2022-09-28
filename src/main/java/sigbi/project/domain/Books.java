
package sigbi.project.domain;


import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Books implements Serializable{
    
    private static final long serialVersionUID=1L;
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private Long book_id;
   private  String book_name;
   private String author;
   private String cantidad;
      
    
}
