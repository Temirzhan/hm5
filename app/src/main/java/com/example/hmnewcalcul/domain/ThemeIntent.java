package com.example.hmnewcalcul.domain;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hmnewcalcul.R;

public class ThemeIntent extends AppCompatActivity {
    protected static final String NameSharedPreference = "LOGIN";


    protected static final String AppTheme = "APP_THEME";

    protected static final int MyCodeStyle = 0;
    protected static final int AppThemeLightCodeStyle = 1;
    protected static final int AppThemeCodeStyle = 2;
    protected static final int AppThemeDarkCodeStyle = 3;

    protected int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    protected int getCodeStyle(int codeStyle){
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    protected int codeStyleToStyleId(int codeStyle){
        switch(codeStyle){
            case AppThemeCodeStyle:
                return R.style.AppTheme;
            case AppThemeLightCodeStyle:
                return R.style.AppThemeLight;
            case AppThemeDarkCodeStyle:
                return R.style.AppThemeDark;
            default:
                return R.style.MyStyle;
        }
    }
}
