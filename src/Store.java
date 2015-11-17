public class Store {

    //private constructor

    public enum CurrencyType {
        DIAMONDS, POINTS
    }

    public void buyAgent(){
    }

    public void buySupervisor(){
    }

    public void buyCounter(){
    }

    public void buyDiamonds(){
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
