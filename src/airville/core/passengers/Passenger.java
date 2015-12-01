package airville.core.passengers;
import airville.core.Player;
import airville.core.gamepieces.counters.Counter;

/**
 * A Passenger that is to be processed by a Counter. A passenger can either be Regular,
 * Overbooked, have Extra Baggage, or be Rerouted.
 */
public class Passenger {

    private final boolean isFrequentFlyer;
    private final PassengerType passengerType;

    /**
     * Instantiates a new Passenger of the given type and frequent flyer status.
     * @param isFrequentFlyer The frequent flyer status of this passenger.
     * @param passengerType The type of this passenger. Is given by the Enum PassengerType.
     */
    public Passenger(boolean isFrequentFlyer, PassengerType passengerType){
        this.isFrequentFlyer = isFrequentFlyer;
        this.passengerType = passengerType;
    }

    /**
     * Returns whether or not this Passenger is a frequent flyer.
     * @return true if this Passenger is a frequent flyer, false otherwise.
     */
    public boolean isFrequentFlyer() {
        return isFrequentFlyer;
    }

    /**
     * Returns the type of this Passenger.
     * @return An Enum of PassengerType.
     */
    public PassengerType getPassengerType() {
        return passengerType;
    }

    /**
     * Process this given passenger at the given counter. Passengers adjust the busyTime of the
     * given counter based on what its type is, i.e. Regular Passengers are processed quickly,
     * and Overbooked Passengers are processed slowly. A Passenger is processed by adding its
     * point value to the Player's point value. Rerouted Passengers are processed slightly different
     * than other Passengers. They require a Supervisor to be at the Counter they are being
     * processed at.
     * @param counter
     */
    public void processAt(Counter counter){
        //add this passengers busy time to the counter
        counter.setBusyTime(counter.getBusyTime() + passengerType.getBusyTime());
        if (passengerType == PassengerType.REROUTED){
            //if this passenger is rerouted handle is specially
            processReroutedPassenger(counter);
        } else {
            //otherwise process it as normal
            processPassenger();
        }
        //this passenger has been processed and its busy time can
        //be removed from the counter
        counter.setBusyTime(counter.getBusyTime() - passengerType.getBusyTime());
    }

    /**
     * Processes a Rerouted Passenger at the specified Counter. Can only be completed if
     * there is a Supervisor at the given Counter.
     * @param counter The Counter at which this passenger is to be processed.
     */
    private void processReroutedPassenger(Counter counter) {
        assert this.getPassengerType() == PassengerType.REROUTED;
        if (counter.hasSupervisor()){
            //the counter has a supervisor and this passenger
            //can be processed normally
            processPassenger();
        } else {
            //passing this off to the real time team tbh
        }
    }

    /**
     * Add the point value of this Passenger to the Player's point total.
     */
    private void processPassenger(){
        Player.getInstance().addPoints(passengerType.getPoints());
    }
}
