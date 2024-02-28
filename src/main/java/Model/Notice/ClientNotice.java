package Model.Notice;

import Model.Enums.AccountType;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientNotice {
    private  String event;
    private AccountType accountType;
}
