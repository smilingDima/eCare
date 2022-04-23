package ecare.local.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public final class TariffDto {
    private long id;
    private String Name;
    private long Price;
}
