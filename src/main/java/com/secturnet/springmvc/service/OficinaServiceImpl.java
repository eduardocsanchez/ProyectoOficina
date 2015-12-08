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
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.secturnet.springmvc.dao.OficinaDao;
import com.secturnet.springmvc.model.Oficina;
 
@Service("oficinaService")
@Transactional
public class OficinaServiceImpl implements OficinaService {

    @Autowired
    private OficinaDao dao;
     
    public Oficina findById(int id) {
        return dao.findById(id);
    }
 
    public void saveOficina(Oficina oficina) {
        dao.saveOficina(oficina);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateOficina(Oficina oficina) {
        Oficina entity = dao.findById(oficina.getIdcontacto());
        if(entity!=null){
            entity.setNombre_contacto(oficina.getNombre_contacto());
            entity.setFecha_dealta(oficina.getFecha_dealta());
            entity.setCorreo_oficina(oficina.getCorreo_oficina());
            entity.setTel_oficina(oficina.getTel_oficina());
            entity.setDirecion(oficina.getDirecion());
            entity.setIdcontacto(oficina.getIdcontacto());
        }
    }
 
    public void deleteOficinaById(Integer idcontacto) {
        dao.deleteOficinaById(idcontacto);
    }
     
    public List<Oficina> findAllOficinas() {
        return dao.findAllOficinas();
    }
 
    public Oficina findById(Integer idcontacto) {
        return dao.findById(idcontacto);
    }
 
    public boolean isOficinaSsnUnique(Integer idcontacto, Integer idcontact) {
        Oficina oficina = findById(idcontacto);
        return ( oficina == null || ((idcontacto != null) && (oficina.getIdcontacto()== idcontacto)));
    }

     
}
