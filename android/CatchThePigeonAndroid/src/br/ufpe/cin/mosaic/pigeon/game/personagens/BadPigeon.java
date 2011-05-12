package br.ufpe.cin.mosaic.pigeon.game.personagens;

import org.anddev.andengine.opengl.texture.region.TiledTextureRegion;

public class BadPigeon extends Ave {
	
	/** Velocidade da Ave */	
	private float velocity = 60.0f;
	
	/** Posicao da ave na tela no eixo x*/
	private float posX = 0;
	/** Posicao da ave na tela no eixo y*/
	private float posY = 0;
	
	public BadPigeon(final float pX, final float pY, final TiledTextureRegion pTextureRegion, int startAnimation, int endAnimation) {
		super(pX, pY, pTextureRegion);
		this.posX = pX;
		this.posY = pY;
		this.animate(new long[]{200, 200, 200}, startAnimation, endAnimation, true);
	}
	
	public BadPigeon(final float pX, final float pY, final TiledTextureRegion pTextureRegion) {
		this(pX, pY, pTextureRegion, 0, 2);
	}

	@Override
	protected void onManagedUpdate(final float pSecondsElapsed) { 
		this.mPhysicsHandler.setVelocityX(this.velocity);
		//A perseguicao e feita calculando a diferenca de altura entre o pombo mau e o bom e em seguindo diminuindo a distancia entre eles com a porcentagem entre a distancia do pombo mau e o bom
		//this.mPhysicsHandler.setVelocityY((Pigeon.posY - this.posY) * (this.posX/Pigeon.posX));
		this.mPhysicsHandler.setVelocityY((Pigeon.posY - this.posY) * (this.posX/Pigeon.posX));
		
		super.onManagedUpdate(pSecondsElapsed);
	}
	
	@Override
	public float getVelocity() {	
		return velocity;
	}
}