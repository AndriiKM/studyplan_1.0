import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.util.Callback;
import javafx.util.converter.DefaultStringConverter;

import javax.swing.text.TabExpander;
import java.beans.EventHandler;

/**
 * Created by Kuznetcov.An on 13.05.2017.
 */
public class CentralTable {
    private TableView<GetInfoStore> table;
    private TableColumn<GetInfoStore, String> cellId;
    private TableColumn<GetInfoStore, String> nameColumn;
    private TableColumn<GetInfoStore, String> infoColumn;
    private TableColumn<GetInfoStore, String> linkColumn;
    private TableColumn<GetInfoStore, String> dateColumn;
    private TableColumn<GetInfoStore, String> statusColumn;
    private Controller controller;
    private MainForm mainForm;
    private ObservableList<GetInfoStore> list;


    public TableView launchCentralTable() throws Exception {

        controller = new Controller();
        list = FXCollections.observableArrayList();
        list = controller.get();
        mainForm = new MainForm();

        table = new TableView();
        table.setVisible(true);
        table.setEditable(true);

        cellId = new TableColumn(new TitleClass(mainForm.getNameTable()).getId());
        cellId.setCellValueFactory(new PropertyValueFactory<GetInfoStore, String>("id"));
        cellId.setMinWidth(20);

        nameColumn = new TableColumn(new TitleClass(mainForm.getNameTable()).getNameText());
        nameColumn.setCellValueFactory(new PropertyValueFactory<GetInfoStore, String>("nameText"));
        nameColumn.setMinWidth(130);

        infoColumn = new TableColumn(new TitleClass(mainForm.getNameTable()).getInfoText());
        infoColumn.setCellValueFactory(new PropertyValueFactory<GetInfoStore, String>("infoText"));
        infoColumn.setMinWidth(130);

        linkColumn = new TableColumn(new TitleClass(mainForm.getNameTable()).getLinkText());
        linkColumn.setCellValueFactory(new PropertyValueFactory<GetInfoStore, String>("linkText"));
        linkColumn.setMinWidth(200);

        dateColumn = new TableColumn(new TitleClass(mainForm.getNameTable()).getDateText());
        dateColumn.setCellValueFactory(new PropertyValueFactory<GetInfoStore, String>("dateText"));
        dateColumn.setMinWidth(150);

        statusColumn = new TableColumn(new TitleClass(mainForm.getNameTable()).getStatusText());
        statusColumn.setCellValueFactory(new PropertyValueFactory<GetInfoStore, String>("statusText"));
        statusColumn.prefWidthProperty().bind(
                table.widthProperty()
                        .subtract(cellId.widthProperty())
                        .subtract(nameColumn.widthProperty())
                        .subtract(infoColumn.widthProperty())
                        .subtract(linkColumn.widthProperty())
                        .subtract(dateColumn.widthProperty()));


        ObservableList<String> cbValues = FXCollections.observableArrayList("Добавленно", "В процесси", "Изученно");
        statusColumn.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), cbValues));

        statusColumn.setOnEditCommit((TableColumn.CellEditEvent<GetInfoStore, String> event) -> {
            TablePosition<GetInfoStore, String> pos = event.getTablePosition();
            int row = pos.getRow();

            GetInfoStore getInfoStore = event.getTableView().getItems().get(row);
            getInfoStore.setStatusText(event.getNewValue());
            new MyDataBase(mainForm.getNameTable(), getInfoStore).changeStatusInCell();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информационное окно");
            alert.setHeaderText(null);
            alert.setContentText(MyDataBase.message);
            alert.showAndWait();

            MainForm mainForm = new MainForm();
            mainForm.getCentralTableView().getItems().clear();
            try {
                mainForm.getCentralTableView().getItems().addAll(new Controller().get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        table.setItems(list);

        table.getColumns().addAll(cellId, nameColumn, infoColumn, linkColumn, dateColumn, statusColumn);

        return table;

    }
}
