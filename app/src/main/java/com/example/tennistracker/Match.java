public class Match {
    public int id;

    public double latitude;
    public double longitude;
    public Player player1;
    public Player player2;
    // public ArrayList<Set> sets;

    public Match(int id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

}

public class Set
{
    public int gamesWonPlayer1;
    public int gamesWonPlayer2;
}

public class Game
{
    public int scorePlayer1;
    public int scorePlayer2;
}