package juli.bindi.x_o_game;

public class GameLogicSinglePlayerManager extends CommonGameLogic {

    public void onButtonClick(int number) {
        game(number);
    }

    public void game(int numberButton) {
        if (countStep % 2 == 0) {
            updateText(X, numberButton);
            checkWinEnd(X);
        } else {
            updateText(O, numberButton);
            checkWinEnd(O);
        }
        setValueMass(massMain, numberButton - 1);
        enabledButton(numberButton);
        countStep++;
    }

    private void setValueMass(String[][] mass, int position) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if (i * 3 + j == position) {
                    mass[i][j] = X;
                }
            }
        }
    }

    private void updateText(String text, int number) {
        switch (number) {
            case 1:
                callback.onTextUpdate1(text);
                break;
            case 2:
                callback.onTextUpdate2(text);
                break;
            case 3:
                callback.onTextUpdate3(text);
                break;
            case 4:
                callback.onTextUpdate4(text);
                break;
            case 5:
                callback.onTextUpdate5(text);
                break;
            case 6:
                callback.onTextUpdate6(text);
                break;
            case 7:
                callback.onTextUpdate7(text);
                break;
            case 8:
                callback.onTextUpdate8(text);
                break;
            case 9:
                callback.onTextUpdate9(text);
                break;
        }
    }

    private void enabledButton(int num) {
        switch (num) {
            case 1:
                callback.onButtonStateChanged(false, R.id.textView1);
                break;
            case 2:
                callback.onButtonStateChanged(false, R.id.textView2);
                break;
            case 3:
                callback.onButtonStateChanged(false, R.id.textView3);
                break;
            case 4:
                callback.onButtonStateChanged(false, R.id.textView4);
                break;
            case 5:
                callback.onButtonStateChanged(false, R.id.textView5);
                break;
            case 6:
                callback.onButtonStateChanged(false, R.id.textView6);
                break;
            case 7:
                callback.onButtonStateChanged(false, R.id.textView7);
                break;
            case 8:
                callback.onButtonStateChanged(false, R.id.textView8);
                break;
            case 9:
                callback.onButtonStateChanged(false, R.id.textView9);
                break;
        }
    }
}
