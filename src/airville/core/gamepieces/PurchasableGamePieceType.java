package airville.core.gamepieces;

import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.gamepieces.counters.RegularCounter;

import java.util.function.Supplier;

/**
 * Created by nathaniel on 11/22/15.
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
     *
     * @return
     */
    public Supplier getConstructor(){
        return this.constructor;
    }

    /**
     *
     * @return
     */
    public int getGamePieceCost(){
        return this.gamePieceCost;
    }
}
