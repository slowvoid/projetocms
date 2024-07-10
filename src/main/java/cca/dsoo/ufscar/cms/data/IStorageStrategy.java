package cca.dsoo.ufscar.cms.data;

import java.util.HashMap;
import java.util.List;

public interface IStorageStrategy {
    List<HashMap<String, Object>> runQuery(String str);
}
