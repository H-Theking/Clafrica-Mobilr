package com.resulam.harvey.clafricamobilekeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class KeyboardService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private enum State{
        FOUND, FOUND_EXTRA, NOT_FOUND, SEARCHING
    }
    private Keyboard keyboard;
    private KeyboardView keyboardView;
    private boolean caps = false;
    private HashMap<String, String> characters, dictionary;
    private List<HashMap<String, String>> foundMaps = new ArrayList<>();
    private String typed = "";
    private State state = State.NOT_FOUND;

    @Override
    public View onCreateInputView() {
        try {
            characters = getCharacters(getResources().openRawResource(R.raw.characters));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dictionary = characters;
        keyboardView = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard_view, null);
        keyboard = new Keyboard(this, R.xml.qwerty);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
        playClick(primaryCode);
        int length = typed.length();

        switch(primaryCode){
            case Keyboard.KEYCODE_DELETE :
                ic.deleteSurroundingText(1, 0);
                if (typed.length() > 0){
                    typed = typed.substring(0, length - 1);
                    dictionary = findCombination(typed, characters);
                }else{
                    typed = "";
                    dictionary = characters;
                }
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                keyboardView.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
            default:
                char code = (char)primaryCode;
                if(Character.isLetter(code) && caps){
                    code = Character.toUpperCase(code);
                }
                typed += String.valueOf(code);
                Log.e("typed", typed);
                dictionary = findCombination(typed, characters);
                Set<String> keys = dictionary.keySet();
                for (String key : keys) {
                    Log.d(key, dictionary.get(key));
                }
                State state = currentState(typed, dictionary);
                switch (state) {
                    case FOUND:
                        Log.e("state", "found");
                        ic.deleteSurroundingText(length, 0);
                        ic.commitText(dictionary.get(keys.toArray()[0]),1);
                        typed = "";
//                        dictionary = characters;
//                        foundMaps.clear();
                        break;
                    case FOUND_EXTRA:
                        Log.e("state", "found extra");
                        String substring = typed.substring(0, length);
                        Log.e("typed to get", substring);
                        String charCode = characters.get(substring);
                        Log.e("charCode", charCode);
                        ic.deleteSurroundingText(length, 0);
                        ic.commitText(charCode,1);
                        ic.commitText(typed.substring(length, length + 1), 1);
                        typed = typed.substring(length, length + 1);
//                        dictionary.clear();
//                        foundMaps.clear();
                        break;
                    case NOT_FOUND:
                        Log.e("state", "not found");
                        ic.commitText(String.valueOf(code),1);
                        typed = String.valueOf(code);
//                        foundMaps.clear();
                        dictionary = findCombination(typed, characters);
                        if (dictionary.isEmpty()) {
                            typed = "";
                            dictionary = characters;
                        }
                        break;
                    default:
                        Log.e("state", "searching");
                        ic.commitText(String.valueOf(code),1);
                }

//                ic.commitText(String.valueOf(code),1);
        }
    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {
    }

    private void playClick(int keyCode){
        AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
        switch(keyCode){
            case 32:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case Keyboard.KEYCODE_DONE:
            case 10:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default: am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
        }
    }

    protected static HashMap<String, String> getCharacters(InputStream inputStream ) throws IOException {
//        InputStream inputStream = getResources().openRawResource(R.raw.characters.txt);
        System.out.println("inputStream " + inputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        HashMap<String, String> characterMap = new HashMap<>();
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            String[] words = line.split(":");
            characterMap.put(words[0].trim(), words[1].trim());
        }
        return characterMap;
    }

    public HashMap<String, String> findCombination(String partial, HashMap<String, String> map){
        HashMap<String, String> temp = new HashMap<>();
        for (String key : map.keySet()) {
            if (key.startsWith(partial)){
                temp.put(key, map.get(key));
            }
        }
        return temp;
    }

    public State currentState(String input, HashMap<String, String> map){
        State currentState;
        switch (map.size()) {
            case 1://found a complete combination
                currentState = State.FOUND;
                break;
            case 0: //no combination. Find whether the previous characters.txt make one
                Log.d("input ", input);
                if(input.length() > 1){
                    Log.d("Shorter ", input.substring(0, input.length() - 1) + "length char " + characters.size());
                    String code = characters.get(input.substring(0, input.length() - 1));
                    currentState = code != null ? State.FOUND_EXTRA: State.NOT_FOUND;
                }else{
                    currentState = State.SEARCHING;}

                break;
            default://no final combination yet
                currentState = State.SEARCHING;
        }
        return currentState;
    }
}
