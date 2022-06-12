import exceptions.UndefinedNameException;
import models.Human;
import models.Swamper;
import models.Woodman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SolutionTest {

    @Test
    public void testHumanCosts() {
        Human human = new Human();
        assertEquals(5, human.getStepCost('S'));
        assertEquals(2, human.getStepCost('W'));
        assertEquals(3, human.getStepCost('T'));
        assertEquals(1, human.getStepCost('P'));
    }

    @Test
    public void testSwamperCosts() {
        Swamper swamper = new Swamper();
        assertEquals(2, swamper.getStepCost('S'));
        assertEquals(2, swamper.getStepCost('W'));
        assertEquals(5, swamper.getStepCost('T'));
        assertEquals(2, swamper.getStepCost('P'));
    }

    @Test
    public void testWoodmanCosts() {
        Woodman woodman = new Woodman();
        assertEquals(3, woodman.getStepCost('S'));
        assertEquals(3, woodman.getStepCost('W'));
        assertEquals(2, woodman.getStepCost('T'));
        assertEquals(2, woodman.getStepCost('P'));
    }

    @ParameterizedTest(name = "{index} - {0} is incorrect")
    @ValueSource(strings = {"TTTT", "T", "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"})
    public void incorrectMapStringLength(String stringMap) {
        assertThrows(IllegalStateException.class, () -> Solution.getResult(stringMap, "Human"));
    }

    @ParameterizedTest(name = "{index} - {0} is incorrect")
    @ValueSource(strings = {"2TWSWTPPTPTTPWPP", "STWRRTPPTPTTPWPP", "STWSOOOOTPTTPWPP"})
    public void incorrectSymbolInMapString(String stringMap) {
        assertThrows(IllegalStateException.class, () -> Solution.getResult(stringMap, "Human"));
    }


    @ParameterizedTest(name = "{index} - {0} is correct")
    @ValueSource(strings = {"Human", "Woodman", "Swamper"})
    public void correctCreatureName(String creatureName) {
        Solution.getResult("TTTTTTTTTTTTTTTT", creatureName);
    }

    @ParameterizedTest(name = "{index} - {0} is incorrect")
    @ValueSource(strings = {"Hum", "Zombie", "Swa2mper"})
    public void incorrectCreatureName(String creatureName) {
        assertThrows(UndefinedNameException.class, () -> Solution.getResult("TTTTTTTTTTTTTTTT", creatureName));
    }

    @ParameterizedTest(name = "{index} is incorrect")
    @CsvSource({
            "STWSWTPPTPTTPWPP, 10",
            "PPPPPPPPPPPPPPPP, 6",
            "SSSSSSSSSSSSPPPP, 14",
    })
    public void bestWayForHuman(String stringMap, int expected){
        String creatureName = "Human";
        assertEquals(expected, Solution.getResult(stringMap, creatureName));

    }

    @ParameterizedTest(name = "{index} is incorrect")
    @CsvSource({
            "STWSWTPPTPTTPWPP, 15",
            "PPPPPPPPPPPPPPPP, 12",
            "SSSSSSSSSSSSPPPP, 12",
    })
    public void bestWayForSwamper(String stringMap, int expected){
        String creatureName = "Swamper";
        assertEquals(expected, Solution.getResult(stringMap, creatureName));

    }

    @ParameterizedTest(name = "{index} is incorrect")
    @CsvSource({
            "STWSWTPPTPTTPWPP, 12",
            "PPPPPPPPPPPPPPPP, 12",
            "SSSSSSSSSSSSPPPP, 14",
    })
    public void bestWayForWoodman(String stringMap, int expected){
        String creatureName = "Woodman";
        assertEquals(expected, Solution.getResult(stringMap, creatureName));

    }
}