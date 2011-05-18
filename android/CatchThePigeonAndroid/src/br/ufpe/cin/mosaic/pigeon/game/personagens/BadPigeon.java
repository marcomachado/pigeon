package br.ufpe.cin.mosaic.pigeon.game.personagens;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

import android.util.Log;

public class BadPigeon extends Ave {
	
	/** Velocidade da Ave */	
	public static float velocity = 70.0f;

	
	public BadPigeon(final float pX, final float pY, final TiledTextureRegion pTextureRegion, int startAnimation, int endAnimation, int life) {
		super(pX, pY, pTextureRegion, life);
		this.setPosition(pX, pY);
		this.animate(new long[]{200, 200, 200}, startAnimation, endAnimation, true);
	}
	
	public BadPigeon(final float pX, final float pY, final TiledTextureRegion pTextureRegion, int life) {
		this(pX, pY, pTextureRegion, 0, 2, 1);
	}

	@Override
	protected void onManagedUpdate(final float pSecondsElapsed) { 
		this.mPhysicsHandler.setVelocityX(this.velocity * (Pigeon.posX < this.getX() ? - 1: 1));
		//A perseguicao e feita calculando a diferenca de altura entre o pombo mau e o bom e em seguindo diminuindo a distancia entre eles com a porcentagem entre a distancia do pombo mau e o bom		
		this.mPhysicsHandler.setVelocityY((Pigeon.posY - this.getY()) * (this.getX()/Pigeon.posX));
		
		this.mPhysicsHandler.setVelocityX(0);
		//A perseguicao e feita calculando a diferenca de altura entre o pombo mau e o bom e em seguindo diminuindo a distancia entre eles com a porcentagem entre a distancia do pombo mau e o bom		
		this.mPhysicsHandler.setVelocityY(0);
		
		super.onManagedUpdate(pSecondsElapsed);
	}
	
	@Override
	public float getVelocity() {	
		return velocity;
	}
}