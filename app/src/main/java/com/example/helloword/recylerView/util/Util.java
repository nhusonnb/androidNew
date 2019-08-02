package com.example.helloword.recylerView.util;

import android.content.Context;
import android.content.res.Resources;

import com.example.helloword.R;

import org.json.JSONObject;
// 7,15,16
import java.io.InputStream;

public class Util {
    public static JSONObject fileToJSon(int fileName, Context context) {
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(fileName);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            return new JSONObject(strData);

        } catch (Exception e) {
            return null;
        }
    }
    public static JSONObject fileToJSonPlaces(int fileName , Context context){
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(fileName);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            return new JSONObject(strData);

        } catch (Exception e) {
            return null;
        }
    }
}
