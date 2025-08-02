package com.tuv.tensiontracker.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;", "Lapp/cash/sqldelight/Transacter;", "sessionFeedbackQueries", "Lcom/tuv/tensiontracker/data/database/SessionFeedbackQueries;", "getSessionFeedbackQueries", "()Lcom/tuv/tensiontracker/data/database/SessionFeedbackQueries;", "stringCatalogQueries", "Lcom/tuv/tensiontracker/data/database/StringCatalogQueries;", "getStringCatalogQueries", "()Lcom/tuv/tensiontracker/data/database/StringCatalogQueries;", "stringingLocationsQueries", "Lcom/tuv/tensiontracker/data/database/StringingLocationsQueries;", "getStringingLocationsQueries", "()Lcom/tuv/tensiontracker/data/database/StringingLocationsQueries;", "stringingSessionsQueries", "Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries;", "getStringingSessionsQueries", "()Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries;", "userPreferencesQueries", "Lcom/tuv/tensiontracker/data/database/UserPreferencesQueries;", "getUserPreferencesQueries", "()Lcom/tuv/tensiontracker/data/database/UserPreferencesQueries;", "Companion", "data_release"})
public abstract interface TensionTrackerDatabase extends app.cash.sqldelight.Transacter {
    @org.jetbrains.annotations.NotNull()
    public static final com.tuv.tensiontracker.data.database.TensionTrackerDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.tuv.tensiontracker.data.database.SessionFeedbackQueries getSessionFeedbackQueries();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.tuv.tensiontracker.data.database.StringCatalogQueries getStringCatalogQueries();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.tuv.tensiontracker.data.database.StringingLocationsQueries getStringingLocationsQueries();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.tuv.tensiontracker.data.database.StringingSessionsQueries getStringingSessionsQueries();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.tuv.tensiontracker.data.database.UserPreferencesQueries getUserPreferencesQueries();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase$Companion;", "", "()V", "Schema", "Lapp/cash/sqldelight/db/SqlSchema;", "Lapp/cash/sqldelight/db/QueryResult$Value;", "", "getSchema", "()Lapp/cash/sqldelight/db/SqlSchema;", "invoke", "Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "data_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final app.cash.sqldelight.db.SqlSchema<app.cash.sqldelight.db.QueryResult.Value<kotlin.Unit>> getSchema() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.tuv.tensiontracker.data.database.TensionTrackerDatabase invoke(@org.jetbrains.annotations.NotNull()
        app.cash.sqldelight.db.SqlDriver driver) {
            return null;
        }
    }
}