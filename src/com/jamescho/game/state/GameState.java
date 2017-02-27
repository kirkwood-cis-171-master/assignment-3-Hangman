package com.jamescho.game.state;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by k0808273 on 2/27/2017.
 */
public class GameState extends State {

    private ArrayList<Character> keyChar = new ArrayList<>();;

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
            g.drawString(userGuessesAsString(),100,100);
        }
    }

    private String userGuessesAsString() {
        String x = "";
        for( char y : keyChar) {
            x = x + y;
        }

        return x;
    }

    private Boolean userHasNotMadeAnyGuesses() {
        return keyChar.size() == 0;
    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        keyChar.add(e.getKeyChar());
        System.out.println(keyChar);

    }


}
