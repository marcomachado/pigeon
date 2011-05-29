package br.eng.mosaic.pigeon.client.gameplay.cast.anim;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import br.eng.mosaic.pigeon.client.gameplay.cast.Ave;

public class FeatherEvent extends Ave{

	/** Velocidade da Ave */	
	private float velocity = 0.0f;
	private Scene scene;
	private int smokeFrame = 0;
	
	public FeatherEvent(final float pX, final float pY, final TiledTextureRegion pTextureRegion, Scene scene) {
		super(pX, pY, pTextureRegion, 50);
		this.animate(new long[]{200, 200, 200}, 12, 14, 1);
		this.scene = scene;
	}

	@Override
	protected void onManagedUpdate(final float pSecondsElapsed) { 
		this.mPhysicsHandler.setVelocityX(this.velocity);		
		if(++smokeFrame > 10) {
			this.setVisible(false);
			this.scene.detachChild(this);
		}
		super.onManagedUpdate(pSecondsElapsed);
	}
	
	@Override
	public float getVelocity() {	
		return velocity;
	}
}