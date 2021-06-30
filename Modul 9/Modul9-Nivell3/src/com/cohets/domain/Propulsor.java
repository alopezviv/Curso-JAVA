package com.cohets.domain;

public class Propulsor implements Runnable {
	int numPropulsor;
	int potenciaActual;
	Thread t = new Thread(this);
	int potenciaMax;
	boolean isAcelerating;
	boolean isActive = true;
	int aceleracion;
	public Propulsor(int numPropulsor, int potenciaMax) {
		setNumPropulsor(numPropulsor);
		setPotenciaMax(potenciaMax);
		setPotenciaActual(0);
		setAceleracion(1);
	}


	public int getAceleracion() {
		return aceleracion;
	}


	public void setAceleracion(int aceleracion) {
		this.aceleracion = aceleracion;
	}


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


	public String toString() {
		return "Propulsor " + numPropulsor + " Potencia Actual " + potenciaActual + 
				 " Potencia Maxima " + potenciaMax;
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
		}else if(potenciaActual >= this.potenciaMax) {
			this.potenciaActual = this.potenciaMax;
		}else {
			this.potenciaActual = potenciaActual;
		}
	}

		public Thread getT() {
		return t;
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
	//Mara el boolean isActive com a true i inicialitza els threads
	public void activate() {
		isActive = true;
		t = new Thread(this);
		t.start();
	}




	@Override
	public void run() {
		while(isActive) {
			if(isAcelerating) {
				while(isAcelerating){
					if(potenciaActual<potenciaMax) {
						setPotenciaActual(potenciaActual+aceleracion);
						System.out.println(this.toString());
					}else {
						System.out.println(this.toString());
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						t.interrupt();;
					}
				}
			}else {	
					while(!isAcelerating) {
						if(potenciaActual > 0) {
							setPotenciaActual(potenciaActual-aceleracion);
							System.out.println(this.toString());
						}else {
							System.out.println("Propulsor " + getNumPropulsor() + " parado");
						}
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							t.interrupt();
						}
					}
				}
			}
		System.out.println("Thread Finalizado propulsor " + getNumPropulsor());
		
	}
}
