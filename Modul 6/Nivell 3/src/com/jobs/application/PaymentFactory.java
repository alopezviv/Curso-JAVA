package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				double totalPaid = salaryPerMonth * 1.5;
				try {
					if(totalPaid < 5000 || totalPaid > 8000) {
						throw new Exception();
					}
				}catch(Exception e) {
					System.out.println("Salario de un Boss fuera de Limite");
				}
				return totalPaid;//todo 
			}
		};
	}
	
	public static IPaymentRate createPaymentRateJunior(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double totalPaid = salaryPerMonth * 0.85;
				try {
					if(totalPaid < 900 || totalPaid > 1600) {
						throw new Exception();
					}
				}catch(Exception e) {
					System.out.println("Salario de un Junior fuera de Limite");
				}
				return totalPaid;//todo 
			}
		};
		
	}
	public static IPaymentRate createPaymentRateMid(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double totalPaid = salaryPerMonth * 0.90;
				try {
					if(totalPaid < 1800 || totalPaid > 2500) {
						throw new Exception();
					}
				}catch(Exception e) {
					System.out.println("Salario de un Mid fuera de Limite");
				}
				return totalPaid;//todo 
			}
		};
	}
	public static IPaymentRate createPaymentRateSenior(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				double totalPaid = salaryPerMonth * 0.95;
				try {
					if(totalPaid < 2700 || totalPaid > 4000) {
						throw new Exception();
					}
				}catch(Exception e) {
					System.out.println("Salario de un Senior fuera de Limite");
				}
			
				return totalPaid;//todo 
			}
		};
	}
		public static IPaymentRate createPaymentRateManager(){
			return new IPaymentRate() {
				@Override
				public double pay(double salaryPerMonth) {
					double totalPaid = salaryPerMonth * 1.1;
					try {
						if(totalPaid < 3000 || totalPaid > 5000) {
							throw new Exception();
						}
					}catch(Exception e) {
						System.out.println("Salario de un Manager fuera de Limite");
					}
					return totalPaid;//todo 
				}
			};
	}
}
