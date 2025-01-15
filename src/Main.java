import Repo.SpielerRepo;
import Repo.VereinRepo;

public class Main {
    public static void main(String[] args) {

        VereinRepo vereinRepo = new VereinRepo();
        SpielerRepo spielerRepo = new SpielerRepo();
        AppController controller = new AppController(spielerRepo, vereinRepo); // repo1, repo2
        AppUI ui = new AppUI(controller);

        ui.start();

    }
}