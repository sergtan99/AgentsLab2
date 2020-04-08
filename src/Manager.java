import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;
public class Manager  extends Agent
{
    protected void setup()
    {
        System.out.println("Hello. My name is "+getLocalName()+".");
        addBehaviour(new CyclicBehaviour(this)
        {
            public void action()
            {
                ACLMessage msg = receive();
                if (msg!=null) {
                    String content = msg.getContent();
                    System.out.println( myAgent.getLocalName() + ": " +
                            content+" - "+ msg.getSender().getName() );

                    ACLMessage reply = msg.createReply();
                    reply.setPerformative( ACLMessage.INFORM );
                    int decision = (int)Math.round(Math.random());
                    if(decision == 1)
                        content = "Yes";
                    if(decision == 0)
                        content = "No";
                    reply.setContent( content );
                    send(reply);
                }
                block();
            }
        });
    }
}