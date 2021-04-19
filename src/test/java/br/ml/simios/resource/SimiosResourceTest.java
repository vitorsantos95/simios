package br.ml.simios.resource;

import static br.ml.simios.DnaUtils.buildEmptyMatrix;
import static br.ml.simios.DnaUtils.buildHuman5x5;
import static br.ml.simios.DnaUtils.buildNotNxNMatriz;
import static br.ml.simios.DnaUtils.buildVerticalSimian5x5;

import java.util.List;

import br.ml.simios.commons.SimiosRequest;
import br.ml.simios.commons.SimiosStatsResponse;
import br.ml.simios.excetions.InvalidMatrixException;
import br.ml.simios.service.SimiosService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class SimiosResourceTest {

    @Mock
    private SimiosService simiosService;

    @InjectMocks
    private SimiosResource simiosResource;

    @Test
    public void testRegisterSimianDNA() throws InvalidMatrixException {
        final List<String> simian5x5 = buildVerticalSimian5x5();
        final SimiosRequest simiosRequest = SimiosRequest.builder().dna(simian5x5).build();

        Mockito.when(simiosService.isSimian(simian5x5)).thenReturn(true);

        final ResponseEntity<Void> responseEntity = simiosResource.registerDna(simiosRequest);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testRegisterHumanDNA() throws InvalidMatrixException {
        final List<String> human5x5 = buildHuman5x5();
        final SimiosRequest simiosRequest = SimiosRequest.builder().dna(human5x5).build();

        Mockito.when(simiosService.isSimian(human5x5)).thenReturn(false);

        final ResponseEntity<Void> responseEntity = simiosResource.registerDna(simiosRequest);

        Assert.assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());

    }

    @Test
    public void testRegisterNullDna(){
        final ResponseEntity<Void> responseEntity = simiosResource.registerDna(null);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void testRegisterEmptyDna(){
        final List<String> emptyMatrix = buildEmptyMatrix();
        final SimiosRequest simiosRequest = SimiosRequest.builder().dna(emptyMatrix).build();
        final ResponseEntity<Void> responseEntity = simiosResource.registerDna(simiosRequest);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void testInvalidMatrixDna() throws InvalidMatrixException {
        final List<String> notNxNMatriz = buildNotNxNMatriz();
        final SimiosRequest simiosRequest = SimiosRequest.builder().dna(notNxNMatriz).build();
        Mockito.when(simiosService.isSimian(notNxNMatriz)).thenThrow(InvalidMatrixException.class);
        final ResponseEntity<Void> responseEntity = simiosResource.registerDna(simiosRequest);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void testRetrieveSimiosStatistics () {
        final SimiosStatsResponse simiosStatsResponse = SimiosStatsResponse.builder()
                .ratio(0.5)
                .simios(1)
                .humans(2)
                .build();
        final ResponseEntity<SimiosStatsResponse> responseEntity = ResponseEntity.ok(simiosStatsResponse);
        Mockito.when(simiosService.retrieveSimiosStatistics()).thenReturn(simiosStatsResponse);

        final ResponseEntity<SimiosStatsResponse> simiosStatsResponseResponseEntity = simiosResource
                .retrieveSimiosStatistics();
        Assert.assertEquals(simiosStatsResponseResponseEntity.getStatusCode(), responseEntity.getStatusCode());
        Assert.assertEquals(simiosStatsResponseResponseEntity.getBody().getSimios(), responseEntity.getBody().getSimios());
        Assert.assertEquals(simiosStatsResponseResponseEntity.getBody().getHumans(), responseEntity.getBody().getHumans());
        Assert.assertEquals(simiosStatsResponseResponseEntity.getBody().getRatio(), responseEntity.getBody().getRatio());
    }
}
