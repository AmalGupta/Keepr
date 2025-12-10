package com.keepr.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/keepr/app/util/DateUtils;", "", "()V", "dateFormatter", "Ljava/text/SimpleDateFormat;", "dateTimeFormatter", "calculateDaysUntilExpiry", "", "warrantyEndDate", "", "formatDate", "", "timestamp", "formatDateTime", "formatExpiryStatus", "getStartOfDay", "isExpired", "", "app_debug"})
public final class DateUtils {
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat dateFormatter = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat dateTimeFormatter = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.keepr.app.util.DateUtils INSTANCE = null;
    
    private DateUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatDate(long timestamp) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatDateTime(long timestamp) {
        return null;
    }
    
    public final int calculateDaysUntilExpiry(long warrantyEndDate) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatExpiryStatus(long warrantyEndDate) {
        return null;
    }
    
    public final boolean isExpired(long warrantyEndDate) {
        return false;
    }
    
    public final long getStartOfDay(long timestamp) {
        return 0L;
    }
}