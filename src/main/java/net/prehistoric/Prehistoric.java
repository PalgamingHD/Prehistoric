package net.prehistoric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.decoration.AbstractDecorationEntity;
import net.minecraft.entity.decoration.painting.PaintingEntity;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.item.*;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.prehistoric.blocks.*;
import net.prehistoric.items.*;
import net.prehistoric.recipe.FossilRecipe;
import net.prehistoric.recipe.RepairRecipe;
import net.prehistoric.recipe.SandRecipe;
import net.prehistoric.screens.Analyzer.AnalyzerScreenHandler;
import net.prehistoric.screens.ArcheologyWorkbench.ArcheologyWorkbenchScreenHandler;
import net.prehistoric.screens.Sifter.SifterBlockScreenHandler;

public class Prehistoric implements ModInitializer
{
    public static final String MOD_NAME = "Prehistoric";
    public static final String MOD_ID = "prehistoric";
    //blocks
    public static final Block FOSSIL_BLOCK = new FossilBlock();
    public static final Block SKULL_BLOCK = new SkullBlock();
    public static final Block SKULL_BLOCK_LANTERN = new SkullBlockLantern();

    //sifter screen n stuff
    public static final Block SIFTER_BLOCK;
    public static final BlockEntityType SIFTER_BLOCK_ENTITY;

    public static final RecipeType<SandRecipe> SAND_RECIPE_TYPE;

    public static final RecipeSerializer<SandRecipe> SAND_RECIPE_SERIALIZER;

    public static final ScreenHandlerType<SifterBlockScreenHandler> SIFTER_BLOCK_SCREEN_HANDLER;

    public static final ItemGroup PREHISTORIC = FabricItemGroupBuilder.build(
            new Identifier("prehistoric", "general"),
            () -> new ItemStack(Prehistoric.FOSSIL));

    static {
        SIFTER_BLOCK = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "sifter"), new SifterBlock(FabricBlockSettings.of(Material.WOOD).hardness(2)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "sifter"), new BlockItem(SIFTER_BLOCK, new Item.Settings().group(Prehistoric.PREHISTORIC)));
        SIFTER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "sifter"), BlockEntityType.Builder.create(SifterBlockEntity::new, SIFTER_BLOCK).build(null));

        SAND_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, "sifter"), new RecipeType<SandRecipe>() {
            @Override
            public String toString() {
                return "sifter";
            }
        });

        SAND_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, "sifter"), new CookingRecipeSerializer(SandRecipe::new, 200));

        SIFTER_BLOCK_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "sifter"), SifterBlockScreenHandler::new);
    }
    //analyzer screen n' stuff
    public static final Block ANALYZER_BLOCK = new Analyzer(FabricBlockSettings.of(Material.STONE).hardness(5).breakByTool(FabricToolTags.PICKAXES).breakByHand(true));
    public static final BlockEntityType ANALYZER_BLOCK_ENTITY;
    public static final RecipeType<FossilRecipe> FOSSIL_RECIPE_TYPE;
    public static final RecipeSerializer<FossilRecipe> FOSSIL_RECIPE_SERIALIZER;
    public static final ScreenHandlerType<AnalyzerScreenHandler> ANALYZER_SCREEN_HANDLER;

    static {
        //Block
        Registry.register(Registry.BLOCK, new Identifier("prehistoric", "analyzer"), ANALYZER_BLOCK);
        //BlockItem
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "analyzer"), new BlockItem(ANALYZER_BLOCK, new Item.Settings().group(Prehistoric.PREHISTORIC)));
        //BlockEntity
        ANALYZER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "analyzer"), BlockEntityType.Builder.create(AnalyzerBlockEntity::new, ANALYZER_BLOCK).build(null));

        FOSSIL_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, "analyzer"), new RecipeType<FossilRecipe>() {
            @Override
            public String toString() {return "analyzer";}
        });
        FOSSIL_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, "analyzer"), new CookingRecipeSerializer(FossilRecipe::new, 200));
        ANALYZER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "test_furnace"), AnalyzerScreenHandler::new);

    }

    //archeologyworkbench screen and stuff
    public static final Block ARCHEOLOGY_WORKBENCH;
    public static final BlockEntityType ARCHEOLOGY_WORKBENCH_BLOCK_ENTITY;
    public static final RecipeType<RepairRecipe> REPAIR_RECIPE_TYPE;
    public static final RecipeSerializer<RepairRecipe> REPAIR_RECIPE_SERIALIZER;
    public static final ScreenHandlerType<ArcheologyWorkbenchScreenHandler> ARCHEOLOGY_WORKBENCH_SCREEN_HANDLER;

    static {
        //Block
        ARCHEOLOGY_WORKBENCH = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "archeology_workbench"), new ArcheologyWorkbench(FabricBlockSettings.of(Material.WOOD).hardness(2)));
        //BlockItem
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "archeology_workbench"), new BlockItem(ARCHEOLOGY_WORKBENCH, new Item.Settings().group(Prehistoric.PREHISTORIC)));
        //BlockEntity
        ARCHEOLOGY_WORKBENCH_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "archeology_workbench"), BlockEntityType.Builder.create(ArcheologyWorkbenchBlockEntity::new, ARCHEOLOGY_WORKBENCH).build(null));
        REPAIR_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new Identifier(MOD_ID, "archeology_workbench"), new RecipeType<RepairRecipe>() {
            @Override
            public String toString() {return "archeology_workbench";}
        });
        REPAIR_RECIPE_SERIALIZER = Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, "archeology_workbench"), new CookingRecipeSerializer(RepairRecipe::new, 200));
        ARCHEOLOGY_WORKBENCH_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "archeology_workbench"), ArcheologyWorkbenchScreenHandler::new);

    }



    //items
    public static final Fossil FOSSIL = new Fossil(new FabricItemSettings().group(Prehistoric.PREHISTORIC));
    public static final SiltedMush SILTED_MUSH = new SiltedMush(new FabricItemSettings().group(Prehistoric.PREHISTORIC));
    public static final Relics RELIC_SCRAP = new Relics(new FabricItemSettings().group(Prehistoric.PREHISTORIC));
    public static final AncientBrokenSword BROKEN_ANCIENT_SWORD = new AncientBrokenSword(new FabricItemSettings().group(Prehistoric.PREHISTORIC));
    public static final Scarab SCARAB = new Scarab(new FabricItemSettings().group(Prehistoric.PREHISTORIC));
    public static final ArmorMaterial ancientArmorMaterial = new AncientArmorMaterial();
    public static final Item ANCIENT_HELMET = new ArmorItem(ancientArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(Prehistoric.PREHISTORIC));
    public static final BrokenAncientHelmet BROKEN_ANCIENT_HELMET = new BrokenAncientHelmet(new FabricItemSettings().group(Prehistoric.PREHISTORIC));
    public static final AnalyzedRelic ANALYZED_RELIC = new AnalyzedRelic(new FabricItemSettings().group(Prehistoric.PREHISTORIC));
public static final StoneTablet STONE_TABLET = new StoneTablet(EntityType.PAINTING, new Item.Settings().group(Prehistoric.PREHISTORIC));
    public static final PotteryShard POTTERY_SHARD = new PotteryShard(new FabricItemSettings().group(Prehistoric.PREHISTORIC));



    //ores
    private static ConfiguredFeature<?, ?> ORE_FOSSIL_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    FOSSIL_BLOCK.getDefaultState(),
                    9)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, // bottom offset
                    1, // min y level
                    18))) // max y level
            .spreadHorizontally()
            .repeat(20); // number of veins per chunk

    @Override
    public void onInitialize() {

        //blocks
        Registry.register(Registry.BLOCK, new Identifier("prehistoric", "fossil_block"), FOSSIL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("prehistoric","fossil_block"), new BlockItem(FOSSIL_BLOCK, new Item.Settings().group(Prehistoric.PREHISTORIC)));
        Registry.register(Registry.BLOCK, new Identifier("prehistoric", "skull_block"), SKULL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("prehistoric","skull_block"), new BlockItem(SKULL_BLOCK, new Item.Settings().group(Prehistoric.PREHISTORIC)));
        Registry.register(Registry.BLOCK, new Identifier("prehistoric", "skull_block_lantern"), SKULL_BLOCK_LANTERN);
        Registry.register(Registry.ITEM, new Identifier("prehistoric","skull_block_lantern"), new BlockItem(SKULL_BLOCK_LANTERN, new Item.Settings().group(Prehistoric.PREHISTORIC)));

        //items
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "fossil"), FOSSIL);
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "silted_mush"), SILTED_MUSH);
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "relic_scrap"), RELIC_SCRAP);
        FuelRegistry.INSTANCE.add(FOSSIL,2000);
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "ancient_sword"), new SwordBase(new AncientToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "broken_ancient_sword"), BROKEN_ANCIENT_SWORD);
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "scarab"), SCARAB);
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "ancient_helmet"), ANCIENT_HELMET);
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "broken_ancient_helmet"), BROKEN_ANCIENT_HELMET);
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "scarab_pickaxe"), new PickaxeBase(new ScarabToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "scarab_axe"), new AxeBase(new ScarabToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "scarab_sword"), new SwordBaseScarab(new ScarabToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "scarab_hoe"), new HoeBase(new ScarabToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "scarab_shovel"), new ShovelBase(new ScarabToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "analyzed_relic"), ANALYZED_RELIC);
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "stone_tablet"), STONE_TABLET);
        Registry.register(Registry.ITEM, new Identifier("prehistoric", "pottery_shard"), POTTERY_SHARD);


        //block_entity

        //Controllers
        //ores
        RegistryKey<ConfiguredFeature<?, ?>> oreFossilOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("prehistoric", "ore_fossil_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreFossilOverworld.getValue(), ORE_FOSSIL_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreFossilOverworld);
    }
}


