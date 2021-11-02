
public class MAIN {

    public static void main(String[] args){
        MATRIX m = new MATRIX(12);
        FENSTER f = new FENSTER();
        MATRIZENANZEIGE ma = new MATRIZENANZEIGE(m,40,70,1,f);
        MATRIXKEYHANDLER mkh= new MATRIXKEYHANDLER(ma,m,f);
        f.addKeyListener(mkh);
        ma.MatrixAnzeigen();

    }

}
