import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


class  massive {
    ArrayList<Integer> ones = new ArrayList<>();
    int count = 0;
    boolean flag = false;

    public boolean isClosed(int[][] mas) {
        //ArrayList<Integer> ones = new ArrayList<>();
        int OK = 1;

        for (int i = 1; i < mas.length; i++) {
            for (int j = 1; j < mas.length + 1; j++) {

                if (mas[i][j] == 1) {
                    if (mas[i - 1][j] == 1 && mas[i + 1][j] == 1) {
                        ones.add(OK);
                    }
                }
                if (mas[i][j] == 1) {
                    if (mas[i - 1][j] == 1 && mas[i][j - 1] == 1) {
                        ones.add(OK);
                    }
                }
                if (mas[i][j] == 1) {
                    if (mas[i][j + 1] == 1 && mas[i + 1][j] == 1) {
                        ones.add(OK);
                    }
                }
                if (mas[i][j] == 1) {
                    if (mas[i][j - 1] == 1 && mas[i][j + 1] == 1) {
                        ones.add(OK);
                    }
                }
                if (mas[i][j] == 1) {
                    if (mas[i - 1][j] == 1 && mas[i][j + 1] == 1) {
                        ones.add(OK);
                    }
                }
                if (mas[i][j] == 1) {
                    if (mas[i + 1][j] == 1 && mas[i][j - 1] == 1) {
                        ones.add(OK);
                    }
                }

                if (mas[i][j] == 1) {
                    count += 1;
                }
            }

        }

        int lang = ones.toArray().length;

        if (lang == count) {
            //System.out.println("Лінія у масиві замкнута!");
            flag = true;
        } else {
            //System.out.println("Лінія у масиві не замкнута!");
        }
        return flag;
    }
}

    public class main {
        public static void main(String[] args) {

            JFrame frame = new JFrame("Масив");
            frame.setBounds(10, 10, 600, 600);
            JPanel pn = new JPanel() {
                @Override
                public void paint(Graphics g) {
                    int[][] massive = {
                            {0, 0, 0, 0, 0, 0},
                            {1, 1, 1, 1, 0, 0},
                            {1, 0, 0, 1, 1, 1},
                            {1, 1, 0, 0, 0, 1},
                            {0, 1, 1, 1, 1, 1},};
                    int n = 7;
                    int m = 8;

                    int[][] massive_copy = new int[n][m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            massive_copy[i][j] = 0;
                        }
                    }

                    for (int i = 0; i < n - 2; i++) {
                        for (int j = 0; j < m - 2; j++) {
                            if (massive[i][j] == 1) {
                                massive_copy[i + 1][j + 1] = 1;
                            }
                            System.out.print(massive[i][j] + "\t");
                        }
                        System.out.println();
                    }

                    System.out.println();

                    massive arr = new massive();
                    System.out.println(arr.isClosed(massive_copy));

                    for (int y = 0; y < massive.length; y++) {
                        for (int x = 0; x < massive.length + 1; x++) {
                            if (massive[y][x] == 1) {
                                g.setColor(new Color(128, 128, 128, 182));
                            } else {
                                g.setColor(new Color(255, 255, 255));

                            }
                            g.fillRect(x* 64, y* 64, 64 , 64);
                            if (arr.isClosed(massive_copy)){
                                g.drawString("Лінія у масиві замкнута! ", 127, 355);
                            }
                            else {
                                g.drawString("Лінія у масиві не замкнута! ", 127, 355);
                            }

                        }
                    }
                }
            };
            frame.add(pn);
            frame.setDefaultCloseOperation(3);
            frame.setVisible(true);

        }
    }





