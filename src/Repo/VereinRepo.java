package Repo;

import Model.Vereine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VereinRepo implements IRepo<Vereine> {

    private final Map<Integer, Vereine> vereine = new HashMap<>();

    @Override
    public void add(Vereine obj) {
        vereine.putIfAbsent(obj.getID(), obj);
    }

    @Override
    public void update(Vereine obj) {
        vereine.replace(obj.getID(), obj);
    }

    @Override
    public void delete(int id) {
        vereine.remove(id);
    }

    @Override
    public Vereine get(int id) {
        return vereine.get(id);
    }

    @Override
    public List<Vereine> getAll() {
        return vereine.values().stream().toList();
    }
}
