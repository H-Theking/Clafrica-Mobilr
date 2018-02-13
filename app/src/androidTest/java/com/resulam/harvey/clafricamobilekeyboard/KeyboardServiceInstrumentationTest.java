package com.resulam.harvey.clafricamobilekeyboard;

import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertTrue;

/**
 * Created by harvey on 2/10/18.
 */
public class KeyboardServiceInstrumentationTest {
    @Test
    public void getCharacters() throws Exception {
        InputStream inputStream = getInstrumentation().getContext().getResources().openRawResource(R.raw.characters);
        HashMap<String, String> characterMap = KeyboardService.getCharacters(inputStream);
        System.out.println(characterMap.size());
        characterMap.forEach((s, s2) -> {
            System.out.println(s);
        });
        assertTrue(characterMap.containsKey("a4"));
        assertTrue(characterMap.size() == 470);
    }
}