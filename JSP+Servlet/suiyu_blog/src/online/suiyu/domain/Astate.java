package online.suiyu.domain;

public class Astate {
    private int stateId;
    private String astate;

    public Astate() {
    }

    public Astate(int stateId, String astate) {
        this.stateId = stateId;
        this.astate = astate;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getAstate() {
        return astate;
    }

    public void setAstate(String astate) {
        this.astate = astate;
    }

    @Override
    public String toString() {
        return "Astate{" +
                "stateId=" + stateId +
                ", astate='" + astate + '\'' +
                '}';
    }
}
