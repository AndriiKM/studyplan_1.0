import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;

/**
 * Created by Андрей on 15.05.2017.
 */
public class Controller {
    ObservableList<GetInfoStore> list;
    ResultSet result;

    public ObservableList<GetInfoStore> get() throws Exception {

            list = FXCollections.observableArrayList();
            result = new MyDataBase(new MainForm().getNameTable()).getFromTable();

            while(result.next()){
                GetInfoStore getInfoStore = new GetInfoStore();

                getInfoStore.setId(result.getString("cell_id"));
                getInfoStore.setNameText(result.getString("name_column"));
                getInfoStore.setInfoText(result.getString("info_column"));
                getInfoStore.setLinkText(result.getString("link_column"));
                getInfoStore.setDateText(result.getString("date_column"));
                getInfoStore.setStatusText(result.getString("status_column"));

                list.add(getInfoStore);
            }
            return list;
    }
}
