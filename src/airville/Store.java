package airville;

public class Store {

    public enum CurrencyType {
        DIAMONDS, POINTS
    }

    public void buyDiamond(){
        //prompt the user to enter credit card details and handle this elsewhere
    }

    public void buyItem(PurchasableGamePieceType gamePieceType){
        Airport.getInstance()
                .addItem(gamePieceType);
        Player.getInstance()
                .increaseCountOf(gamePieceType);
        if (PurchasableGamePieceType.SUPERVISOR == gamePieceType){
            removeCurrency(CurrencyType.DIAMONDS, gamePieceType.getGamePieceCost());
        } else {
            removeCurrency(CurrencyType.POINTS, gamePieceType.getGamePieceCost());
        }
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
