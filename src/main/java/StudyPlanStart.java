import javafx.application.Application;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


/**
 * Created by Kuznetcov.An on 12.05.2017.
 */
public class StudyPlanStart extends Application {

    @Override
    public void init() throws Exception {
        super.init();
        MainForm mainForm = new MainForm();
        mainForm.setNameTable(0);
        TableView tableView = new CentralTable().launchCentralTable();
        mainForm.setCentralTableView(tableView);

    }

    @Override
    public void start(Stage mainStage) throws Exception {
    new MainForm().launchMainForm(mainStage);
    }


    public static void main(String[] args) {
       launch();
    }
}
