package juli.bindi.x_o_game;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GamePlayerActivity extends AppCompatActivity implements View.OnClickListener, OnPathButtonStateChangeCallback {

    public static final String GAME_MODE ="game_mode";

    TextView buttonText1;
    TextView buttonText2;
    TextView buttonText3;
    TextView buttonText4;
    TextView buttonText5;
    TextView buttonText6;
    TextView buttonText7;
    TextView buttonText8;
    TextView buttonText9;

    CommonGameLogic logicManager;
    private boolean mGameMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_field);

        mGameMode = getIntent().getBooleanExtra(GAME_MODE, true);

        Button button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
            }
        });

        buttonText1 = findViewById(R.id.textView1);
        buttonText2 = findViewById(R.id.textView2);
        buttonText3 = findViewById(R.id.textView3);
        buttonText4 = findViewById(R.id.textView4);
        buttonText5 = findViewById(R.id.textView5);
        buttonText6 = findViewById(R.id.textView6);
        buttonText7 = findViewById(R.id.textView7);
        buttonText8 = findViewById(R.id.textView8);
        buttonText9 = findViewById(R.id.textView9);

        buttonText1.setOnClickListener(this);
        buttonText2.setOnClickListener(this);
        buttonText3.setOnClickListener(this);
        buttonText4.setOnClickListener(this);
        buttonText5.setOnClickListener(this);
        buttonText6.setOnClickListener(this);
        buttonText7.setOnClickListener(this);
        buttonText8.setOnClickListener(this);
        buttonText9.setOnClickListener(this);

        logicManager = mGameMode ? new GameLogic_SinglePlayerManager() : new GameLogic_MultiPlayerManager();
        logicManager.setCallback(this);
    }

    @Override
    public void onButtonStateChanged(boolean enabled, int buttonResId) {
        switch (buttonResId) {
            case R.id.textView1:
                buttonText1.setEnabled(enabled);
                break;
            case R.id.textView2:
                buttonText2.setEnabled(enabled);
                break;
            case R.id.textView3:
                buttonText3.setEnabled(enabled);
                break;
            case R.id.textView4:
                buttonText4.setEnabled(enabled);
                break;
            case R.id.textView5:
                buttonText5.setEnabled(enabled);
                break;
            case R.id.textView6:
                buttonText6.setEnabled(enabled);
                break;
            case R.id.textView7:
                buttonText7.setEnabled(enabled);
                break;
            case R.id.textView8:
                buttonText8.setEnabled(enabled);
                break;
            case R.id.textView9:
                buttonText9.setEnabled(enabled);
                break;
        }
    }

    @Override
    public void onTextUpdate1(String text) {
        buttonText1.setText(text);
    }

    @Override
    public void onTextUpdate2(String text) {
        buttonText2.setText(text);
    }

    @Override
    public void onTextUpdate3(String text) {
        buttonText3.setText(text);
    }

    @Override
    public void onTextUpdate4(String text) {
        buttonText4.setText(text);
    }

    @Override
    public void onTextUpdate5(String text) {
        buttonText5.setText(text);
    }

    @Override
    public void onTextUpdate6(String text) {
        buttonText6.setText(text);
    }

    @Override
    public void onTextUpdate7(String text) {
        buttonText7.setText(text);
    }

    @Override
    public void onTextUpdate8(String text) {
        buttonText8.setText(text);
    }

    @Override
    public void onTextUpdate9(String text) {
        buttonText9.setText(text);
    }

    @Override
    public void showGameDialog(String text, boolean bool) {
        //вызов диалогового окна в конце игры:
        final Dialog dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);// скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend);//путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// прозрачный фон дмалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); // окно нельзя закрыть системной кнопкой назад

        Button btnContinue = dialogEnd.findViewById(R.id.btncontinue);
        TextView buttonText = dialogEnd.findViewById(R.id.textdescriptionEnd); // основной текст в диалоге

        if (bool) {
            buttonText.setText(R.string.levelEndWin);
            btnContinue.setText(text);
        } else {
            buttonText.setText(R.string.levelEndLose);
            btnContinue.setVisibility(View.INVISIBLE);
        }

        // кнопка, которая закрывает диалоговое окно начало
        TextView btnClose = dialogEnd.findViewById(R.id.btncloses);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // вернуться назад к выбору уровня
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                }
                dialogEnd.dismiss();//закрываем диалоговое окно
            }
        });
        dialogEnd.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView1:
                logicManager.onButtonClick(1);
                break;
            case R.id.textView2:
                logicManager.onButtonClick(2);
                break;
            case R.id.textView3:
                logicManager.onButtonClick(3);
                break;
            case R.id.textView4:
                logicManager.onButtonClick(4);
                break;
            case R.id.textView5:
                logicManager.onButtonClick(5);
                break;
            case R.id.textView6:
                logicManager.onButtonClick(6);
                break;
            case R.id.textView7:
                logicManager.onButtonClick(7);
                break;
            case R.id.textView8:
                logicManager.onButtonClick(8);
                break;
            case R.id.textView9:
                logicManager.onButtonClick(9);
                break;
        }
    }
}
