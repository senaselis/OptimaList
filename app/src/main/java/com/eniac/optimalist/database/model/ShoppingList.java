package com.eniac.optimalist.database.model;

public class ShoppingList {
    public static final String TABLE_NAME = "shopping_lists";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_MARKET_ID = "market_id";

    private long id;
    private String title;
    private String createdAt;
    private long marketId;

    public static final String CREATE_TABLE =
            "create table " + TABLE_NAME + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_TITLE + " text not null,"
            + COLUMN_CREATED_AT + " datetime default (DATETIME(CURRENT_TIMESTAMP, 'LOCALTIME'))"
            //+ COLUMN_MARKET_ID + " integer default 0"
            //+ "foreign key " + COLUMN_MARKET_ID + " references " + Market.COLUMN_ID
            + ")";
    
    public ShoppingList(long id, String title, String createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getMarketId() {
        return marketId;
    }
}
