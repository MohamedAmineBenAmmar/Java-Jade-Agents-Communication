package agents;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;

public class AMSAgent extends Agent {
    protected void setup() {
        try {
            // Create a description of the agent to find
            SearchConstraints sc = new SearchConstraints();
            sc.setMaxResults(new Long(-1)); // long value of -1 means get all agents
            AMSAgentDescription[] agents = AMSService.search(this, new AMSAgentDescription(), sc);

            if (agents.length == 0) {
                System.out.println("- No agents found");
            } else {
                System.out.println("- " + agents.length + " Agents found");
                // Print the local names of the agents
                for (int i = 0; i < agents.length; i++) {
                    AID agentID = agents[i].getName();
                    System.out.println(agentID.getLocalName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
