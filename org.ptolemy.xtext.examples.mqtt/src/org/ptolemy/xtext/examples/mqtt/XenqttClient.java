package org.ptolemy.xtext.examples.mqtt;

import net.sf.xenqtt.client.AsyncMqttClient;

public class XenqttClient extends DelegatingAsyncClientListener {

	private AsyncMqttClient asyncMqttClient;

	public XenqttClient(String brokerUri, int messageHandlerThreadPoolSize) {
		asyncMqttClient = new AsyncMqttClient(brokerUri, this, messageHandlerThreadPoolSize);
	}
	
	public AsyncMqttClient getAsyncMqttClient() {
		return asyncMqttClient;
	}
}
