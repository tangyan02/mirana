public class Config {

    /**
     * 限制服务列表，不会直接生成全部方法
     */
    public static String[] serviceList = {
            "ApplicationApIService"
    };

    /**
     * 限制服务内，允许生成的方法列表
     */
    public static String[] methodWhiteList = {
            "createApp",
            "getAppList",
            "updateApplication",
            "getConfigs",
            "submitGroundingReview",
    };

}
