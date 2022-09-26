import java.util.Scanner;
public class mainscroll {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to print? ");

        String userin = input.nextLine();
        //sends the users input to disp.java to be turned into a 3D array of ascii art characters
        disp out = new disp(userin);
        //instructs the class to turn the 3D array into a 2D array that can be traversed
        String[][] test = out.createLong();
        //i find that having a short delay in the beggining lets the program run smoother
        try{
            Thread.sleep(300);
        }catch(InterruptedException e){
            System.out.print("");
        }
        //first for loop shifts the "box" or display in which the user will view the ascii characthers across the screen
        //every time this loop runs a new "frame" is displayed
        for (int constant = 0; constant < test[0].length; constant++){
            //second for loop gets the row of the entire 2D array that needs to be printed for the given frame
            for (String[] row : test){
                //third for loop gets the collumn of the entire 2D array that needs to be printed and stops after what ever number is
                //                                        here (the size of the box)
                for (int i = constant + 0; i < constant + 25; i++){
                    //lazy code so the program doesnt error
                    if (i == row.length){
                        break;
                    }
                    System.out.print(row[i]);
                }
                //so the program prints to the next line and it actually looks like letters
                System.out.println("");
            }
            //this controls the fps
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                System.out.print("");
            }
            //clears the console to make it look like a movie
            for (int i = 0; i < 100; i++) {
            	System.out.print("\n");
            }
            //System.out.print("\033[H\033[2J");
        }
        input.close();

    }
}
