package dev.ithundxr.mods.dbe.multiloader;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.EnumMap;
import java.util.Map;

public class CommonTags {
    public static final CommonTag<Item>
            STRING = item("string");

    public static final Map<DyeColor, CommonTag<Item>> DYES = Util.make(new EnumMap<>(DyeColor.class), dyes -> {
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName();
            String common = "dyes/" + name + "_dyes";
            String fabric = name + "_dyes";
            String forge = "dyes/" + name;
            dyes.put(color, item(common, fabric, forge));
        }
    });

    public static final CommonTag<Block>
            RELOCATION_NOT_SUPPORTED = block("relocation_not_supported");

    public static CommonTag<Block> block(String path) {
        return CommonTag.conventional(Registry.BLOCK_REGISTRY, path);
    }

    public static CommonTag<Item> item(String common, String fabric, String forge) {
        return CommonTag.conventional(Registry.ITEM_REGISTRY, common, fabric, forge);
    }

    public static CommonTag<Item> item(String path) {
        return item(path, path, path);
    }
}
