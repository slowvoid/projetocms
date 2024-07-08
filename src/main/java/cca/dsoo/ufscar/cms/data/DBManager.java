package cca.dsoo.ufscar.cms.data;

import java.util.ArrayList;

public class DBManager {
    private static DBManager _instance;
    private DBManager() {}

    public static DBManager getInstance() {
        if(_instance == null) {
            _instance = new DBManager();
        }

        return _instance;
    }

    @Query()
    public QueryResult[] execute(String query) {
        return (QueryResult[]) new ArrayList<QueryResult>().toArray();
    }
}
