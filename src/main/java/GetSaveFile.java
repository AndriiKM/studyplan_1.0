import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;

/**
 * Created by Андрей on 18.05.2017.
 */

public class GetSaveFile {
    private ObservableList<GetInfoStore> list;
    private ResultSet result;
    private String saveFile = "";

    public String getSaveFile() throws Exception {

        list = FXCollections.observableArrayList();
        result = new MyDataBase(new MainForm().getNameTable()).getFromTable();

        while(result.next()){
            String rez = result.getString("cell_id")+" "
            + result.getString("name_column")+" "
            + result.getString("info_column")+" "
            + result.getString("link_column")+" "
            + result.getString("date_column")+" "
            + result.getString("status_column")
            + " \r\n";

            saveFile += rez;
        }
        return saveFile;
    }
}
