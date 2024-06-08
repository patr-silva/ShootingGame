package io.codeforall.forsome;

import java.io.*;

public class ScoreWriter {

    private final String fileName = "highscore";

    public int readScoreFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return Integer.MIN_VALUE; // Return a small number if the file is empty or doesn't exist
    }

    private void writeScoreToFile(int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName))) {
            writer.write(Integer.toString(score));
            writer.newLine();
            System.out.println("Number written to file: " + score);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public int compareScores(int newScore) {
        int existingScore = this.readScoreFromFile();
        System.out.println("Existing number in file: " + existingScore);

        if (newScore > existingScore) {
            System.out.println("New number (" + newScore + ") is greater than existing number (" + existingScore + "). Updating the file.");
            writeScoreToFile(newScore);
            return newScore;
        } else {
            System.out.println("New number (" + newScore + ") is not greater than existing number (" + existingScore + "). No update needed.");
            return existingScore;
        }
    }

}


