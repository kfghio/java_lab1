package Model.Clients;

import Model.Enums.StatusType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private final List<Integer> accountList = new ArrayList<>();
    private String name;
    private String surname;
    private String emailAdress;
    private int passport;
    private StatusType statusType;

}
