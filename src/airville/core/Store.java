package airville.core;

import airville.core.gamepieces.GamePieceType;

/**
 * A singleton class that represents the Store where the Player can buy different items.
 */
public class Store {

    private static final Store instance = new Store();

    private Store() {
        //to prevent instantiation
    }

    /**
     * Returns an instance of the Store.
     * @return An instance of the singleton Store.
     */
    public static Store getInstance(){
        return instance;
    }

    /**
     * An Enum describing the type of currency to buy game pieces with.
     */
    public enum CurrencyType {
        DIAMONDS, POINTS
    }

    /**
     * Buys a diamond from the Store. This is done with real money.
     */
    public void buyDiamond(){
        //prompt the user to enter credit card details and handle this elsewhere
    }

    /**
     * Buys a game piece from the store and adds it to the game qnd increases
     * the Player's count of that item.
     * @param gamePieceType The type of game piece to buy.
     */
    public void buyItem(GamePieceType gamePieceType){
        //add this item to the airport
        Airport.getInstance().addItem(gamePieceType.getConstructor().get());
        //add this item to the player's count of it
        Player.getInstance().increaseCountOf(gamePieceType);
        gamePieceType.buy();
    }

    /**
     * Removes an amount of currency from the Player.
     * @param currencyType The type of currency to remove from the Player. Can be diamonds or points.
     * @param cost The amount of currency to remove from the player.
     */
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
