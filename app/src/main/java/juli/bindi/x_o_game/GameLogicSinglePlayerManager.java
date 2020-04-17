package juli.bindi.x_o_game;

public class GameLogicSinglePlayerManager extends CommonGameLogic {
    private OnPathButtonStateChangeCallback callback;
    private String[][] massMain = new String[3][3];
    private int countStep = 0;
    private String start = "X";


    void setCallback(OnPathButtonStateChangeCallback callback) {
        this.callback = callback;
    }

    public void onButtonClick(int number) {
        switch (number) {
            case 1:
                callback.onTextUpdate1(start);
                countStep++;
                massMain[0][0] = start;
                callback.onButtonStateChanged(false, R.id.textView1);
                checkWinEnd(start);
                updateStart();
                break;
            case 2:
                callback.onTextUpdate2(start);
                countStep++;
                massMain[0][1] = start;
                callback.onButtonStateChanged(false, R.id.textView2);
                checkWinEnd(start);
                updateStart();
                break;
            case 3:
                callback.onTextUpdate3(start);
                countStep++;
                massMain[0][2] = start;
                callback.onButtonStateChanged(false, R.id.textView3);
                checkWinEnd(start);
                updateStart();
                break;
            case 4:
                callback.onTextUpdate4(start);
                countStep++;
                massMain[1][0] = start;
                callback.onButtonStateChanged(false, R.id.textView4);
                checkWinEnd(start);
                updateStart();
                break;
            case 5:
                callback.onTextUpdate5(start);
                countStep++;
                massMain[1][1] = start;
                callback.onButtonStateChanged(false, R.id.textView5);
                checkWinEnd(start);
                updateStart();
                break;
            case 6:
                callback.onTextUpdate6(start);
                countStep++;
                massMain[1][2] = start;
                callback.onButtonStateChanged(false, R.id.textView6);
                checkWinEnd(start);
                updateStart();
                break;
            case 7:
                callback.onTextUpdate7(start);
                countStep++;
                massMain[2][0] = start;
                callback.onButtonStateChanged(false, R.id.textView7);
                checkWinEnd(start);
                updateStart();
                break;
            case 8:
                callback.onTextUpdate8(start);
                countStep++;
                massMain[2][1] = start;
                callback.onButtonStateChanged(false, R.id.textView8);
                checkWinEnd(start);
                updateStart();
                break;
            case 9:
                callback.onTextUpdate9(start);
                countStep++;
                massMain[2][2] = start;
                callback.onButtonStateChanged(false, R.id.textView9);
                checkWinEnd(start);
                updateStart();
                break;
        }
    }

    public void checkWinEnd(String text) {
        if (checkWin(massMain)) {
            callback.showGameDialog(text, true);
        }
        if (IsFull(massMain)) {
            callback.showGameDialog(text, false);
        }
    }

    public void updateStart() {
        if (countStep % 2 == 0) {
            start = "X";
        } else {
            start = "O";
        }
    }
}
