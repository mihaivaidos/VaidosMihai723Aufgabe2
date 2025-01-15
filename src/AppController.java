import Model.Spieler;
import Model.Vereine;
import Repo.SpielerRepo;
import Repo.VereinRepo;

import java.util.List;

public class AppController {

    private final SpielerRepo spielerRepo;
    private final VereinRepo vereinRepo;
    private int newVereinID = 0;

    public AppController(SpielerRepo spielerRepo, VereinRepo vereinRepo) { //repo1, repo2
        this.spielerRepo = spielerRepo;
        this.vereinRepo = vereinRepo;
    }

    //CRUD FOR OBJECTS + OTHER METHODS
    public void addSpieler(String name, int age, String position, int value) {
        spielerRepo.add(new Spieler(name, age, position, value));
    }

    public void addVereine(String name, String city, List<Spieler> spielers) {
        vereinRepo.add(new Vereine(++newVereinID, name, city, spielers));
    }

    public void deleteSpieler(String name) {
        for(int i = 0; i<spielerRepo.getAll().size(); i++){
            if(spielerRepo.getAll().get(i).getName().equals(name)){
                spielerRepo.delete(i);
                break;
            }
        }
    }

    public void deleteVereine(int id) {
        vereinRepo.delete(id);
    }

    public List<Spieler> getAllSpielers() {
        return spielerRepo.getAll();
    }

    public List<Vereine> getAllVereines() {
        return vereinRepo.getAll();
    }

    public void updateSpieler(String name, int age, String position, int value) {
        Spieler spieler = spielerRepo.takeByName(name);
        spieler.setName(name);
        spieler.setAge(age);
        spieler.setPosition(position);
        spieler.setValue(value);
        spielerRepo.update(spieler);
    }
    public void updateVereine(int id, String name, String city, List<Spieler> spielers) {
        Vereine vereine = vereinRepo.get(id);
        vereine.setName(name);
        vereine.setCity(city);
        vereine.setPlayerList(spielers);
        vereinRepo.update(vereine);
    }

    public List<Vereine> filterVereineByCity(String city) {
        List<Vereine> allVereine = vereinRepo.getAll();
        return allVereine.stream().filter(v -> v.getCity().equals(city)).toList();
    }

    public List<Spieler> vereinePlayers(String name) {
//        List<Vereine> vereine = vereinRepo.getAll();
//        List<Spieler> result = new ArrayList<>();
//        for(Vereine spieler : spielers) {
//            if()
//        }
        return vereinRepo.getAll().stream().filter(v-> v.getName().equals(name)).map(v -> (Spieler) v.getPlayerList()).toList();
        //return spielerRepo.getAll().stream().filter(c -> c.get().stream().filter(p -> p.get().equals(season1)).toList().isEmpty()).toList();
    }

    public List<Spieler> sortByValue(int vereinID, String mode) {
        Vereine vereine = vereinRepo.get(vereinID);
        List<Spieler> spielers = vereine.getPlayerList();

        spielers.sort((p1, p2) -> mode.equals("asc") ? Integer.compare(p1.getValue(), p2.getValue()) : Integer.compare(p2.getValue(), p1.getValue()));
        return spielers;
    }

    public void addPlayerToVerein(String playerName, int vereinID) {
        Vereine vereine = vereinRepo.get(vereinID);
        Spieler spieler = spielerRepo.takeByName(playerName);
        vereine.getPlayerList().add(spieler);
        vereine.setPlayerList(vereine.getPlayerList());
        vereinRepo.update(vereine);
    }

}
