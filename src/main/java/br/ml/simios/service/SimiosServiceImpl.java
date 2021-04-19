package br.ml.simios.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.ml.simios.commons.SimiosStatsResponse;
import br.ml.simios.entity.SimiosEntity;
import br.ml.simios.excetions.InvalidMatrixException;
import br.ml.simios.repository.SimiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimiosServiceImpl implements SimiosService {

    @Value("${acceptedDna}")
    public List<String> acceptedDna;

    @Autowired
    private SimiosRepository simiosRepository;

    @Override
    public SimiosStatsResponse retrieveSimiosStatistics () {
        final List<SimiosEntity> simios = simiosRepository.findBySimian(true);
        final List<SimiosEntity> humans = simiosRepository.findBySimian(false);

        final Integer simioCount = simios.size();
        final Integer humanCount = humans.size();
        final Double ratio = (simioCount == 0 || humanCount == 0) ?
                0 : Double.valueOf(simioCount) / Double.valueOf(humanCount);

        return SimiosStatsResponse.builder()
                .simios(simioCount)
                .humans(humanCount)
                .ratio(ratio)
                .build();
    }

    @Override
    public boolean isSimian (List<String> dna) throws InvalidMatrixException {

        final boolean simian = checkDnaMatrixForSimian(dna);

        String dnaFull = "";
        for (String d : dna) {
            dnaFull = dnaFull.concat(d);
        }

        final SimiosEntity simiosEntity = SimiosEntity.builder()
                .simianId(UUID.randomUUID())
                .dna(dnaFull)
                .simian(simian)
                .build();

        simiosRepository.save(simiosEntity);

        return simian;
    }

    private boolean checkDnaMatrixForSimian (List<String> dna) throws InvalidMatrixException {
        if (dna.isEmpty()) {
            return false;
        }

        boolean simian;

        final String[][] dnaMatrix = convertToMatrix(dna);

        simian = readDnaLines(dnaMatrix);
        if (simian) {
            return true;
        }

        simian = readDnaColumns(dnaMatrix);
        if (simian) {
            return true;
        }

        return readDnaDiagonal(dnaMatrix);
    }

    private boolean readDnaDiagonal (final String[][] dnaMatrix) {

        if (readDiagonalsPrincipals(dnaMatrix) || readDiagonalSecondaries(dnaMatrix)) {
            return true;
        }

        return false;
    }

    private boolean readDiagonalsPrincipals (final String[][] dnaMatrix) {
        //diagonal principal /
        String sequence = "";
        for (int i = 0, j = dnaMatrix[0].length - 1; i < dnaMatrix[0].length && j >= 0; i++, j--) {
            sequence = sequence.concat(dnaMatrix[i][j]);
        }

        boolean simian = checkForSimian(sequence);
        if (simian) {
            return true;
        }

        //diagonal principal \
        sequence = "";
        for (int i = 0; i < dnaMatrix[0].length; i++) {
            sequence = sequence.concat(dnaMatrix[i][i]);
        }

        simian = checkForSimian(sequence);
        if (simian) {
            return true;
        }

        return false;
    }

    private boolean readDiagonalSecondaries (final String[][] dnaMatrix) {
        //todo: ler diagonais \ acima da principal
        if (readDiagonalsNotPrincipalLeftRight(dnaMatrix, true)) {
            return true;
        }

        //todo: ler diagonais \ abaixo da principal
        if (readDiagonalsNotPrincipalLeftRight(dnaMatrix, false)) {
            return true;
        }

        //todo: ler diagonais / acima da principal
        if (readDiagonalsNotPrincipalRightLeftAbove(dnaMatrix)) {
            return true;
        }

        //todo: ler diagonais / abaixo da principal
        if (readDiagonalsNotPrincipalRightLeftBelow(dnaMatrix)) {
            return true;
        }
        return false;
    }

    private boolean readDiagonalsNotPrincipalRightLeftBelow (final String[][] dnaMatrix) {

        boolean simian;
        String sequenceTemp = "";
        int i = 1;
        int j = dnaMatrix[0].length - 1;
        int diagonalsAbovePrincipal = dnaMatrix[0].length - 1;
        int aux = 0;

        while (aux < diagonalsAbovePrincipal) {
            sequenceTemp = sequenceTemp.concat(dnaMatrix[i][j]);
            if (i == dnaMatrix[0].length - 1) {
                simian = checkForSimian(sequenceTemp);
                if (simian) {
                    return true;
                }
                sequenceTemp = "";

                aux++;
                i = aux + 1;
                j = dnaMatrix[0].length - 1;
            } else {
                i++;
                j--;
            }
        }

        return false;
    }

    private boolean readDiagonalsNotPrincipalRightLeftAbove (final String[][] dnaMatrix) {
        boolean simian;
        String sequenceTemp = "";
        int i = 0;
        int j = dnaMatrix[0].length - 2;
        int aux = j;
        int diagonalsAbovePrincipal = dnaMatrix[0].length - 1;
        int iterations = 1;
        while (iterations < diagonalsAbovePrincipal) {
            sequenceTemp = sequenceTemp.concat(dnaMatrix[i][j]);
            if (j == 0) {
                simian = checkForSimian(sequenceTemp);
                if (simian) {
                    return true;
                }
                sequenceTemp = "";
                i = 0;

                iterations++;
                aux--;
                j = aux;
            } else {
                i++;
                j--;
            }
        }
        return false;
    }

    private boolean readDiagonalsNotPrincipalLeftRight (final String[][] dnaMatrix, boolean above) {
        boolean simian;
        String sequenceTemp = "";
        int i = 0;
        int j = 1;
        int aux = 0;
        int diagonalsAbovePrincipal = dnaMatrix[0].length - 1;
        while (aux < diagonalsAbovePrincipal) {
            if (above) {
                sequenceTemp = sequenceTemp.concat(dnaMatrix[i][j]);
            } else {
                sequenceTemp = sequenceTemp.concat(dnaMatrix[j][i]);
            }
            if (j == dnaMatrix[0].length - 1) {
                simian = checkForSimian(sequenceTemp);
                if (simian) {
                    return true;
                }
                sequenceTemp = "";
                i = 0;
                aux++;
                j = aux + 1;
            } else {
                i++;
                j++;
            }
        }
        return false;
    }

    private boolean readDnaColumns (final String[][] dnaMatrix) {

        for (int columnIndex = 0; columnIndex < dnaMatrix[0].length; columnIndex++) {
            String column = "";
            for (int i = 0; i < dnaMatrix[0].length; i++) {
                column = column.concat(dnaMatrix[i][columnIndex]);
            }

            boolean simian = checkForSimian(column);

            if (simian) {
                return true;
            }
        }

        return false;
    }

    private boolean readDnaLines (final String[][] dnaMatrix) {

        for (int i = 0; i < dnaMatrix.length; i++) {
            String line = "";
            for (String aux : dnaMatrix[i]) {
                line = line.concat(aux);
            }
            //final String line = dnaMatrix[i].toString();

            final String lineaux = line;

            boolean simian = checkForSimian(lineaux);

            if (simian) {
                return true;
            }
        }

        return false;
    }

    private String[][] convertToMatrix (final List<String> dna) throws InvalidMatrixException {
        final Integer dimension = dna.size();
        final String[][] dnaMatrix = new String[dimension][dimension];
        Integer index = 0;
        for (String sequence : dna) {
            final char[] sequenceSplitted = sequence.toCharArray();

            //check if not NxN matrix
            if (sequenceSplitted.length != dimension) {
                throw new InvalidMatrixException();
            }
            for (int i = 0; i < dimension; i++) {
                dnaMatrix[index][i] = String.valueOf(sequenceSplitted[i]);
            }
            index += 1;
        }
        return dnaMatrix;
    }

    private boolean checkForSimian (final String sequence) {
        final List<String> filteredList = acceptedDna.stream()
                .filter(
                        s -> sequence.contains(s)
                ).collect(Collectors.toList());

        return !filteredList.isEmpty();
    }

}
