package juli.bindi.x_o_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOne = findViewById(R.id.button);
        Button buttonTwo = findViewById(R.id.button2);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(getBaseContext(), GamePlayerActivity.class);
                    intent.putExtra(GamePlayerActivity.GAME_MODE, true);
                    startActivity(intent);
                } catch (Exception e) {
                }
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(getBaseContext(), GamePlayerActivity.class);
                    intent.putExtra(GamePlayerActivity.GAME_MODE, false);
                    startActivity(intent);
                } catch (Exception e) {
                }
            }
        });
    }
    //Системная кнопка "Назад" начало
    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed(); // закрывает игру
            return;
        } else{
            backToast = Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis(); // засекли время нажатия на кнопку
    }

    //конец
}
