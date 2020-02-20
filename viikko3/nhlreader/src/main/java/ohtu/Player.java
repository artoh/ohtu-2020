
package ohtu;

public class Player implements Comparable<Player>
{
    private String name;
    private int goals;
    private int assists;
    private String team;
    private String nationality;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public int getGoals() {
        return this.goals;
    }
    
    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public int getAssists() {
        return this.assists;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getTeam() {
        return this.team;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getNationality() {
        return this.nationality;
    }
    
    public int getScore() {
        return getGoals() + getAssists();
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %-8s %3d + %3d = %3d",name, team, goals, assists, getScore());
    }

    @Override
    public int compareTo(Player t) {
        return t.getScore() - this.getScore();
        
    }
      
}
