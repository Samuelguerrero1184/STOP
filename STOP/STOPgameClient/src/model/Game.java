package model;

import java.util.Random;

public class Game {

    public String type = "Game";

    public char letter;
    private Answer chosenAnswer;
    private Answer youreAnswer;
    private int playerPoints;
    private int yourePoints;
    private int chosenNamePoints;
    private int chosenAnimalPoints;
    private int chosenLocationPoints;
    private int chosenObjectPoint;
    private int youreeChosenNamePoints;
    private int youreAnimalPoints;
    private int youreLocationPoints;
    private int youreObjectPoints;

    public Game(char letter) {
        this.letter = randomLetter();

    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getLetter() {
        return this.letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Answer getMyAnswer() {
        return this.chosenAnswer;
    }

    public void setMyAnswer(Answer chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    public Answer getYourAnswer() {
        return this.youreAnswer;
    }

    public void setYourAnswer(Answer youreAnswer) {
        this.youreAnswer = youreAnswer;
    }

    public int getMyPoints() {
        return this.playerPoints;
    }

    public void setMyPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public int getYourPoints() {
        return this.yourePoints;
    }

    public void setYourPoints(int yourePoints) {
        this.yourePoints = yourePoints;
    }

    public int getMyNamePoints() {
        return this.chosenNamePoints;
    }

    public void setMyNamePoints(int chosenNamePoints) {
        this.chosenNamePoints = chosenNamePoints;
    }

    public int getMyAnimalPoints() {
        return this.chosenAnimalPoints;
    }

    public void setMyAnimalPoints(int chosenAnimalPoints) {
        this.chosenAnimalPoints = chosenAnimalPoints;
    }

    public int getMyLocationPoints() {
        return this.chosenLocationPoints;
    }

    public void setMyLocationPoints(int chosenLocationPoints) {
        this.chosenLocationPoints = chosenLocationPoints;
    }

    public int getMyObjectPoint() {
        return this.chosenObjectPoint;
    }

    public void setMyObjectPoint(int chosenObjectPoint) {
        this.chosenObjectPoint = chosenObjectPoint;
    }

    public int getYourNamePoints() {
        return this.youreeChosenNamePoints;
    }

    public void setYourNamePoints(int youreeChosenNamePoints) {
        this.youreeChosenNamePoints = youreeChosenNamePoints;
    }

    public int getYourAnimalPoints() {
        return this.youreAnimalPoints;
    }

    public void setYourAnimalPoints(int youreAnimalPoints) {
        this.youreAnimalPoints = youreAnimalPoints;
    }

    public int getYourLocationPoints() {
        return this.youreLocationPoints;
    }

    public void setYourLocationPoints(int youreLocationPoints) {
        this.youreLocationPoints = youreLocationPoints;
    }

    public int getYourObjectPoints() {
        return this.youreObjectPoints;
    }

    public void setYourObjectPoints(int youreObjectPoints) {
        this.youreObjectPoints = youreObjectPoints;
    }

    public void calculatePoints() {

        String chosenName = chosenAnswer.getName();
        String youreeChosenName = youreAnswer.getName();

        if (chosenName.isEmpty() || youreeChosenName.isEmpty()) {
            if (chosenName.isEmpty() && youreeChosenName.isEmpty() == false) {
                yourePoints += 100;
            } else if (chosenName.isEmpty() == false && youreeChosenName.isEmpty()) {
                playerPoints += 100;
            } else {
            }

        } else if (chosenName.equals(youreeChosenName)) {
            yourePoints += 50;
            playerPoints += 50;
        } else {
            yourePoints += 100;
            playerPoints += 100;

        }
        String chosenAnimal = chosenAnswer.getAnimal();
        String youreAnimal = youreAnswer.getAnimal();

        if (chosenAnimal.isEmpty() || youreAnimal.isEmpty()) {
            if (chosenAnimal.isEmpty() && youreAnimal.isEmpty() == false) {
                yourePoints += 100;
            } else if (chosenAnimal.isEmpty() == false && youreAnimal.isEmpty()) {
                playerPoints += 100;
            } else {
            }

        } else if (chosenAnimal.equals(youreAnimal)) {
            yourePoints += 50;
            playerPoints += 50;
        } else {
            yourePoints += 100;
            playerPoints += 100;
        }
        String chosenCity = chosenAnswer.getLocation();
        String youreCity = youreAnswer.getLocation();

        if (chosenCity.isEmpty() || youreCity.isEmpty()) {
            if (chosenCity.isEmpty() && youreCity.isEmpty() == false) {
                yourePoints += 100;
            } else if (chosenCity.isEmpty() == false && youreCity.isEmpty()) {
                playerPoints += 100;
            } else {
            }
        } else if (chosenCity.equals(youreCity)) {

            yourePoints += 50;
            playerPoints += 50;
        } else {
            yourePoints += 100;
            playerPoints += 100;

        }
        String chosenObject = chosenAnswer.getObject();
        String youreObject = youreAnswer.getObject();

        if (chosenObject.isEmpty() || youreObject.isEmpty()) {
            if (chosenObject.isEmpty() && youreObject.isEmpty() == false) {
                yourePoints += 100;
            } else if (chosenObject.isEmpty() == false && youreObject.isEmpty()) {
                playerPoints += 100;
            } else {
            }

        } else if (chosenObject.equals(youreObject)) {
            yourePoints += 50;
            playerPoints += 50;
        } else {
            yourePoints += 100;
            playerPoints += 100;

        }
    }

    public static char randomLetter() {
        Random random = new Random();
        String setOfCharacters = "abcdefghijklmnopqrstuvwxyz";
        int randomInt = random.nextInt(setOfCharacters.length());
        char randomChar = setOfCharacters.charAt(randomInt);
        return randomChar;

    }

}