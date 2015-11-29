package airville.core.passengers;
import airville.core.Player;
import airville.core.gamepieces.counters.Counter;

/**
 * Created by nathaniel on 11/28/15.
 */
public class Passenger {

    private final boolean isFrequentFlyer;
    private final PassengerType passengerType;

    public Passenger(boolean isFrequentFlyer, PassengerType passengerType){
        this.isFrequentFlyer = isFrequentFlyer;
        this.passengerType = passengerType;
    }

    public boolean isFrequentFlyer() {
        return isFrequentFlyer;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void processAt(Counter counter){
        counter.setBusyTime(counter.getBusyTime() + passengerType.getBusyTime());
        if (passengerType == PassengerType.REROUTED){
            processReroutedPassenger(counter);
        } else {
            Player.getInstance().addPoints(passengerType.getPoints());
        }
        counter.setBusyTime(counter.getBusyTime() - passengerType.getBusyTime());
    }

    private void processReroutedPassenger(Counter counter) {
        if (counter.hasSupervisor()){
            Player.getInstance().addPoints(passengerType.getPoints());
        } else {
            //pass this off to the real time team tbh
        }
    }
}
