package model;

/**
 *
 * @author pa
 */
public class Grid {
    private final Cell[][] plate;
    private int percent;
    private final int i;
    private final int j;

    public Grid(int i, int j, int percent) {
        this.i = i;
        this.j = j;
        this.plate = new Cell[i][j];
        this.percent = percent;
        setPlate(this.plate);
        setMines(this.percent);
        System.out.println("Nouvelle grille de démineur de " + i + " x " + j + " avec " + percent + "% de mines.");
    }
    
    public void setPlate(Cell[][] plate){
        for(int x = 0 ; x < this.i ; x++){
            for(int y = 0 ; y < this.j ; y++){
                plate[x][y] = new Cell();
            }
        }
    }
    
    public void setMines(int percent){
        int surface = this.i * this.j;
        int nbMines = surface * this.percent / 100;
        int tempx;
        int tempy;
        for(int it = 0 ; it < nbMines ; it++){
            do{
                tempx = 0 + (int)(Math.random() * this.i);
                tempy = 0 + (int)(Math.random() * this.j);
            } while (!this.plate[tempx][tempy].content.equals(PossibleCell.EMPTY));
            this.plate[tempx][tempy].setContent(PossibleCell.MINE);
        }
    }

    public int getPercent() {
        return percent;
    }

    public Cell[][] getPlate() {
        return plate;
    }
    

    public void setPercent(int percent) {
        this.percent = percent;
    }
    
    public void printInit() {
        for(int x = 0 ; x < this.i ; x++){
            for(int y = 0 ; y < this.j ; y++){
                System.out.print("# ");
            }
            System.out.println("");
        }
    }
    
    public void printDebug(){
        for(int x = 0 ; x < this.i ; x++){
            for(int y = 0 ; y < this.j ; y++){
                if(this.plate[x][y].content == PossibleCell.MINE){
                    System.out.print("X ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println("");
        }
    }
}
