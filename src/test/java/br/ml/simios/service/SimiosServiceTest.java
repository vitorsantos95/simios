package br.ml.simios.service;

import static br.ml.simios.DnaUtils.buildDiagonalLeftSimian11x11;
import static br.ml.simios.DnaUtils.buildDiagonalLeftSimian5x5;
import static br.ml.simios.DnaUtils.buildDiagonalLeftSimian6x6;
import static br.ml.simios.DnaUtils.buildDiagonalMiddleLeftSimian10x10;
import static br.ml.simios.DnaUtils.buildDiagonalMiddleLeftSimian5x5;
import static br.ml.simios.DnaUtils.buildDiagonalMiddleRightSimian10x10;
import static br.ml.simios.DnaUtils.buildDiagonalMiddleRightSimian5x5;
import static br.ml.simios.DnaUtils.buildDiagonalRightSimian11x11;
import static br.ml.simios.DnaUtils.buildDiagonalRightSimian5x5;
import static br.ml.simios.DnaUtils.buildDiagonalRightSimian6x6;
import static br.ml.simios.DnaUtils.buildEmptyMatrix;
import static br.ml.simios.DnaUtils.buildHorizontalSimian11x11;
import static br.ml.simios.DnaUtils.buildHorizontalSimian5x5;
import static br.ml.simios.DnaUtils.buildHuman11x11;
import static br.ml.simios.DnaUtils.buildHuman5x5;
import static br.ml.simios.DnaUtils.buildNotNxNMatriz;
import static br.ml.simios.DnaUtils.buildVerticalSimian11X11;
import static br.ml.simios.DnaUtils.buildVerticalSimian5x5;

import java.util.ArrayList;
import java.util.List;

import br.ml.simios.excetions.InvalidMatrixException;
import br.ml.simios.repository.SimiosRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SimiosServiceTest {

    @Mock
    private List<String> acceptedDna;

    @Mock
    private SimiosRepository simiosRepository;

    @InjectMocks
    SimiosServiceImpl simiosService;

    @BeforeEach
    public void before () {
        simiosService.acceptedDna = new ArrayList<>();
        simiosService.acceptedDna.add("CCCC");
        simiosService.acceptedDna.add("TTTT");
        simiosService.acceptedDna.add("GGGG");
        simiosService.acceptedDna.add("AAAA");
    }

    @Test
    public void testSimianVertical5x5 () throws InvalidMatrixException {
        final List<String> simian5x5 = buildVerticalSimian5x5();
        final boolean simian = simiosService.isSimian(simian5x5);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianVertical11x11 () throws InvalidMatrixException {
        final List<String> simianList = buildVerticalSimian11X11();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianHorizontal5x5 () throws InvalidMatrixException {
        final List<String> simianList = buildHorizontalSimian5x5();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianHorizontall11x11 () throws InvalidMatrixException {
        final List<String> simianList = buildHorizontalSimian11x11();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalRight5x5 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalRightSimian5x5();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalRight6x6 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalRightSimian6x6();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalLeft5x5 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalLeftSimian5x5();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalLeft6x6 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalLeftSimian6x6();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalRight11x11 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalRightSimian11x11();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalLeft11x11 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalLeftSimian11x11();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalRightMiddle5x5 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalMiddleRightSimian5x5();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalRightMiddle10x10 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalMiddleRightSimian10x10();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalLeftMiddle5x5 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalMiddleLeftSimian5x5();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testSimianDiagonalLeftMiddle10x10 () throws InvalidMatrixException {
        final List<String> simianList = buildDiagonalMiddleLeftSimian10x10();
        final boolean simian = simiosService.isSimian(simianList);
        Assert.assertTrue(simian);
    }

    @Test
    public void testHuman5x5 () throws InvalidMatrixException {
        final List<String> human5x5 = buildHuman5x5();
        final boolean simian = simiosService.isSimian(human5x5);
        Assert.assertFalse(simian);
    }

    @Test
    public void testHuman11x11 () throws InvalidMatrixException {
        final List<String> human11x11 = buildHuman11x11();
        final boolean simian = simiosService.isSimian(human11x11);
        Assert.assertFalse(simian);
    }
//
//    @Test
//    public void testInvalidMatrix () throws InvalidMatrixException {
//        final List<String> notNxNMatriz = buildNotNxNMatriz();
//        Mockito.when(simiosService.isSimian(notNxNMatriz)).thenThrow(InvalidMatrixException.class);
//    }
//
//    @Test
//    public void testEmptyMatrix () throws InvalidMatrixException {
//        final List<String> emptyMatrix = buildEmptyMatrix();
//        Mockito.when(simiosService.isSimian(emptyMatrix)).thenThrow(InvalidMatrixException.class);
//    }
}

