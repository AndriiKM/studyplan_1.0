import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
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

    public GridPane launchLeftButtonBar(){

        gridLeftButton = new GridPane();
        gridLeftButton.setVgap(10);


        DropShadow dropShadow = new DropShadow();
        dropShadow.setSpread(0.5);

        ColorAdjust colorAdjustLight = new ColorAdjust();
        colorAdjustLight.setBrightness(0.4);

        ColorAdjust colorAdjustNormal = new ColorAdjust();
        colorAdjustLight.inputProperty();


        Image imageBook = new Image(getClass().getResourceAsStream("book.png"));
        bookButton = new Button();
        bookButton.setEffect(dropShadow);
        bookButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (new MainForm().getNameTable()!= 0){
                bookButton.setEffect(colorAdjustNormal);
                bookButton.setEffect(dropShadow);}
            }
        });
        bookButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (new MainForm().getNameTable()!= 0)
                    bookButton.setEffect(colorAdjustLight);
            }
        });
        bookButton.setStyle("-fx-padding: 0 0 0 0;");
        bookButton.graphicProperty().setValue(new ImageView(imageBook));
        bookButton.setPrefSize(120, 180);
        bookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    resetBars(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                bookButton.setEffect(colorAdjustNormal);
                bookButton.setEffect(dropShadow);
                linkButton.setEffect(colorAdjustLight);
                videoButton.setEffect(colorAdjustLight);

            }
        }) ;

        Image imageLink = new Image(getClass().getResourceAsStream("link.png"));
        linkButton = new Button();
        linkButton.setEffect(dropShadow);
        linkButton.setEffect(colorAdjustLight);
        linkButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (new MainForm().getNameTable()!= 1){
                linkButton.setEffect(colorAdjustNormal);
                linkButton.setEffect(dropShadow);
            }}
        });
        linkButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (new MainForm().getNameTable()!= 1) linkButton.setEffect(colorAdjustLight);
            }
        });
        linkButton.setStyle("-fx-padding: 0 0 0 0;");
        linkButton.graphicProperty().setValue(new ImageView(imageLink));
        linkButton.setPrefSize(120, 180);
        linkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    resetBars(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                linkButton.setEffect(colorAdjustNormal);
                linkButton.setEffect(dropShadow);
                bookButton.setEffect(colorAdjustLight);
                videoButton.setEffect(colorAdjustLight);
            }
        }) ;

        Image imageVideo = new Image(getClass().getResourceAsStream("video.png"));
        videoButton = new Button();
        videoButton.setEffect(dropShadow);
        videoButton.setEffect(colorAdjustLight);
        videoButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (new MainForm().getNameTable()!= 2){
                videoButton.setEffect(colorAdjustNormal);
                videoButton.setEffect(dropShadow);
            }}
        });
        videoButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (new MainForm().getNameTable()!= 2) videoButton.setEffect(colorAdjustLight);
            }
        });
        videoButton.setStyle("-fx-padding: 0 0 0 0;");
        videoButton.graphicProperty().setValue(new ImageView(imageVideo));
        videoButton.setPrefSize(120, 180);
        videoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    resetBars(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                linkButton.setEffect(colorAdjustLight);
                bookButton.setEffect(colorAdjustLight);
                videoButton.setEffect(colorAdjustNormal);
                videoButton.setEffect(dropShadow);

            }
        }) ;

        gridLeftButton.add(bookButton, 0, 0);
        gridLeftButton.add(linkButton, 0, 1);
        gridLeftButton.add(videoButton, 0, 2);

        return gridLeftButton;
    }
    void resetBars(int num) throws Exception {
        MainForm mainForm = new MainForm();
        mainForm.setNameTable(num);
        mainForm.getCentralTableView().getColumns().clear();

            TableView tableView = new CentralTable().launchCentralTable();
            mainForm.setCentralTableView(tableView);
            mainForm.getMainPanel().setCenter(mainForm.getCentralTableView());
            mainForm.getMainPanel().setMargin(mainForm.getCentralTableView(), new Insets(10, 10, 10, 0));

        mainForm.getBottomFlowPane().getChildren().clear();
        FlowPane flowPane = new BottomMenuBar().launchBottomMenuBar();
        mainForm.setBottomFlowPane(flowPane);
        mainForm.getMainPanel().setBottom(mainForm.getBottomFlowPane());
        mainForm.getMainPanel().setMargin(mainForm.getBottomFlowPane(), new Insets(0, 10, 10, 10));
    }
}
