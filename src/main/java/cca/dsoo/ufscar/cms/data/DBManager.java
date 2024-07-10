package cca.dsoo.ufscar.cms.data;

import cca.dsoo.ufscar.cms.util.ConfigManager;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.HashMap;
import java.util.List;

public class DBManager {
    private static DBManager _instance;

    private IStorageStrategy strategy;

    private DBManager() {
        // Lê a estratégia do arquivo de configuração
        try {
            ConfigManager mgr = ConfigManager.getInstance();
            String dbStrategy = mgr.getProperty("database_strategy");
            switch (dbStrategy) {
                case "mysql":
                    strategy = MySQLStrategy.getInstance();
                    break;
                case "sqlite":
                    strategy = SQLiteStrategy.getInstance();
                    break;
                case "file":
                    strategy = FileStrategy.getInstance();
                    break;
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBManager getInstance() {
        if(_instance == null) {
            _instance = new DBManager();
        }

        return _instance;
    }

    public List<HashMap<String, Object>> execute(String query) throws InvalidObjectException {
        if(strategy == null) {
            throw new InvalidObjectException("Objeto strategy não pode ser nulo");
        }

        return strategy.runQuery(query);
    }
}
