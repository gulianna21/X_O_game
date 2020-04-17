package juli.bindi.x_o_game;

public abstract class CommonGameLogic {

    public boolean IsFull(String[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                if (mass[i][j] == null)
                    return false;
            }
        }
        return true;
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
            boolean checkNumber = true;
            String check = mass[0][i];
            if (check == null) {
                continue;
            } else {
                for (int j = 1; j < mass.length; j++) {
                    if (mass[j][i] != check) {
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

    public static boolean findDiagonalLeft(String[][] mass) {
        String check = mass[0][0];
        for (int i = 0; i < mass.length; i++) {
            if (mass[i][i] != null) {
                if (mass[i][i] != check) {
                    return false;
                }
            } else return false;
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
}
