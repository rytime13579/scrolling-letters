public class disp {
    private String[][][] mainString;
    private data let = new data();
    private String[] letOrder = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "};
    public disp(String slice){
        //adds two spaces to the beggining of the string to let the scrolling letters look cooler
        slice = "  " + slice;
        //constructor that converts the users inputed string into a list of 2D arrays that look like letters (3D array). See data.java
        //for the arrays it gets
        //-----
        //converts the string given to an array of string characters, not an array of character objects
        String[] sliceAr = new String[slice.length()];
        char[] first = slice.toCharArray();
        for (int i = 0; i < first.length; i ++){
            sliceAr[i] = String.valueOf(first[i]);
        }
        //creates the 3 dimensional array
        String[][][] temp = new String[slice.length()][5][10];
        //itterates through the list of string characters
        for (int i = 0; i < temp.length; i ++){
            //in one step compares the string litteral letter, to the the "letOrder" array which has the same indexs as 
            //the letters 3D array in data.java and assignes it to temp which will then become the main array
            temp[i] = let.letters[findIndex(sliceAr[i])];
        }
        this.mainString = temp;
    }
    //returns the array indecy of the item in the "letOrder" array
    private int findIndex(String character){
        for (int i = 0; i < letOrder.length; i++){
            if (character.equals(letOrder[i])){
                return i;
            }
        }
        return 0;
    }
    //returns the main string
    public String[][][] getMain(){
        return this.mainString;
    }
    //"flattens out" the 3D array into something that can be traversed
    // itterates row by row of every 2D array in the "mainString" and adds it to a new 2D array "flattening it out"
    public String[][] createLong(){
        String[][] temp = new String[5][10 * this.mainString.length];
        int z;
        for (int x = 0; x < 5; x++){
            z = 0;
            for (String[][] letter : this.mainString){
                for (int i = 0; i < letter[x].length; i++){
                    temp[x][z] = letter[x][i];
                    z++;
                }
            }
        }
        return temp;
    }
}
