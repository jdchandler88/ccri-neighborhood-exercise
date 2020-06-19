package ccri.neighborhood.exercise;

import java.util.HashMap;
import java.util.Map;

public class NeighborhoodBuilder {

    private int width;
    private int height;
    private Map<Location, Integer> valuesAtLocation = new HashMap<>();

    public NeighborhoodBuilder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public NeighborhoodBuilder withValueAtLocation(Location location, int value) {
        this.valuesAtLocation.put(location, value);
        return this;
    }

    public Neighborhood build() {
        Neighborhood neighborhood = new Neighborhood(this.width, this.height);
        valuesAtLocation.forEach((location, value) -> neighborhood.getCellAtLocation(location).setValue(value));
        return neighborhood;
    }

}
