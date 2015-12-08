package com.secturnet.springmvc.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
import java.util.List;
 
import com.secturnet.springmvc.model.Oficina;
 
public interface OficinaDao {
 
    Oficina findById(int idcontacto);
 
    void saveOficina(Oficina oficina);
     
    void deleteOficinaById(int idcontacto);
     
    List<Oficina> findAllOficinas(); 
}
