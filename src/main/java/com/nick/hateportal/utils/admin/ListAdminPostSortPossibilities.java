package com.nick.hateportal.utils.admin;

public enum ListAdminPostSortPossibilities {
    SORT_POST_ID_DOWN(5),
    SORT_POST_ID_UP(6),
    SORT_POST_DATE_DOWN(7),
    SORT_POST_DATE_UP(8);

    private int mask;

    private ListAdminPostSortPossibilities(int mask) {
        this.mask = mask;
    }

    public static ListAdminPostSortPossibilities getMask(int n) {
        switch (n){
            case 5:
                return ListAdminPostSortPossibilities.SORT_POST_ID_DOWN;
            case 6:
                return ListAdminPostSortPossibilities.SORT_POST_ID_UP;
            case 7:
                return ListAdminPostSortPossibilities.SORT_POST_DATE_DOWN;
            case 8:
                return ListAdminPostSortPossibilities.SORT_POST_DATE_UP;
            default:
                return null;
        }
    }
}