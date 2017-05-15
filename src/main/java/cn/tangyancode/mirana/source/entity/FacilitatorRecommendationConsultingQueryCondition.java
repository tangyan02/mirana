package cn.tangyancode.mirana.source.entity;


import java.time.LocalDateTime;

public class FacilitatorRecommendationConsultingQueryCondition {

    /**
     * 服务商名
     */
    private String facilitatorName;

    /**
     * 起始日期
     */
    private LocalDateTime beginDate;

    /**
     * 结束日期
     */
    private LocalDateTime endDate;

    /**
     * 商家账号
     */
    private String shopAccount;

    /**
     * 城市
     */
    private String cityName;

    /**
     * 商家类型
     */
    private String shopType;

    /**
     * 偏移量
     */
    private int offset;

    /**
     * 限制量
     */
    private int limit;
}
