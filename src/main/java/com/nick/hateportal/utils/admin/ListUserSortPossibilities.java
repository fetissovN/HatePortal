package com.nick.hateportal.utils.admin;

public enum ListUserSortPossibilities {
    SORT_USER_ID_DOWN(1),
    SORT_USER_ID_UP(2),
    SORT_USER_RATE_DOWN(3),
    SORT_USER_RATE_UP(4);

    private int mask;

    private ListUserSortPossibilities(int mask) {
        this.mask = mask;
    }

    public static ListUserSortPossibilities getMask(int n) {
        switch (n){
            case 1:
                return ListUserSortPossibilities.SORT_USER_ID_DOWN;
            case 2:
                return ListUserSortPossibilities.SORT_USER_RATE_UP;
            case 3:
                return ListUserSortPossibilities.SORT_USER_RATE_DOWN;
            case 4:
                return ListUserSortPossibilities.SORT_USER_RATE_UP;
            default:
                return null;
        }
    }
}