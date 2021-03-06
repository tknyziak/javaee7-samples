/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.javaee7.ejb.async;

import org.javaee7.ejb.async.MyAsyncBeanMethodLevel;
import javax.ejb.EJB;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Arun Gupta
 */
public class AccountSessionBeanTest {
    @EJB MyAsyncBeanMethodLevel bean;
    
    /**
     * Arquillian specific method for creating a file which can be deployed
     * while executing the test.
     *
     * @return a war file
     */
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class).
                addClass(MyAsyncBeanMethodLevel.class);
        System.out.println(war.toString(true));
        return war;
    }
    
    /**
     * Test of withdraw method, of class AccountSessionBean.
     */
//    @Test
    public void testWithdraw() {
//        String result = bean.withdraw((float)5.0);
//        assertEquals("Withdrawn: 5.0", result);
    }

    /**
     * Test of deposit method, of class AccountSessionBean.
     */
//    @Test
    public void testDeposit() {
//        String result = bean.withdraw((float)10.0);
//        assertEquals("Deposited: 10.0", result);
    }
    
}
