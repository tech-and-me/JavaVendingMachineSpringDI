package com.we.dao;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.we.dto.item.Item;

public interface IItemDAO {
	void addDefaultItems();
	void addItemToInventory(Item item);
	Map<Integer, Item> loadingInventory(File filename);
	void writeInventoryToFile(File filename);
}
