package com.packedit.util.builder;

import java.util.Date;
import java.util.List;

import com.packedit.model.Item;
import com.packedit.model.ListItem;
import com.packedit.model.PackingList;
import com.packedit.model.User;

public class PackingListBuilder {

    private final PackingList list = new PackingList();

    private final User user;
    private String description = "A Packing List";
    private Date startDate = null;
    private Date endDate = null;
    private List<ListItem> items = new ListItemsBuilder(list).build();

    public PackingListBuilder(final User user) {
        this.user = user;
    }

    public PackingListBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public PackingListBuilder withStartDate(final Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public PackingListBuilder withEndDate(final Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public PackingListBuilder withItems(final List<Item> items) {
        this.items = new ListItemsBuilder(list).withItems(items).build();
        return this;
    }

    public PackingList build() {
        list.setUser(user);
        list.setDescription(description);
        list.setStartDate(startDate);
        list.setEndDate(endDate);
        list.setItems(items);
        return list;
    }
}
