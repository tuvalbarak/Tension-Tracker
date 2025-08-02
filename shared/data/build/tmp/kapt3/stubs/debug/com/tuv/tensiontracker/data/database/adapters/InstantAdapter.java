package com.tuv.tensiontracker.data.database.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0015\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tuv/tensiontracker/data/database/adapters/InstantAdapter;", "Lapp/cash/sqldelight/ColumnAdapter;", "Lkotlinx/datetime/Instant;", "", "()V", "decode", "databaseValue", "encode", "value", "(Lkotlinx/datetime/Instant;)Ljava/lang/Long;", "data_debug"})
public final class InstantAdapter implements app.cash.sqldelight.ColumnAdapter<kotlinx.datetime.Instant, java.lang.Long> {
    @org.jetbrains.annotations.NotNull()
    public static final com.tuv.tensiontracker.data.database.adapters.InstantAdapter INSTANCE = null;
    
    private InstantAdapter() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.datetime.Instant decode(long databaseValue) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.Long encode(@org.jetbrains.annotations.NotNull()
    kotlinx.datetime.Instant value) {
        return null;
    }
}