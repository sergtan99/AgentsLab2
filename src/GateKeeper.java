import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;
public class GateKeeper extends Agent {
    protected void setup() {
        System.out.println("Hello. My name is " + getLocalName() + ".");

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {

                ACLMessage msg = receive();
                if (msg != null) {

                    String content = msg.getContent();
                    System.out.println(myAgent.getLocalName() + ": " +
                            content + " - " + msg.getSender().getName());

                    if (msg.getReplyWith() != null) {

                        System.out.println(myAgent.getLocalName() + " received a reply.");
                        if (content.equals("Yes")) {
                            ACLMessage msgToClient = new ACLMessage(ACLMessage.CONFIRM);
                            msgToClient.setContent(content);
                            msgToClient.addReceiver(new AID("Client", AID.ISLOCALNAME));
                            send(msgToClient);
                        }
                        if (content.equals("No")) {
                            ACLMessage msgToClient = new ACLMessage(ACLMessage.DISCONFIRM);
                            msgToClient.setContent(content);
                            msgToClient.addReceiver(new AID("Client", AID.ISLOCALNAME));
                            send(msgToClient);
                        }
                    } else {
                        ACLMessage msgToManager = new ACLMessage(ACLMessage.QUERY_IF);
                        msgToManager.setContent(content);
                        msgToManager.addReceiver(new AID("Manager", AID.ISLOCALNAME));
                        send(msgToManager);

                    }
                    block();
                }
            }
        });
    }
}


