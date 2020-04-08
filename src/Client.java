import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.*;

import java.util.concurrent.TimeUnit;

public class Client extends Agent
{
    protected void setup()
    {
        System.out.println("Hello. My name is "+getLocalName()+".");

        // Answering behaviour
        addBehaviour(new CyclicBehaviour(this)
        {
            public void action() {
                ACLMessage msg= receive();
                if (msg!=null)
                    System.out.println( myAgent.getLocalName() + ": " +
                            msg.getContent()+" - "+ msg.getSender().getName() );
                block();
            }
        });
        // Send message
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.setContent( "date:08.04.2021, time:14.00, people:2" );
        msg.addReceiver( new AID( "GateKeeper", AID.ISLOCALNAME) );
        send(msg);

    }
}