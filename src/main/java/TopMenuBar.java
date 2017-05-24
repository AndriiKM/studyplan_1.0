import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Kuznetcov.An on 13.05.2017.
 */
class TopMenuBar extends Control{
    private MenuBar menuBar;
    private Menu menu1;
    private MenuItem saveMenuItem;
    private MenuItem exitItem;
    private Menu menu3;
    private MenuItem aboutMenuItem;
    private SeparatorMenuItem separatorMenuItem;

    //Вверхнее меню
    public MenuBar launchTopMenuBar(){
    menuBar = new MenuBar();

        menu1 = new Menu("File");

        saveMenuItem = new MenuItem("Save", null);
        saveMenuItem.setStyle("-fx-padding: 0 15 0 12;");
        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showSaveDialog(new MainForm().getMainStage());

                if(file != null){
                    try {
                        SaveFile(new GetSaveFile().getSaveFile(), file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
        }});


        separatorMenuItem = new SeparatorMenuItem();

        exitItem = new MenuItem("Exit", null);
        exitItem.setMnemonicParsing(true);
        exitItem.setStyle("-fx-padding: 0 15 0 12;");
        exitItem.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));
        exitItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Platform.exit();
            }});

        menu1.getItems().addAll(saveMenuItem, separatorMenuItem, exitItem);


        menu3 = new Menu("Help");

        aboutMenuItem = new MenuItem("About", null);
        aboutMenuItem.setStyle("-fx-padding: 0 15 0 12;");


        menu3.getItems().addAll(aboutMenuItem);

    menuBar.getMenus().addAll(menu1, menu3);

    return menuBar;
    }
    private void SaveFile(String content, File file) {
        try {
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
