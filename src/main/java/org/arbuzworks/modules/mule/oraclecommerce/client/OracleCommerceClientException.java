/**
 * (c) 2003-2014 Arbuz LLC, The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.arbuzworks.modules.mule.oraclecommerce.client;

/**
 * Signals that an OracleCommerceProxyClient exception has occurred.
 */
public class OracleCommerceClientException extends Exception {
	private final String thirdPartyCode;

	public OracleCommerceClientException(String thirdPartyCode, String message, Throwable cause) {
		super(message, cause);
		this.thirdPartyCode = thirdPartyCode;
	}

	public String getThirdPartyCode() {
		return thirdPartyCode;
	}

	@Override
	public String toString() {
		return "OracleCommerceClientException{" +
				"thirdPartyCode='" + thirdPartyCode + '\'' +
				",message='" + getMessage() + '\'' +
				",cause='" + getCause() + '\'' +
				'}';
	}
}
