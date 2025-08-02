package com.tuv.tensiontracker.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0004)*+,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0082\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u00e9\u0001\u0010\u000e\u001a\u00e4\u0001\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\f0\u000fJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\nJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\nJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\bJ\u008a\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u00e9\u0001\u0010\u000e\u001a\u00e4\u0001\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\f0\u000fJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0013\u001a\u00020\u0012J\u008a\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u00e9\u0001\u0010\u000e\u001a\u00e4\u0001\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\f0\u000fJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u0012J\u008a\u0002\u0010 \u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00122\u00e9\u0001\u0010\u000e\u001a\u00e4\u0001\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\f0\u000fJ]\u0010!\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0002\u0010\"J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012J\u0092\u0002\u0010#\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u00e9\u0001\u0010\u000e\u001a\u00e4\u0001\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\f0\u000fJe\u0010\'\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringCatalogQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "deactivateString", "", "id", "", "getAllActiveStrings", "Lapp/cash/sqldelight/Query;", "Lcom/tuv/tensiontracker/data/database/String_catalog;", "T", "", "mapper", "Lkotlin/Function10;", "Lkotlin/ParameterName;", "name", "", "brand", "type", "", "gauge_mm", "construction", "notes", "price_min", "price_max", "is_active", "getAllBrands", "getAllTypes", "getStringById", "getStringsByBrand", "getStringsByType", "insertString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;J)V", "searchStrings", "value_", "value__", "value", "updateString", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;JJ)V", "GetStringByIdQuery", "GetStringsByBrandQuery", "GetStringsByTypeQuery", "SearchStringsQuery", "data_release"})
public final class StringCatalogQueries extends app.cash.sqldelight.TransacterImpl {
    
    public StringCatalogQueries(@org.jetbrains.annotations.NotNull()
    app.cash.sqldelight.db.SqlDriver driver) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getAllActiveStrings(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function10<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.String_catalog> getAllActiveStrings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getStringsByBrand(@org.jetbrains.annotations.NotNull()
    java.lang.String brand, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function10<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.String_catalog> getStringsByBrand(@org.jetbrains.annotations.NotNull()
    java.lang.String brand) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getStringsByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function10<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.String_catalog> getStringsByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> searchStrings(@org.jetbrains.annotations.NotNull()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    java.lang.String value_, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function10<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.String_catalog> searchStrings(@org.jetbrains.annotations.NotNull()
    java.lang.String value_, @org.jetbrains.annotations.NotNull()
    java.lang.String value__) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>app.cash.sqldelight.Query<T> getStringById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function10<? super java.lang.Long, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.String, ? super java.lang.String, ? super java.lang.Double, ? super java.lang.Double, ? super java.lang.Long, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<com.tuv.tensiontracker.data.database.String_catalog> getStringById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<java.lang.String> getAllBrands() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final app.cash.sqldelight.Query<java.lang.String> getAllTypes() {
        return null;
    }
    
    public final void insertString(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String brand, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.Double gauge_mm, @org.jetbrains.annotations.Nullable()
    java.lang.String construction, @org.jetbrains.annotations.Nullable()
    java.lang.String notes, @org.jetbrains.annotations.Nullable()
    java.lang.Double price_min, @org.jetbrains.annotations.Nullable()
    java.lang.Double price_max, long is_active) {
    }
    
    public final void updateString(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String brand, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.Double gauge_mm, @org.jetbrains.annotations.Nullable()
    java.lang.String construction, @org.jetbrains.annotations.Nullable()
    java.lang.String notes, @org.jetbrains.annotations.Nullable()
    java.lang.Double price_min, @org.jetbrains.annotations.Nullable()
    java.lang.Double price_max, long is_active, long id) {
    }
    
    public final void deactivateString(long id) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringCatalogQueries$GetStringByIdQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "id", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/tuv/tensiontracker/data/database/StringCatalogQueries;JLkotlin/jvm/functions/Function1;)V", "getId", "()J", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "", "data_release"})
    final class GetStringByIdQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        private final long id = 0L;
        
        public GetStringByIdQuery(long id, @org.jetbrains.annotations.NotNull()
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringCatalogQueries$GetStringsByBrandQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "brand", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/tuv/tensiontracker/data/database/StringCatalogQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getBrand", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "data_release"})
    final class GetStringsByBrandQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String brand = null;
        
        public GetStringsByBrandQuery(@org.jetbrains.annotations.NotNull()
        java.lang.String brand, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBrand() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0001\u0010\u00122\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00110\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringCatalogQueries$GetStringsByTypeQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "type", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/tuv/tensiontracker/data/database/StringCatalogQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getType", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "data_release"})
    final class GetStringsByTypeQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String type = null;
        
        public GetStringsByTypeQuery(@org.jetbrains.annotations.NotNull()
        java.lang.String type, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getType() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0001\u0010\u00142\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00130\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tuv/tensiontracker/data/database/StringCatalogQueries$SearchStringsQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "value", "", "value_", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "(Lcom/tuv/tensiontracker/data/database/StringCatalogQueries;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getValue", "()Ljava/lang/String;", "getValue_", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "removeListener", "toString", "data_release"})
    final class SearchStringsQuery<T extends java.lang.Object> extends app.cash.sqldelight.Query<T> {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String value = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String value_ = null;
        
        public SearchStringsQuery(@org.jetbrains.annotations.NotNull()
        java.lang.String value, @org.jetbrains.annotations.NotNull()
        java.lang.String value_, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super app.cash.sqldelight.db.SqlCursor, ? extends T> mapper) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getValue() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getValue_() {
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