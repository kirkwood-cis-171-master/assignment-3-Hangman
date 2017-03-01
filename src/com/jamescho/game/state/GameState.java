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

        //Arm
        if (numberOfWrongGuesses() > 0) {
            g.drawLine(400, 225, 400 + 50, 225);
        }

        //Body
        g.drawLine(425,280,425,200);

        //right leg
        g.drawLine(425,280,425-22,280+50);

        //left leg
        g.drawLine(425,280,425+22,280+50);

        //head
        g.drawOval(400,225-76,50,50);



    }

    private int numberOfWrongGuesses() {
        return 1;
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
