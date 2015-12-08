/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secturnet.springmvc.controller;

/**
 *
 * @author Eduardo
 */
import java.util.List;
import java.util.Locale;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.secturnet.springmvc.model.Oficina;
import com.secturnet.springmvc.service.OficinaService;
 
@Controller
@RequestMapping("/")
public class AppController {
 
    @Autowired
    OficinaService service;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing offices.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listOficinas(ModelMap model) {
 
        List<Oficina> oficinas = service.findAllOficinas();
        model.addAttribute("oficinas", oficinas);
        return "alloficinas";
    }
 
    /*
     * This method will provide the medium to add a new offci3e.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newOficina(ModelMap model) {
        Oficina oficina = new Oficina();
        model.addAttribute("oficina", oficina);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving office in database. It also validates the user input
     */
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveOficina(@Valid Oficina oficina, BindingResult result,ModelMap model) {
        if (result.hasErrors()) {
            return "registration";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [idcontacto] should be implementing custom @Unique annotation 
         * and applying it on field [idcontacto] of Model class [Oficina].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!service.isOficinaSsnUnique(oficina.getIdcontacto(), oficina.getIdcontacto())){
            FieldError ssnError =new FieldError("oficina","idcontacto",messageSource.getMessage("non.unique.idcontacto", new Integer[]{oficina.getIdcontacto()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
         
        service.saveOficina(oficina);
 
        model.addAttribute("success", "Oficina " + oficina.getNombre_contacto()+ " registered successfully");
        return "success";
    }
 
 
    /*
     * This method will provide the medium to update an existing offcies.
     */
    @RequestMapping(value = { "/edit-{idcontacto}-oficina" }, method = RequestMethod.GET)
    public String editOficina(@PathVariable Integer idcontacto, ModelMap model) {
        Oficina oficina = service.findById(idcontacto);
        model.addAttribute("oficina", oficina);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating offcies in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{idcontacto}-oficina" }, method = RequestMethod.POST)
    public String updateOficina(@Valid Oficina oficina, BindingResult result,
            ModelMap model, @PathVariable String idcontacto) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        if(!service.isOficinaSsnUnique(oficina.getIdcontacto(), oficina.getIdcontacto())){
            FieldError ssnError = new FieldError("oficina","id",messageSource.getMessage("non.unique.idcontacto", new Integer[]{oficina.getIdcontacto()}, Locale.getDefault()));
            result.addError(ssnError);
            return "registration";
        }
 
        service.updateOficina(oficina);
 
        model.addAttribute("success", "Oficina " + oficina.getNombre_contacto()+ " updated successfully");
        return "success";
    }
 
     
    /*
     * This method will delete an offcie by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{idcontacto}-oficina" }, method = RequestMethod.GET)
    public String deleteOficina(@PathVariable Integer idcontacto) {
        service.deleteOficinaById(idcontacto);
        return "redirect:/list";
    }
 
}
