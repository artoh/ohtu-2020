package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }

    @Test
    public void findPlayerByName() {
        Player player = stats.search("Gretzky");
        assertEquals( "Gretzky", player.getName());
    }

    @Test
    public void searchUnexistingPlayer() {
        Player player = stats.search("Selänne");
        assertNull(player);
    }

    @Test
    public void listTeam() {
        assertEquals( 3, stats.team("EDM").size());
    }

    @Test
    public void listNonexitsTeam() {
        assertEquals(0, stats.team("KÄRPÄT").size());
    }

    @Test
    public void topScorePlayer() {
        List<Player> list = stats.topScorers(1);
        assertEquals("Gretzky",list.get(0).getName());
    }

}
