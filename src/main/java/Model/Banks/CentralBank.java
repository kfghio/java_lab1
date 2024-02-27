package Model.Banks;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
public class CentralBank {
    private final List<CommercialBank> commercialBanks = new ArrayList<>();
}
