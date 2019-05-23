package online.suiyu.domain;

public class Tags {
    private int aId;
    private String tName;

    public Tags() {
    }

    public Tags(int aId, String tName) {
        this.aId = aId;
        this.tName = tName;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "aId=" + aId +
                ", tName='" + tName + '\'' +
                '}';
    }
}
