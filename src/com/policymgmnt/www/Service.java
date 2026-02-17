package com.policymgmnt.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {

	// all policy details
	static List<InsurancePolicy> policyList = new ArrayList<InsurancePolicy>();
	// all policy number,policy details
	static Map<Integer, InsurancePolicy> mapAllPolicy = new HashMap<Integer, InsurancePolicy>();
	// Counting Map (PolicyType → Count)
	static Map<String, Integer> countPolicyByGroup = new HashMap<>();

	public static void addPolicy(InsurancePolicy insuPolicy) {
		policyList.add(insuPolicy);
		mapAllPolicy.put(insuPolicy.getPolicyNumber(), insuPolicy);
		System.out.println("Policy saved succesfully.");
	}

	public static void findByPolicyNumber(int polNum) {
		System.out.println("=====================================================");
		System.out.println("\n Here are the policy details of " + polNum + "\n");
		for (Map.Entry<Integer, InsurancePolicy> ele : mapAllPolicy.entrySet()) {
			System.out.println(mapAllPolicy.get(polNum));
		}
		System.out.println("=====================================================");
	}

	public static void displayAllPolicies() {
		System.out.println("=====================================================");
		System.out.println("\n These are the list of all policies.");
		for (InsurancePolicy policy : policyList) {
			System.out.println(policy);
		}
		System.out.println("=====================================================");

	}

	public static void displayActivePolicies() {
		System.out.println("=====================================================");
		System.out.println("\n These are the Active policies.\n\n");
		for (InsurancePolicy policy : policyList) {
			if (policy.getPolicyStatus() == PolicyStatus.ACTIVE) {
				System.out.println(policy);
			}
		}
		System.out.println("=====================================================");

	}

	public static void removeExpiredPolicies() {
		List<InsurancePolicy> toRemove = new ArrayList<InsurancePolicy>();

		for (InsurancePolicy ele : policyList) {
			if (ele.getPolicyStatus() == PolicyStatus.EXPIRED) {
				toRemove.add(ele);
			}
		}

		policyList.removeAll(toRemove);
		System.out.println("\nAll the expired policies removed successfully.\n");

		System.out.println("=====================================================");
		System.out.println(" Updated old Policies.");
		for (InsurancePolicy policy : policyList) {
			System.out.println(policy);
		}
		System.out.println("=====================================================");
	}



//	public static void countByPolicyType() throws InvalidPolicyTypeException {
//		int healthInsuranceCount = 0;
//		int vehicleInsuranceCount = 0;
//		int travelInsuranceCount = 0;
//		int lifeInsuranceCount = 0;
//
//		for (InsurancePolicy policyElement : policyList) {
//			if (policyElement.getPolicyType().equals(PolicyType.HEALTH)) {
//				healthInsuranceCount++;
//			} else if (policyElement.getPolicyType().equals(PolicyType.VEHICLE)) {
//				vehicleInsuranceCount++;
//			} else if (policyElement.getPolicyType().equals(PolicyType.TRAVEL)) {
//				travelInsuranceCount++;
//			} else if (policyElement.getPolicyType().equals(PolicyType.LIFE)) {
//				lifeInsuranceCount++;
//			} else {
//				throw new InvalidPolicyTypeException("Invalid");
//			}
//		}
//		System.out.println("Count of total Health Insurance: "+ healthInsuranceCount);
//		System.out.println("Count of total Vehicle Insurance: "+ vehicleInsuranceCount);
//		System.out.println("Count of total Travel Insurance: "+ travelInsuranceCount);
//		System.out.println("Count of total Life Insurance: "+ lifeInsuranceCount);
//	}
//	
	// Count Policies by Type
	public static void countFromHashMap() {

		// static Map<Integer, InsurancePolicy> mapAllPolicy = new HashMap<Integer,
		// InsurancePolicy>();

		if (mapAllPolicy.isEmpty()) {
			System.out.println("No policies in the record.");
			return;
		}

		for (InsurancePolicy insurancePolicy : mapAllPolicy.values()) {
			String type = insurancePolicy.getPolicyType().name();
			Integer count = countPolicyByGroup.get(type);

			if (count == null) {
				countPolicyByGroup.put(type, 1);
			} else {
				countPolicyByGroup.put(type, count + 1);
			}
		}
		
		System.out.println("===========================================");
		for (Map.Entry<String, Integer> ele : countPolicyByGroup.entrySet()) {
			System.out.println("Total count of Policy Types are: ");
			System.out.println(ele.getKey() + " => " + ele.getValue());
		}

	}
}
