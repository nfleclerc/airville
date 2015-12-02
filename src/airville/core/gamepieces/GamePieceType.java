package airville.core.gamepieces;

import airville.core.Player;
import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.gamepieces.counters.RegularCounter;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * An Enum representing a game piece that can be purchased. These are either an Agent, Supervisor,
 * Automatic Counter, and Regular Counter.
 */
public enum GamePieceType {

    AGENT(Agent::new, 50, Player.getInstance()::removePoints),
    SUPERVISOR(Supervisor::new, 1, Player.getInstance()::removeDiamonds),
    AUTO_COUNTER(AutomaticCounter::new, 100, Player.getInstance()::removePoints),
    REG_COUNTER(RegularCounter::new, 150, Player.getInstance()::removePoints);

    private Supplier<GamePiece> constructor;
    private int cost;
    private Consumer<Integer> buyFunction;

    GamePieceType(Supplier<GamePiece> constructor, int cost, Consumer<Integer> buyFunction){
        this.constructor = constructor;
        this.cost = cost;
        this.buyFunction = buyFunction;
    }

    /**
     * Returns the constructor for the game piece.
     * @return The constructor for this game piece.
     */
    public Supplier<GamePiece> getConstructor(){
        return this.constructor;
    }

    /**
     * Buys the game piece by removing its cost from the Player's point or diamond total based
     * on its type. Supervisors cost diamonds, while all other piece cost diamonds.
     */
    public void buy(){
        this.buyFunction.accept(this.cost);
    }

    /**
     * The cost to purchase this game piece. This amount is given in diamonds for Supervisors,
     * and points for all other game piece types.
     * @return The amount is costs to purchase this game piece.
     */
    public int getCost() {
        return cost;
    }
}
