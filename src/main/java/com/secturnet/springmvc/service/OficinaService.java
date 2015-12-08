/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secturnet.springmvc.service;

/**
 *
 * @author Eduardo
 */
import java.util.List;
 
import com.secturnet.springmvc.model.Oficina;
 
public interface OficinaService {
 
    Oficina findById(int idcontacto);
     
    void saveOficina(Oficina oficina);
     
    void updateOficina(Oficina oficina);
     
    void deleteOficinaById(Integer idcontacto);
 
    List<Oficina> findAllOficinas(); 
      
    boolean isOficinaSsnUnique(Integer idcontacto, Integer idcontact);
     
}
