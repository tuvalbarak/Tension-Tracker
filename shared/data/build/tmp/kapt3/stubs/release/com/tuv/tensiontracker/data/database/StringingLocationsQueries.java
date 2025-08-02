package com.tuv.tensiontracker.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u008d\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2u\u0010\u000e\u001aq\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\f0\u000fJ\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0018\u001a\u00020\bJ\u0095\u0001\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2u\u0010\u000e\u001aq\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\f0\u000fJ\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0018\u001a\u00020\u0012J\u0095\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00122u\u0010\u000e\u001aq\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002H\f0\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringingLocationsQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "deleteLocation", "", "id", "", "getAllLocations", "Lapp/cash/sqldelight/Query;", "Lcom/tuv/tensiontracker/data/database/Stringing_locations;", "T", "", "mapper", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "", "location_name", "usage_count", "last_used", "created_at", "getTopLocations", "value_", "value", "insertOrIncrementLocation", "searchLocations", "GetTopLocationsQuery", "SearchLocationsQuery", "data_release"})
public final class StringingLocationsQueries extends app.cash.sqldelight.TransacterImpl {
    
    public StringingLocationsQueries(@org.jetbrains.annotations.NotNull()
    app.cash.sqldelight.db.SqlDriver driver) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getAllLocations(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function5<? super java.lang.Long, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.Stringing_locations> getAllLocations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> searchLocations(@org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function5<? super java.lang.Long, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.Stringing_locations> searchLocations(@org.jetbrains.annotations.NotNull()
    java.lang.String value_) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getTopLocations(long value, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function5<? super java.lang.Long, ? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.Stringing_locations> getTopLocations(long value_) {
        return null;
    }
    
    public final void insertOrIncrementLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String location_name, long last_used, long created_at) {
    }
    
    public final void deleteLocation(long id) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringingLocationsQueries$GetTopLocationsQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "value", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/tuv/tensiontracker/data/database/StringingLocationsQueries;JLkotlin/jvm/functions/Function1;)V", "getValue", "()J", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "", "data_release"})
    final class GetTopLocationsQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        private final long value = 0L;
        
        public GetTopLocationsQuery(long value, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        public final long getValue() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringingLocationsQueries$SearchLocationsQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "value", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/tuv/tensiontracker/data/database/StringingLocationsQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getValue", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "data_release"})
    final class SearchLocationsQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String value = null;
        
        public SearchLocationsQuery(@org.jetbrains.annotations.NotNull()
        java.lang.String value, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getValue() {
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