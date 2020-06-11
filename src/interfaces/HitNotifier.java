package interfaces;

/**
 * this interface represents a hit notifier.
 *
 *  @author Eden Meidan
 *  @id: 207481177
 *  @since: 03/06/2020
 */
public interface HitNotifier {

    /**
     * this method adds a given hit listener object to to hit events by adding a list of hit listeners in this
     * hit notifier.
     *
     * @param hl a given hit listener object.
     */
    void addHitListener(HitListener hl);

    /**
     * this method removes a given hit listener object from hit events by removing it from the list of hit listeners
     * in this hit notifier.
     *
     * @param hl a given hit listener object.
     */
    void removeHitListener(HitListener hl);
}