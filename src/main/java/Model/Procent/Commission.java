package Model.Procent;

import Model.Enums.AccountType;
import Model.Other.Cortege;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commission {
    private double percent;
    private Cortege<Double, Double> cortege;
    private AccountType accountType;
}
