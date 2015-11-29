package airville.passengers;

import airville.gamepieces.counters.Counter;

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

    public double getBusyTime(){
        return passengerType.getBusyTime();
    }

    public void processAt(Counter counter){

    }
}
