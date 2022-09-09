package core.ics.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonSaveRequest {

    Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String personName;

    @NotBlank
    @Size(max = 14)
    private String cpf;

    @NotBlank
    @Size(max = 8)
    private String address;

    @NotBlank
    @Size(max = 20)
    private String tokenKey;
}
