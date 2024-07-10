package cca.dsoo.ufscar.cms.data;

import cca.dsoo.ufscar.cms.util.ConfigManager;
import cca.dsoo.ufscar.cms.util.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MySQLStrategy implements IStorageStrategy {
    private static IStorageStrategy _instance;

    private Connection dbConnection;

    private MySQLStrategy() {
        try {
            ConfigManager mgr = ConfigManager.getInstance();
            dbConnection = DriverManager.getConnection(
                mgr.getProperty("database_connection_string"),
                mgr.getProperty("database_user"),
                mgr.getProperty("database_pass")
            );

            Logger.getInstance().log("Conectado ao banco de dados");
        }
        catch(SQLException e) {
            throw new IllegalStateException("Não foi possível conectar ao banco de dados", e);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static IStorageStrategy getInstance() {
        if(_instance == null) {
            _instance = new MySQLStrategy();
        }

        return _instance;
    }

    @Override
    public List<HashMap<String, Object>> runQuery(String str) {
        // Não foi implementado polling, então é necessário conectar e desconectar sempre que executar uma query
        Statement st = null;
        try {
            st = dbConnection.createStatement();
            boolean r = st.execute(str);
            if(r) {
                ResultSet res = st.getResultSet();
                ResultSetMetaData metaData = res.getMetaData();
                ArrayList<HashMap<String, Object>> resultMap = new ArrayList<>();
                while(res.next()) {
                    HashMap<String, Object> map = new HashMap<>();
                    for(int i = 1; i <= metaData.getColumnCount(); i++) {
                        String columnName = metaData.getColumnName(i);
                        Object columnValue = res.getObject(i);
                        map.put(columnName, columnValue);
                    }
                    resultMap.add(map);
                }

                return resultMap;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
