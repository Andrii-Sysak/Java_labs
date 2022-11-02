package Menu;

import Droids.*;
import Droids.Healer;

public class Table {


    public void MainMenuTable(){
        System.out.println("""
                ┌────────────────────────────┐
                │         Main Menu          │
                ├───┬────────────────────────┤
                │ 1 │ Create Droid           │
                │ 2 │ Show Droids            │
                │ 3 │ Duel                   │
                │ 4 │ Team battle            │
                │ 5 │ Show battle from file  │
                │ 6 │ Exit                   │
                └───┴────────────────────────┘
                """);
    }
    public void CreatingTable(){
        System.out.print("""
                ┌───────────────────────────────────────────────────────────┐
                │                      Create Droid Menu                    │
                ├───┬───────────────┬───────────────────────────────────────┤
                │ 1 │ Base          │  Base Droid with common oportunities  │
                │ 2 │ Berserk       │  With every hit his damage increase   │
                │ 3 │ Healer        │  Can heal teammates                   │
                │ 4 │ Tank          │  Have resistence to damage            │
                │ 5 │ Terminator    │  Have chance after killing stay alive │
                └───┴───────────────┴───────────────────────────────────────┘
                """
        );
    }

    public void ListDroidTable(){
        System.out.print("""
                ┌────────────────────────────────────────────────────────────────────────────────────────────┐
                │                                       DROIDS LIST                                          │
                └────────────────────────────────────────────────────────────────────────────────────────────┘
                """);
    }

    public void PrintLine(){
        System.out.print("──────────────────────────────────────────────────────────────────────────────────────────────");
    }
}
