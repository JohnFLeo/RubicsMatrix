public class MATRIX {
    //region attributes
    char[][]matrix;
    int spaltenReihenAnzahl;
    //endregion
    //region constructor
    public MATRIX(int spaltenReihenAnzahl){
        MatrixErzeugen(spaltenReihenAnzahl);
    }
    public MATRIX(char[][] array){
        if(array[0].length == array.length){
            matrix = array;
            spaltenReihenAnzahl = array.length;
        }else{
            System.out.println("experimental Matrix-Konstruktor");
            matrix = array;
            spaltenReihenAnzahl = array.length;
            /*----Auffüllen enabled
            if(array.length < array[0].length){
                matrix = new char[array[0].length][array[0].length];
            }else{
                matrix = new char[array.length][array.length];
            }
            MatrixEinfuegen(array,0,0);
            */
        }

    }
    private void MatrixErzeugen(int spaltenReihenAnzahl){
        switch (spaltenReihenAnzahl){
            case 4:
                matrix  = new char[][]{
                        {'b','b','b','b'},
                        {'b','r','g','b'},
                        {'b','g','r','g'},
                        {'b','b','g','r'}
                };
                this.spaltenReihenAnzahl = 4;
                break;
            case 3:
                matrix  = new char[][]{
                        {'r','g','b'},
                        {'r','g','b'},
                        {'r','g','b'}
                };
                this.spaltenReihenAnzahl = 3;
                break;
            case 12:
                matrix  = new char[][]{
                        {'x','x','x','g','g','g','x','x','x','x','x','x'},
                        {'x','x','x','g','g','g','x','x','x','x','x','x'},
                        {'x','x','x','g','g','g','x','x','x','x','x','x'},
                        {'r','r','r','w','w','w','o','o','o','x','x','x'},
                        {'r','r','r','w','w','w','o','o','o','x','x','x'},
                        {'r','r','r','w','w','w','o','o','o','x','x','x'},
                        {'x','x','x','b','b','b','x','x','x','x','x','x'},
                        {'x','x','x','b','b','b','x','x','x','x','x','x'},
                        {'x','x','x','b','b','b','x','x','x','x','x','x'},
                        {'x','x','x','y','y','y','x','x','x','x','x','x'},
                        {'x','x','x','y','y','y','x','x','x','x','x','x'},
                        {'x','x','x','y','y','y','x','x','x','x','x','x'},
                };
                this.spaltenReihenAnzahl = 12;
                break;
            default:
                matrix= null;
                this.spaltenReihenAnzahl = 0;
                break;
        }
    }
    //endregion
    //region turnOperations
    public void MatrixDrehenIUZ(){    //Matrix wird im Uhrzeigersinn gedreht
        int x = matrix[0].length;
        int y = matrix.length;
        char[][] matrix2 = new char[y][x];
        for(int i = 0; i < y;i++){                              //oberste Reihe -> letzte Spalte usw.
            for(int j = 0; j < x;j++){
                matrix2[j][spaltenReihenAnzahl-1-i] = matrix[i][j];
            }
        }
        matrix = matrix2;
        //MatrixAusgeben();
    }
    public void MatrixDrehenGUZ(){    //Matrix wird gegen Uhrzeigersinn gedreht
        int x = matrix[0].length;
        int y = matrix.length;
        char[][] matrix2 = new char[y][x];
        for(int i = 0; i < y;i++){                              //oberste Reihe -> erste Spalte usw.
            for(int j = 0; j < x;j++){
                matrix2[spaltenReihenAnzahl-1-i][j] = matrix[j][i];
            }
        }
        matrix = matrix2;
        //MatrixAusgeben();
    }
    //endregion
    public MATRIX MatrixAusschneiden(int yPos, int xPos, int height,int width){
        char[][] NewArray = new char[height][width];
        for(int i = yPos; i < (yPos+height);i++){
            for(int j = xPos; j < (xPos+width);j++){
                NewArray[i-yPos][j-xPos] = matrix[i][j];
            }
        }
        return new MATRIX(NewArray);
    }
    public void MatrixEinfuegen(char[][] array, int yPos, int xPos){
        for(int i = yPos;i < (yPos + array.length);i++){
            for(int j = xPos; j < (xPos+array[0].length);j++){
                matrix[i][j] = array[i-yPos][j-xPos];
            }
        }
    }
    //region GetterSetter
    public char[][] getMatrix() {
        return matrix;
    }
    public int getSpaltenReihenAnzahl(){
        return spaltenReihenAnzahl;
    }
    //endregion
    public void MatrixAusgeben(){
        int x = matrix[0].length;
        int y = matrix.length;
        for(int i = 0; i < y;i++){
            for(int j = 0; j < x;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
