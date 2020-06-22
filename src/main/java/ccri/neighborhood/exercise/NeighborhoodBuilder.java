package ccri.neighborhood.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Builder that constructs a neighborhood.
 */
@SuppressWarnings("PMD.BeanMembersShouldSerialize")
public class NeighborhoodBuilder {

  private int width;

  private int height;

  private Map<Location, Integer> valuesAtLocation = new HashMap<>();

  /**
   * Creates a neighborhood builder.
   * @param width width of the neighborhood that will be built
   * @param height height of the neighborhood that will be built
   */
  public NeighborhoodBuilder(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Specify a value that should be at the specified location when the neighborhood is built.
   * @param location location where value will be set
   * @param value value that location will contain
   * @return this builder
   */
  public NeighborhoodBuilder withValueAtLocation(Location location, int value) {
    this.valuesAtLocation.put(location, value);
    return this;
  }

  /**
   * Builds the neighborhood that has been specified by interactions with this builder.
   * @return the constructed Neighborhood
   */
  public Neighborhood build() {
    Neighborhood neighborhood = new Neighborhood(this.width, this.height);
    valuesAtLocation
        .forEach((location, value) -> neighborhood.setValueAtLocation(location, value));
    return neighborhood;
  }

}
