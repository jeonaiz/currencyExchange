package kg.esep.models.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import kg.esep.enums.Type;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@JsonIgnoreProperties( ignoreUnknown = true )
public class EsepEvent
{

    @JsonProperty( "type" )
    private Type type;

    @JsonProperty( "m" )
    private String message;
}
