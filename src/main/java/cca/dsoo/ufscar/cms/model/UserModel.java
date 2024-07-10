package cca.dsoo.ufscar.cms.model;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserModel extends Model{
    private int id;
    private String name;
    private String email;
    private String password;

    public UserModel() {
        super();
    }

    public void setId(int inId) {
        id = inId;
    }

    public int getId() {
        return id;
    }

    public void setName(String inName) {
        this.name = inName;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String inEmail) {
        this.email = inEmail;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String inPassword) {
        this.password = inPassword;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public HashMap<String, Object> getModelMap() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);
        map.put("email", email);
        map.put("password", password);

        return map;
    }

    @Override
    public void create() {
        String query = String.format("INSERT INTO users (name, email, password) VALUES (\"%s\", \"%s\", \"%s\")", name, email, password);
        try {
            dbManager.execute(query);
            List<HashMap<String, Object>> result = dbManager.execute("SELECT LAST_INSERT_ID() as id FROM users");
            if (result.isEmpty()) {
                throw new RuntimeException("Erro na execução da query");
            }

            int createdId = Integer.parseInt(result.getFirst().get("id").toString());
            setId(createdId);
        } catch (InvalidObjectException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete() {
    }

    @Override
    public void update() {
    }

    @Override
    public ArrayList<Model> find() {
        try {
            List<HashMap<String, Object>> result = dbManager.execute("SELECT * FROM users");
            if(result.isEmpty()) {
                return new ArrayList<>();
            }

            ArrayList<Model> models = new ArrayList<>();
            for(int i = 0; i < result.size(); i++) {
                HashMap<String, Object> data = result.get(i);
                UserModel m = new UserModel();
                m.setId(Integer.parseInt(data.get("id").toString()));
                m.setName(data.get("name").toString());
                m.setEmail(data.get("email").toString());
                models.add(m);
            }

            return models;
        }
        catch (InvalidObjectException e) {
            throw new RuntimeException(e);
        }
    }
}
