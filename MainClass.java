/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.pkg1;

/**
 *
 * @author student
 */
public class MainClass {

    private static double[][] normalizeLearningSet(double[][] learningSet) {
        double[][] normalizedLearningSet = new double[learningSet.length][learningSet[0].length];
        int nrOfColumns = learningSet[0].length;
        int nrOfLines = learningSet.length;
        double[] min = new double[nrOfColumns];
        double[] max = new double[nrOfColumns];
        for (int i = 0; i < nrOfColumns; i++) {
            min[i] = learningSet[0][i];
            max[i] = learningSet[0][i];
            for (int j = 0; j < nrOfLines; j++) {
                if (learningSet[j][i] < min[i]) {
                    min[i] = learningSet[j][i];
                }
                if (learningSet[j][i] > max[i]) {
                    max[i] = learningSet[j][i];
                }
            }
        }
        for (int i = 0; i < nrOfLines; i++) {

            for (int j = 0; j < nrOfColumns; j++) {
                normalizedLearningSet[i][j] = (learningSet[i][j] - min[j]) / (max[j] - min[j]);
            }
        }
        return normalizedLearningSet;
    }

    public static void main(String[] args) {
        double[][] learningSet = FileUtils.readLearningSetFromFile("C:/Users/student/Documents/NetBeansProjects/Lab1-1/src/lab1/pkg1/in.txt");
        FileUtils.writeLearningSetToFile("C:/Users/student/Documents/NetBeansProjects/Lab1-1/src/lab1/pkg1/out.csv",
                normalizeLearningSet(learningSet));
    }

}
