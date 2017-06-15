package com.nick.hateportal.utils.admin;

public enum ListAdminUserSortPossibilities {
    SORT_USER_ID_DOWN(1),
    SORT_USER_ID_UP(2),
    SORT_USER_RATE_DOWN(3),
    SORT_USER_RATE_UP(4);

    private int mask;

    private ListAdminUserSortPossibilities(int mask) {
        this.mask = mask;
    }

    public static ListAdminUserSortPossibilities getMask(int n) {
        switch (n){
            case 1:
                return ListAdminUserSortPossibilities.SORT_USER_ID_DOWN;
            case 2:
                return ListAdminUserSortPossibilities.SORT_USER_RATE_UP;
            case 3:
                return ListAdminUserSortPossibilities.SORT_USER_RATE_DOWN;
            case 4:
                return ListAdminUserSortPossibilities.SORT_USER_RATE_UP;
            default:
                return null;
        }
    }
}