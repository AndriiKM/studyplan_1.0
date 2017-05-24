/**
 * Created by Kuznetcov.An on 15.05.2017.
 */
public class GetInfoStore {

    private String id;
    private String nameText;
    private String infoText;
    private String linkText;
    private String dateText;
    private String statusText;


    GetInfoStore(String addNameText, String addInfoText, String addLinkText, String addStatusText){
        nameText = addNameText;
        infoText = addInfoText;
        linkText = addLinkText;
        statusText = addStatusText;

    }

    GetInfoStore(){

    }

    public String getId(){
        return id;
    }
    public void setId(String addId){
        id = addId;
    }

    public String getNameText(){
        return nameText;
    }
    public void setNameText(String addNameText){
        nameText = addNameText;
    }

    public String getInfoText(){
        return infoText;
    }
    public void setInfoText(String addInfoText){
        infoText = addInfoText;
    }

    public String getLinkText(){
        return linkText;
    }
    public void setLinkText(String addLinkText){
        linkText = addLinkText;
    }

    public String getDateText(){
        return dateText;
    }
    public void setDateText(String addDateText){dateText = addDateText;}

    public String getStatusText(){
        return statusText;
    }
    public void setStatusText(String addStatusText){
        statusText = addStatusText;
    }


}