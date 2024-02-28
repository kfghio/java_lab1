package Entity.Clients;

import Model.Enums.StatusType;
import Model.Notice.ClientNotice;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Client {

    private int clientID;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    private String emailAdress;
    private int passport;
    private StatusType statusType;
    private List<ClientNotice> clientNotices;

    /**
     * Initializes the client and validates the status
     * @param clientID Client's ID
     * @param name Client's name
     * @param surname Client's surname
     * @param emailAdress Client's adress
     * @param passport Client's passport numbers
     */
    public Client(int clientID,@NonNull String name, @NonNull String surname, String emailAdress, int passport){
        this.clientID =  clientID;
        this.name = name;
        this.surname = surname;
        this.emailAdress = emailAdress;
        this.passport = passport;
        clientNotices = new ArrayList<>();
        validation();
    }

    /**
     * Checks the initialized data and sets the status to the client
     */
    public void validation(){
        if(this.emailAdress == null || this.passport == 0)
            statusType = StatusType.QUESTIONABLE;
        else
            statusType = StatusType.NOTQUESTIONABLE;
    }

    /**
     * Adds a notification
     * @param clientNotice Notification
     */
    public void update(ClientNotice clientNotice){
        clientNotices.add(clientNotice);
    }


}
