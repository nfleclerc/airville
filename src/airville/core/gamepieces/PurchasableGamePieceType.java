package airville.core.gamepieces;

import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.gamepieces.counters.RegularCounter;

import java.util.function.Supplier;

/**
 * An Enum representing a game peice that can be purchased. These are either an Agent, Supervisor,
 * Automatic Counter, and Regular Counter.
 */
public enum PurchasableGamePieceType {

    AGENT(Agent::new, 50),
    SUPERVISOR(Supervisor::new, 1),
    AUTO_COUNTER(AutomaticCounter::new, 100),
    REG_COUNTER(RegularCounter::new, 150);

    private Supplier constructor;
    private int gamePieceCost;

    PurchasableGamePieceType(Supplier constructor, int gamePieceCost){
        this.constructor = constructor;
        this.gamePieceCost = gamePieceCost;
    }

    /**
     * Returns the constructor for the game piece.
     * @return The constructor for this game piece.
     */
    public Supplier getConstructor(){
        return this.constructor;
    }

    /**
     * How much this piece costs to buy from the store. All costs are in points, except
     * for the Supervisor which costs diamonds.
     * @return How much this piece costs to buy from the store.
     */
    public int getGamePieceCost(){
        return this.gamePieceCost;
    }
}
