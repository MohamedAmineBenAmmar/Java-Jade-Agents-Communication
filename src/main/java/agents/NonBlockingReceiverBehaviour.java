package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.behaviours.SimpleBehaviour;

public class NonBlockingReceiverBehaviour extends CyclicBehaviour {
    private static final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);

    public NonBlockingReceiverBehaviour(Agent agent) {
        super(agent);
    }

    public void action() {
        ACLMessage msg = myAgent.receive(mt);
        if (msg != null) {
            System.out.println(myAgent.getLocalName() + ": Ireceived message.\n" + msg.toString());

            if (msg.getContent().equalsIgnoreCase("stop")) {
                System.out.println("Received stop message. Terminating agent...");
                myAgent.doDelete();
            } else {
                // Make a reply
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.INFORM);
                reply.setContent("I'm fine. Thank you! from non blocking receiver");
                myAgent.send(reply);
            }
        } else {
            this.block();
        }
    }
}


