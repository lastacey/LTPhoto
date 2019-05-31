package net.levi.lt;

import java.io.IOException;
import java.util.Scanner;

public class App {
    String albumsUri = "https://jsonplaceholder.typicode.com/photos?albumId=";

    void startIt() {
        // Intro
        System.out.println("Welcome to LT Album Display! \n");
        System.out.println("To display the contents of a photo album, enter a numerical album id and press enter.");
        System.out.println("To exit the application, type quit and press enter.");
        cInput();
        // Outro
        System.out.println("Goodbye");
    }

    void cInput() {
        String input;
        Scanner uInput = new Scanner(System.in);

        UrlDataCom dataCom = new UrlDataCom();
        DataParse dParse = new DataParse();

        System.out.print("> ");
        while (uInput.hasNextLine()) {
            input = uInput.nextLine().toLowerCase();
            switch (input) {
                case "quit":
                    return;
                default:
                    try {
                        for (DataParse.Data i : dParse.parseJSONList(dataCom.urlGet(albumsUri + input)))
                            System.out.println(i);
                    } catch (IOException e) {
                        System.out.println("Could not find " + input);
                    }
                
            }
            System.out.print("> "); 
        }
    }


    public static void main(String[] args) {
        new App().startIt();
    }
}

