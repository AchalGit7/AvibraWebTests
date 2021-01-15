package constants;

public enum PlanType {

	STARTER("Starter"), ESSENTIAL("Essential"), NOWORRIES("No Worries"), SPOILME("Spoil Me");
	private String planType;

	PlanType(String planType) {
		this.planType = planType;
	}

	public String getPlanType() {
		return planType;
	}

}
