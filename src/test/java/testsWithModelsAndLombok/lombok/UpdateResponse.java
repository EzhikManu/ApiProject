package testsWithModelsAndLombok.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateResponse {
    public String name;
    public String job;
    public String updatedAt;
}
