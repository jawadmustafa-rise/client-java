package eu.arrowhead.ArrowheadProvider.common.model;

public class ArrowheadToken {

	private String token;
	private String signature;
	
	public ArrowheadToken() {
	}

	public String getToken() {
		return token;
	}

	public String getSignature() {
		return signature;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}