package cca.dsoo.ufscar.cms.model;

import cca.dsoo.ufscar.cms.data.DBManager;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    private String table;
    private String primaryKey;

    protected HashMap<String, Object> getModelMap() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Classe base não implementa a função");
    }

    Model() {}

    public void create() {
        DBManager instance = DBManager.getInstance();
        instance.execute(String.format("INSERT INTO %s (column1, column2) VALUES (%s, %s);", table, primaryKey, "default"));
    }

    public void delete() {}

    public void update() {}

    public ArrayList<Model> find() {
        return new ArrayList<Model>();
    }
}
