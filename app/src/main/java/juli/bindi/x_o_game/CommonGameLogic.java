package juli.bindi.x_o_game;

abstract class CommonGameLogic {

    int countStep = 0;
    final String X = "X";
    final String O = "O";

    String[][] massMain = new String[3][3];

    OnPathButtonStateChangeCallback callback;
    void setCallback(OnPathButtonStateChangeCallback callback) {
        this.callback = callback;
    }

    public abstract void onButtonClick(int number);

    private boolean IsFull(String[][] mass) {
        for (String[] strings : mass) {
            for (int j = 0; j < mass.length; j++) {
                if (strings[j] == null)
                    return false;
            }
        }
        return true;
    }

    private boolean checkWin(String[][] mass) {
        for (String[] strings : mass) {
            if (findString(strings))
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

    private static boolean findString(String[] mass) {
        String check = mass[0];
        for (int i = 1; i < mass.length; i++) {
            if (mass[i] != null) {
                if (mass[i]!=check)
                    return false;
            } else return false;
        }
        return true;
    }

    private static boolean findUp(String[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            boolean checkNumber = true;
            String check = mass[0][i];
            if (check == null) {
                continue;
            } else {
                for (int j = 1; j < mass.length; j++) {
                    if (mass[j][i]!=check) {
                        checkNumber = false;
                        break;
                    }
                }
                if (checkNumber) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean findDiagonalLeft(String[][] mass) {
        String check = mass[0][0];
        for (int i = 0; i < mass.length; i++) {
            if (mass[i][i] != null) {
                if (mass[i][i]!=check) {
                    return false;
                }
            } else return false;
        }
        return true;
    }

    private static boolean findDiagonalRight(String[][] mass) {
        String check = mass[0][mass.length - 1];
        for (int i = 0; i < mass.length; i++) {
            if (mass[i][mass.length - 1 - i] != null) {
                if (mass[i][mass.length - 1 - i]!=check) {
                    return false;
                }
            } else return false;
        }
        return true;
    }

    void checkWinEnd(String text) {
        if (checkWin(massMain)) {
            callback.showGameDialog(text, true);
        }
        if (IsFull(massMain)) {
            callback.showGameDialog(text, false);
        }
    }
}
