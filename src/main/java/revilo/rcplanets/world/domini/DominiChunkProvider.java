package revilo.rcplanets.world.domini;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import cpw.mods.fml.common.eventhandler.Event.Result;
import gregapi.data.OP;
import gregapi.util.ST;
import revilo.reach.api.data.RCMT;

public class DominiChunkProvider implements IChunkProvider {

    private Random endRNG;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    public NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    @SuppressWarnings("unused")
    private World endWorld;
    private double[] densities;
    /** The biomes that are used to generate the chunk */
    @SuppressWarnings("unused")
    private BiomeGenBase[] biomesForGeneration;
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;
    int[][] field_73203_h = new int[32][32];

    public DominiChunkProvider(World p_i2007_1_, long p_i2007_2_) {
        this.endWorld = p_i2007_1_;
        this.endRNG = new Random(p_i2007_2_);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.endRNG, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.endRNG, 10);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.endRNG, 16);

        NoiseGenerator[] noiseGens = { noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5 };
        noiseGens = TerrainGen.getModdedNoiseGenerators(p_i2007_1_, this.endRNG, noiseGens);
        this.noiseGen1 = (NoiseGeneratorOctaves) noiseGens[0];
        this.noiseGen2 = (NoiseGeneratorOctaves) noiseGens[1];
        this.noiseGen3 = (NoiseGeneratorOctaves) noiseGens[2];
        this.noiseGen4 = (NoiseGeneratorOctaves) noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves) noiseGens[4];
    }

    public void func_147420_a(int p_147420_1_, int p_147420_2_, Block[] p_147420_3_, BiomeGenBase[] p_147420_4_) {
        byte b0 = 2;
        int k = b0 + 1;
        byte b1 = 33;
        int l = b0 + 1;
        this.densities = this.initializeNoiseField(this.densities, p_147420_1_ * b0, 0, p_147420_2_ * b0, k, b1, l);

        for (int i1 = 0; i1 < b0; ++i1) {
            for (int j1 = 0; j1 < b0; ++j1) {
                for (int k1 = 0; k1 < 32; ++k1) {
                    double d0 = 0.25D;
                    double d1 = this.densities[((i1 + 0) * l + j1 + 0) * b1 + k1 + 0];
                    double d2 = this.densities[((i1 + 0) * l + j1 + 1) * b1 + k1 + 0];
                    double d3 = this.densities[((i1 + 1) * l + j1 + 0) * b1 + k1 + 0];
                    double d4 = this.densities[((i1 + 1) * l + j1 + 1) * b1 + k1 + 0];
                    double d5 = (this.densities[((i1 + 0) * l + j1 + 0) * b1 + k1 + 1] - d1) * d0;
                    double d6 = (this.densities[((i1 + 0) * l + j1 + 1) * b1 + k1 + 1] - d2) * d0;
                    double d7 = (this.densities[((i1 + 1) * l + j1 + 0) * b1 + k1 + 1] - d3) * d0;
                    double d8 = (this.densities[((i1 + 1) * l + j1 + 1) * b1 + k1 + 1] - d4) * d0;

                    for (int l1 = 0; l1 < 4; ++l1) {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i2 = 0; i2 < 8; ++i2) {
                            int j2 = i2 + i1 * 8 << 11 | 0 + j1 * 8 << 7 | k1 * 4 + l1;
                            short short1 = 128;
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;

                            for (int k2 = 0; k2 < 8; ++k2) {
                                Block block = null;

                                if (d15 > 0.0D) {
                                    block = ST.block(
                                        OP.blockSolid.dat(RCMT.DominiTurf)
                                            .getStack(1));
                                }

                                p_147420_3_[j2] = block;
                                j2 += short1;
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    private double[] initializeNoiseField(double[] p_73187_1_, int p_73187_2_, int p_73187_3_, int p_73187_4_,
        int p_73187_5_, int p_73187_6_, int p_73187_7_) {
        ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(
            this,
            p_73187_1_,
            p_73187_2_,
            p_73187_3_,
            p_73187_4_,
            p_73187_5_,
            p_73187_6_,
            p_73187_7_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Result.DENY) return event.noisefield;

        if (p_73187_1_ == null) {
            p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];
        }

        double d0 = 684.412D;
        double d1 = 684.412D;
        this.noiseData4 = this.noiseGen4.generateNoiseOctaves(
            this.noiseData4,
            p_73187_2_,
            p_73187_4_,
            p_73187_5_,
            p_73187_7_,
            1.121D,
            1.121D,
            0.5D);
        this.noiseData5 = this.noiseGen5.generateNoiseOctaves(
            this.noiseData5,
            p_73187_2_,
            p_73187_4_,
            p_73187_5_,
            p_73187_7_,
            200.0D,
            200.0D,
            0.5D);
        d0 *= 2.0D;
        this.noiseData1 = this.noiseGen3.generateNoiseOctaves(
            this.noiseData1,
            p_73187_2_,
            p_73187_3_,
            p_73187_4_,
            p_73187_5_,
            p_73187_6_,
            p_73187_7_,
            d0 / 80.0D,
            d1 / 160.0D,
            d0 / 80.0D);
        this.noiseData2 = this.noiseGen1.generateNoiseOctaves(
            this.noiseData2,
            p_73187_2_,
            p_73187_3_,
            p_73187_4_,
            p_73187_5_,
            p_73187_6_,
            p_73187_7_,
            d0,
            d1,
            d0);
        this.noiseData3 = this.noiseGen2.generateNoiseOctaves(
            this.noiseData3,
            p_73187_2_,
            p_73187_3_,
            p_73187_4_,
            p_73187_5_,
            p_73187_6_,
            p_73187_7_,
            d0,
            d1,
            d0);
        int k1 = 0;
        int l1 = 0;

        for (int i2 = 0; i2 < p_73187_5_; ++i2) {
            for (int j2 = 0; j2 < p_73187_7_; ++j2) {
                double d2 = (this.noiseData4[l1] + 256.0D) / 512.0D;

                if (d2 > 1.0D) {
                    d2 = 1.0D;
                }

                double d3 = this.noiseData5[l1] / 8000.0D;

                if (d3 < 0.0D) {
                    d3 = -d3 * 0.3D;
                }

                d3 = d3 * 3.0D - 2.0D;
                float f = (float) (i2 + p_73187_2_ - 0) / 1.0F;
                float f1 = (float) (j2 + p_73187_4_ - 0) / 1.0F;
                float f2 = 100.0F - MathHelper.sqrt_float(f * f + f1 * f1) * 8.0F;

                if (f2 > 80.0F) {
                    f2 = 80.0F;
                }

                if (f2 < -100.0F) {
                    f2 = -100.0F;
                }

                if (d3 > 1.0D) {
                    d3 = 1.0D;
                }

                d3 /= 8.0D;
                d3 = 0.0D;

                if (d2 < 0.0D) {
                    d2 = 0.0D;
                }

                d2 += 0.5D;
                d3 = d3 * (double) p_73187_6_ / 16.0D;
                ++l1;
                double d4 = (double) p_73187_6_ / 2.0D;

                for (int k2 = 0; k2 < p_73187_6_; ++k2) {
                    double d5 = 0.0D;
                    double d6 = ((double) k2 - d4) * 8.0D / d2;

                    if (d6 < 0.0D) {
                        d6 *= -1.0D;
                    }

                    double d7 = this.noiseData2[k1] / 512.0D;
                    double d8 = this.noiseData3[k1] / 512.0D;
                    double d9 = (this.noiseData1[k1] / 10.0D + 1.0D) / 2.0D;

                    if (d9 < 0.0D) {
                        d5 = d7;
                    } else if (d9 > 1.0D) {
                        d5 = d8;
                    } else {
                        d5 = d7 + (d8 - d7) * d9;
                    }

                    d5 -= 8.0D;
                    d5 += (double) f2;
                    byte b0 = 2;
                    double d10;

                    if (k2 > p_73187_6_ / 2 - b0) {
                        d10 = (double) ((float) (k2 - (p_73187_6_ / 2 - b0)) / 64.0F);

                        if (d10 < 0.0D) {
                            d10 = 0.0D;
                        }

                        if (d10 > 1.0D) {
                            d10 = 1.0D;
                        }

                        d5 = d5 * (1.0D - d10) + -3000.0D * d10;
                    }

                    b0 = 8;

                    if (k2 < b0) {
                        d10 = (double) ((float) (b0 - k2) / ((float) b0 - 1.0F));
                        d5 = d5 * (1.0D - d10) + -30.0D * d10;
                    }

                    p_73187_1_[k1] = d5;
                    ++k1;
                }
            }
        }

        return p_73187_1_;
    }

    @Override
    public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Chunk provideChunk(int p_73154_1_, int p_73154_2_) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Chunk loadChunk(int p_73158_1_, int p_73158_2_) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean unloadQueuedChunks() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canSave() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String makeString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_,
        int p_73155_4_) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_,
        int p_147416_5_) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getLoadedChunkCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void recreateStructures(int p_82695_1_, int p_82695_2_) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveExtraData() {
        // TODO Auto-generated method stub

    }

}
