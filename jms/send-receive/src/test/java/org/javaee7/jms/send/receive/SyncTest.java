package org.javaee7.jms.send.receive;

import org.javaee7.jms.send.receive.classic.ClassicMessageSender;
import org.javaee7.jms.send.receive.classic.ClassicMessageReceiver;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.javaee7.jms.send.receive.simple.MessageReceiverSync;
import org.javaee7.jms.send.receive.simple.MessageSenderSync;
import org.javaee7.jms.send.receive.simple.appmanaged.MessageReceiverAppManaged;
import org.javaee7.jms.send.receive.simple.appmanaged.MessageSenderAppManaged;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

/**
 * @author Patrik Dudits
 */
@RunWith(Arquillian.class)
public class SyncTest {

    @EJB
    ClassicMessageSender classicSender;

    @EJB
    ClassicMessageReceiver classicReceiver;

    @EJB
    MessageSenderSync simpleSender;

    @EJB
    MessageReceiverSync simpleReceiver;

    @EJB
    MessageSenderAppManaged appManagedSender;

    @EJB
    MessageReceiverAppManaged appManagedReceiver;

    @Test
    public void testClassicApi() {
        String message = "The test message over JMS 1.1 API";
        classicSender.sendMessage(message);

        assertEquals(message, classicReceiver.receiveMessage());
    }

    @Test
    public void testContainerManagedJmsContext() {
        String message = "Test message over container-managed JMSContext";
        simpleSender.sendMessage(message);

        assertEquals(message, simpleReceiver.receiveMessage());
    }

    @Test
    public void testAppManagedJmsContext() {
        String message = "The test message over app-managed JMSContext";
        appManagedSender.sendMessage(message);

        assertEquals(message, appManagedReceiver.receiveMessage());
    }

    @Deployment
    public static WebArchive deploy() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(MessageSenderSync.class,
                        MessageReceiverSync.class,
                        ClassicMessageSender.class,
                        ClassicMessageReceiver.class,
                        MessageSenderAppManaged.class,
                        MessageReceiverAppManaged.class,
                        Resources.class);
    }

}
