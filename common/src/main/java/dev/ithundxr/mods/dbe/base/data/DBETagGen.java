package dev.ithundxr.mods.dbe.base.data;

import dev.ithundxr.mods.dbe.multiloader.CommonTag;
import dev.ithundxr.mods.dbe.multiloader.CommonTags;
import dev.ithundxr.mods.dbe.registry.DBETags.AllBlockTags;
import dev.ithundxr.mods.dbe.registry.DBETags.AllItemTags;
import com.tterrag.registrate.providers.RegistrateItemTagsProvider;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.data.tags.TagsProvider.TagAppender;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

/**
 * Based on {@link TagGen}
 */
public class DBETagGen {
    public static void generateBlockTags(RegistrateItemTagsProvider tags) {

    }

    public static void generateItemTags(RegistrateItemTagsProvider tags) {
        CommonTags.DYES.values().forEach(tag -> tag.generateCommon(tags));
        CommonTags.IRON_NUGGETS.generateCommon(tags);
        CommonTags.ZINC_NUGGETS.generateCommon(tags);
        CommonTags.BRASS_NUGGETS.generateCommon(tags);
        CommonTags.COPPER_INGOTS.generateCommon(tags);
        CommonTags.STRING.generateCommon(tags)
                .generateBoth(tags, tag -> tag.add(Items.STRING));
        CommonTags.IRON_PLATES.generateCommon(tags);
//			.generateBoth(tags, tag -> tag.add(AllItems.IRON_SHEET.get()));
    }

    @ExpectPlatform
    public static <T> TagAppender<T> tagAppender(RegistrateTagsProvider<T> prov, TagKey<T> tag) {
        throw new AssertionError();
    }
}
