import java.awt.*;

public class MATRIZENANZEIGE {
    //region attributes
    MATRIX m;
    Graphics g;
    FENSTER f;
    char[][] array;
    int ppFeld;
    int o;
    int rb;
    //endregion
    public MATRIZENANZEIGE(MATRIX matrix, int pixelProFeld, int offset,int ramenBreite,FENSTER fenster){
        m = matrix;
        ppFeld = pixelProFeld;
        o = offset;
        rb = ramenBreite;
        f = fenster;
        g = f.getImageGraphic();
        array = m.getMatrix();
    }
    //region visual
    public void MatrixAnzeigen(){
        array = m.getMatrix();
        for(int i = 0;i < array.length ; i++){
            for(int j = 0; j < array[0].length; j++){
                switch (array[i][j]){
                    case 'r':
                        FeldZeichnen(i,j,Color.RED);
                        break;
                    case 'g':
                        FeldZeichnen(i,j,Color.GREEN);
                        break;
                    case 'b':
                        FeldZeichnen(i,j,Color.BLUE);
                        break;
                    case 'y':
                        FeldZeichnen(i,j,Color.YELLOW);
                        break;
                    case 'o':
                        FeldZeichnen(i,j,Color.ORANGE);
                        break;
                    case 'w':
                        FeldZeichnen(i,j,Color.LIGHT_GRAY);
                        break;
                    default:
                        FeldZeichnen(i,j,Color.GRAY);
                        break;
                }
            }
        }
    }
    private void FeldZeichnen(int yPos,int xPos,Color color){
        g.setColor(Color.BLACK);
        g.fillRect((xPos*ppFeld)+o,(yPos*ppFeld)+o,ppFeld,ppFeld);
        g.setColor(color);
        g.fillRect((xPos*ppFeld)+o+rb,(yPos*ppFeld)+o+rb,ppFeld-(2*rb),ppFeld-(2*rb));

        f.repaint();
    }
    //endregion
}
