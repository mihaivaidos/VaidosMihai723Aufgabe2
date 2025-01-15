package Repo;

import Model.Spieler;

import java.util.ArrayList;
import java.util.List;

public class SpielerRepo implements IRepo<Spieler> {

    private final List<Spieler> spielers = new ArrayList<>();

    @Override
    public void add(Spieler obj) {
        spielers.add(obj);
    }

    @Override
    public void update(Spieler obj) {
        spielers.set(spielers.indexOf(obj), obj);
    }

    @Override
    public void delete(int id) {
        spielers.remove(id);
    }

    @Override
    public Spieler get(int id) {
        return spielers.get(id);
    }

    @Override
    public List<Spieler> getAll() {
        return spielers;
    }

    public Spieler takeByName(String name) {
        for (Spieler s : spielers) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

}
