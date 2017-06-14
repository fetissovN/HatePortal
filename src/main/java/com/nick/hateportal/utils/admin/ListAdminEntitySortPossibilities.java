package com.nick.hateportal.utils.admin;

public enum ListAdminEntitySortPossibilities {
    SORT_USER_ID_DOWN(1),
    SORT_USER_ID_UP(2),
    SORT_USER_RATE_DOWN(3),
    SORT_USER_RATE_UP(4),
    SORT_POST_ID_DOWN(5),
    SORT_POST_ID_UP(6),
    SORT_POST_DATE_DOWN(7),
    SORT_POST_DATE_UP(8);

    private int mask;

    private ListAdminEntitySortPossibilities(int mask) {
        this.mask = mask;
    }

    public static ListAdminEntitySortPossibilities getMask(int n) {
        switch (n){
            case 1:
                return ListAdminEntitySortPossibilities.SORT_USER_ID_DOWN;
            case 2:
                return ListAdminEntitySortPossibilities.SORT_USER_RATE_UP;
            case 3:
                return ListAdminEntitySortPossibilities.SORT_USER_RATE_DOWN;
            case 4:
                return ListAdminEntitySortPossibilities.SORT_USER_RATE_UP;
            case 5:
                return ListAdminEntitySortPossibilities.SORT_POST_ID_DOWN;
            case 6:
                return ListAdminEntitySortPossibilities.SORT_POST_ID_UP;
            case 7:
                return ListAdminEntitySortPossibilities.SORT_POST_DATE_DOWN;
            case 8:
                return ListAdminEntitySortPossibilities.SORT_POST_DATE_UP;
            default:
                return null;
        }
    }
}