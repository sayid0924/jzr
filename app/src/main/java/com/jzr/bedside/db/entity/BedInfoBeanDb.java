package com.jzr.bedside.db.entity;

import com.jzr.bedside.bean.BedInfoBean;
import com.google.gson.Gson;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.converter.PropertyConverter;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class BedInfoBeanDb {

    @Id(autoincrement = true)
    private Long id;

    @Property
    @Convert(converter = BedInfoBeanConverter.class, columnType = String.class)
    private BedInfoBean bedInfoBean;

    @Generated(hash = 1761726544)
    public BedInfoBeanDb(Long id, BedInfoBean bedInfoBean) {
        this.id = id;
        this.bedInfoBean = bedInfoBean;

    }

    @Generated(hash = 469589109)
    public BedInfoBeanDb() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BedInfoBean getBedInfoBean() {
        return this.bedInfoBean;
    }

    public void setBedInfoBean(BedInfoBean bedInfoBean) {
        this.bedInfoBean = bedInfoBean;
    }

    public static class BedInfoBeanConverter implements PropertyConverter<BedInfoBean, String> {
        @Override
        public BedInfoBean convertToEntityProperty(String databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            return new Gson().fromJson(databaseValue, BedInfoBean.class);
        }

        @Override
        public String convertToDatabaseValue(BedInfoBean entityProperty) {
            if (entityProperty == null) {
                return null;
            }
            return new Gson().toJson(entityProperty);
        }
    }

}

