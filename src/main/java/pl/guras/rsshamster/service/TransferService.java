package pl.guras.rsshamster.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.annotation.ejb.Service;

@Service(objectName = "pl.guras.rsshamster:service=TransferService")
public class TransferService implements TransferServiceMBean {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void startTransfer() throws Exception {

	}
}
