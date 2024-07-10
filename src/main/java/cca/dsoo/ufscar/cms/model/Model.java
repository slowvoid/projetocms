package cca.dsoo.ufscar.cms.model;

import cca.dsoo.ufscar.cms.data.DBManager;

import java.util.ArrayList;
import java.util.Map;

public abstract class  Model {
    private String table;
    private String primaryKey;
    protected DBManager dbManager = DBManager.getInstance();

    public abstract Map<String, Object> getModelMap();

    public abstract void create();

    public abstract void delete();

    public abstract void update();

    public abstract ArrayList<Model> find();
}
