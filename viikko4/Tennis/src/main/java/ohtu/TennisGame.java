package ohtu;

public class TennisGame {
    
    private int scoresA=0;
    private int scoresB=0;
    private String[] names = {"",""};
    
    public TennisGame(String player1Name, String player2Name) {
        this.names[0] = player1Name;
        this.names[1] = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(names[0]))
            scoresA++;
        else
            scoresB++;
    }
    
    private static final String[] PointNames = {"Love","Fifteen","Thirty","Forty"};
    private static final String EqualPointPostfix = "-All";
    private static final String EqualPointsName = "Deuce";
    private static final String AdvanceName = "Advantage ";
    private static final String WinName = "Win for ";
    
    
    private String getScoreBeforeLimit() {
        return scoresA == scoresB ? 
            PointNames[scoresA] + EqualPointPostfix :
            PointNames[scoresA] + "-" + PointNames[scoresB];
    }

    private String getAdvanceString(int difference, int leader) {
        if( difference == 0) {
            return EqualPointsName;
        } else if( difference == 1) {
            return AdvanceName + names[leader];
        } else {
            return WinName + names[leader];
        }
    }
        
    private String getScoreAfterLimit() {
        if( scoresA > scoresB) {
            return getAdvanceString(scoresA - scoresB, 0);
        } else {
            return getAdvanceString(scoresB - scoresA, 1);
        }
    }
    
    public String getScore() {
        if( scoresA >= PointNames.length || scoresB >= PointNames.length) {
            return getScoreAfterLimit();
        } else {
            return getScoreBeforeLimit();
        }
    }
}