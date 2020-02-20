/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author mluukkai
 */
public class Main {
        public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        List<Player> list = Arrays.asList(players);
        
        System.out.println("Players from FIN \n");
        
        list
                .stream()
                .filter(player -> player.getNationality().equals("FIN"))
                .sorted()
                .forEach(player -> System.out.println(player));
        
    }
}
 