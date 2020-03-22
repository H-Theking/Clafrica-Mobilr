package org.resulam.www.clafricamobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import java.util.List;

/**
 * Created by harvey on 3/12/18.
 */

public class KeyboardV extends KeyboardView {
    private final Paint paint;
    private final Paint paint2;

    public KeyboardV(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.paint = new Paint();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(40);
        paint.setColor(Color.LTGRAY);

        this.paint2 = new Paint();
        paint2.setTextAlign(Paint.Align.LEFT);
        paint2.setTextSize(50);
        paint2.setColor(Color.WHITE);
    }

    private void draw(Keyboard.Key key, String character, double x, Canvas canvas){
        canvas.drawText(character, key.x + (float)key.width/2 - (float) x, key.y + 55, paint);
    }

    private void draw2(Keyboard.Key key, String character, double x, Canvas canvas){
        canvas.drawText(character, key.x + (float)key.width/2 - (float) x, key.y + 105, paint2);
    }

    private boolean contains(int[] codes, int value){
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] == value) return true;
        }
        return false;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //get all your keys and draw whatever you want
        List<Keyboard.Key> keys = getKeyboard().getKeys();
        for (Keyboard.Key key : keys) {

            if (contains(key.codes,113)) {
                String letter = this.getKeyboard().isShifted() ? "Q" : "q";
                draw(key, "%",  14, canvas);
                draw2(key, letter, 14, canvas);
            }

            if (contains(key.codes,119)) {
                String letter = this.getKeyboard().isShifted() ? "W" : "w";
                draw(key, "^",  9, canvas);
                draw2(key, letter, 19, canvas);
            }

            if (contains(key.codes,101)) {
                String letter = this.getKeyboard().isShifted() ? "E" : "e";
                draw(key, "~", 13, canvas);
                draw2(key, letter, 13, canvas);
            }

            if (contains(key.codes,114)) {
                String letter = this.getKeyboard().isShifted() ? "R" : "r";
                draw(key, "|", 4, canvas);
                draw2(key, letter,8, canvas);
            }

            if (contains(key.codes,116)) {
                String letter = this.getKeyboard().isShifted() ? "T" : "t";
                draw(key, "[", 5, canvas);
                draw2(key, letter,8.5, canvas);
            }

            if (contains(key.codes,121)) {
                String letter = this.getKeyboard().isShifted() ? "Y" : "y";
                draw(key, "]", 5, canvas);
                draw2(key, letter,12, canvas);
            }

            if (contains(key.codes,117)) {
                String letter = this.getKeyboard().isShifted() ? "U" : "u";
                draw(key, "<", 8.5, canvas);
                draw2(key, letter,13.5, canvas);
            }

            if (contains(key.codes,105)) {
                String letter = this.getKeyboard().isShifted() ? "I" : "i";
                draw(key, ">", 12, canvas);
                draw2(key, letter,6.5, canvas);
            }

            if (contains(key.codes,111)) {
                String letter = this.getKeyboard().isShifted() ? "O" : "o";
                draw(key, "{", 8.5, canvas);
                draw2(key, letter,14, canvas);
            }

            if (contains(key.codes,112)) {
                String letter = this.getKeyboard().isShifted() ? "P" : "p";
                draw(key, "}", 8.5, canvas);
                draw2(key, letter,15.5, canvas);
            }

//            if (contains(key.codes,113)) {
//                draw(key, "%", canvas);
//                draw2(key, letter, canvas);
//            }
//
//            if (contains(key.codes,119)) {
//                draw(key, "^", canvas);
//                draw2(key, letter, canvas);
//            }


            if (key.label != null) {

//                if (key.label.toString().equals("q") || key.label.toString().equals("Q")) {
//                    draw(key, "%", canvas);
//                }

//                 if (key.label.toString().equals("w") || key.label.toString().equals("W"))
//                    draw(key, "^", canvas);

//                 if (key.label.toString().equals("e") || key.label.toString().equals("E"))
//                     draw(key, "~", canvas);
////                    canvas.drawText("~", key.x + (key.width / 2) + 40, key.y + 65, paint);
//
//                else if (key.label.toString().equals("r") || key.label.toString().equals("R"))
//                     draw(key, "|", canvas);
////                    canvas.drawText("|", key.x + (key.width / 2) + 40, key.y + 65, paint);
//
//                else if (key.label.toString().equals("t") || key.label.toString().equals("T"))
//                     draw(key, "[", canvas);
////                    canvas.drawText("[", key.x + (key.width / 2) + 40, key.y + 65, paint);
//
//                else if (key.label.toString().equals("y") || key.label.toString().equals("Y"))
//                     draw(key, "]", canvas);
////                    canvas.drawText("]", key.x + (key.width / 2) + 40, key.y + 65, paint);
//
//                else if (key.label.toString().equals("u") || key.label.toString().equals("U"))
//                     draw(key, "]", canvas);
////                    canvas.drawText("<", key.x + (key.width / 2) + 40, key.y + 65, paint);
//
//                else if (key.label.toString().equals("i") || key.label.toString().equals("I"))
//                     draw(key, ">", canvas);
////                    canvas.drawText(">", key.x + (key.width / 2) + 40, key.y + 65, paint);
//
//                else if (key.label.toString().equals("o") || key.label.toString().equals("o"))
//                     draw(key, "{", canvas);
////                    canvas.drawText("{", key.x + (key.width / 2) + 40, key.y + 65, paint);
//
//                else if (key.label.toString().equals("p") || key.label.toString().equals("P"))
//                     draw(key, "}", canvas);
//                    canvas.drawText("}", key.x + (key.width / 2) + 40, key.y + 65, paint);


                if (key.label.toString().equals("a") || key.label.toString().equals("A"))
                    canvas.drawText("@", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("s") || key.label.toString().equals("S"))
                    canvas.drawText("#", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("d") || key.label.toString().equals("D"))
                    canvas.drawText("&", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("f") || key.label.toString().equals("F"))
                    canvas.drawText("*", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("g") || key.label.toString().equals("G"))
                    canvas.drawText("-", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("h") || key.label.toString().equals("H"))
                    canvas.drawText("+", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("j") || key.label.toString().equals("J"))
                    canvas.drawText("=", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("k") || key.label.toString().equals("K"))
                    canvas.drawText("(", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("l") || key.label.toString().equals("L"))
                    canvas.drawText(")", key.x + (key.width / 2) + 40, key.y + 65, paint);


                else if (key.label.toString().equals("z") || key.label.toString().equals("Z"))
                    canvas.drawText("_", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("x") || key.label.toString().equals("X"))
                    canvas.drawText("$", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("c") || key.label.toString().equals("C"))
                    canvas.drawText("\"", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("v") || key.label.toString().equals("V"))
                    canvas.drawText("'", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("b") || key.label.toString().equals("B"))
                    canvas.drawText(":", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("n") || key.label.toString().equals("N"))
                    canvas.drawText(";", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("m") || key.label.toString().equals("M"))
                    draw(key, "/", 12.5, canvas);
//                    canvas.drawText("/", key.x + (key.width / 2) + 40, key.y + 65, paint);

            }
//            else if (Arrays.asList(key.codes).contains(-5)) {
//                Paint paint2 = new Paint();
//                paint2.setColor(Color.TRANSPARENT);
//                canvas.draw
//            }
        }
    }
}
