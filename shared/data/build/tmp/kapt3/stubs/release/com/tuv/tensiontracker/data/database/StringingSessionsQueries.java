package com.tuv.tensiontracker.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0003+,-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u00da\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u00c1\u0002\u0010\u000e\u001a\u00bc\u0002\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\f0\u000fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\"J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\bJ\u00e2\u0002\u0010#\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u00c1\u0002\u0010\u000e\u001a\u00bc\u0002\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\f0\u000fJ\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017J\u00e4\u0002\u0010$\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u00c1\u0002\u0010\u000e\u001a\u00bc\u0002\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\f0\u000fJ#\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010&J\u00f1\u0002\u0010%\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u00c1\u0002\u0010\u000e\u001a\u00bc\u0002\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\f0\u000f\u00a2\u0006\u0002\u0010\'J\u0081\u0001\u0010(\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b\u00a2\u0006\u0002\u0010)J\u0081\u0001\u0010*\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010)\u00a8\u0006."}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "deleteSession", "", "id", "", "getAllSessions", "Lapp/cash/sqldelight/Query;", "Lcom/tuv/tensiontracker/data/database/Stringing_sessions;", "T", "", "mapper", "Lkotlin/Function14;", "Lkotlin/ParameterName;", "name", "date_strung", "main_string_id", "cross_string_id", "", "main_tension_value", "", "main_tension_unit", "cross_tension_value", "cross_tension_unit", "price_paid", "location_installed", "hours_until_break", "hours_until_dead", "created_at", "updated_at", "getLastInsertedSessionId", "Lapp/cash/sqldelight/ExecutableQuery;", "getSessionById", "getSessionsByLocation", "getSessionsByString", "(JLjava/lang/Long;)Lapp/cash/sqldelight/Query;", "(JLjava/lang/Long;Lkotlin/jvm/functions/Function14;)Lapp/cash/sqldelight/Query;", "insertSession", "(JJLjava/lang/Long;DLjava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;JJ)V", "updateSession", "GetSessionByIdQuery", "GetSessionsByLocationQuery", "GetSessionsByStringQuery", "data_release"})
public final class StringingSessionsQueries extends app.cash.sqldelight.TransacterImpl {
    
    public StringingSessionsQueries(@org.jetbrains.annotations.NotNull()
    app.cash.sqldelight.db.SqlDriver driver) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getAllSessions(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.Stringing_sessions> getAllSessions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getSessionById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.Stringing_sessions> getSessionById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getSessionsByString(long main_string_id, @org.jetbrains.annotations.Nullable()
    java.lang.Long cross_string_id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.Stringing_sessions> getSessionsByString(long main_string_id, @org.jetbrains.annotations.Nullable()
    java.lang.Long cross_string_id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getSessionsByLocation(@org.jetbrains.annotations.Nullable()
    java.lang.String location_installed, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function14<? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Long, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.Stringing_sessions> getSessionsByLocation(@org.jetbrains.annotations.Nullable()
    java.lang.String location_installed) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.ExecutableQuery<java.lang.Long> getLastInsertedSessionId() {
        return null;
    }
    
    public final void insertSession(long date_strung, long main_string_id, @org.jetbrains.annotations.Nullable()
    java.lang.Long cross_string_id, double main_tension_value, @org.jetbrains.annotations.NotNull()
    java.lang.String main_tension_unit, @org.jetbrains.annotations.Nullable()
    java.lang.Double cross_tension_value, @org.jetbrains.annotations.Nullable()
    java.lang.String cross_tension_unit, @org.jetbrains.annotations.Nullable()
    java.lang.Double price_paid, @org.jetbrains.annotations.Nullable()
    java.lang.String location_installed, @org.jetbrains.annotations.Nullable()
    java.lang.Double hours_until_break, @org.jetbrains.annotations.Nullable()
    java.lang.Double hours_until_dead, long created_at, long updated_at) {
    }
    
    public final void updateSession(long date_strung, long main_string_id, @org.jetbrains.annotations.Nullable()
    java.lang.Long cross_string_id, double main_tension_value, @org.jetbrains.annotations.NotNull()
    java.lang.String main_tension_unit, @org.jetbrains.annotations.Nullable()
    java.lang.Double cross_tension_value, @org.jetbrains.annotations.Nullable()
    java.lang.String cross_tension_unit, @org.jetbrains.annotations.Nullable()
    java.lang.Double price_paid, @org.jetbrains.annotations.Nullable()
    java.lang.String location_installed, @org.jetbrains.annotations.Nullable()
    java.lang.Double hours_until_break, @org.jetbrains.annotations.Nullable()
    java.lang.Double hours_until_dead, long updated_at, long id) {
    }
    
    public final void deleteSession(long id) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries$GetSessionByIdQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "id", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries;JLkotlin/jvm/functions/Function1;)V", "getId", "()J", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "", "data_release"})
    final class GetSessionByIdQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        private final long id = 0L;
        
        public GetSessionByIdQuery(long id, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        public final long getId() {
            return 0L;
        }
        
        @java.lang.Override()
        public void addListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        public void removeListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <R extends java.lang.Object>app.cash.sqldelight.db.QueryResult<R> execute(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends app.cash.sqldelight.db.QueryResult<R>> mapper) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries$GetSessionsByLocationQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "location_installed", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getLocation_installed", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "data_release"})
    final class GetSessionsByLocationQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String location_installed = null;
        
        public GetSessionsByLocationQuery(@org.jetbrains.annotations.Nullable()
        java.lang.String location_installed, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLocation_installed() {
            return null;
        }
        
        @java.lang.Override()
        public void addListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        public void removeListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <R extends java.lang.Object>app.cash.sqldelight.db.QueryResult<R> execute(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends app.cash.sqldelight.db.QueryResult<R>> mapper) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0001\u0010\u00162\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00150\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries$GetSessionsByStringQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "main_string_id", "", "cross_string_id", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries;JLjava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "getCross_string_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMain_string_id", "()J", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "", "data_release"})
    final class GetSessionsByStringQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        private final long main_string_id = 0L;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Long cross_string_id = null;
        
        public GetSessionsByStringQuery(long main_string_id, @org.jetbrains.annotations.Nullable()
        java.lang.Long cross_string_id, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        public final long getMain_string_id() {
            return 0L;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Long getCross_string_id() {
            return null;
        }
        
        @java.lang.Override()
        public void addListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        public void removeListener(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.Query.Listener listener) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <R extends java.lang.Object>app.cash.sqldelight.db.QueryResult<R> execute(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends app.cash.sqldelight.db.QueryResult<R>> mapper) {
            return null;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}