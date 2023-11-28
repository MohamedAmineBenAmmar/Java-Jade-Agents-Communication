package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class BlockingReceiverAgent extends Agent {
    protected void setup() {
        System.out.println("Hello. My name is " + this.getLocalName());
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                ACLMessage msg = blockingReceive();
                if (msg != null) {
                    System.out.println("Received message: " + msg.toString());

                    if (msg.getContent().equalsIgnoreCase("stop")) {
                        System.out.println("Received stop message. Terminating agent...");
                        doDelete();
                    } else {
                        // Make a reply
                        ACLMessage reply = msg.createReply();
                        reply.setPerformative(ACLMessage.INFORM);
                        reply.setContent("I'm fine. Thank you! from blocking receiver");
                        send(reply);
                    }
                }
            }
        });
    }
}

