package sigbi.project.web;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sigbi.project.dao.AdminDAO;
import sigbi.project.domain.Adm;
import sigbi.project.domain.Books;
import sigbi.project.domain.Usuarios;
import sigbi.project.servicio.AdminService;
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
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private AdminDAO repo;
    
    
    @GetMapping("/home")
    // agrega un objeto como atributo al metodo
    public String home(Model model){
        
    log.info("entrada a home");
    return "index_1.html";
  
    // guardar administradores
    }
    
  
    @GetMapping("/")
    // agrega un objeto como atributo al metodo
    public String inicio(Model model){
        
    log.info("ejecutando el controlador para sigbi");
    return "redirect:/login";
  
    // guardar administradores
    }
    
    
    
        @GetMapping("/register")
    // agrega un objeto como atributo al metodo
    public String register(Model model,Adm adm){
        model.addAttribute("adm", adm);
        
    log.info("ejecutando el controlador para registro");
    return "registration.html";
    
    }
    
     @PostMapping("/save_admin")
    public String guardar_admin( Adm adm){
        
        adminService.guardar(adm);
    return "redirect:/register";   
    }
    
    
   //****************************************
    
    
    // verificar administradores
    
    
    //**********************************
    
    @GetMapping("/login")
    public String login (Model model){
        
        Adm adm = new Adm();
        model.addAttribute("adm", adm);
    
    return "login";
    }
    
    @PostMapping("/userLogin")
    public String LoginUser(@ModelAttribute("adm") Adm adm, Adm admData){
        System.out.println(adm.getName());
        System.out.println(adm.getPsw());
        String name=adm.getName();
        String psw=adm.getPsw();
           
        admData = repo.findByNameContainingAndPswContaining(name, psw);
        
        if(admData == null ){
            log.info("QUERY SIN DATA");
            return"login";
        
        }else{
        
        return"index_1.html";
        
        }
        
           
        }
        
    
    
     
    
   //****************************************
    
    
    // verificar administradores
    
    
    //**********************************
    
    
    
    
   

    // leer tabla de usuarios
    
    
        @GetMapping("/leer_usu")
    // agrega un objeto como atributo al metodo
    public String leer_usu(Model model){
        
    var usuarios = personaService.listarPersonas();
        
    model.addAttribute("usuario", usuarios);
    log.info("ejecutando el controlador para sigbi");
    return "leerUsuarios.html";
    
    // leer tabla de libros
    }
    
    @GetMapping("/leer_books")
    // agrega un objeto como atributo al metodo
    public String leer_books(Model model){
        
    var libros = books_Service.listarbooks();
        
    model.addAttribute("jk", libros);
    log.info("ejecutando el controlador para sigbi leer boooks");
    return "leerbooks.html";
    }
    
    // realizar el POST de libros
   
    @GetMapping("/llenar_books")
        
    //va a crear un objeto para ser llenado luego en el PostMapping
    public String llenar_books(Model model,Books book){
        
    model.addAttribute("jk", book);
                         
    log.info("ejecutando el controlador para sigbi leer boooks");
    return "llenarbook.html";  
    }
    
    @PostMapping("/save")
    public String guardar_book(Books book){
        books_Service.guardarbooks(book);
    return "redirect:/llenar_books";   
    }
    
    
    
    
    // realizar el POST de usuarios
    
    
    @GetMapping("/llenar_usu")
        
    //va a crear un objeto para ser llenado luego en el PostMapping
    public String llenar_usu(Model model,Usuarios usuario){
        
    model.addAttribute("usuario", usuario);
                         
    log.info("ejecutando el controlador para sigbi leer boooks");
    return "LLenarUsuarios.html";
    }
    
    @PostMapping("/save_usu")
    public String guardar_usu(Usuarios usuario){
        personaService.guardar(usuario);
    return "redirect:/llenar_usu";   
    }
       
    
    // crud editar USUARIO
    
    @GetMapping("/editar{usuario_id}")
    public String editar(Usuarios usuarios , Model model){
        // lo guardo en una variable persona 
       usuarios =  personaService.encontrarPersona(usuarios);
       model.addAttribute("usuario", usuarios);
       return "LLenarUsuarios.html";        
        
    }
    
    
    //crud eliminar USUARIO
    
      @GetMapping("/eliminar/{usuario_id}")
    public String eliminar(Usuarios usuario ){
        // lo guardo en una variable persona 
     personaService.eliminar(usuario);
       
        return "redirect:/leer_usu";
       
        
        
    }
    
    
    
    
        // crud editar BOOKS
    
    @GetMapping("/modificar")
    public String editar_book(Books libro , Model model){
        // lo guardo en una variable persona 
       libro =  books_Service.encontrarboooks(libro);
       model.addAttribute("jk", libro);
       log.info("SE EJECUTO MODIFICAR LIBRO ");
       return "llenarbook.html";        
        
    }
    
    
    //crud eliminar BOOKS
    
    
      @GetMapping("/borrar_book/{book_id}")
    public String eliminar_book(Books book ){
        // lo guardo en una variable persona 
     books_Service.eliminarbooks(book);
       
        return "redirect:/leer_books";
       
        
       
    }
   
   
    
    

}

    



