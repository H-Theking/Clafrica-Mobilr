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
    public KeyboardV(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(50);
        paint.setColor(Color.LTGRAY);
        //get all your keys and draw whatever you want
        List<Keyboard.Key> keys = getKeyboard().getKeys();
        for (Keyboard.Key key : keys) {
            if (key.label != null) {

                if (key.label.toString().equals("q") || key.label.toString().equals("Q"))
                    canvas.drawText("%", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("w") || key.label.toString().equals("W"))
                    canvas.drawText("^", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("e") || key.label.toString().equals("E"))
                    canvas.drawText("~", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("r") || key.label.toString().equals("R"))
                    canvas.drawText("|", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("t") || key.label.toString().equals("T"))
                    canvas.drawText("[", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("y") || key.label.toString().equals("Y"))
                    canvas.drawText("]", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("u") || key.label.toString().equals("U"))
                    canvas.drawText("<", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("i") || key.label.toString().equals("I"))
                    canvas.drawText(">", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("o") || key.label.toString().equals("o"))
                    canvas.drawText("{", key.x + (key.width / 2) + 40, key.y + 65, paint);

                else if (key.label.toString().equals("p") || key.label.toString().equals("P"))
                    canvas.drawText("}", key.x + (key.width / 2) + 40, key.y + 65, paint);


                else if (key.label.toString().equals("a") || key.label.toString().equals("A"))
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
                    canvas.drawText("/", key.x + (key.width / 2) + 40, key.y + 65, paint);

            }
//            else if (Arrays.asList(key.codes).contains(-5)) {
//                Paint paint2 = new Paint();
//                paint2.setColor(Color.TRANSPARENT);
//                canvas.draw
//            }
        }
    }
}
