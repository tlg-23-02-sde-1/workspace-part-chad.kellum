package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;
    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findByCategory_shouldReturnCorrectResult() {
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.ROCK);
        assertEquals(6, items.size());

//        for (MusicItem item : items) {
//            assertEquals(6, items.size());
//        }
        List<MusicItem> itemList = new ArrayList<>(items);
        itemList.sort(null);


    }

    @Test
    public void findSelfTitles_shouldReturnCorrectResult() {
        Collection<MusicItem> items = catalog.findSelfTitled();
        // size should be 2, ids are 6 and 7
        assertEquals(2, items.size());

        // I need to extract (get) the first one and make sure its id is 6, then the 2nd one
        List<MusicItem> itemsList = new ArrayList<>(items);
        itemsList.sort(null);
        // now you can say itemsList.get(0) and check its id for 6
        // now you can say itemsList.get(1) and check its id for 7
        assertEquals(6L, itemsList.get(0).getId().longValue());
        assertEquals(7L, itemsList.get(1).getId().longValue());

    }

    @Test(expected = UnsupportedOperationException.class)
    public void getAll_shouldReturnReadOnlyCollection() {
        Collection<MusicItem> items = catalog.getAll();
        items.clear(); // should trigger UnsupportedOperationException
    }

    @Test
    public void findByID_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(1000L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItemWithThatId_whenIdFound() {
        MusicItem item = catalog.findById(12L);
        assertEquals(12L, item.getId().longValue());
        assertTrue(12L == item.getId());
    }
}