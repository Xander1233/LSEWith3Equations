import java.util.*;
public class rechner {
    public static void main(String[] args) {

        double[] vektorX = new double[3];
        double[] vektorY = new double[3];
        double[][] matrixA = new double[3][3];

        Scanner sc = new Scanner(System.in);

        System.out.print("Menu\n\n1. a11 * x + a12 * y + a13 * z = b1\n2. a21 * x + a22 * y + a23 * z = b2" +
                "\n3. a31 * x + a32 * y + a33 * z = b3\nLösen eines LGS mit einer 3x3-Matrix\n");

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print("a" + (i + 1) + (j + 1) + ": ");
                matrixA[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < vektorY.length; i++) {
            System.out.print("b" + (i + 1) + ": ");
            vektorY[i] = sc.nextDouble();
        }

        double[][] newMatrixA = matrixA;

        double D = Determinante(newMatrixA);
        for (int i = 0; i < matrixA.length; i++) {
            newMatrixA = replace(matrixA, vektorY, i);
            vektorX[i] = (Determinante(newMatrixA) / D);
        }


        System.out.println("\nResult:\nx = " + vektorX[0] + "\ny = " + vektorX[1] + "\nz = " + vektorX[2]);
    }

    public static double Determinante(double[][] matrixA) {
        return matrixA[0][0] * matrixA[1][1] * matrixA[2][2] +
               matrixA[0][1] * matrixA[1][2] * matrixA[2][0] +
               matrixA[0][2] * matrixA[1][0] * matrixA[2][1] -
               matrixA[0][2] * matrixA[1][1] * matrixA[2][0] -
               matrixA[0][0] * matrixA[1][2] * matrixA[2][1] -
               matrixA[0][1] * matrixA[1][0] * matrixA[2][2];
    }

    public static double[][] replace(double[][] m, double[] b, int spalte) {
        double[][] matrixCopy = copy(m);
        for (int i = 0; i < 3; i++) {
            matrixCopy[i][spalte] = b[i];
        }
        return matrixCopy;
    }

    public static double[][] copy(double[][] m) {

        double[][] kopie = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < kopie[i].length; j++) {
                kopie[i][j] = m[i][j];
            }
        }

        return kopie;
    }
}
