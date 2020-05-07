package juli.bindi.x_o_game;

public class GameLogic_SinglePlayerManager extends CommonGameLogic {

    public void onButtonClick(int number) {
        game(number);
    }

    private void game(int numberButton) {
        updateText(X, numberButton);
        setValueMass(massMain, numberButton - 1);
        enabledButton(numberButton);
        checkWinEnd(X);
        if (!win) {
            if (checkVolumeMass(massMain)) {
                smartyComputer(massMain);
                checkWinEnd(O);
            }
        }
    }

    private void smartyComputer(String[][] mass) {
        int a = -1;
        blockWin(mass, a);
    }

    private void blockWin(String[][] mass, int a) {
        int number = checkString(mass);
        if (number != a) {
            installVolume(mass, number);
            return;
        }
        int numberUp = checkUp(mass);
        if (numberUp != a) {
            installVolume(mass, numberUp);
            return;
        }
        int numberDiagonal = checkDiagonal(mass);
        if (numberDiagonal != a) {
            installVolume(mass, numberDiagonal);
            return;
        }
        int numberGenerate = generate(massMain);
        updateText(O, numberGenerate + 1);
        enabledButton(numberGenerate + 1);
        checkWinEnd(O);
    }

    private void installVolume(String[][] mass, int number) {
        setNumber(mass, number);
        updateText(O, number + 1);
        enabledButton(number + 1);
    }

    private int checkString(String[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < 1; j++) {
                if (mass[i][j] != null && mass[i][j + 1] != null && mass[i][j] == mass[i][j + 1] &&
                        mass[i][j + 2] == null) {
                    return i * 3 + 2;
                }
                if (mass[i][j] != null && mass[i][j + 2] != null && mass[i][j] == mass[i][j + 2] &&
                        mass[i][j + 1] == null) {
                    return i * 3 + 1;
                }
                if (mass[i][j + 1] != null && mass[i][j + 2] != null &&
                        mass[i][j + 1] == mass[i][j + 2] && mass[i][j] == null) {
                    return i * 3;
                }
            }
        }
        return -1;
    }

    private int checkUp(String[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < 1; j++) {
                if (mass[j][i] != null && mass[j + 1][i] != null && mass[j][i] == mass[j + 1][i] &&
                        mass[j + 2][i] == null) {
                    return 6 + i;
                }
                if (mass[j][i] != null && mass[j + 2][i] != null && mass[j][i] == mass[j + 2][i] &&
                        mass[j + 1][i] == null) {
                    return 3 + i;
                }
                if (mass[j + 1][i] != null && mass[j + 2][i] != null &&
                        mass[j + 1][i] == mass[j + 2][i] && mass[j][i] == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int checkDiagonal(String[][] mass) {
        if (mass[0][0] != null && mass[1][1] != null && mass[0][0] == mass[1][1] &&
                mass[2][2] == null)
            return 8;
        if (((mass[0][0] != null && mass[2][2] != null && mass[0][0] == mass[2][2]) ||
                (mass[0][2] != null && mass[2][0] != null && mass[0][2] == mass[2][0])) &&
                mass[1][1] == null)
            return 4;
        if (mass[1][1] != null && mass[2][2] != null && mass[1][1] == mass[2][2] &&
                mass[0][0] == null)
            return 0;

        if (mass[0][2] != null && mass[1][1] != null && mass[0][2] == mass[1][1] &&
                mass[2][0] == null)
            return 6;
        if (mass[1][1] != null && mass[2][0] != null && mass[1][1] == mass[2][0] &&
                mass[0][2] == null)
            return 2;
        return -1;
    }

    private boolean findDiagonalRight(String[][] mass) {
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

    private boolean checkVolumeMass(String[][] mass) {
        int count = 0;
        for (String[] strings : mass) {
            for (int j = 0; j < mass.length; j++) {
                if (strings[j] == null)
                    count++;
            }
        }
        return count > 1;
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

    private int generate(String[][] mass) {
        int generateNumber;
        do {
            generateNumber = (int) (Math.random() * 9);
        } while (!setNumber(mass, generateNumber));
        return generateNumber;
    }

    private boolean setNumber(String[][] mass, int generateNumber) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if ((i * 3 + j) == generateNumber && mass[i][j] == null) {
                    mass[i][j] = O;
                    return true;
                }
            }
        }
        return false;
    }
}
