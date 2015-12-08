/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secturnet.springmvc.model;

/**
 *
 * @author Eduardo
 */
import java.math.BigDecimal;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
@Table(name="OFICINA")
public class Oficina {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcontacto;
 
    @Size(min=3, max=50)
    @Column(name = "NOMBRE_CONTACTO", nullable = false)
    private String nombre_contacto;
 
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "FECHA_DEALTA", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate fecha_dealta;
 
    @NotNull
//    @Digits(integer=8, fraction=2)
    @Column(name = "CORREO_OFICINA", nullable = false)
    private String correo_oficina;
    
    @NotNull
//    @Digits(integer=8, fraction=2)
    @Column(name = "TEL_OFICINA", nullable = false)
    private String tel_oficina;
    
    @NotNull
//    @Digits(integer=8, fraction=2)
    @Column(name = "DIRECION", nullable = false)
    private String direcion;
     
//    @NotEmpty
//    @Column(name = "IDCONTACTO", unique=true, nullable = false)
//    private int idcontacto;
 
        /**
     * @return the idcontacto
     */
    public int getIdcontacto() {
        return idcontacto;
    }

    /**
     * @param idcontacto the idcontacto to set
     */
    public void setIdcontacto(int idcontacto) {
        this.idcontacto = idcontacto;
    }
    /**
     * @return the nombre_contacto
     */
    public String getNombre_contacto() {
        return nombre_contacto;
    }

    /**
     * @param nombre_contacto the nombre_contacto to set
     */
    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    /**
     * @return the fecha_dealta
     */
    public LocalDate getFecha_dealta() {
        return fecha_dealta;
    }

    /**
     * @param fecha_dealta the fecha_dealta to set
     */
    public void setFecha_dealta(LocalDate fecha_dealta) {
        this.fecha_dealta = fecha_dealta;
    }

    /**
     * @return the correo_oficina
     */
    public String getCorreo_oficina() {
        return correo_oficina;
    }

    /**
     * @param correo_oficina the correo_oficina to set
     */
    public void setCorreo_oficina(String correo_oficina) {
        this.correo_oficina = correo_oficina;
    }

    /**
     * @return the tel_oficina
     */
    public String getTel_oficina() {
        return tel_oficina;
    }

    /**
     * @param tel_oficina the tel_oficina to set
     */
    public void setTel_oficina(String tel_oficina) {
        this.tel_oficina = tel_oficina;
    }

    /**
     * @return the direccion
     */
    public String getDirecion() {
        return direcion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }
    /**
     * @return the idcontacto
     */
//    public String getIdcontacto() {
//        return idcontacto;
//    }
//
//    /**
//     * @param idcontacto the idcontacto to set
//     */
//    public void setIdcontacto(String idcontacto) {
//        this.idcontacto = idcontacto;
//    }  
 
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + id;
//        result = prime * result + ((id == 0)? 0 : id.hashCode());
//        return result;
//    }
// 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Oficina))
            return false;
        Oficina other = (Oficina) obj;
        if (getIdcontacto()!= other.getIdcontacto())
            return false;
        if (getIdcontacto() == 0) {
            if (other.getIdcontacto()!= 0)
                return false;
        } else if (getIdcontacto() != (other.getIdcontacto()))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Oficina [idcontacto=" + getIdcontacto()+ ", name=" + nombre_contacto + ", joiningDate="
                + fecha_dealta + ", correo=" + correo_oficina + ", tel_oficina=" + tel_oficina  + ", direccion=" + direcion + "]";
    }

    


}
