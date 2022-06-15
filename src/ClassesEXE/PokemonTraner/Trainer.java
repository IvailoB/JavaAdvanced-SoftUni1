package ClassesEXE.PokemonTraner;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String trainerName;
    private int numberOfBadges;

    public Trainer(String trainerName, int numberOfBadges) {
        this.trainerName = trainerName;
        this.numberOfBadges = numberOfBadges;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }
}
