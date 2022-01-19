package testsWithModelsAndLombok.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsuccessfulRegRequest {
    public String email;
}
