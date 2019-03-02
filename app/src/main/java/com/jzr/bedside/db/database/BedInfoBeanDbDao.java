package com.jzr.bedside.db.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.db.entity.BedInfoBeanDb.BedInfoBeanConverter;

import com.jzr.bedside.db.entity.BedInfoBeanDb;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BED_INFO_BEAN_DB".
*/
public class BedInfoBeanDbDao extends AbstractDao<BedInfoBeanDb, Long> {

    public static final String TABLENAME = "BED_INFO_BEAN_DB";

    /**
     * Properties of entity BedInfoBeanDb.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property BedInfoBean = new Property(1, String.class, "bedInfoBean", false, "BED_INFO_BEAN");
    }

    private final BedInfoBeanConverter bedInfoBeanConverter = new BedInfoBeanConverter();

    public BedInfoBeanDbDao(DaoConfig config) {
        super(config);
    }
    
    public BedInfoBeanDbDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BED_INFO_BEAN_DB\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"BED_INFO_BEAN\" TEXT);"); // 1: bedInfoBean
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BED_INFO_BEAN_DB\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BedInfoBeanDb entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        BedInfoBean bedInfoBean = entity.getBedInfoBean();
        if (bedInfoBean != null) {
            stmt.bindString(2, bedInfoBeanConverter.convertToDatabaseValue(bedInfoBean));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BedInfoBeanDb entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        BedInfoBean bedInfoBean = entity.getBedInfoBean();
        if (bedInfoBean != null) {
            stmt.bindString(2, bedInfoBeanConverter.convertToDatabaseValue(bedInfoBean));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public BedInfoBeanDb readEntity(Cursor cursor, int offset) {
        BedInfoBeanDb entity = new BedInfoBeanDb( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : bedInfoBeanConverter.convertToEntityProperty(cursor.getString(offset + 1)) // bedInfoBean
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BedInfoBeanDb entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBedInfoBean(cursor.isNull(offset + 1) ? null : bedInfoBeanConverter.convertToEntityProperty(cursor.getString(offset + 1)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(BedInfoBeanDb entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(BedInfoBeanDb entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BedInfoBeanDb entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
