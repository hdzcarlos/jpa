package chc.udemy.jpa.controller;

import chc.udemy.jpa.models.entity.JugadorEntity;
import chc.udemy.jpa.repository.IJugadorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class JugadorController {
    @Autowired
    private IJugadorDAO jugadorDAO;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo","listado de jugadores");
        model.addAttribute("jugadores",jugadorDAO.findAll());
                return "listar";
    }

    /**
     * Metodo que se encarga de mostrar el formulario al usuario.
     * @param model
     * @return
     */
    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model){
        JugadorEntity jugadorEntity = new JugadorEntity();
        model.put("jugadorEntity", jugadorEntity);
        model.put("titulo","Formulario de jugador");

        return "form";
    }
    /**
     * Metodo para procesar el submit, almacenandlo en base de datos.
     * Recibe el objeto jugador entity y lo guardamos con save.
     * @Valid habilita la validación en el objeto mapeado al form
     */
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid JugadorEntity jugadorEntity, BindingResult result){
        //Si el resultado contiene errores , retornamos al formulario
        if(result.hasErrors()){
            return "form";
        }
        jugadorDAO.save(jugadorEntity);
        return "redirect:listar";
    }
}
