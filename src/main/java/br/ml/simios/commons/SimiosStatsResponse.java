package br.ml.simios.commons;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimiosStatsResponse {

    @JsonProperty("count_mutant_dna")
    private Integer simios;

    @JsonProperty("count_human_dna")
    private Integer humans;
    
    private Double ratio;

}
