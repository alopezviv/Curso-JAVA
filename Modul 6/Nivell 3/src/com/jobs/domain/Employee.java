package com.jobs.domain;

public abstract class  Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	protected double salarioLimpio=0;
	protected double salarioLimpioAnual=salarioLimpio*12;
	protected double salarioBrutoAnual=totalPaid*12;

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
		salarioBrutoAnual=totalPaid*12;
		salarioLimpio = totalPaid - retencion();
		salarioLimpioAnual=salarioLimpio*12;
	}
	public String toString() {
		
		return   super.toString() +"salaryPerMonth=" + salaryPerMonth + " Salario Bruto=" + totalPaid + "Salario Limpio=" + 
		salarioLimpio + " Salario Bruto anual=" + salarioBrutoAnual + " Salario limpio anual=" + salarioLimpioAnual;
	}
	public void payBonus() { // Calcula el bonus y se lo suma a lo que cobra ese mes
		this.pay(); //calculamos primero el salario
		//Se calcula Bonus bruto y limpio
		double bonus = ((totalPaid*12)/10);
		double bonusLimpio = bonus - retencion();
		// Se le suma al salario bruto y al bruto anuel el bonus y al salario limpio y al salario limpio anual el bonus con la retencion
		totalPaid += bonus;
		salarioLimpio += bonusLimpio;
		salarioBrutoAnual += bonus;
		salarioLimpioAnual += bonusLimpio;
	}
	public abstract double retencion();
}
