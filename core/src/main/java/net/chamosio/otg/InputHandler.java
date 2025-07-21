package net.chamosio.otg;

public class InputHandler {
    public static final int Q = 0;
    public static final int W = 1;
    public static final int E = 2;
    public static final int R = 3;
    public static final int T = 4;
    public static final int Y = 5;
    public static final int U = 6;
    public static final int I = 7;
    public static final int O = 8;
    public static final int P = 9;
    public static final int A = 10;
    public static final int S = 11;
    public static final int D = 12;
    public static final int F = 13;
    public static final int G = 14;
    public static final int H = 15;
    public static final int J = 16;
    public static final int K = 17;
    public static final int L = 18;
    public static final int Z = 19;
    public static final int X = 20;
    public static final int C = 21;
    public static final int V = 22;
    public static final int B = 23;
    public static final int N = 24;
    public static final int M = 25;

    private volatile static boolean Q_PRESSED = false;
    private volatile static boolean W_PRESSED = false;
    private volatile static boolean E_PRESSED = false;
    private volatile static boolean R_PRESSED = false;
    private volatile static boolean T_PRESSED = false;
    private volatile static boolean Y_PRESSED = false;
    private volatile static boolean U_PRESSED = false;
    private volatile static boolean I_PRESSED = false;
    private volatile static boolean O_PRESSED = false;
    private volatile static boolean P_PRESSED = false;
    private volatile static boolean A_PRESSED = false;
    private volatile static boolean S_PRESSED = false;
    private volatile static boolean D_PRESSED = false;
    private volatile static boolean F_PRESSED = false;
    private volatile static boolean G_PRESSED = false;
    private volatile static boolean H_PRESSED = false;
    private volatile static boolean J_PRESSED = false;
    private volatile static boolean K_PRESSED = false;
    private volatile static boolean L_PRESSED = false;
    private volatile static boolean Z_PRESSED = false;
    private volatile static boolean X_PRESSED = false;
    private volatile static boolean C_PRESSED = false;
    private volatile static boolean V_PRESSED = false;
    private volatile static boolean B_PRESSED = false;
    private volatile static boolean N_PRESSED = false;
    private volatile static boolean M_PRESSED = false;

    protected static boolean mouseLeftClicked;
    protected static boolean mouseRightClicked;
    protected static boolean mouseMiddleClicked;

    protected static int[] mousePos = new int[] {0, 0};

    public static boolean isMouseLeftClicked() {return mouseLeftClicked;}
    public static boolean isMouseRightClicked() {return mouseRightClicked;}
    public static boolean isMouseMiddleClicked() {return mouseMiddleClicked;}

    public static boolean isKeyPressed(int key) {
        return switch (key) {
            case 0 -> Q_PRESSED;
            case 1 -> W_PRESSED;
            case 2 -> E_PRESSED;
            case 3 -> R_PRESSED;
            case 4 -> T_PRESSED;
            case 5 -> Y_PRESSED;
            case 6 -> U_PRESSED;
            case 7 -> I_PRESSED;
            case 8 -> O_PRESSED;
            case 9 -> P_PRESSED;
            case 10 -> A_PRESSED;
            case 11 -> S_PRESSED;
            case 12 -> D_PRESSED;
            case 13 -> F_PRESSED;
            case 14 -> G_PRESSED;
            case 15 -> H_PRESSED;
            case 16 -> J_PRESSED;
            case 17 -> K_PRESSED;
            case 18 -> L_PRESSED;
            case 19 -> Z_PRESSED;
            case 20 -> X_PRESSED;
            case 21 -> C_PRESSED;
            case 22 -> V_PRESSED;
            case 23 -> B_PRESSED;
            case 24 -> N_PRESSED;
            case 25 -> M_PRESSED;
            default -> false;
        };
    }
    public static void handleKeyPressed(int key) {
        switch (key) {
            case 0 -> Q_PRESSED = true;
            case 1 -> W_PRESSED = true;
            case 2 -> E_PRESSED = true;
            case 3 -> R_PRESSED = true;
            case 4 -> T_PRESSED = true;
            case 5 -> Y_PRESSED = true;
            case 6 -> U_PRESSED = true;
            case 7 -> I_PRESSED = true;
            case 8 -> O_PRESSED = true;
            case 9 -> P_PRESSED = true;
            case 10 -> A_PRESSED = true;
            case 11 -> S_PRESSED = true;
            case 12 -> D_PRESSED = true;
            case 13 -> F_PRESSED = true;
            case 14 -> G_PRESSED = true;
            case 15 -> H_PRESSED = true;
            case 16 -> J_PRESSED = true;
            case 17 -> K_PRESSED = true;
            case 18 -> L_PRESSED = true;
            case 19 -> Z_PRESSED = true;
            case 20 -> X_PRESSED = true;
            case 21 -> C_PRESSED = true;
            case 22 -> V_PRESSED = true;
            case 23 -> B_PRESSED = true;
            case 24 -> N_PRESSED = true;
            case 25 -> M_PRESSED = true;
        }
    }
    public static void handleKeyReleased(int key) {
        switch (key) {
            case 0 -> Q_PRESSED = false;
            case 1 -> W_PRESSED = false;
            case 2 -> E_PRESSED = false;
            case 3 -> R_PRESSED = false;
            case 4 -> T_PRESSED = false;
            case 5 -> Y_PRESSED = false;
            case 6 -> U_PRESSED = false;
            case 7 -> I_PRESSED = false;
            case 8 -> O_PRESSED = false;
            case 9 -> P_PRESSED = false;
            case 10 -> A_PRESSED = false;
            case 11 -> S_PRESSED = false;
            case 12 -> D_PRESSED = false;
            case 13 -> F_PRESSED = false;
            case 14 -> G_PRESSED = false;
            case 15 -> H_PRESSED = false;
            case 16 -> J_PRESSED = false;
            case 17 -> K_PRESSED = false;
            case 18 -> L_PRESSED = false;
            case 19 -> Z_PRESSED = false;
            case 20 -> X_PRESSED = false;
            case 21 -> C_PRESSED = false;
            case 22 -> V_PRESSED = false;
            case 23 -> B_PRESSED = false;
            case 24 -> N_PRESSED = false;
            case 25 -> M_PRESSED = false;
        }
    }
    public static int localToGdx(int local) {
        return switch (local) {
            case 0 -> 45;
            case 1 -> 51;
            case 2 -> 33;
            case 3 -> 46;
            case 4 -> 48;
            case 5 -> 53;
            case 6 -> 49;
            case 7 -> 37;
            case 8 -> 43;
            case 9 -> 44;
            case 10 -> 29;
            case 11 -> 47;
            case 12 -> 32;
            case 13 -> 34;
            case 14 -> 35;
            case 15 -> 36;
            case 16 -> 38;
            case 17 -> 39;
            case 18 -> 40;
            case 19 -> 54;
            case 20 -> 52;
            case 21 -> 31;
            case 22 -> 50;
            case 23 -> 30;
            case 24 -> 42;
            case 25 -> 41;
            default -> 0xDEADBEEF;
        };
    }
    public static int gdxToLocal(int key) {
        return switch (key) {
            case 45 -> 0;
            case 51 -> 1;
            case 33 -> 2;
            case 46 -> 3;
            case 48 -> 4;
            case 53 -> 5;
            case 49 -> 6;
            case 37 -> 7;
            case 43 -> 8;
            case 44 -> 9;
            case 29 -> 10;
            case 47 -> 11;
            case 32 -> 12;
            case 34 -> 13;
            case 35 -> 14;
            case 36 -> 15;
            case 38 -> 16;
            case 39 -> 17;
            case 40 -> 18;
            case 54 -> 19;
            case 52 -> 20;
            case 31 -> 21;
            case 50 -> 22;
            case 30 -> 23;
            case 42 -> 24;
            case 41 -> 25;
            default -> 0xDEADBEEF;
        };
    }
}
