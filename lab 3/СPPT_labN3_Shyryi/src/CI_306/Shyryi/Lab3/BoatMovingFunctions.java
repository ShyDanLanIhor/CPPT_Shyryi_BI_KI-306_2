package CI_306.Shyryi.Lab3;

import CI_306.Shyryi.Lab3.models.Boat;
import CI_306.Shyryi.Lab3.models.Helmsman;

/**
 * An interface for boat moving functions.
 */
public interface BoatMovingFunctions {

    /**
     * Move forward.
     *
     * @param helmsman The helmsman object.
     * @param boat   The boat object.
     * @return True if successful, false otherwise.
     */
    Boolean MoveForward(Helmsman helmsman, Boat boat);

    /**
     * Move backward.
     *
     * @param helmsman The helmsman object.
     * @param boat   The boat object.
     * @return True if successful, false otherwise.
     */
    Boolean MoveBackward(Helmsman helmsman, Boat boat);

    /**
     * Move left.
     *
     * @param helmsman The helmsman object.
     * @param boat   The boat object.
     * @return True if successful, false otherwise.
     */
    Boolean MoveLeft(Helmsman helmsman, Boat boat);

    /**
     * Move right.
     *
     * @param helmsman The helmsman object.
     * @param boat   The boat object.
     * @return True if successful, false otherwise.
     */
    Boolean MoveRight(Helmsman helmsman, Boat boat);
}
