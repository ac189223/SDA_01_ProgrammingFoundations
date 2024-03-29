package Random.AntProblem_Dina;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AntProblem02_PointAnt {
    private static AntProblem02_PointAnt antProblem = new AntProblem02_PointAnt();
    // Input
    // R N A B X
    // X hard cells
    private int R;      // length of edge       2 <= R <= 20
    private int N;      // number of chews      1 <= N <= R^3 - (R - 1)^3
    private int A;      // starting cell (on the edge)
    private int B;      // destination cell
    private int X;      // number of hard cells 0 <= X <= R^3 - (R - 1)^3 -1
    private ArrayList<Integer> hardCells;
    private int cells;
    private ArrayList<Integer> softCells;
    private int[][][] honey;    // number of cell, minimum number of steps from A
    private Random random = new Random();
    private Point ant;

    public int getR() { return R; }
    public int getN() { return N; }
    public int getA() { return A; }
    public int getB() { return B; }
    public int getX() { return X; }
    public ArrayList<Integer> getHardCells() { return hardCells; }
    public int getCells() { return cells; }
    public ArrayList<Integer> getSoftCells() { return softCells; }
    public int[][][] getHoney() { return honey; }
    public Point getAnt() { return ant; }

    public void setR(int r) { R = r; }
    public void setN(int n) { N = n; }
    public void setA(int a) { A = a; }
    public void setB(int b) { B = b; }
    public void setX(int x) { X = x; }
    public void setHardCells(ArrayList<Integer> hardCells) { this.hardCells = hardCells; }
    public void setCells(int cells) { this.cells = cells; }
    public void setSoftCells(ArrayList<Integer> softCells) { this.softCells = softCells; }
    public void setHoney(int[][][] honey) { this.honey = honey; }
    public void setAnt(Point ant) { this.ant = ant; }

    public static void main(String[] args) {
        antProblem.readData();
        antProblem.createHoney();
        antProblem.printHoney();
        antProblem.moveTheAnt(antProblem.getA(), antProblem.getN());
    }

    private void readData() {
        setR(random.nextInt(19) + 2);
        setCells(third(getR()) - third(getR() - 1));
        setN(random.nextInt(getCells()) + 1);
        setA(random.nextInt(getR()) + 1);
        setX(random.nextInt(getCells()));
        settleHardCells();
        if (getX() == getCells() - 1)
            setB(getA());
        else {
            setSoftCells(new ArrayList<>());
            for (int i = 1; i <= getCells(); i++)
                if (!getHardCells().contains(i))
                    getSoftCells().add(i);
            setB(getSoftCells().get(random.nextInt(getSoftCells().size())));
        }
    }

    private int third(int i) { return i * i * i; }

    private void settleHardCells() {
        setHardCells(new ArrayList<>());
        while (getHardCells().size() < getX()){
            int potentialHC = random.nextInt(getCells()) + 1;
            if (!getHardCells().contains(potentialHC) && getA() != potentialHC)
                getHardCells().add(potentialHC);
        }
    }

    private void createHoney() {
        int diagonal = getR() * 2 - 1;
        setHoney(new int[diagonal][][]);
        int length = R;
        int num = 1;
        for(int r = 0; r < diagonal; r++) {
            getHoney()[r] = new int[length][];
            for (int pos = 0; pos < length; pos++) {
                getHoney()[r][pos] = new int[]{num, getCells(), 0};
                if (num == getA()) {
                    setAnt(new Point(r, pos));
                    getHoney()[r][pos][1] = 0;
                    getHoney()[r][pos][2] = num;
                }
                num++;
            }
            if (r < R - 1)
                length++;
            else
                length--;
        }
    }

    private void printHoney() {
        System.out.println(getR() + " " + getCells()  + " " + getA() + " " + getB());
        for(int r = 0; r < getHoney().length; r++) {
            for (int pos = 0; pos < getHoney()[r].length; pos++) {
                if (getHardCells().contains(getHoney()[r][pos][0]))
                    System.out.print("*");
                System.out.print(getHoney()[r][pos][0] + " ");
            }
            System.out.println();
        }
    }

    private void moveTheAnt(int comingFrom, int stepsLeft) {
        // right
        if  (getAnt().y != getHoney()[getAnt().x].length - 1)
            setAnt(new Point(getAnt().x, getAnt().y + 1));
    }


}
