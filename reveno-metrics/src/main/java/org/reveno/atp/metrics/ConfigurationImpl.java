/**
 *  Copyright (c) 2015 The original author or authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.reveno.atp.metrics;

import org.reveno.atp.utils.MeasureUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ConfigurationImpl implements Configuration {

	protected boolean sendToGraphite = false;
	public boolean sendToGraphite() {
		return sendToGraphite;
	}
	@Override
	public Configuration sendToGraphite(boolean sendToGraphite) {
		this.sendToGraphite = sendToGraphite;
		return this;
	}
	
	protected boolean sendToLog = true;
	public boolean sendToLog() {
		return sendToLog;
	}
	@Override
	public Configuration sendToLog(boolean sendToLog) {
		this.sendToLog = sendToLog;
		return this;
	}
	
	protected String graphiteServer;
	public String graphiteServer() {
		return graphiteServer;
	}
	@Override
	public Configuration graphiteServer(String graphiteServer) {
		this.graphiteServer = graphiteServer;
		return this;
	}
	
	protected int graphitePort = 2004;
	public int graphitePort() {
		return graphitePort;
	}
	@Override
	public Configuration graphitePort(int graphitePort) {
		this.graphitePort = graphitePort;
		return this;
	}
	
	protected String instanceName = "default";
	public String instanceName() {
		return instanceName;
	}
	@Override
	public Configuration instanceName(String instanceName) {
		this.instanceName = instanceName;
		return this;
	}
	
	protected String hostName;
	public String hostName() {
		return hostName;
	}
	@Override
	public Configuration hostName(String hostName) {
		this.hostName = hostName;
		return this;
	}
	
	protected int metricBufferSize = MeasureUtils.kb(128);
	public int metricBufferSize() {
		return metricBufferSize;
	}
	@Override
	public Configuration metricBufferSize(int size) {
		this.metricBufferSize = size;
		return this;
	}
	
	public ConfigurationImpl() {
		try {
			this.hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	protected static final Logger log = LoggerFactory.getLogger(ConfigurationImpl.class);
	
}
