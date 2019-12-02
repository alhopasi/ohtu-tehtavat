package statistics;

import statistics.matcher.*;

public class QueryBuilder {

    Matcher m;

    public QueryBuilder() {
        m = new All();
    }

    private QueryBuilder(Matcher m) {
        this.m = m;
    }

    public Matcher build() {
        return m;
    }

    public QueryBuilder playsIn(String team) {
        Matcher matcher = new And(m, new PlaysIn(team));
        return new QueryBuilder(matcher);
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        Matcher matcher = new And(m, new HasAtLeast(value, category));
        return new QueryBuilder(matcher);
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        Matcher matcher = new And(m, new HasFewerThan(value, category));
        return new QueryBuilder(matcher);
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        Matcher matcher = new Or(m1, m2);
        return new QueryBuilder(matcher);
    }
}
