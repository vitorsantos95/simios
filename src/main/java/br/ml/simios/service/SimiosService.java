package br.ml.simios.service;

import java.util.List;

import br.ml.simios.commons.SimiosStatsResponse;
import br.ml.simios.excetions.InvalidMatrixException;

public interface SimiosService {
    
    SimiosStatsResponse retrieveSimiosStatistics ();

    boolean isSimian (List<String> dna) throws InvalidMatrixException;
}
