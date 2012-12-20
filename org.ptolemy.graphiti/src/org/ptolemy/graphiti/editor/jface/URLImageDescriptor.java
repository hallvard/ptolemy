package org.ptolemy.graphiti.editor.jface;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.ImageData;

/**
 * ImageDescriptor that downloads the image data from a URL
 * Typically used by a LabelProvider with an ImageRegistry to provide icons.
 * @see LabelProvider
 * @see ImageRegistry
 * @author hal
 *
 */
public class URLImageDescriptor extends ImageDescriptor {

	private URL url;

	public URLImageDescriptor(URL url) {
		this.url = url;
	}
	public URLImageDescriptor(String urlString) throws MalformedURLException {
		this(new URL(urlString));
	}
	public URLImageDescriptor(URI uri) throws MalformedURLException {
		this(uri.toURL());
	}
	
	@Override
	public String toString() {
		return "[URLImageDescriptor @ " + getUrl() + "]";
	}
	
	public URL getUrl() {
		return url;
	}

	@Override
	public ImageData getImageData() {
		try {
			return getImageData(getUrl());
		} catch (Exception e) {
			return null;
		}
	}
	
	public ImageData getImageData(URL url) {
		InputStream inputStream = null;
		try {
			inputStream = url.openStream();
			return new ImageData(inputStream);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
