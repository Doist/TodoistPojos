package com.todoist.model;

class Colors {
    static final String[] PROJECT_COLORS_PREMIUM = {
            "#95EF63",
            "#FF8581",
            "#FFC471",
            "#F9EC75",
            "#A8C8E4",
            "#D2B8A3",
            "#E2A8E4",
            "#CCCCCC",
            "#FB886E",
            "#FFCC00",
            "#74E8D3",
            "#3BD5FB",
            "#DC4FAD",
            "#AC193D",
            "#D24726",
            "#82BA00",
            "#03B3B2",
            "#008299",
            "#5DB2FF",
            "#0072C6",
            "#000000",
            "#777777"
    };
    static final String[] PROJECT_COLORS_FREE = new String[12]; // First 12 colors are free.
    static {
        System.arraycopy(PROJECT_COLORS_PREMIUM, 0, PROJECT_COLORS_FREE, 0, PROJECT_COLORS_FREE.length);
    }
    static final int DEFAULT_PROJECT_COLOR = 7;

    static final String[] LABEL_COLORS = {
            "#019412",
            "#A39D01",
            "#E73D02",
            "#E702A4",
            "#9902E7",
            "#1D02E7",
            "#0082C5",
            "#555555",
            "#008299",
            "#03B3B2",
            "#AC193D",
            "#82BA00",
            "#111111"
    };
    static final int DEFAULT_LABEL_COLOR = 0;

    static final String[] FILTER_COLORS = LABEL_COLORS;
    static final int DEFAULT_FILTER_COLOR = 6;

    static final String[] COLLABORATOR_AVATAR_COLORS = {
            "#FCC652",
            "#E9952C",
            "#E16B2D",
            "#D84B40",
            "#E8435A",
            "#E5198A",
            "#AD3889",
            "#86389C",
            "#A8A8A8",
            "#98BE2F",
            "#5D9D50",
            "#5F9F85",
            "#5BBCB6",
            "#32A3BF",
            "#2BAFEB",
            "#2D88C3",
            "#3863CC",
            "#5E5E5E"
    };
}
