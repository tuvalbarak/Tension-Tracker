package com.tuv.tensiontracker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH\u0016J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0019\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tuv/tensiontracker/data/repository/StringingLocationRepositoryImpl;", "Lcom/tuv/tensiontracker/domain/repository/StringingLocationRepository;", "database", "Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;", "(Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;)V", "queries", "Lcom/tuv/tensiontracker/data/database/StringingLocationsQueries;", "deleteLocation", "", "locationId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLocations", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/tuv/tensiontracker/domain/model/StringingLocation;", "getTopLocations", "limit", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOrIncrementLocation", "locationName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchLocations", "query", "data_release"})
public final class StringingLocationRepositoryImpl implements com.tuv.tensiontracker.domain.repository.StringingLocationRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.TensionTrackerDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.StringingLocationsQueries queries = null;
    
    public StringingLocationRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.TensionTrackerDatabase database) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertOrIncrementLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String locationName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteLocation(long locationId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.tuv.tensiontracker.domain.model.StringingLocation>> getAllLocations() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object searchLocations(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.tuv.tensiontracker.domain.model.StringingLocation>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTopLocations(int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.tuv.tensiontracker.domain.model.StringingLocation>> $completion) {
        return null;
    }
}