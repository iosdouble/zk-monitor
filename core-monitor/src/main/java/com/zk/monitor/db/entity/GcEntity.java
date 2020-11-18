package com.zk.monitor.db.entity;

/**
 * com.zk.monitor.db.entity
 * create by admin nihui
 * create time 2020/11/18
 * version 1.0
 **/
public class GcEntity {

    private Integer id;
    private String name; //进程ID
    private String date; //x：时间
    private String S0C;
    private String S1C;
    private String S0U;
    private String S1U;
    private String EC;
    private String EU;
    private String OC;
    private String OU;
    private String MC;//PC
    private String MU;//PU
    private String CCSC;
    private String CCSU;
    private String YGC;
    private String YGCT;
    private String FGC;
    private String FGCT;
    private String GCT;

    public GcEntity() {
    }

    public GcEntity(Integer id, String name, String date, String s0C, String s1C, String s0U, String s1U, String EC, String EU, String OC, String OU, String MC, String MU, String CCSC, String CCSU, String YGC, String YGCT, String FGC, String FGCT, String GCT) {
        this.id = id;
        this.name = name;
        this.date = date;
        S0C = s0C;
        S1C = s1C;
        S0U = s0U;
        S1U = s1U;
        this.EC = EC;
        this.EU = EU;
        this.OC = OC;
        this.OU = OU;
        this.MC = MC;
        this.MU = MU;
        this.CCSC = CCSC;
        this.CCSU = CCSU;
        this.YGC = YGC;
        this.YGCT = YGCT;
        this.FGC = FGC;
        this.FGCT = FGCT;
        this.GCT = GCT;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getS0C() {
        return S0C;
    }

    public void setS0C(String s0C) {
        S0C = s0C;
    }

    public String getS1C() {
        return S1C;
    }

    public void setS1C(String s1C) {
        S1C = s1C;
    }

    public String getS0U() {
        return S0U;
    }

    public void setS0U(String s0U) {
        S0U = s0U;
    }

    public String getS1U() {
        return S1U;
    }

    public void setS1U(String s1U) {
        S1U = s1U;
    }

    public String getEC() {
        return EC;
    }

    public void setEC(String EC) {
        this.EC = EC;
    }

    public String getEU() {
        return EU;
    }

    public void setEU(String EU) {
        this.EU = EU;
    }

    public String getOC() {
        return OC;
    }

    public void setOC(String OC) {
        this.OC = OC;
    }

    public String getOU() {
        return OU;
    }

    public void setOU(String OU) {
        this.OU = OU;
    }

    public String getMC() {
        return MC;
    }

    public void setMC(String MC) {
        this.MC = MC;
    }

    public String getMU() {
        return MU;
    }

    public void setMU(String MU) {
        this.MU = MU;
    }

    public String getCCSC() {
        return CCSC;
    }

    public void setCCSC(String CCSC) {
        this.CCSC = CCSC;
    }

    public String getCCSU() {
        return CCSU;
    }

    public void setCCSU(String CCSU) {
        this.CCSU = CCSU;
    }

    public String getYGC() {
        return YGC;
    }

    public void setYGC(String YGC) {
        this.YGC = YGC;
    }

    public String getYGCT() {
        return YGCT;
    }

    public void setYGCT(String YGCT) {
        this.YGCT = YGCT;
    }

    public String getFGC() {
        return FGC;
    }

    public void setFGC(String FGC) {
        this.FGC = FGC;
    }

    public String getFGCT() {
        return FGCT;
    }

    public void setFGCT(String FGCT) {
        this.FGCT = FGCT;
    }

    public String getGCT() {
        return GCT;
    }

    public void setGCT(String GCT) {
        this.GCT = GCT;
    }
}
