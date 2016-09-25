

public class GumballMachine implements IGumballMachine {
 
    State soldOutState;
    State noCoinState;
    State hasCoinState;
    State soldState;
 
    State state = soldOutState;
    int count = 0;
    int insertedAmount = 0;
    int gumballsInSlot = 0;
 
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noCoinState;
        } 
    }
    
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        insertedAmount += 25;
        state.insertCoin();
    }
    
    public void insertDime() {
        System.out.println("You inserted a dime");
        insertedAmount += 10;
        state.insertCoin();
    }
    
    public void insertNickel() {
        System.out.println("You inserted a nickel");
        insertedAmount += 5;
        state.insertCoin();
    }
    
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
    
    public boolean isGumballInSlot( ) {
        return gumballsInSlot > 0;
    }
    
    public void takeGumballFromSlot( ) {
        gumballsInSlot = 0;
        System.out.println("Gumball Slot is empty now...");
    }
 
    public void ejectCoins() {
        state.ejectCoins();
    }

    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        gumballsInSlot++;
        System.out.println("A gumball comes into the slot...");
        insertedAmount -= 50;
        if(insertedAmount > 0){
            System.out.println("Change amount "+insertedAmount+" cents dispensed...");
            insertedAmount = 0;
        }
        if (count != 0) {
           count = count - 1;
        }
    }
    
    public int getInsertedAmount() {
        return insertedAmount;
    }
    
    public void setInsertedAmount(int insertedAmount) {
        this.insertedAmount = insertedAmount;
    }
    
    public int getGumballCountInSlot() {
        return gumballsInSlot;
    }
 
    int getCount() {
        return count;
    }
 
    void refill(int count) {
        this.count = count;
        state = noCoinState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getSoldState() {
        return soldState;
    }
 
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2016");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine has " + insertedAmount + " cents\n");
        result.append("Machine has " + gumballsInSlot + " gumballs in slot\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
