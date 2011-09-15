package pl.guras.rsshamster.service;

import org.jboss.annotation.ejb.Management;

@Management
public interface TransferServiceMBean {
	void startTransfer() throws Exception;
}
