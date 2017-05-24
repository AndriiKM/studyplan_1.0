import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 * Created by Kuznetcov.An on 13.05.2017.
 */
public class LeftButtonBar{
    private GridPane gridLeftButton;
    private Button bookButton;
    private Button linkButton;
    private Button videoButton;
    MainForm mainForm;

    public GridPane launchLeftButtonBar(){

        gridLeftButton = new GridPane();
        gridLeftButton.setVgap(10);

        Bloom firsBloom = new Bloom();
        firsBloom.setThreshold(10);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setWidth(20);

        Image imageBook = new Image(getClass().getResourceAsStream("book.png"));
        bookButton = new Button();
        bookButton.setEffect(dropShadow);
        bookButton.setStyle("-fx-padding: 0 0 0 0;");
        bookButton.graphicProperty().setValue(new ImageView(imageBook));
        bookButton.setPrefSize(120, 180);
        bookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainForm mainForm = new MainForm();
                mainForm.setNameTable(0);
                mainForm.getCentralTableView().getColumns().clear();
                try {
                    TableView tableView = new CentralTable().launchCentralTable();
                    mainForm.setCentralTableView(tableView);
                    mainForm.getMainPanel().setCenter(mainForm.getCentralTableView());
                    mainForm.getMainPanel().setMargin(mainForm.getCentralTableView(), new Insets(10, 10, 10, 0));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                mainForm.getBottomFlowPane().getChildren().clear();
                FlowPane flowPane = new BottomMenuBar().launchBottomMenuBar();
                mainForm.setBottomFlowPane(flowPane);
                mainForm.getMainPanel().setBottom(mainForm.getBottomFlowPane());
                mainForm.getMainPanel().setMargin(mainForm.getBottomFlowPane(), new Insets(0, 10, 10, 10));

            }
        }) ;

        Image imageLink = new Image(getClass().getResourceAsStream("link.png"));
        linkButton = new Button();
        linkButton.setEffect(dropShadow);
        linkButton.setStyle("-fx-padding: 0 0 0 0;");
        linkButton.graphicProperty().setValue(new ImageView(imageLink));
        linkButton.setPrefSize(120, 180);
        linkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainForm mainForm = new MainForm();
                mainForm.setNameTable(1);
                mainForm.getCentralTableView().getColumns().clear();
                try {
                    TableView tableView = new CentralTable().launchCentralTable();
                    mainForm.setCentralTableView(tableView);
                    mainForm.getMainPanel().setCenter(mainForm.getCentralTableView());
                    mainForm.getMainPanel().setMargin(mainForm.getCentralTableView(), new Insets(10, 10, 10, 0));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                mainForm.getBottomFlowPane().getChildren().clear();
                FlowPane flowPane = new BottomMenuBar().launchBottomMenuBar();
                mainForm.setBottomFlowPane(flowPane);
                mainForm.getMainPanel().setBottom(mainForm.getBottomFlowPane());
                mainForm.getMainPanel().setMargin(mainForm.getBottomFlowPane(), new Insets(0, 10, 10, 10));

            }
        }) ;

        Image imageVideo = new Image(getClass().getResourceAsStream("video.png"));
        videoButton = new Button();
        videoButton.setEffect(dropShadow);
        videoButton.setStyle("-fx-padding: 0 0 0 0;");
        videoButton.graphicProperty().setValue(new ImageView(imageVideo));
        videoButton.setPrefSize(120, 180);
        videoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainForm mainForm = new MainForm();
                mainForm.setNameTable(2);
                mainForm.getCentralTableView().getColumns().clear();
                try {
                    TableView tableView = new CentralTable().launchCentralTable();
                    mainForm.setCentralTableView(tableView);
                    mainForm.getMainPanel().setCenter(mainForm.getCentralTableView());
                    mainForm.getMainPanel().setMargin(mainForm.getCentralTableView(), new Insets(10, 10, 10, 0));

                } catch (Exception e) {
                    e.printStackTrace();
                }

                mainForm.getBottomFlowPane().getChildren().clear();
                FlowPane flowPane = new BottomMenuBar().launchBottomMenuBar();
                mainForm.setBottomFlowPane(flowPane);
                mainForm.getMainPanel().setBottom(mainForm.getBottomFlowPane());
                mainForm.getMainPanel().setMargin(mainForm.getBottomFlowPane(), new Insets(0, 10, 10, 10));
            }
        }) ;

        gridLeftButton.add(bookButton, 0, 0);
        gridLeftButton.add(linkButton, 0, 1);
        gridLeftButton.add(videoButton, 0, 2);

        return gridLeftButton;

    }
}
