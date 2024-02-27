package Model.Other;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Cortege<First,Second> {
    private First first;
    private Second second;
}
