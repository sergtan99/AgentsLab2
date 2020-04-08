public class Main {
    public static void main(String[] args){
        String[] args1={"-gui", "Manager:Manager"};
        String[] args2={"-container", "GateKeeper:GateKeeper"};
        String[] args3={"-container", "Client:Client"};
        jade.Boot.main(args1);
        jade.Boot.main(args2);
        jade.Boot.main(args3);
    }
}
