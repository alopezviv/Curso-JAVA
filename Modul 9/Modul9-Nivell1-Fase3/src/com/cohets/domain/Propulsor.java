package com.cohets.domain;

public class Propulsor implements Runnable {
	int numPropulsor;
	int potenciaActual;
	int potenciaObjectiu;
	int potenciaMax;
	boolean isAcelerating;
	boolean isActive = true;
	public boolean isAcelerating() {
		return isAcelerating;
	}


	public void setAcelerating(boolean isAcelerating) {
		this.isAcelerating = isAcelerating;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Propulsor(int numPropulsor, int potenciaObjectiu, int potenciaMax) {
		setNumPropulsor(numPropulsor);
		setPotenciaMax(potenciaMax);
		setPotenciaObjectiu(potenciaObjectiu);
		setPotenciaActual(0);
	}
	
	
	public String toString() {
		return "Propulsor " + numPropulsor + " Potencia Actual " + potenciaActual + 
				" PotenciaObjetivo " + potenciaObjectiu + " Potencia Maxima " + potenciaMax;
	}
	public int getNumPropulsor() {
		return numPropulsor;
	}

	public void setNumPropulsor(int numPropulsor) {
		this.numPropulsor = numPropulsor;
	}

	public int getPotenciaActual() {
		return potenciaActual;
	}
	//Fem el control en el setter
	public void setPotenciaActual(int potenciaActual) {
		if(potenciaActual <= 0) {
			this.potenciaActual = 0;
		}else if(potenciaActual >= this.potenciaObjectiu) {
			this.potenciaActual = this.potenciaObjectiu;
		}else {
			this.potenciaActual = potenciaActual;
		}
	}

	public int getPotenciaObjectiu() {
		return potenciaObjectiu;
	}
	//Fem el control en el setter
	public void setPotenciaObjectiu(int potenciaObjectiu) {
		if(potenciaObjectiu > potenciaMax) {
			this.potenciaObjectiu = potenciaMax;
		}else {
			this.potenciaObjectiu = potenciaObjectiu;
		}
	}

	public int getPotenciaMax() {
		return potenciaMax;
	}

	public void setPotenciaMax(int potenciaMax) {
		if(potenciaMax > 0) {
			this.potenciaMax = potenciaMax;
		}else {
			this.potenciaMax = 0;
		}
	}

	@Override
	public void run() {
		while(isActive) {
			while(isAcelerating){
				if(potenciaActual<potenciaObjectiu) {
					setPotenciaActual(potenciaActual+1);
					System.out.println(this.toString());
				}else {
					System.out.println(this.toString());
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			while(!isAcelerating) {
				if(potenciaActual > 0) {
					setPotenciaActual(potenciaActual-1);
					System.out.println(this.toString());
				}else {
					System.out.println("Propulsor " + getNumPropulsor() + " parado");
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
