package testsWithModelsAndLombok.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserRespData {
    @JsonProperty("data")
    private SingleUserResponse data;

}
