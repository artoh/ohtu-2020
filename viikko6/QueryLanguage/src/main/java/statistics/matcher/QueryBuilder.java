/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;

/**
 *
 * @author ahyvatti
 */
public class QueryBuilder {

    Matcher stack;
    
    public QueryBuilder() {
        stack = new All();
    }
    
    public Matcher build() {
        return stack;
    }
    
    public QueryBuilder playsIn(String team) {
        this.stack = new And(new PlaysIn(team), stack);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.stack =  new And( new HasAtLeast(value, category), stack);
        return this;
    }
 
    public QueryBuilder hasFewerThan(int value, String category) {
        this.stack = new And( new HasFewerThan(value, category), stack);
        return this;
    }
    
    public QueryBuilder oneOf(Matcher ...matchers) {
        this.stack = new Or( matchers );
        return this;
    }
}
