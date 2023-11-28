package agents;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Scanner;

public class SenderAgent extends Agent {
    protected void setup() {
        System.out.println("Hello. My name is " + this.getLocalName());
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a message: ");
                String userMessage = scanner.nextLine();

                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(new AID("Boss", AID.ISLOCALNAME));
                msg.setContent(userMessage);
                send(msg);

                // Receive reply
                ACLMessage reply = blockingReceive();
                System.out.println("Received reply: " + reply.toString());

                // If the user types "stop", terminate the agent
                if (userMessage.equalsIgnoreCase("stop")) {
                    System.out.println("Received stop message. Terminating agent...");
                    doDelete();
                }
            }
        });
    }
}


