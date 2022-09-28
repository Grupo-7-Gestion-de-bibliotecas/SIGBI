package sigbi.project.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import sigbi.project.domain.Usuarios;
import sigbi.project.servicio.PersonaService;
import sigbi.project.servicio.booksService;


@Controller
@Slf4j
public class ControladorInicio {
    
    // vamos a inyectar el repositorio la clase persona DAO a nuestro controlador
    @Autowired
    private PersonaService personaService;
    @Autowired
    private booksService books_Service;
    
        
    @GetMapping("/")
    // agrega un objeto como atributo al metodo
    public String inicio(Model model){
        
    log.info("ejecutando el controlador para sigbi");
    return "index_1.html";
    
    }
    
        @GetMapping("/leer_usu")
    // agrega un objeto como atributo al metodo
    public String leer_usu(Model model){
        
    var personas = personaService.listarPersonas();
        
    model.addAttribute("personas", personas);
    log.info("ejecutando el controlador para sigbi");
    return "leerUsuarios.html";
    }
    
    @GetMapping("/leer_books")
    // agrega un objeto como atributo al metodo
    public String leer_books(Model model){
        
    var libros = books_Service.listarbooks();
        
    model.addAttribute("jk", libros);
    log.info("ejecutando el controlador para sigbi leer boooks");
    return "leerbooks.html";
    }
    
    
    
    
    
    @GetMapping("/agregar")
    public String agregar(Usuarios persona){
               
       return "leerUsuarios.html"  ;      
        
    }
    
    
    
@PostMapping("/guardar")

public String guardar(Usuarios persona){
     personaService.guardar(persona);
     return "redirect:/";
    

}

    @GetMapping("/editar/{idPersona}")
    public String editar(Usuarios persona , Model model){
        // lo guardo en una variable persona 
       persona =  personaService.encontrarPersona(persona);
       model.addAttribute("persona", persona);
       return "modificar.html";        
        
    }
    
    
      @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Usuarios persona ){
        // lo guardo en una variable persona 
     personaService.eliminar(persona);
       
        return "redirect:/";
       
        
        
    }

    
}
