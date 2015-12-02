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
     * Sets this game piece to be busy.
     */
    void setBusy();

    /**
     * Sets this game piece to be not busy.
     */
    void setFree();

    /**
     * Sets how long this game piece will be busy for.
     * @param busyTime The amount of time this piece will be busy for.
     */
    void setBusyTime(double busyTime);

    /**
     * Returns an Enum describing the type of game piece this is.
     * @return The type of game piece this is.
     */
    GamePieceType getGamePieceType();

}
