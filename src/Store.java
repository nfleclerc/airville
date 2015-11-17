public class Store {

    //pieces that cost points
    private static final int AGENT_COST = 20;
    private static final int AUTOCOUNTER_COST = 50;
    private static final int REGCOUNTER_COST = 100;

    //pieces that cost diamonds
    private static final int SUPERVISOR_COST = 20;

    public enum CurrencyType {
        DIAMONDS, POINTS
    }

    public void buyAgent(){
        GamePieces.addFloatingAgent(new FloatingAgent());
        Player.getInstance().addAgent();
        removeCurrency(CurrencyType.POINTS, AGENT_COST);
    }

    public void buySupervisor(){
        GamePieces.addSupervisor(new Supervisor());
        Player.getInstance().addSupervisor();
        removeCurrency(CurrencyType.DIAMONDS, SUPERVISOR_COST);
    }

    public void buyRegularCounter(){
        GamePieces.addCounter(new RegularCounter());
        Player.getInstance().addRegularCounter();
        removeCurrency(CurrencyType.POINTS, REGCOUNTER_COST);
    }

    public void buyAutomaticCounter(){
        GamePieces.addCounter(new AutomaticCounter());
        Player.getInstance().addAutomaticCounter();
        removeCurrency(CurrencyType.POINTS, AUTOCOUNTER_COST);
    }

    public void buyDiamond(){
        //prompt the user to enter credit card details and handle this elsewhere
        Player.getInstance().addDiamond();
    }

    private void removeCurrency(CurrencyType currencyType, int cost){
        switch (currencyType){
            case DIAMONDS:
                Player.getInstance().removeDiamonds(cost);
                break;
            case POINTS:
                Player.getInstance().removePoints(cost);
        }

    }

}
