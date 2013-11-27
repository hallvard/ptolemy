package org.ptolemy.xtext.examples.mqtt;

import java.util.ArrayList;
import java.util.List;

import net.sf.xenqtt.client.AsyncClientListener;
import net.sf.xenqtt.client.AsyncMqttClient;
import net.sf.xenqtt.client.MqttClient;
import net.sf.xenqtt.client.PublishMessage;
import net.sf.xenqtt.client.Subscription;
import net.sf.xenqtt.message.ConnectReturnCode;

public class DelegatingAsyncClientListener implements AsyncClientListener {

	protected List<AsyncClientListener> listeners = new ArrayList<AsyncClientListener>();

	public void addAsyncClientListener(AsyncClientListener listener) {
		listeners.add(listener);
	}

	public void removeAsyncClientListener(AsyncClientListener listener) {
		listeners.remove(listener);
	}
	
	// AsyncClientListener methods

	@Override
	public void publishReceived(MqttClient client, PublishMessage message) {
		for (AsyncClientListener listener : listeners) {
			listener.publishReceived(client, message);
		}
	}

	@Override
	public void disconnected(MqttClient client, Throwable cause, boolean reconnecting) {
		for (AsyncClientListener listener : listeners) {
			listener.disconnected(client, cause, reconnecting);
		}
	}

	@Override
	public void connected(MqttClient client, ConnectReturnCode returnCode) {
		for (AsyncClientListener listener : listeners) {
			listener.connected(client, returnCode);
		}
	}

	@Override
	public void subscribed(MqttClient client, Subscription[] requestedSubscriptions, Subscription[] grantedSubscriptions, boolean requestsGranted) {
		for (AsyncClientListener listener : listeners) {
			listener.subscribed(client, requestedSubscriptions, grantedSubscriptions, requestsGranted);
		}
	}

	@Override
	public void unsubscribed(MqttClient client, String[] topics) {
		for (AsyncClientListener listener : listeners) {
			listener.unsubscribed(client, topics);
		}
	}

	@Override
	public void published(MqttClient client, PublishMessage message) {
		for (AsyncClientListener listener : listeners) {
			listener.published(client, message);
		}
	}
}
