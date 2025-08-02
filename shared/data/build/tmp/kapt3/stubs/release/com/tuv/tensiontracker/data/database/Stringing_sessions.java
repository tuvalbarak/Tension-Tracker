package com.tuv.tensiontracker.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010,\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\t\u00102\u001a\u00020\bH\u00c6\u0003J\t\u00103\u001a\u00020\nH\u00c6\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u000b\u00105\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u00a8\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010<\u001a\u00020=H\u00d6\u0001J\t\u0010>\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\'\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0015\u00a8\u0006?"}, d2 = {"Lcom/tuv/tensiontracker/data/database/Stringing_sessions;", "", "id", "", "date_strung", "main_string_id", "cross_string_id", "main_tension_value", "", "main_tension_unit", "", "cross_tension_value", "cross_tension_unit", "price_paid", "location_installed", "hours_until_break", "hours_until_dead", "created_at", "updated_at", "(JJJLjava/lang/Long;DLjava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;JJ)V", "getCreated_at", "()J", "getCross_string_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCross_tension_unit", "()Ljava/lang/String;", "getCross_tension_value", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDate_strung", "getHours_until_break", "getHours_until_dead", "getId", "getLocation_installed", "getMain_string_id", "getMain_tension_unit", "getMain_tension_value", "()D", "getPrice_paid", "getUpdated_at", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JJJLjava/lang/Long;DLjava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;JJ)Lcom/tuv/tensiontracker/data/database/Stringing_sessions;", "equals", "", "other", "hashCode", "", "toString", "data_release"})
public final class Stringing_sessions {
    private final long id = 0L;
    private final long date_strung = 0L;
    private final long main_string_id = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long cross_string_id = null;
    private final double main_tension_value = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String main_tension_unit = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double cross_tension_value = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String cross_tension_unit = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double price_paid = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String location_installed = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double hours_until_break = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double hours_until_dead = null;
    private final long created_at = 0L;
    private final long updated_at = 0L;
    
    public Stringing_sessions(long id, long date_strung, long main_string_id, @org.jetbrains.annotations.Nullable()
    java.lang.Long cross_string_id, double main_tension_value, @org.jetbrains.annotations.NotNull()
    java.lang.String main_tension_unit, @org.jetbrains.annotations.Nullable()
    java.lang.Double cross_tension_value, @org.jetbrains.annotations.Nullable()
    java.lang.String cross_tension_unit, @org.jetbrains.annotations.Nullable()
    java.lang.Double price_paid, @org.jetbrains.annotations.Nullable()
    java.lang.String location_installed, @org.jetbrains.annotations.Nullable()
    java.lang.Double hours_until_break, @org.jetbrains.annotations.Nullable()
    java.lang.Double hours_until_dead, long created_at, long updated_at) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final long getDate_strung() {
        return 0L;
    }
    
    public final long getMain_string_id() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCross_string_id() {
        return null;
    }
    
    public final double getMain_tension_value() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMain_tension_unit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getCross_tension_value() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCross_tension_unit() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getPrice_paid() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocation_installed() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getHours_until_break() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getHours_until_dead() {
        return null;
    }
    
    public final long getCreated_at() {
        return 0L;
    }
    
    public final long getUpdated_at() {
        return 0L;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component12() {
        return null;
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final long component14() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component4() {
        return null;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.data.database.Stringing_sessions copy(long id, long date_strung, long main_string_id, @org.jetbrains.annotations.Nullable()
    java.lang.Long cross_string_id, double main_tension_value, @org.jetbrains.annotations.NotNull()
    java.lang.String main_tension_unit, @org.jetbrains.annotations.Nullable()
    java.lang.Double cross_tension_value, @org.jetbrains.annotations.Nullable()
    java.lang.String cross_tension_unit, @org.jetbrains.annotations.Nullable()
    java.lang.Double price_paid, @org.jetbrains.annotations.Nullable()
    java.lang.String location_installed, @org.jetbrains.annotations.Nullable()
    java.lang.Double hours_until_break, @org.jetbrains.annotations.Nullable()
    java.lang.Double hours_until_dead, long created_at, long updated_at) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}