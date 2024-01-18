package kg.esep.models.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import kg.esep.enums.Side;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@JsonIgnoreProperties( ignoreUnknown = true )
public class ExchangeRequestDto
{
    @JsonProperty( "source" ) // source
    private Currency sourceCurrency;

    @JsonProperty( "target" ) // target
    private Currency targetCurrency;

    @JsonProperty( "rate" ) // rate
    private Double rate;

    @JsonProperty( "side" ) // side
    private Side side;
}
