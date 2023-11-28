package agents;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;

public class SenderAgent extends Agent {
    protected void setup() {
        System.out.println("Hello. My name is " + this.getLocalName());
        sendMessage();
    }

    private void sendMessage() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID("Boss", AID.ISLOCALNAME));
        msg.setContent("Hello! How are you?");
        send(msg);

        // receive reply
        ACLMessage reply = blockingReceive();
        System.out.println("Received reply: " + reply.toString());


    }
}
