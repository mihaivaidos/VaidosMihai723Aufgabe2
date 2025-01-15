package Model;

import java.util.List;

public class Vereine {

    private int ID;
    private String name;
    private String city;
    private List<Spieler> playerList;

    public Vereine(int ID, String name, String city, List<Spieler> playerList) {
        this.ID = ID;
        this.name = name;
        this.city = city;
        this.playerList = playerList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Spieler> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Spieler> playerList) {
        this.playerList = playerList;
    }

    @Override
    public String toString() {
        return "Vereine{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", playerList=" + playerList +
                '}';
    }
}
