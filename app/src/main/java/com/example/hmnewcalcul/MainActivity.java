package com.example.hmnewcalcul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hmnewcalcul.domain.Calculator;
import com.example.hmnewcalcul.domain.CalculatorPresenter;
import com.example.hmnewcalcul.domain.Constants;
import com.example.hmnewcalcul.domain.Operation;

public class MainActivity extends AppCompatActivity implements Constants {

    CalculatorPresenter calculatorPresenter = new CalculatorPresenter();
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    private int theme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtonChosser();
        initSetings();

    }

    void initSetings(){
        Button settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
                                            startActivity (runSettings);
                                        }
                                    }
        );

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == RESULT_OK){
            theme = data.getIntExtra(YOUR_THEME,0);
        }
    }




    void initButtonChosser(){
        calculatorPresenter.setText(findViewById(R.id.text_value));
        calculatorPresenter.pressButton(findViewById(R.id.button_0),0);
        calculatorPresenter.pressButton(findViewById(R.id.button_1),1);
        calculatorPresenter.pressButton(findViewById(R.id.button_2),2);
        calculatorPresenter.pressButton(findViewById(R.id.button_3),3);
        calculatorPresenter.pressButton(findViewById(R.id.button_4),4);
        calculatorPresenter.pressButton(findViewById(R.id.button_5),5);
        calculatorPresenter.pressButton(findViewById(R.id.button_6),6);
        calculatorPresenter.pressButton(findViewById(R.id.button_7),7);
        calculatorPresenter.pressButton(findViewById(R.id.button_8),8);
        calculatorPresenter.pressButton(findViewById(R.id.button_9),9);

        calculatorPresenter.pressButton(findViewById(R.id.button_plus), Operation.ADD);
        calculatorPresenter.pressButton(findViewById(R.id.button_minus),Operation.DIV);
        calculatorPresenter.pressButton(findViewById(R.id.button_multiplication),Operation.MULT);
        calculatorPresenter.pressButton(findViewById(R.id.button_division),Operation.DIST);
        calculatorPresenter.pressButton(findViewById(R.id.button_equal),Operation.EQUAL);
        calculatorPresenter.pressButton(findViewById(R.id.button_clear),Operation.CLEAR);
    }
}


