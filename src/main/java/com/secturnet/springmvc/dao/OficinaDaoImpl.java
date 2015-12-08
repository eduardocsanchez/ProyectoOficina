/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secturnet.springmvc.dao;

/**
 *
 * @author Eduardo
 */
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.secturnet.springmvc.model.Oficina;
 
@Repository("oficinaDao")
public class OficinaDaoImpl extends AbstractDao<Integer, Oficina> implements OficinaDao {
 
    public Oficina findById(int id) {
        return getByKey(id);
    }
 
    public void saveOficina(Oficina oficina) {
        persist(oficina);
    }
 
    public void deleteOficinaById(int idcontacto) {
        Query query = getSession().createSQLQuery("delete from oficina where idcontacto = :idcontacto");
        query.setInteger("idcontacto", idcontacto);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    public List<Oficina> findAllOficinas() {
        Criteria criteria = createEntityCriteria();
        return (List<Oficina>) criteria.list();
    }
 
//    public Oficina findOficinaBySsn(String ssn) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("ssn", ssn));
//        return (Oficina) criteria.uniqueResult();
//    }
}
