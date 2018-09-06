package br.pucpr.mage.phong;

import org.joml.Vector3f;

import br.pucpr.mage.SimpleMaterial;
import br.pucpr.mage.Texture;

public class MultiTextureMaterial extends SimpleMaterial {
    private Vector3f ambientColor;
    private Vector3f diffuseColor;
    private Vector3f specularColor;
    private float specularPower;
    
    public MultiTextureMaterial(Vector3f ambientColor, Vector3f diffuseColor, Vector3f specularColor, float specularPower) {
        super("/br/pucpr/mage/resource/phong/phongMT");
        this.ambientColor = ambientColor;
        this.diffuseColor = diffuseColor;
        this.specularColor = specularColor;
        this.specularPower = specularPower;
    }
    
    public MultiTextureMaterial(Vector3f ambient, Vector3f diffuse) {
        this(ambient, diffuse, new Vector3f(), 0.0f);
    }

    public MultiTextureMaterial(Vector3f color) {
        this(color, color, new Vector3f(), 0.0f);
    }
    
    public MultiTextureMaterial() {
        this(new Vector3f(1.0f, 1.0f, 1.0f));
    }
    
    public Vector3f getAmbientColor() {
        return ambientColor;
    }
    public Vector3f getDiffuseColor() {
        return diffuseColor;
    }
    public Vector3f getSpecularColor() {
        return specularColor;
    }
    public float getSpecularPower() {
        return specularPower;
    }
    
    public void setSpecularPower(float specularPower) {
        this.specularPower = specularPower;
    }    
    
    public MultiTextureMaterial setTextures(Texture ... textures) {
        for (int i = 0; i < textures.length; i++) {
            setTexture("uTex" + i, textures[i]);
        }
        return this;
    }
    
    @Override
    public void apply() {
        getShader().setUniform("uAmbientMaterial", ambientColor);
        getShader().setUniform("uDiffuseMaterial", diffuseColor);
        getShader().setUniform("uSpecularMaterial", specularColor);
        getShader().setUniform("uSpecularPower", specularPower);
        
        super.apply();
    }
}
