package com.techelevator;

public class FruitTree {

	public String typeOfFruit;

	public int piecesOfFruitLeft;
	
	
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit){
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = startingPiecesOfFruit;
	}

	public String getTypeOfFruit() {
		return typeOfFruit;
	}

	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	
	}
	
	public boolean pickFruit(int numberOfPiecesToRemove) {
		if (piecesOfFruitLeft - numberOfPiecesToRemove < 0) {
			piecesOfFruitLeft = 0;
					return false;
		} else {
			piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
			return true;
		}
	}

}
