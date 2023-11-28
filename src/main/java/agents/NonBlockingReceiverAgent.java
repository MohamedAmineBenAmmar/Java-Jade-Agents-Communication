package agents;

import jade.core.Agent;

public class NonBlockingReceiverAgent extends Agent {
    protected void setup() {
        System.out.println("Hello. My name is " + this.getLocalName());
        addBehaviour(new NonBlockingReceiverBehaviour(this));
    }
}
