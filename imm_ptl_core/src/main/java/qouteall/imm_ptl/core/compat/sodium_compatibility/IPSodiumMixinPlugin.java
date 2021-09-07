package qouteall.imm_ptl.core.compat.sodium_compatibility;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class IPSodiumMixinPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {
    
    }
    
    @Override
    public String getRefMapperConfig() {
        return null;
    }
    
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean sodiumLoaded = FabricLoader.getInstance().isModLoaded("sodium");
        
        // MixinIrisSodiumChunkShaderInterface and MixinIrisSodiumSodiumTerrainPipeline
        if (mixinClassName.contains("Iris")) {
            boolean irisLoaded = FabricLoader.getInstance().isModLoaded("iris");
            return sodiumLoaded && irisLoaded;
        }
        
        if (mixinClassName.contains("SodiumOriginal")) {
            boolean irisLoaded = FabricLoader.getInstance().isModLoaded("iris");
            return sodiumLoaded && (!irisLoaded);
        }
        
        return sodiumLoaded;
    }
    
    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    
    }
    
    @Override
    public List<String> getMixins() {
        return null;
    }
    
    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    
    }
    
    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    
    }
}
