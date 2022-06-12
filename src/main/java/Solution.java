import algo.Algo;
import algo.Node;
import exceptions.UndefinedNameException;
import models.Creature;
import models.Human;
import models.Swamper;
import models.Woodman;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private final static int MAP_LENGTH = 16;

    public static int getResult(String stringMap, String creatureName){

        if (stringMap.length() != MAP_LENGTH){
            throw new IllegalStateException("Map length has to be 16!");
        }

        Creature creature = chooseCreature(creatureName);
        List<List<Node>> map = initializeMap(stringMap, creature);

        Algo algo = new Algo(map);

        return algo.getBestWay();
    }

    private static List<List<Node>> initializeMap(String stringMap, Creature creature) {

        List<List<Node>> map = new ArrayList<List<Node>>();


        // Инициализация пустой мапы
        for (int i = 0; i < MAP_LENGTH; i++) {
            map.add(new ArrayList<Node>());
        }

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                // Добавление вершины находящейся сверху
                if (i > 0) {
                    map.get(i * 4 + j).add(new Node((i - 1) * 4 + j, creature.getStepCost(stringMap.toUpperCase().charAt((i - 1) * 4 + j))));
                }

                // Добавление вершины находящейся снизу
                if (i < 3) {
                    map.get(i * 4 + j).add(new Node((i + 1) * 4 + j, creature.getStepCost(stringMap.toUpperCase().charAt((i + 1) * 4 + j))));
                }

                // Добавление вершины находящейся справа
                if (j > 0) {
                    map.get(i * 4 + j).add(new Node(i * 4 + j - 1, creature.getStepCost(stringMap.toUpperCase().charAt(i * 4 + j - 1))));
                }

                // Добавление вершины находящейся снизу
                if (j < 3) {
                    map.get(i * 4 + j).add(new Node(i * 4 + j + 1, creature.getStepCost(stringMap.toUpperCase().charAt(i * 4 + j + 1))));
                }
            }
        }

        return map;
    }

    private static Creature chooseCreature(String createName) throws UndefinedNameException {

        return switch (createName) {
            case ("Human") -> new Human();
            case ("Swamper") -> new Swamper();
            case ("Woodman") -> new Woodman();
            default -> throw new UndefinedNameException("Creature with " + createName + " doesnt exists");
        };
    }
}
