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

    private void drawOtherCharacter(Keyboard.Key key, String character, double x, Canvas canvas) {
        canvas.drawText(character, key.x + (float) key.width / 2 - (float) x, key.y + 55, paint);
    }

    private void drawLetter(Keyboard.Key key, String character, double x, Canvas canvas) {
        canvas.drawText(character, key.x + (float) key.width / 2 - (float) x, key.y + 110, paint2);
    }

    private void drawKey(Keyboard.Key key, String upper, double upperX, String lower, double lowerX,
                         String otherCharacter, double otherX, Canvas canvas) {
        if (isCapsOn()) {
            drawLetter(key, upper, upperX, canvas);
        } else drawLetter(key, lower, lowerX, canvas);
        drawOtherCharacter(key, otherCharacter, otherX, canvas);
    }

    private boolean contains(int[] codes, int value) {
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

            if (contains(key.codes, 113)) {
                if (isCapsOn()) {
                    drawLetter(key, "Q", 17, canvas);
                } else {
                    drawLetter(key, "q", 14, canvas);
                }
                drawOtherCharacter(key, "%", 14, canvas);
            } else if (contains(key.codes, 119)) {
                if (isCapsOn()) drawLetter(key, "W", 25, canvas);
                else drawLetter(key, "w", 19, canvas);
                drawOtherCharacter(key, "^", 9, canvas);
            } else if (contains(key.codes, 101)) {
                if (isCapsOn())
                    drawLetter(key, "E", 14, canvas);
                else
                    drawLetter(key, "e", 13, canvas);
                drawOtherCharacter(key, "~", 13, canvas);
            } else if (contains(key.codes, 114)) {
                if (isCapsOn())
                    drawLetter(key, "R", 15, canvas);
                else drawLetter(key, "r", 8, canvas);
                drawOtherCharacter(key, "|", 4, canvas);
            } else if (contains(key.codes, 116)) {
                if (isCapsOn())
                    drawLetter(key, "T", 14, canvas);
                else drawLetter(key, "t", 8.5, canvas);
                drawOtherCharacter(key, "[", 5, canvas);
            } else if (contains(key.codes, 121)) {
                if (isCapsOn())
                    drawLetter(key, "Y", 14, canvas);
                else drawLetter(key, "y", 12, canvas);
                drawOtherCharacter(key, "]", 5, canvas);
            } else if (contains(key.codes, 117)) {
                if (isCapsOn())
                    drawLetter(key, "U", 16.5, canvas);
                else drawLetter(key, "u", 13.5, canvas);
                drawOtherCharacter(key, "<", 10, canvas);
            } else if (contains(key.codes, 105)) {
                if (isCapsOn())
                    drawLetter(key, "I", 6.5, canvas);
                else drawLetter(key, "i", 6.5, canvas);
                drawOtherCharacter(key, ">", 10, canvas);
            } else if (contains(key.codes, 111)) {
                if (isCapsOn())
                    drawLetter(key, "O", 17, canvas);
                else drawLetter(key, "o", 14, canvas);
                drawOtherCharacter(key, "{", 8.5, canvas);
            } else if (contains(key.codes, 112)) {
                if (isCapsOn())
                    drawLetter(key, "P", 15.5, canvas);
                else drawLetter(key, "p", 12.5, canvas);
                drawOtherCharacter(key, "}", 8.5, canvas);
            }

            //------------------------Row 2---------------------------
            else if (contains(key.codes, 97)) {
                drawKey(key, "A", 16.5, "a", 14, "@", 17, canvas);
            }
            else if (contains(key.codes, 115)) {
                drawKey(key, "S", 15, "s", 12, "#", 11, canvas);
            }
            else if (contains(key.codes, 100)) {
                drawKey(key, "D", 15, "d", 14, "&", 11, canvas);
            }
            else if (contains(key.codes, 102)) {
                drawKey(key, "F", 14, "f", 9, "*", 8, canvas);
            }
            else if (contains(key.codes, 103)) {
                drawKey(key, "G", 17, "g", 14, "-", 5, canvas);
            }
            else if (contains(key.codes, 104)) {
                drawKey(key, "H", 18, "h", 13, "+", 11, canvas);
            }
            else if (contains(key.codes, 106)) {
                drawKey(key, "J", 14, "j", 5, "=", 11, canvas);
            }
            else if (contains(key.codes, 107)) {
                drawKey(key, "K", 14, "k", 11, "(", 8, canvas);
            }
            else if (contains(key.codes, 108)) {
                drawKey(key, "L", 13, "l", 6, ")", 7, canvas);
            }
            else if (contains(key.codes, 122)) {
                drawKey(key, "Z", 15, "z", 12, "_", 10, canvas);
            }
            else if (contains(key.codes, 120)) {
                drawKey(key, "X", 15.5, "x", 12, "$", 11, canvas);
            }
            else if (contains(key.codes, 99)) {
                drawKey(key, "C", 17, "c", 14, "\"", 7, canvas);
            }
            else if (contains(key.codes, 118)) {
                drawKey(key, "V", 16, "v", 12, "'", 4, canvas);
            }
            else if (contains(key.codes, 98)) {
                drawKey(key, "B", 15, "b", 14, ":", 5, canvas);
            }
            else if (contains(key.codes, 110)) {
                drawKey(key, "N", 18, "n", 13, ";", 3, canvas);
            }
            else if (contains(key.codes, 109)) {
                drawKey(key, "M", 21, "m", 22, "/", 8, canvas);
            }
        }
    }

    private boolean isCapsOn() {
        return this.getKeyboard().isShifted();
    }
}
