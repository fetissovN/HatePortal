package com.nick.hateportal.utils.admin;

public enum ListUserSortPossibilities {
    SORT_USER_ID_DOWN(1),
    SORT_USER_ID_UP(2),
    SORT_USER_RATE_DOWN(3),
    SORT_USER_RATE_UP(4);

    private int mask;

    ListUserSortPossibilities(int mask) {
        this.mask = mask;
    }

    public int getMask() {
        return mask;
    }
}
