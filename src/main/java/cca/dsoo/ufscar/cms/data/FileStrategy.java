package cca.dsoo.ufscar.cms.data;

import java.util.HashMap;
import java.util.List;

public class FileStrategy implements IStorageStrategy {
    private static IStorageStrategy _instance;
    private FileStrategy() {}

    public static IStorageStrategy getInstance() {
        if(_instance == null) {
            _instance = new FileStrategy();
        }
        return _instance;
    }

    @Override
    public List<HashMap<String, Object>> runQuery(String str) {
        return null;
    }
}
