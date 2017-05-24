import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 * Created by Kuznetcov.An on 12.05.2017.
 */
class MainForm {
    private static Stage mainStage;
    private static BorderPane mainPanel;
    private Scene mainScene;
    private GridPane leftButtonBar;
    private static TableView centralTableView;
    private static FlowPane bottomFlowPane;
    private static int nameTable;

    public Stage getMainStage(){
        return mainStage;
    }

    public void setMainStage(Stage mainStage){
        this.mainStage = mainStage;
    }

    public BorderPane getMainPanel(){
        return mainPanel;
    }

    public void setMainPanel(BorderPane mainPanel){
        this.mainPanel = mainPanel;
    }

    public TableView getCentralTableView(){
        return centralTableView;
    }

    public void setCentralTableView(TableView centralTableView){
        this.centralTableView = centralTableView;
    }

    public int getNameTable(){
        return nameTable;
    }

    public void setNameTable(int nameTable){
        this.nameTable = nameTable;
    }

    public FlowPane getBottomFlowPane(){
        return bottomFlowPane;
    }

    public void setBottomFlowPane(FlowPane bottomFlowPane){
        this.bottomFlowPane = bottomFlowPane;
    }



    public void launchMainForm(Stage mainStage) throws Exception{
    this.mainStage = mainStage;

    //Настроить стейдж
    mainStage.setTitle("Study Plan");
    mainStage.setResizable(false);
    mainStage.setWidth(1000);
    mainStage.setHeight(800);

    //Установить по центру
    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
    mainStage.setX((primScreenBounds.getWidth() - mainStage.getWidth()) / 2);
    mainStage.setY((primScreenBounds.getHeight() - mainStage.getHeight()) / 2);

    //Задаем компоновку
    mainPanel = new BorderPane();
    mainPanel.setBackground(Background.EMPTY);

    //Делаем сцену
    mainScene = new Scene(mainPanel, 1000, 800);
    mainScene.setFill(Color.GREY);
    mainStage.setScene(mainScene);


    mainPanel.setTop(new TopMenuBar().launchTopMenuBar());

    leftButtonBar = new LeftButtonBar().launchLeftButtonBar();
    mainPanel.setLeft(leftButtonBar);
    mainPanel.setMargin(leftButtonBar, new Insets(10));

    mainPanel.setCenter(centralTableView);
    mainPanel.setMargin(centralTableView, new Insets(10, 10, 10, 0));

    bottomFlowPane = new BottomMenuBar().launchBottomMenuBar();
    mainPanel.setBottom(bottomFlowPane);
    mainPanel.setMargin(bottomFlowPane, new Insets(0, 10, 10, 10));

    mainStage.show();

    }
}
