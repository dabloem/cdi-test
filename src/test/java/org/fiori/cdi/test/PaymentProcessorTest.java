/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fiori.cdi.test;

import com.google.common.collect.Iterables;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.fiori.cdi.processor.CreditCardProcessor;
import org.fiori.cdi.processor.PaymentEvent;
import org.fiori.cdi.processor.PaymentProcessor;
import org.fiori.cdi.processor.StripeProcessor;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author duncan
 */
@RunWith(Arquillian.class)
public class PaymentProcessorTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(PaymentProcessor.class, CreditCardProcessor.class, StripeProcessor.class, PaymentEvent.class)
                .setManifest(new StringAsset("Manifest-Version: 1.0\r\nDependencies: com.google.guava\r\n"))
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    
    @Inject
    Instance<PaymentProcessor> paymentProcessors;
            
    @Test
    public void testPaymentProcessors() {
        for (PaymentProcessor paymentProcessor : paymentProcessors) {
            paymentProcessor.pay();
        }
        
        Assert.assertEquals(2, Iterables.size(paymentProcessors));
    }
}
