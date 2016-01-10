
package com.gis.mongy.basicmaterialdesignui.bean;

public class NavigationEntity extends BaseEntity {

    private int iconResId;

    public NavigationEntity(String id, String name, int iconResId) {
        super(id, name);
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}
