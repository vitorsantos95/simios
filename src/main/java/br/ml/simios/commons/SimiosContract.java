package br.ml.simios.commons;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface SimiosContract {

    String API = "application/json";

    @GetMapping(produces = API, path = "/stats")
    ResponseEntity<SimiosStatsResponse> retrieveSimiosStatistics ();

    @PostMapping(produces = API, path = "/simian")
    ResponseEntity<Void> registerDna (@RequestBody final SimiosRequest dna);

}
