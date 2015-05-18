/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fiori.cdi.processor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

/**
 *
 * @author duncan
 */
@Stateless @LocalBean
public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void pay() {
        Logger.getLogger(CreditCardProcessor.class.getName()).log(Level.INFO, "paid by Creditcard.");
    }
    
    public void onObserve(@Observes PaymentEvent event) {
        Logger.getLogger(CreditCardProcessor.class.getName()).log(Level.INFO, "Observing {0}", event);
    }
}
