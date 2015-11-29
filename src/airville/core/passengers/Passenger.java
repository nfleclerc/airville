package airville.core.passengers;
import airville.core.Player;
import airville.core.gamepieces.counters.Counter;

/**
 * Created by nathaniel on 11/28/15.
 */
public class Passenger {

    private final boolean isFrequentFlyer;
    private final PassengerType passengerType;

    /**
     *
     * @param isFrequentFlyer
     * @param passengerType
     */
    public Passenger(boolean isFrequentFlyer, PassengerType passengerType){
        this.isFrequentFlyer = isFrequentFlyer;
        this.passengerType = passengerType;
    }

    /**
     *
     * @return
     */
    public boolean isFrequentFlyer() {
        return isFrequentFlyer;
    }

    /**
     *
     * @return
     */
    public PassengerType getPassengerType() {
        return passengerType;
    }

    /**
     *
     * @param counter
     */
    public void processAt(Counter counter){
        counter.setBusyTime(counter.getBusyTime() + passengerType.getBusyTime());
        if (passengerType == PassengerType.REROUTED){
            processReroutedPassenger(counter);
        } else {
            Player.getInstance().addPoints(passengerType.getPoints());
        }
        counter.setBusyTime(counter.getBusyTime() - passengerType.getBusyTime());
    }

    /**
     *
     * @param counter
     */
    private void processReroutedPassenger(Counter counter) {
        if (counter.hasSupervisor()){
            Player.getInstance().addPoints(passengerType.getPoints());
        } else {
            //pass this off to the real time team tbh
        }
    }
}
