package core.ics.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonSaveRequest {

    @NotBlank
    @Size(min = 2, max = 50)
    private String personName;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 50)
    private String address;

    @NotBlank
    private String tokenKey;
}
