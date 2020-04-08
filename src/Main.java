public class Main {
    public static void main(String[] args){
        String[] args1={"-gui", "Client:Client"};
        String[] args2={"-container", "GateKeeper:GateKeeper"};
        String[] args3={"-container", "Manager:Manager"};
        jade.Boot.main(args1);
        jade.Boot.main(args2);
        jade.Boot.main(args3);
    }
}
