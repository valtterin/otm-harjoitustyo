
package muistipeli.database;


public class Score {
    private String playerName;
    private int score;
    private String gamemode;
    

    public Score(String player, int score, String gamemode) {
        this.playerName = player;
        this.score = score;
        this.gamemode = gamemode;
    }
    
    public String getPlayerName() {
        return this.playerName;
    }
    
    public int getScore() {
        return this.score;
    }
    
    public String getGamemode() {
        return this.gamemode;
    }
    
    
    public void setPlayerName(String player) {
        this.playerName = player;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }

        
}

