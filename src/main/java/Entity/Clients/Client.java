package Entity.Clients;

import Model.Enums.StatusType;
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

    public Client(int clientID,@NonNull String name, @NonNull String surname, String emailAdress, int passport){
        this.clientID =  clientID;
        this.name = name;
        this.surname = surname;
        this.emailAdress = emailAdress;
        this.passport = passport;
        validation();
    }

    void validation(){
        if(this.emailAdress == null || this.passport == 0)
            statusType = StatusType.QUESTIONABLE;
        else
            statusType = StatusType.NOTQUESTIONABLE;
    }


}
