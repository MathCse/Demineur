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
        setMines(this.percent);
        System.out.println("Nouvelle grille de démineur de " + i + " x " + j + " avec " + percent + "% de mines.");
    }
    
    public void setPlate(Cell[][] plate){
        for(int x = 0 ; x < this.i ; x++){
            for(int y = 0 ; y < this.j ; y++){
                plate[i][j] = new Cell();
            }
        }
    }
    
    public void setMines(int percent){
        int surface = this.i * this.j;
        int nbMines = surface * this.percent / 100;
        
    }

    public int getPercent() {
        return percent;
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
}
