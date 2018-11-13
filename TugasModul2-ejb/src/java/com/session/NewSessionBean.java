/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import java.text.DecimalFormat;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author asus
 */
@Stateful
@LocalBean
public class NewSessionBean {

    DecimalFormat a = new DecimalFormat("0.0");
    String result;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String businessMethod(double param) {
        return result = a.format(param*80000);
    }
}
