import java.util.Random;

public class Grid {

    private short[][] rows;

    public Grid() {
        rows = new short[9][9];
        initGrid();
    }

    private void initGrid() {
        for (short row = 0; row < 9; row++) {
            for (short col = 0; col < 9; col++) {
                setValue(row, col, (short) (1 +(col)));
            }
            shuffleArray(rows[row]);
        }
    }

    static void shuffleArray(short[] ar)
    {
        Random rnd = new Random();
        for (short i = 8; i > 0; i--)
        {
            short index = (short) rnd.nextInt(i + 1);
            // Simple swap
            short a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public void setValue(short row, short col, short value) {
        short[][] rowCopy = rows.clone();
        rowCopy[row][col] = value;
        rows = rowCopy.clone();
    }

    public short[] getRow(short row) {
        return rows[row];
    }

    public short[] getCol(short col) {
        short[] result = new short[9];
        for (short i = 0; i < 9; i++) {
            result[i] = rows[i][col];
        }
        return result;
    }

    public Grid getValues() {
        Grid result = new Grid();
        for (short i = 0; i < 9; i++) {
            for (short j = 0; j < 9; j++) {
                result.setValue(i, j, this.rows[i][j]);
            }
        }
        return result;
    }

    public void print() {
        for (short[] row : rows) {
            System.out.print("[");
            for (int i = 0; i < 9; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }
    }
}