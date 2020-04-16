package juli.bindi.x_o_game;

public class GameLogicManager {
    private OnPathButtonStateChangeCallback callback;
    private String[][] massMain = new String[3][3];
    private int countStep = 0;
    private String start = "X";


    void setCallback(OnPathButtonStateChangeCallback callback) {
        this.callback = callback;
    }

    public boolean checkWin(String[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            if (findString(mass[i]))
                return true;
        }
        if (findUp(mass))
            return true;
        if (findDiagonalLeft(mass))
            return true;
        if (findDiagonalRight(mass))
            return true;
        return false;
    }

    public static boolean findString(String[] mass) {
        String check = mass[0];
        for (int i = 1; i < mass.length; i++) {
            if (mass[i] != null) {
                if (mass[i] != check)
                    return false;
            } else return false;
        }
        return true;
    }

    public static boolean findUp(String[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            String check = mass[0][i];
            for (int j = 0; j < mass.length; j++) {
                if (mass[j][i] != null) {
                    if (mass[j][i] != check) {
                        return false;
                    }
                } else return false;
            }
        }
        return true;
    }

    public static boolean findDiagonalLeft(String[][] mass) {
        String check = mass[0][0];
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if (mass[i][j] != null) {
                    if (i == j && mass[i][j] != check) {
                        return false;
                    } else continue;
                } else return false;
            }
        }
        return true;
    }

    public static boolean findDiagonalRight(String[][] mass) {
        String check = mass[0][mass.length - 1];
        for (int i = 0; i < mass.length; i++) {
            if (mass[i][mass.length - 1 - i] != null) {
                if (mass[i][mass.length - 1 - i] != check) {
                    return false;
                }
            } else return false;
        }
        return true;
    }

    public void onButtonClick(int number) {
        if (!checkWin(massMain)) {
            switch (number) {
                case 1:
                    callback.onTextUpdate1(start);
                    countStep++;
                    updateStart();
                    massMain[0][0] = start;
                    callback.onButtonStateChanged(false, R.id.textView1);
                    break;
                case 2:
                    callback.onTextUpdate2(start);
                    countStep++;
                    updateStart();
                    massMain[0][1] = start;
                    callback.onButtonStateChanged(false, R.id.textView2);
                    break;
                case 3:
                    callback.onTextUpdate3(start);
                    countStep++;
                    updateStart();
                    massMain[0][2] = start;
                    callback.onButtonStateChanged(false, R.id.textView3);
                    break;
                case 4:
                    callback.onTextUpdate4(start);
                    countStep++;
                    updateStart();
                    massMain[1][0] = start;
                    callback.onButtonStateChanged(false, R.id.textView4);
                    break;
                case 5:
                    callback.onTextUpdate5(start);
                    countStep++;
                    updateStart();
                    massMain[1][1] = start;
                    callback.onButtonStateChanged(false, R.id.textView5);
                    break;
                case 6:
                    callback.onTextUpdate6(start);
                    countStep++;
                    updateStart();
                    massMain[1][2] = start;
                    callback.onButtonStateChanged(false, R.id.textView6);
                    break;
                case 7:
                    callback.onTextUpdate7(start);
                    countStep++;
                    updateStart();
                    massMain[2][0] = start;
                    callback.onButtonStateChanged(false, R.id.textView7);
                    break;
                case 8:
                    callback.onTextUpdate8(start);
                    countStep++;
                    updateStart();
                    massMain[2][1] = start;
                    callback.onButtonStateChanged(false, R.id.textView8);
                    break;
                case 9:
                    callback.onTextUpdate9(start);
                    countStep++;
                    updateStart();
                    massMain[2][2] = start;
                    callback.onButtonStateChanged(false, R.id.textView9);
                    break;
            }
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
