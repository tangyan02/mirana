package mirana.source.enumeration;

public enum FacilitatorRecommendationStatus {

    /**
     * 在线
     */
    ONLINE(0),

    /**
     * 下线
     */
    OFFLINE(1);

    int code;

    FacilitatorRecommendationStatus(int code) {
        this.code = code;
    }
}
