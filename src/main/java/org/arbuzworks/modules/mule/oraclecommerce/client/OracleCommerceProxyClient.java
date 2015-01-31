/**
 * (c) 2003-2014 Arbuz LLC, The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.arbuzworks.modules.mule.oraclecommerce.client;

import org.arbuzworks.modules.mule.oraclecommerce.definition.*;

import java.net.URL;

/**
 * Created by arbuzworks on 12/11/2014.
 */
public class OracleCommerceProxyClient {

	PerformRQLQuerySEI rqlQueryPort;
	PerformRQLCountQuerySEI rqlCountQuerySEIPort;
	GetRepositoryItemSEI getRepositoryItemSEIPort;

	public OracleCommerceProxyClient() {
	}

	public void initialize(String host, String port) throws OracleCommerceClientException {
		initRqlQuery(host, port);
		initRqlCountQuery(host, port);
		initGetRepositoryItem(host, port);
	}

	private void initRqlCountQuery(String host, String port) throws OracleCommerceClientException {
		PerformRQLCountQuerySEIService service = new PerformRQLCountQuerySEIServiceLocator();

		try {
			URL endpoint = new URL("http", host, Integer.parseInt(port),
					"/repository/generic/performRQLCountQuery/performRQLCountQuery");
			PerformRQLQuerySEIService.class.getClassLoader().getResource("wsdl/performRQLCountQuery.wsdl");
			rqlCountQuerySEIPort = service.getPerformRQLCountQuerySEIPort(endpoint);
		} catch (Exception se) {
			throw new OracleCommerceClientException(se.getClass().getName(), se.getMessage(), se);
		}
	}

	private void initRqlQuery(String host, String port) throws OracleCommerceClientException {
		try {
			PerformRQLQuerySEIService service = new PerformRQLQuerySEIServiceLocator();
			URL endpoint = new URL("http", host, Integer.parseInt(port),
					"/repository/generic/performRQLQuery/performRQLQuery");
			PerformRQLQuerySEIService.class.getClassLoader().getResource("wsdl/performRQLQuery.wsdl");
			rqlQueryPort = service.getPerformRQLQuerySEIPort(endpoint);
		} catch (Exception e) {
			throw new OracleCommerceClientException(e.getClass().getName(), e.getMessage(), e);
		}
	}

	private void initGetRepositoryItem(String host, String port) throws OracleCommerceClientException {
		GetRepositoryItemSEIService service = new GetRepositoryItemSEIServiceLocator();

		try {
			URL endpoint = new URL("http", host, Integer.parseInt(port),
					"/repository/generic/getRepositoryItem/getRepositoryItem");
			PerformRQLQuerySEIService.class.getClassLoader().getResource("wsdl/getRepositoryItem.wsdl");
			getRepositoryItemSEIPort = service.getGetRepositoryItemSEIPort(endpoint);
		} catch (Exception se) {
			throw new OracleCommerceClientException(se.getClass().getName(), se.getMessage(), se);
		}
	}

	public String[] performRQLQuery(String repositoryComponentPath, String itemDescriptorName, String RQLString) throws OracleCommerceClientException {
		try {
			return rqlQueryPort.performRQLQuery(repositoryComponentPath, itemDescriptorName, RQLString);
		} catch (Exception e) {
			throw new OracleCommerceClientException(e.getClass().getName(), e.getMessage(), e);
		}
	}

	public int performRQLCountQuery(String repositoryComponentPath, String itemDescriptorName, String RQLString) throws OracleCommerceClientException {
		try {
			return rqlCountQuerySEIPort.performRQLCountQuery(repositoryComponentPath, itemDescriptorName, RQLString);
		} catch (Exception e) {
			throw new OracleCommerceClientException(e.getClass().getName(), e.getMessage(), e);
		}
	}

	public String getRepositoryItem(String repositoryComponentPath, String itemDescriptorName, String itemId) throws OracleCommerceClientException {
		try {
			return getRepositoryItemSEIPort.getRepositoryItem(repositoryComponentPath, itemDescriptorName, itemId);
		} catch (Exception e) {
			throw new OracleCommerceClientException(e.getClass().getName(), e.getMessage(), e);
		}
	}

}
