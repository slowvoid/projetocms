package cca.dsoo.ufscar.cms.data;

import cca.dsoo.ufscar.cms.util.ConfigManager;
import cca.dsoo.ufscar.cms.util.Logger;
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
        Logger logger = Logger.getInstance();
        try {
            ConfigManager mgr = ConfigManager.getInstance();
            String dbStrategy = mgr.getProperty("database_strategy");
            switch (dbStrategy) {
                case "mysql":
                    logger.log("Usando estratégia MySQL");
                    strategy = MySQLStrategy.getInstance();
                    break;
                case "sqlite":
                    logger.log("Usando estratégia SQLite");
                    strategy = SQLiteStrategy.getInstance();
                    break;
                case "file":
                    logger.log("Usando estratégia File");
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
