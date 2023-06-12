package de.dafuqs.paginatedadvancements.client;

import de.dafuqs.paginatedadvancements.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.screen.advancement.*;
import net.minecraft.item.*;

public class PaginatedAdvancementTabType {
	
	public static final int WIDTH = 28;
	public static final int HEIGHT = 32;
	
	public static int getWidthWithSpacing() {
		return WIDTH + PaginatedAdvancementsClient.CONFIG.SpacingBetweenHorizontalTabs; // includes the empty space between tabs
	}
	
	public static void drawBackground(DrawContext context, int x, int y, boolean selected, int index) {
		int i = index > 0 ? WIDTH : 0;
		int j = selected ? HEIGHT : 0;
		context.drawTexture(AdvancementsScreen.TABS_TEXTURE, x + getTabX(index), y + getTabY(), i, j, WIDTH, HEIGHT);
	}
	
	public static void drawIcon(DrawContext context, int x, int y, int index, ItemStack stack) {
		int i = x + getTabX(index) + 6;
		int j = y + getTabY() + 9;
		context.drawItemWithoutEntity(stack, i, j);
	}
	
	public static int getTabX(int index) {
		return getWidthWithSpacing() * index;
	}
	
	public static int getTabY() {
        return -HEIGHT + 4;
    }

    public static boolean isClickOnTab(int screenX, int screenY, int index, double mouseX, double mouseY) {
        int i = screenX + getTabX(index);
        int j = screenY + getTabY();
        return mouseX > (double)i && mouseX < (double)(i + WIDTH) && mouseY > (double)j && mouseY < (double)(j + HEIGHT);
    }
    
}
