package cca.dsoo.ufscar.cms.data;

import java.util.Dictionary;
import java.util.Hashtable;

public class QueryResult {
    Dictionary<String, Object> dataSet;

    public QueryResult() {
        dataSet = new Hashtable<String, Object>();
    }

    public void setValue(String column, Object value) {
        dataSet.put(column, value);
    }

    public Object getValue(String column) {
        return dataSet.get(column);
    }
}
