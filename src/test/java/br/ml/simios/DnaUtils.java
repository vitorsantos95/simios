package br.ml.simios;

import java.util.ArrayList;
import java.util.List;

public class DnaUtils {

    public static List<String> buildNotNxNMatriz () {
        List<String> dna = new ArrayList<>();
        dna.add("HHHHH");
        dna.add("HHHHH");
        dna.add("HHHHH");
        dna.add("HHHHH");
        return dna;
    }

    public static List<String> buildEmptyMatrix () {
        return new ArrayList<>();
    }

    public static List<String> buildHuman5x5 () {
        List<String> dna = new ArrayList<>();
        dna.add("HHHHH");
        dna.add("HHHHH");
        dna.add("HHHHH");
        dna.add("HHHHH");
        dna.add("HHHHH");
        return dna;
    }

    public static List<String> buildHuman11x11 () {
        List<String> dna = new ArrayList<>();
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        return dna;
    }

    public static List<String> buildVerticalSimian5x5 () {
        List<String> dna = new ArrayList<>();
        dna.add("AUIOQ");
        dna.add("AUIOQ");
        dna.add("AUIOQ");
        dna.add("AUIOQ");
        dna.add("XUIOQ");
        return dna;
    }

    public static List<String> buildHorizontalSimian5x5 () {
        List<String> dna = new ArrayList<>();
        dna.add("VUIOQ");
        dna.add("FAAAA");
        dna.add("FUIOQ");
        dna.add("FUIOQ");
        dna.add("AUIOQ");
        return dna;
    }

    public static List<String> buildVerticalSimian11X11 () {
        List<String> dna = new ArrayList<>();
        dna.add("AUIOQGSSSSS");
        dna.add("AUIOQTSSSSS");
        dna.add("AUIOQTSSSSS");
        dna.add("AUIOQTSSSSS");
        dna.add("XUIOQTSSSSS");
        dna.add("IUIOQGSSGSS");
        dna.add("IUIOQTSSGSS");
        dna.add("IIUIOQTSGSS");
        dna.add("IUIOQTSSGSS");
        dna.add("XUIOQTSSSSS");
        dna.add("AUIOQTSSSSS");
        return dna;
    }

    public static List<String> buildHorizontalSimian11x11 () {
        List<String> dna = new ArrayList<>();
        dna.add("VUIOQVUIOQA");
        dna.add("FAAAAVUIOQA");
        dna.add("FUIOQVUIOQA");
        dna.add("FUIOQVUIOQH");
        dna.add("AUIOQVUIOQA");
        dna.add("VUIOQVUIOQA");
        dna.add("LLLLLLLLLLL");
        dna.add("FAAAAVUIOQA");
        dna.add("FUIOQVUIOQA");
        dna.add("FUIOQVUIOQH");
        dna.add("AUIOQVUIOQA");
        return dna;
    }

    public static List<String> buildDiagonalMiddleRightSimian5x5 () {
        List<String> dna = new ArrayList<>();
        dna.add("ABBBB");
        dna.add("BABBB");
        dna.add("BBABB");
        dna.add("BBBAB");
        dna.add("BBBBG");
        return dna;
    }

    public static List<String> buildDiagonalMiddleLeftSimian5x5 () {
        List<String> dna = new ArrayList<>();
        dna.add("BBBBA");
        dna.add("BBBAB");
        dna.add("BBABB");
        dna.add("BABBB");
        dna.add("BBBBB");
        return dna;
    }

    public static List<String> buildDiagonalRightSimian11x11 () {
        List<String> dna = new ArrayList<>();
        dna.add("HGHHHHHHHHH");
        dna.add("HHGHHHHHHHH");
        dna.add("HHHGHHHHHHH");
        dna.add("HHHHGHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHAHHHH");
        dna.add("HHHHHHHAHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        dna.add("HHHHHHHHHHH");
        return dna;
    }

    public static List<String> buildDiagonalLeftSimian11x11 () {
        List<String> dna = new ArrayList<>();
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVGVV");
        dna.add("VVVVVVVGVVV");
        dna.add("VVVVVVGVVVV");
        dna.add("VVVVVGVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        return dna;
    }

    public static List<String> buildDiagonalMiddleRightSimian10x10 () {
        List<String> dna = new ArrayList<>();
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVAVVVVVVV");
        dna.add("VVAVVVVVVVV");
        dna.add("VAVVVVVVVVV");
        dna.add("AVVVVVVVVVV");
        return dna;
    }

    public static List<String> buildDiagonalMiddleLeftSimian10x10 () {
        List<String> dna = new ArrayList<>();
        dna.add("AVVVVVVVVVV");
        dna.add("VAVVVVVVVVV");
        dna.add("VVAVVVVVVVV");
        dna.add("VVVAVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        dna.add("VVVVVVVVVVV");
        return dna;
    }

    public static List<String> buildDiagonalRightSimian5x5 () {
        List<String> dna = new ArrayList<>();
        dna.add("VVVVV");
        dna.add("VVVVT");
        dna.add("VVVTV");
        dna.add("VVTVV");
        dna.add("VTVVV");
        return dna;
    }

    public static List<String> buildDiagonalRightSimian6x6 () {
        List<String> dna = new ArrayList<>();
        dna.add("VVVVVV");
        dna.add("VVVVTV");
        dna.add("VVVTVV");
        dna.add("VVTVVV");
        dna.add("VTVVVV");
        dna.add("VTVVVV");
        return dna;
    }

    public static List<String> buildDiagonalLeftSimian5x5 () {
        List<String> dna = new ArrayList<>();
        dna.add("VVVVV");
        dna.add("CVVVV");
        dna.add("VCVVV");
        dna.add("VVCVV");
        dna.add("VVVCV");
        return dna;
    }

    public static List<String> buildDiagonalLeftSimian6x6 () {
        List<String> dna = new ArrayList<>();
        dna.add("VVVVVV");
        dna.add("CVVVVV");
        dna.add("VCVVVV");
        dna.add("VVCVVV");
        dna.add("VVVCVV");
        dna.add("VVVCVV");
        return dna;
    }

}
