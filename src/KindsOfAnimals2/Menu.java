package KindsOfAnimals2;

import java.util.Scanner;

public class Menu {
    private String menuHead;
    private String[] menuLOG;

    Menu(String menuHead, String[] menuLOG){
        this.menuHead = menuHead;
        this.menuLOG = menuLOG;
    }

    public void menuPrint(){
        System.out.println(menuHead);
        for (int i = 0; i < menuLOG.length; i++){
            System.out.println(menuLOG[i]);
        }
    }


}
