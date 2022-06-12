import algo.Algo;
import algo.Node;
import models.Creature;
import models.Swamper;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String map1 = "STWSWTPPTPTTPWPP";
        System.out.println("=== " + map1 + " ===");
        System.out.print("Best way for human: ");
        System.out.println(Solution.getResult(map1, "Human"));
        System.out.print("Best way for human: ");
        System.out.println(Solution.getResult(map1, "Swamper"));
        System.out.print("Best way for human: ");
        System.out.println(Solution.getResult(map1, "Woodman"));

        String map2 = "STWWPWTTWTTWWPSS";
        System.out.println("\n=== " + map2 + " ===");
        System.out.print("Best way for human: ");
        System.out.println(Solution.getResult(map2, "Human"));
        System.out.print("Best way for human: ");
        System.out.println(Solution.getResult(map2, "Swamper"));
        System.out.print("Best way for human: ");
        System.out.println(Solution.getResult(map2, "Woodman"));

        String map3 = "STSWPWTTSSTPWPSW";
        System.out.println("\n=== " + map3 + " ===");
        System.out.print("Best way for human: ");
        System.out.println(Solution.getResult(map3, "Human"));
        System.out.print("Best way for human: ");
        System.out.println(Solution.getResult(map3, "Swamper"));
        System.out.print("Best way for human: ");
        System.out.println(Solution.getResult(map3, "Woodman"));

    }
}
