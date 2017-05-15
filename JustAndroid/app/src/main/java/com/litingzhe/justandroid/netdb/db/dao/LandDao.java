package com.litingzhe.justandroid.netdb.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.litingzhe.justandroid.netdb.db.model.Land;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LAND".
*/
public class LandDao extends AbstractDao<Land, Long> {

    public static final String TABLENAME = "LAND";

    /**
     * Properties of entity Land.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property LandId = new Property(0, Long.class, "landId", true, "_id");
        public final static Property LandCode = new Property(1, String.class, "LandCode", false, "LAND_CODE");
        public final static Property LandName = new Property(2, String.class, "landName", false, "LAND_NAME");
    }


    public LandDao(DaoConfig config) {
        super(config);
    }
    
    public LandDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LAND\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: landId
                "\"LAND_CODE\" TEXT," + // 1: LandCode
                "\"LAND_NAME\" TEXT);"); // 2: landName
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LAND\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Land entity) {
        stmt.clearBindings();
 
        Long landId = entity.getLandId();
        if (landId != null) {
            stmt.bindLong(1, landId);
        }
 
        String LandCode = entity.getLandCode();
        if (LandCode != null) {
            stmt.bindString(2, LandCode);
        }
 
        String landName = entity.getLandName();
        if (landName != null) {
            stmt.bindString(3, landName);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Land entity) {
        stmt.clearBindings();
 
        Long landId = entity.getLandId();
        if (landId != null) {
            stmt.bindLong(1, landId);
        }
 
        String LandCode = entity.getLandCode();
        if (LandCode != null) {
            stmt.bindString(2, LandCode);
        }
 
        String landName = entity.getLandName();
        if (landName != null) {
            stmt.bindString(3, landName);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Land readEntity(Cursor cursor, int offset) {
        Land entity = new Land( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // landId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // LandCode
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // landName
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Land entity, int offset) {
        entity.setLandId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLandCode(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setLandName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Land entity, long rowId) {
        entity.setLandId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Land entity) {
        if(entity != null) {
            return entity.getLandId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Land entity) {
        return entity.getLandId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}