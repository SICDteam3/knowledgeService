package org.xjtusicd3.sphinx.api;

public class SphinxFactory {
	private static SphinxClient client= null;
	public static SphinxClient getClient(){
		if (client==null) {
			client = new SphinxClient();
		}
		return client;
	}
}
