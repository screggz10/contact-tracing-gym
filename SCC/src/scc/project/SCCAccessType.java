package scc.project;

public enum SCCAccessType {
	
	NOT_AUTHENTICATED(0), MANAGER(1), STAFF(2), CUSTOMER(3);

	private int accessId;

	private SCCAccessType(int accessId) {
		this.accessId = accessId;
	}

	public int getAccessType() {
		return accessId;
	}
	
	public static void main(String[] args) {
		System.out.println(NOT_AUTHENTICATED.getAccessType());
		System.out.println(MANAGER.getAccessType());
		System.out.println(STAFF.getAccessType());
		System.out.println(CUSTOMER.getAccessType());
	}
}
