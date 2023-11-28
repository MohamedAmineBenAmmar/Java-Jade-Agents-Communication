package agents;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class BlockingReceiverAgent extends Agent {
    protected void setup() {
        System.out.println("Hello. My name is " + this.getLocalName());
        System.out.println("Waiting for message ...");
        // ACLMessage msg = blockingReceive();
        doWait();
        ACLMessage msg = receive();
        System.out.println("Received message: " + msg.toString());

        // Make a reply
        ACLMessage reply = msg.createReply();
        reply.setPerformative(ACLMessage.INFORM);
        reply.setContent("I'm fine. Thank you! from blocking receiver");
        send(reply);


    }
}