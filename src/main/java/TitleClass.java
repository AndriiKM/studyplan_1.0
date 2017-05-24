/**
 * Created by Андрей on 17.05.2017.
 */
public class TitleClass {
    private String id;
    private String nameText;
    private String infoText;
    private String linkText;
    private String dateText;
    private String statusText;
    private String addFieldNameText;
    private String addFieldInfoText;
    private String addFieldLinkText;
    private int tableName;


    TitleClass(int tableName){
        this.tableName = tableName;
        setTextInTable();
        setTextInFields();
    }

    private void setTextInTable(){
        switch (tableName){
            case 0:
                id = "Id";
                nameText = "Название книги";
                infoText = "Автор книги";
                linkText = "Ссылка на книгу";
                dateText = "Дата добаления";
                statusText = "Статус изучения";
                break;
            case 1:
                id = "Id";
                nameText = "Название сайта";
                infoText = "Тема сайта";
                linkText = "Ссылка на сайт";
                dateText = "Дата добаления";
                statusText = "Статус изучения";
                break;
            case 2:
                id = "Id";
                nameText = "Название видео";
                infoText = "Тема видео";
                linkText = "Ссылка на видео";
                dateText = "Дата добаления";
                statusText = "Статус изучения";
                break;

        }
    }

    private void setTextInFields(){
        switch (tableName){
            case 0:
                addFieldNameText = "Введите название книги";
                addFieldInfoText = "Введите автора книги";
                addFieldLinkText = "Введите ссылку на книги";
                break;
            case 1:
                addFieldNameText = "Введите название сайта";
                addFieldInfoText = "Введите тему сайта";
                addFieldLinkText = "Введите ссылку на сайт";
                break;
            case 2:
                addFieldNameText = "Введите название видео";
                addFieldInfoText = "Введите тему видео";
                addFieldLinkText = "Введите ссылку на видео";
                break;

        }
    }

    public String getFieldNameText(){
        return addFieldNameText;
    }
    public String getFieldInfoText(){
        return addFieldInfoText;
    }
    public String getFieldLinkText(){
        return addFieldLinkText;
    }

    public String getId(){
        return id;
    }
    public String getNameText(){
        return nameText;
    }
    public String getInfoText(){
        return infoText;
    }
    public String getLinkText(){
        return linkText;
    }
    public String getDateText(){
        return dateText;
    }
    public String getStatusText(){
        return statusText;
    }
}
