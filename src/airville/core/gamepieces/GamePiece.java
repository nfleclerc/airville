package airville.core.gamepieces;

/**
 * A game piece in Airville.
 */
public interface GamePiece {

    /**
     * Whether or not this game piece is busy right now.
     * @return The busy status of this piece.
     */
    boolean isBusy();

    /**
     * Returns how long this piece is busy for.
     * @return How long this piece is busy for.
     */
    double getBusyTime();

    /**
     * Sets how long this game piece will be busy for.
     * @param busyTime The amount of time this piece will be busy for.
     */
    void setBusyTime(double busyTime);

}
