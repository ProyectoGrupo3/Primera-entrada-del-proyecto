/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Proyecto;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author ikitess
 */
public class LineaParte {

    /**
     * @return the hora_inicio
     */
    public Time getHora_inicio() {
        return hora_inicio;
    }

    /**
     * @param hora_inicio the hora_inicio to set
     */
    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    /**
     * @return the hora_fin
     */
    public Time getHora_fin() {
        return hora_fin;
    }

    /**
     * @param hora_fin the hora_fin to set
     */
    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

    private Time hora_inicio;
    private Time hora_fin;
    
}
