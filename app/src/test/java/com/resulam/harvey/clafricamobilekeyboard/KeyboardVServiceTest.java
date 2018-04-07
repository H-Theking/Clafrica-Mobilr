package com.resulam.harvey.clafricamobilekeyboard;

import android.test.mock.MockResources;

import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by harvey on 2/11/18.
 */
public class KeyboardVServiceTest {
    MockResources mockResources = new MockResources();

    @Test
    public void getCharacters() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("raw/characters.txt");
        HashMap<String, String> characterMap = KeyboardService.getCharacters(inputStream);
        System.out.println(characterMap.size());
        characterMap.forEach((s, s2) -> {
            System.out.println(s);
        });
        assertTrue(characterMap.containsKey("a4"));
        assertTrue(characterMap.size() == 470);
    }

}