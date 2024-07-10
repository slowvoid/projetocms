package cca.dsoo.ufscar.cms.data;

import java.util.HashMap;
import java.util.List;

public class SQLiteStrategy implements IStorageStrategy {
    private static IStorageStrategy _instance;
    private SQLiteStrategy() {}

    public static IStorageStrategy getInstance() {
        if(_instance == null) {
            _instance = new SQLiteStrategy();
        }
        return _instance;
    }

    @Override
    public List<HashMap<String, Object>> runQuery(String str) {
        return null;
    }
}
