package com.insurancemajortak.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PolicyService {

	List<InsurancePolicy> policyList = new ArrayList<>();
	Map<Integer, InsurancePolicy> policyMap = new HashMap<>();
	Map<String, Integer> policyCount = new HashMap<>();

	// Add Policy removes duplicate as well
	public void addPolicy(InsurancePolicy policy) {

		if (policyMap.containsKey(policy.getPolicyNumber())) {
			System.err.println("Policy Number already exists!");
			return;
		}

		policyList.add(policy);
		policyMap.put(policy.getPolicyNumber(), policy);

		String type = policy.getPolicyType();
		policyCount.put(type, policyCount.getOrDefault(type, 0) + 1);

		System.out.println("Policy Added Successfully!");
	}

	// Locate Policy details
	public void locatePolicy(int policyNumber) {

		InsurancePolicy policy = policyMap.get(policyNumber);

		if (policy == null) {
			System.out.println("Policy Not Found!");
		} else {
			System.out.println(policy);
		}
	}

	// Display All ACTIVE Policies (Use List)
	public void displayActivePolicies() {

		boolean found = false;

		for (InsurancePolicy policy : policyList) {
			if (policy.getPolicyStatus() == "ACTIVE") {
				System.out.println(policy);
				found = true;
			}
		}

		if (!found) {
			System.out.println("No Active Policies Found!");
		}
	}

	// 5️ Group Policies by Type
	public void groupPoliciesByType() {

		if (policyCount.isEmpty()) {
			System.out.println("No Policies Available!");
			return;
		}

		System.out.println("Policy Count by Type:");

		for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	// 6️ Highest Premium Policy
	public void findHighestPremiumPolicy() {

		if (policyList.isEmpty()) {
			System.out.println("No Policies Available!");
			return;
		}

		InsurancePolicy maxPolicy = policyList.get(0);

		for (InsurancePolicy policy : policyList) {
			if (policy.getFinalPremium() > maxPolicy.getFinalPremium()) {
				maxPolicy = policy;
			}
		}

		System.out.println("Highest Premium Policy:");
		System.out.println(maxPolicy);
	}

	// 7️ Remove expired policy
	public void removeExpiredPolicies() {

		List<InsurancePolicy> toRemove = new ArrayList<>();

		for (InsurancePolicy policy : policyList) {

			if (policy.getPolicyStatus() == "EXPIRED") {

				policyMap.remove(policy.getPolicyNumber());

				String type = policy.getPolicyType();
				policyCount.put(type, policyCount.get(type) - 1);

				toRemove.add(policy);
			}
		}

		policyList.removeAll(toRemove);

		System.out.println("Expired Policies Removed Successfully!");
	}

}
