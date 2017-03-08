package com.jamescho.game.state;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by k0808273 on 2/27/2017.
 */
public class GameState extends State {

    private String correctAnswer = "Dog";
    private ArrayList<Character> incorrectGuesses = new ArrayList<>();
    private ArrayList<Character> correctGuesses = new ArrayList<>();

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        if(userHasNotMadeAnyGuesses()) {
            g.drawString("Welcome to hangman", 100, 100);
        } else {
            g.drawString(userGuessesAsString(),100,200);
        }

        int numberOfLettersInWord = 3;
        int width = 20;
        for (int i = 0; i < numberOfLettersInWord; i++) {
           int xModifier = i * 25;
           String letter = getLetter(i);
           if (userHasGuessedLetter(letter)) {
               g.drawString(letter,100+xModifier+8,140-5);

           }
            //if userHasGuessed{i}Letter
            //   print first letter
            //if userHasGuessedSecondLetter
            //   print second letter
            g.drawLine(100+xModifier,140,100+width+xModifier,140);
        }

        //Head
        if (numberOfWrongGuesses() > 0) {
            g.drawOval(400, 225 - 76, 50, 50);
        }

        //Body
        if (numberOfWrongGuesses() > 1) {
            g.drawLine(425, 280, 425, 200);
        }

        //arm
        if (numberOfWrongGuesses() > 2) {
            g.drawLine(400, 225, 400 + 50, 225);
        }

        //left leg
        if (numberOfWrongGuesses() > 3) {
            g.drawLine(425, 280, 425 + 22, 280 + 50);
        }

        //right leg
        if (numberOfWrongGuesses() > 4) {
            g.drawLine(425, 280, 425 - 22, 280 + 50);
        }
    }

    private String getLetter(int i) {
        return correctAnswer.substring(i,i+1);

    }

    private boolean userHasGuessedLetter(String letter) {
        Character c = Character.toUpperCase(letter.charAt(0));
        return correctGuesses.contains(c);
    }

    private int numberOfWrongGuesses() {
        return incorrectGuesses.size();
    }

    private String userGuessesAsString() {
        String x = "";

        for( char y : incorrectGuesses) {
            x = x + y;
        }

        return x;
    }


    private Boolean userHasNotMadeAnyGuesses() {
        if (incorrectGuesses.size() != 0) {
            return false;
        } else if (correctGuesses.size() != 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

        //add to incorrect or correct list
        // if not one of desired characters
        //    add to incorrect list
        // else
        //    add it to correct list

        Character userGuess = e.getKeyChar();
        //if not a letter
        //   exit the funtion early
        if (!Character.isAlphabetic(userGuess)) {
            return;
        }

        if (oneofDesiredCharacters(userGuess)) {
            addToCorrectList(userGuess);
        } else {
            addToIncorrectList(userGuess);
        }

    }

    private void addToCorrectList(Character userGuess) {
        correctGuesses.add(Character.toUpperCase(userGuess));
    }

    private void addToIncorrectList(Character userGuess) {
        incorrectGuesses.add(userGuess);
    }

    private boolean oneofDesiredCharacters(Character userGuess) {

        for (Character c : correctAnswer.toCharArray()) {

            if (c.equals(userGuess) || c.equals(Character.toUpperCase(userGuess))) {
                return true;
            }
        }
        return false;
    }


}
