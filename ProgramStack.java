
import java.util.Stack;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ProgramStack {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static Stack<String> stack = new Stack<>();
    private static Stack<String> backupstack = new Stack<>();

    private static void createStack() {
        System.out.println(ANSI_YELLOW + "||======================================================||");
        System.out.print("|| Berapa Banyak Data Yang Akan Di Masukan : ");
        Scanner banyak = new Scanner(System.in);
        try {
            int brpbanyak = banyak.nextInt();
            System.out.println("||======================================================||");
            for (int i = 0; i < brpbanyak; i++) {
                System.out.print("|| " + (i + 1) + ". Masukan Data : ");
                Scanner newstack = new Scanner(System.in);
                String addstack = newstack.nextLine();
                stack.push(addstack);
                addstack = null;
            }
            System.out.println("||======================================================||" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| SUCCESS : BERHASIL MENAMBAHKAN " + brpbanyak + " DATA KEDALAM STACK\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        } catch (InputMismatchException e) {
            System.out.println("||======================================================||" + ANSI_RESET);
            System.out.println(ANSI_RED + "||======================================================||");
            System.out.println("|| WARNING : INPUT NILAI HARUS BERUPA ANGKA !!!\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        }
        menuProgram();
    }

    private static void removeStack() {
        int adbrpstack = stack.size();
        if (adbrpstack > 0) {
            stack.pop();
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| SUCCESS : BERHASIL MENGHAPUS DATA TERAHIR PADA STACK\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "||======================================================||");
            System.out.println("|| WARNING : TIDAK ADA DATA DI DALAM STACK !!!\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        }
    }

    private static void cleanStack() {
        int adbrpstack = stack.size();
        if (adbrpstack > 0) {
            stack.clear();
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| SUCCESS : BERHASIL MEMBERSIHKAN STACK\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "||======================================================||");
            System.out.println("|| WARNING : TIDAK ADA DATA DI DALAM STACK !!!\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        }
        menuProgram();
    }

    private static void statusStack() {

        int adbrpstack = stack.size();
        if (adbrpstack > 0) {
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| STATUS : TERDAPAT " + stack.size() + " DATA DI DALAM STACK\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "||======================================================||");
            System.out.println("|| WARNING : TIDAK ADA DATA DI DALAM STACK\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        }
    }

    private static void showStack() {
        int adbrpstack = stack.size();

        if (adbrpstack > 0) {
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| LIST DATA YANG ADA DIDALAM STACK :\t\t\t||");
            System.out.println("||======================================================||");
            for (int i = 1; i <= adbrpstack; i++) {
                System.out.println("|| " + (adbrpstack - (i - 1)) + "\t=>\t" + stack.peek());
                backupstack.push(stack.pop());
            }
            int adbrpbackupstack = backupstack.size();
            for (int i = 1; i <= adbrpbackupstack; i++) {
                stack.push(backupstack.pop());
            }
            System.out.println("||======================================================||" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "||======================================================||");
            System.out.println("|| WARNING : TIDAK ADA DATA DI DALAM STACK\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        }
        menuProgram();
    }

    private static void quitApp() {
        String quitss = "y";
        System.out.println(ANSI_RED + "||======================================================||");
        System.out.print("|| KELUAR DARI PROGRAM? (Y/T) >>> ");
        quitss = new Scanner(System.in).nextLine();
        if (quitss.equalsIgnoreCase("y")) {
            System.out.println("||======================================================||" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| SUCCESS : BERHASIL KELUAR DARI DALAM PROGRAM\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
            System.exit(0);
        } else {
            System.out.println("||======================================================||" + ANSI_RESET);
            menuProgram();
        }
    }

    private static void menuChooser(int choosenMenu) {
        switch (choosenMenu) {
            case 1:
                createStack();
                break;
            case 2:
                removeStack();
                break;
            case 3:
                cleanStack();
                break;
            case 4:
                statusStack();
                break;
            case 5:
                showStack();
                break;
            case 6:
                quitApp();
                break;
            default:
                System.out.println(ANSI_RED + "||======================================================||");
                System.out.println("|| WARNING : PILIH MENU SESUAI NOMOR YANG TERSEDIA !!!\t||");
                System.out.println("||======================================================||" + ANSI_RESET);
                break;
        }
        menuProgram();
    }

    private static void menuProgram() {
        int loopX = 0;
        int choosenMenu = 0;
        while (loopX == 0) {
            System.out.println(ANSI_CYAN + "||======================================================||");
            System.out.println("|| M E N U - P R O G R A M\t\t\t\t||");
            System.out.println("||======================================================||");
            System.out.println("|| 1. Menambah Data Pada Stack\t\t\t\t||");
            System.out.println("|| 2. Menghapus Data Pada Stack\t\t\t\t||");
            System.out.println("|| 3. Menghapus Semua Data Pada Stack\t\t\t||");
            System.out.println("|| 4. Menampilkan Jumlah Data Pada Stack\t\t||");
            System.out.println("|| 5. Menampilkan Seluruh Data Pada Stack\t\t||");
            System.out.println("|| 6. Keluar Dari Program\t\t\t\t||");
            System.out.print("|| Pilihan Menu (1 - 6) >>> ");
            Scanner menuOption = new Scanner(System.in);
            try {
                choosenMenu = menuOption.nextInt();
                loopX = 1;
            } catch (InputMismatchException e) {
                System.out.println("||======================================================||" + ANSI_RESET);
                System.out.println(ANSI_RED + "||======================================================||");
                System.out.println("|| WARNING : MASUKAN NILAI BERUPA ANGKA !!!\t\t||");
                System.out.println("||======================================================||" + ANSI_RESET);
            }
        }
        System.out.println("||======================================================||" + ANSI_RESET);
        menuChooser(choosenMenu);
    }

    public static void main(String[] args) {
        System.out.println(ANSI_RED + "||======================================================||");
        System.out.println("||\t\tPROGRAM STACK DENGAN JAVA\t\t||");
        System.out.println("||======================================================||" + ANSI_RESET);
        menuProgram();
    }
}
