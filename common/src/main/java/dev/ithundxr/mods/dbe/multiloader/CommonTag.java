package dev.ithundxr.mods.dbe.multiloader;

import dev.ithundxr.mods.dbe.DBE;
import dev.ithundxr.mods.dbe.base.data.DBETagGen;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.core.Registry;
import net.minecraft.data.tags.TagsProvider.TagAppender;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import java.util.function.Consumer;

/**
 * A common tag is a trio of tags: one for common, one for fabric, and one for forge.
 * The common tag contains both loader tags and should only be used for querying.
 * Content is added to both loader tags separately.
 */
public class CommonTag<T> {
    public final TagKey<T> tag, fabric, forge;

    public CommonTag(TagKey<T> common, TagKey<T> fabric, TagKey<T> forge) {
        this.tag = common;
        this.fabric = fabric;
        this.forge = forge;
    }

    public CommonTag(ResourceKey<? extends Registry<T>> registry, ResourceLocation common, ResourceLocation fabric, ResourceLocation forge) {
        this(TagKey.create(registry, common), TagKey.create(registry, fabric), TagKey.create(registry, forge));
    }

    public static <T> CommonTag<T> conventional(ResourceKey<? extends Registry<T>> registry, String common, String fabric, String forge) {
        return new CommonTag<>(
                registry,
                DBE.asResource("internal/" + common),
                new ResourceLocation("c", fabric),
                new ResourceLocation("forge", forge)
        );
    }

    public static <T> CommonTag<T> conventional(ResourceKey<? extends Registry<T>> registry, String path) {
        return conventional(registry, path, path, path);
    }

    public CommonTag<T> generateBoth(RegistrateTagsProvider<T> tags, Consumer<TagAppender<T>> consumer) {
        consumer.accept(DBETagGen.tagAppender(tags, fabric));
        consumer.accept(DBETagGen.tagAppender(tags, forge));
        return this;
    }

    public CommonTag<T> generateCommon(RegistrateTagsProvider<T> tags) {
        DBETagGen.tagAppender(tags, tag)
                .addOptionalTag(fabric.location())
                .addOptionalTag(forge.location());
        return this;
    }
}
