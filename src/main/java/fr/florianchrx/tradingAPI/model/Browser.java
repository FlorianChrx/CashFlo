package fr.florianchrx.tradingAPI.model;

public interface Browser<T> {
    /**
     * Use to continue browsing
     */
    void next();

    /**
     * Use to go back during browsing
     */
    void previous();

    /**
     * Use for browse without manual iterations
     */
    void browseAll();

    /**
     * Use for restart the browsing
     */
    void reset();

    /**
     * Use for continue browsing with specific numbers of iterations
     * @param iterations the number of iterations to operate
     */
    void next(int iterations);

    /**
     * Use for go back with specific numbers of iterations
     * @param iterations the number of iterations to rollback
     */
    void previous(int iterations);

    /**
     * Check wanted infos at this point of browsing
     * @return infos who can be returned at this point of browsing
     */
    T infos();
}
