import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MATRIXKEYHANDLER implements KeyListener {
    MATRIZENANZEIGE matrizenanzeige;
    MATRIX matrix;
    MATRIX matrix2;
    MATRIZENANZEIGE matrizenanzeige2;
    FENSTER fenster;
    boolean istWuerfelNetz = true;
    char farbe;
    public MATRIXKEYHANDLER(MATRIZENANZEIGE ma, MATRIX m, FENSTER f){
        farbe = 'w';
        matrizenanzeige = ma;
        matrix = m;
        fenster = f;
    }
    private void MatrizenAusschneiden() {
        switch(farbe){
            case'w':
                matrix2 = matrix.MatrixAusschneiden(2, 2, 5,5);
                break;
            case 'r':
                matrix2 = new MATRIX(new char[5][5]);
                matrix2.MatrixEinfuegen(matrix.MatrixAusschneiden(3,0,3,4).getMatrix(),1,1);    //rotenKern und weißer Rand in DrehMatrix
                MATRIX ma2 =  matrix.MatrixAusschneiden(0,3,3,3);                                           //grüne fläche Speichern
                ma2.MatrixDrehenGUZ();                                                                                              //grüne fläche drehen
                matrix2.MatrixEinfuegen(ma2.MatrixAusschneiden(2,0,1,3).getMatrix(),0,1);       //unterste Reihe der grünen Fläche in DrehMatrix
                ma2 = matrix.MatrixAusschneiden(6,3,3,3);                                                   //blaue fläche Speichern
                ma2.MatrixDrehenIUZ();                                                                                              //blaue fläche drehen
                matrix2.MatrixEinfuegen(ma2.MatrixAusschneiden(0,0,1,3).getMatrix(),4,1);       //oberste Reihe der blauen Fläche in DrehMatrix

                break;
        }

    }
    private void Matrizeneinfuegen(){
        switch (farbe){
            case 'w':
                matrix.MatrixEinfuegen(matrix2.matrix, 2,2);
                break;
            case 'r':
                matrix.MatrixEinfuegen(matrix2.MatrixAusschneiden(1,1,3,4).getMatrix(),3,0);
                break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            //System.out.println("gegenUhrzeigerSinn");
            if(istWuerfelNetz){
                //matrix.MatrixDrehenGUZ();
                matrizenanzeige.MatrixAnzeigen();
            }else {
                matrix2.MatrixDrehenGUZ();
                matrizenanzeige2.MatrixAnzeigen();
            }
        }else if (e.getKeyCode()== KeyEvent.VK_RIGHT){
            //System.out.println("imUhrzeigerSinn");
            if(istWuerfelNetz){
                //matrix.MatrixDrehenIUZ();
                matrizenanzeige.MatrixAnzeigen();
            }else {
                matrix2.MatrixDrehenIUZ();
                matrizenanzeige2.MatrixAnzeigen();
            }
        }else if (e.getKeyCode()==KeyEvent.VK_UP){
            if(istWuerfelNetz){
                farbe = 'w';
                MatrizenAusschneiden();
                matrizenanzeige2 = new MATRIZENANZEIGE(matrix2,40,600,1,fenster);
                matrizenanzeige2.MatrixAnzeigen();
                istWuerfelNetz = false;
            }else{
                Matrizeneinfuegen();
                matrizenanzeige.MatrixAnzeigen();
                istWuerfelNetz = true;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
