package com.tellovilla.sprinklerz;

import com.google.gson.GsonBuilder;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;

public final class Configuration {

    //Sprinkler delay between growth
    private int CopperFertDelay = 6000;
    private int IronFertDelay = 3000;
    private int GoldFertDelay = 1500;

    private int NethFertDelay = 750;

    private static final File CONFIG_FILE = new File(FMLPaths.CONFIGDIR.get().toFile(), "sprinklerz.json");

    public Configuration(){
    }

    public static Configuration load(){
        Configuration configuration = new Configuration();
        if(!CONFIG_FILE.exists()){
            save(configuration);
        }
        Reader reader;
        try{
            reader = Files.newBufferedReader(CONFIG_FILE.toPath());
            configuration = (new GsonBuilder().setPrettyPrinting().create().fromJson(reader, Configuration.class));
            reader.close();
        } catch (IOException e){
            SprinklerzMod.LOGGER.error("Error while trying to load configuration file. Default configuration used.", e);

        }
        return configuration;
    }

    public static void save(Configuration config){
        try{
            Writer writer = Files.newBufferedWriter(CONFIG_FILE.toPath());
            (new GsonBuilder().setPrettyPrinting().create()).toJson(config, writer);
            writer.close();
        } catch (IOException e){
            SprinklerzMod.LOGGER.error("Error while trying to save configuration file.", e);

        }
    }

    public int getCopperFertDelay(){
        return CopperFertDelay;
    }
    public void setCopperFertDelay(int delay){
        CopperFertDelay = delay;
    }

    public int getIronFertDelay(){
        return IronFertDelay;
    }
    public void setIronFertDelay(int delay){
        IronFertDelay = delay;
    }
    public int getGoldFertDelay(){
        return GoldFertDelay;
    }
    public void setGoldFertDelay(int delay){
        GoldFertDelay = delay;
    }
    public int getNethFertDelay(){
        return NethFertDelay;
    }
    public void setNethFertDelay(int delay){
        NethFertDelay = delay;
    }
}
