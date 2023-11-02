package com.tellovilla.sprinklerz;

import com.google.gson.GsonBuilder;
import dev.architectury.platform.Platform;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.util.Arrays;

public final class Configuration {

    //default sprinkler delay between growth and Radius
    private int CopperFertDelay = 6000;
    private int CopperRadius = 2;

    private int IronFertDelay = 3000;
    private int IronRadius = 2;
    private int GoldFertDelay = 1500;
    private int GoldRadius = 3;

    private int DiamFertDelay = 1000;
    private int DiamondRadius = 3;
    private int NethFertDelay = 750;
    private int NetheriteRadius = 4;

    private int CeilingRange = 6;


    private boolean BoneMealEffect = true;

    private static final File CONFIG_FILE = new File(Platform.getConfigFolder().toFile(), "sprinklerz.json");

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

    public int getCopperRadius(){
        return CopperRadius;
    }
    public void setCopperRadius(int radius){CopperRadius = radius;}

    public int getIronFertDelay(){
        return IronFertDelay;
    }
    public void setIronFertDelay(int delay){
        IronFertDelay = delay;
    }
    public int getIronRadius(){
        return IronRadius;
    }
    public void setIronRadius(int radius){IronRadius = radius;}
    public int getGoldFertDelay(){
        return GoldFertDelay;
    }
    public void setGoldFertDelay(int delay){
        GoldFertDelay = delay;
    }
    public int getGoldRadius(){
        return GoldRadius;
    }
    public void setGoldRadius(int radius){GoldRadius = radius;}
    public int getNethFertDelay(){
        return NethFertDelay;
    }
    public void setNethFertDelay(int delay){
        NethFertDelay = delay;
    }
    public int getNetheriteRadius(){
        return NetheriteRadius;
    }
    public void setNetheriteRadius(int radius){NetheriteRadius = radius;}

    public int getDiamFertDelay(){
        return DiamFertDelay;
    }
    public void setDiamFertDelay(int delay){
        DiamFertDelay = delay;
    }
    public int getDiamondRadius(){
        return DiamondRadius;
    }
    public void setDiamondRadius(int radius){DiamondRadius = radius;}

    public int getCeilingRange(){
        return CeilingRange;
    }
    public void setCeilingRange(int range){
        CeilingRange = range;
    }

    public boolean getBoneMealEffect(){
        return BoneMealEffect;
    }

    public void setBoneMealEffect(boolean status){
        BoneMealEffect = status;
    }
    public int maxRadius(){
        int [] radii = new int[]{CopperRadius, IronRadius, GoldRadius, DiamondRadius, NetheriteRadius};
        Arrays.sort(radii);
        return radii[radii.length-1];

    }
}
