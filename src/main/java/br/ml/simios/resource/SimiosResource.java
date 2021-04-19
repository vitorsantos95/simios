package br.ml.simios.resource;

import java.util.List;

import br.ml.simios.commons.SimiosContract;
import br.ml.simios.commons.SimiosRequest;
import br.ml.simios.commons.SimiosStatsResponse;
import br.ml.simios.excetions.InvalidMatrixException;
import br.ml.simios.service.SimiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimiosResource implements SimiosContract {

    @Autowired
    private SimiosService simiosService;

    @Override
    public ResponseEntity<SimiosStatsResponse> retrieveSimiosStatistics () {
        return ResponseEntity.ok(simiosService.retrieveSimiosStatistics());
    }

    @Override
    public ResponseEntity<Void> registerDna (final SimiosRequest request) {

        if (request == null || request.getDna().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        final List<String> dna = request.getDna();
        final boolean simian;
        try {
            simian = simiosService.isSimian(dna);
        } catch (InvalidMatrixException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (simian) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
