package intellias.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

  @JsonProperty(required = true)
  @NotBlank
  private Integer depSid;

  @JsonProperty(required = true)
  @NotBlank
  private Integer arrSid;

  @JsonProperty
  private Boolean directBusRoute;
}
