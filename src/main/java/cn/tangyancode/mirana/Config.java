package cn.tangyancode.mirana;

public class Config {

    public static String[] entityPath = {
            "/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/application/Application.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/application/UpdateApplication.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/QueryCondition.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/Config.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/EnumConfig.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/facilitator/FacilitatorResult.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/facilitator/Facilitator.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/struct/facilitator/ApplicationMelodyView.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/operating/ApplicationDetailOverview.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/operating/ApplicationGroundingOverview.java"
    };

    public static String[] enumerationPath = {
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/AppGroundingState.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/AppLabel.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/AppType.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/PlatformType.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-service-descriptor/src/main/java/me/ele/napos/buttonwood/service/descriptor/struct/application/AppState.java",
    };

    public static String[] interfacePath = {
            "/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/service/FacilitatorApiService.java",
            "/Users/Agent/Projects/napos-openapi/buttonwood-api-descriptor/src/main/java/me/ele/napos/buttonwood/api/descriptor/service/ApplicationApIService.java",
            "/Users/Agent/Projects/napos-openapi/nest-api-descriptor/src/main/java/me/ele/napos/nest/api/descriptor/service/OperatingApplicationService.java"
    };

    /**
     * 限制服务列表，不会直接生成全部方法
     */
    public static String[] serviceList = {
            "ApplicationApIService",
            "OperatingApplicationService"
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
            "queryAppManagerByAppInfo",
            "queryAppManagerByEnterpriseName",
            "queryAppManagerByDevAccount",
            "changeAppOffline",
            "queryGrounding",
            "getApplicationByAppId",
            "applicationGroundingPass",
            "applicationGroundingReject"
    };

    /**
     * 系统配置，请勿修改
     */
    public static String classPath = "../../../../../../target/classes";

    /**
     * 系统配置，请勿修改
     */
    public static String mdOutputPath = "target/mdFiles";
}
