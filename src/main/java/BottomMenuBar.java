import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;


/**
 * Created by Андрей on 13.05.2017.
 */
public class BottomMenuBar extends FlowPane{
        private Label date;
        private FlowPane bottomMain;
        private FlowPane timePane;
        private GridPane addAddNenu;
        private TextField addName;
        private TextField addInfo;
        private TextField addLink;
        private ComboBox addStatus;
        private Button addAll;
        private Button deleteAllButton;
        private Label paneNameLabel;
        private String statusText1 = "Добавленно";
        private String statusText2 = "В процесси";
        private String statusText3 = "Изученно";
        private MainForm mainForm;
        private TitleClass titleClass;


    public BottomMenuBar(){
        }

    public FlowPane launchBottomMenuBar(){
        //Основная панель
        bottomMain = new FlowPane(Orientation.HORIZONTAL);
        bottomMain.setMaxHeight(155);
        bottomMain.setMinWidth(975);
        bottomMain.setStyle("-fx-background-color:#eeeeee; -fx-opacity:1;");
        bottomMain.setAlignment(Pos.CENTER);


        //Панель даты
        timePane = new FlowPane(Orientation.VERTICAL, 5, 5);
        timePane.setMaxHeight(155);
        timePane.setMinWidth(250);
        timePane.setAlignment(Pos.CENTER);
        timePane.setStyle("-fx-background-color:#000000; -fx-opacity:1;");


        date = new Label();
        date.setText(new DateAndClock().getCurrentTimeStamp());
        date.getStyleClass().add("date");
        timePane.getChildren().addAll(new DateAndClock(), date);



        // Панель добаления
        addAddNenu = new GridPane();
        addAddNenu.setMaxHeight(155);
        addAddNenu.setMinWidth(bottomMain.getMinWidth() - timePane.getMinWidth());
        addAddNenu.setAlignment(Pos.CENTER);
        addAddNenu.setVgap(12);
        addAddNenu.setHgap(8);
        addAddNenu.setGridLinesVisible(false);

        paneNameLabel = new Label("ДОБАВИТЬ В БАЗУ");
        paneNameLabel.getStyleClass().add("paneNameLabel");

        mainForm = new MainForm();
        titleClass = new TitleClass(mainForm.getNameTable());

        addName = new TextField();
        addName.setPromptText(titleClass.getFieldNameText());
        addName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (addName.getText().length() > 40) {
                    String s = addName.getText().substring(0, 40);
                    addName.setText(s);
                }
            }
        });

        addInfo = new TextField();
        addInfo.setPromptText(titleClass.getFieldInfoText());
        addInfo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (addInfo.getText().length() > 40) {
                    String s = addInfo.getText().substring(0, 40);
                    addInfo.setText(s);
                }
            }
        });

        addLink = new TextField();
        addLink.setPromptText(titleClass.getFieldLinkText());
        addLink.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (addLink.getText().length() > 50) {
                    String s = addLink.getText().substring(0, 50);
                    addLink.setText(s);
                }
            }
        });

        addStatus = new ComboBox();
        addStatus.setPromptText("Статус");
        addStatus.setEditable(false);
        addStatus.setMinWidth(250);
        addStatus.getItems().addAll(statusText1, statusText2, statusText3);


        addAll = new Button("Добавить информацию");
        addAll.setMinWidth(150);
        addAll.setOnAction(new EventHandler<ActionEvent>() {
                                       @Override
                                       public void handle(ActionEvent event) {
                                           if (addName.getText().length()>0 && addInfo.getText().length()>0 && addLink.getText().length()>0 && addStatus.getValue() != null) {
                                               GetInfoStore inf = new GetInfoStore(addName.getText(), addInfo.getText(), addLink.getText(), addStatus.getValue().toString());
                                               MyDataBase data = new MyDataBase(new MainForm().getNameTable(), inf);

                                               try {
                                                   data.insertInTable();
                                                   new AlertInfo(MyDataBase.message).getInfoAlert();

                                                   MainForm mainForm = new MainForm();
                                                   mainForm.getCentralTableView().getItems().clear();
                                                   mainForm.getCentralTableView().getItems().addAll(new Controller().get());

                                               } catch (SQLException e) {
                                                   e.printStackTrace();
                                               } catch (Exception e) {
                                                   e.printStackTrace();
                                               }
                                               addName.clear();
                                               addInfo.clear();
                                               addLink.clear();
                                               addStatus.getSelectionModel().clearSelection();

                                           }
                                           else new AlertInfo("Вами заполнены не все поля").getError();
                                       }
                                   });


        deleteAllButton = new Button("Очистить таблицу");
        deleteAllButton.setMinWidth(150);
        deleteAllButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new MyDataBase(new MainForm().getNameTable()).emptyTable();
                MainForm mainForm = new MainForm();
                mainForm.getCentralTableView().getItems().clear();
                try {
                    mainForm.getCentralTableView().getItems().addAll(new Controller().get());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                new AlertInfo(MyDataBase.message).getInfoAlert();
                }
        });

        addAddNenu.add(paneNameLabel, 1, 0);
        addAddNenu.add(addName, 0, 1);
        addAddNenu.add(addInfo, 2, 1);
        addAddNenu.add(addLink, 0, 2);
        addAddNenu.add(addStatus, 2, 2);
        addAddNenu.add(addAll, 1, 1);
        addAddNenu.add(deleteAllButton, 1, 2);


        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(35);
        columnConstraints.setHalignment(HPos.CENTER);
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setPercentWidth(25);
        columnConstraints1.setHalignment(HPos.CENTER);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setHalignment(HPos.CENTER);
        columnConstraints2.setPercentWidth(35);
        addAddNenu.getColumnConstraints().addAll(columnConstraints, columnConstraints1, columnConstraints2);


        bottomMain.getChildren().addAll(timePane, addAddNenu);

        return bottomMain;

    }
}
