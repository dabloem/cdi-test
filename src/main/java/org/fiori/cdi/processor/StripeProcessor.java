/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fiori.cdi.processor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author duncan
 */
@Stateless
public class StripeProcessor implements PaymentProcessor {

    @Override
    public void pay() {
        Logger.getLogger(StripeProcessor.class.getName()).log(Level.INFO, "paid by Stripe.");
    }
    
}
