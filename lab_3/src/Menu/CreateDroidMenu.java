package Menu;

import Droids.BaseDroid;
import Functions.CreateDroid;
import Functions.Value;

public class CreateDroidMenu {

    private final Value value = new Value();
    public BaseDroid CreateMenu() {
        Table table = new Table();
        CreateDroid create = new CreateDroid();
        table.CreatingTable();
        while (true) {
            switch (value.getInt("Choice")) {
                case 1:
                    return create.CreateBaseDroid();
                case 2:
                    return create.CreateBerserker();
                case 3:
                    return create.CreateHealer();
                case 4:
                    return create.CreateTank();
                case 5:
                    return create.CreateTerminator();
                default:
                    System.out.println("Uncorrect");
                    break;
            }
        }
    }
}
