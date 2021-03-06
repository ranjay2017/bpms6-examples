package org.fxapps.bpms.local.bc;

import org.drools.compiler.kproject.ReleaseIdImpl;
import org.drools.core.io.impl.UrlResource;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 
 * A KieScanner test application. It will fire the rules of the given artifact
 * which must be in some of the repositories configured in your local maven.
 * 
 * @author wsiqueir
 * 
 */
public class KieScannerTest {

	// The group of the maven artifact
	final static String G = "org.kie.example";
	// the artifact id
	final static String A = "project1";
	// *-SNAPSHOT versions can be used for updates based on the artifact
	// timestamp
	// LATEST version will always bring the latest version of the artifact
	final static String V = "1.0.0-SNAPSHOT";

	@Test
	public void doTest() throws InterruptedException {
		new UrlResource();
		KieServices kieServices = KieServices.Factory.get();
		ReleaseIdImpl releaseId = new ReleaseIdImpl(G, A, V);
		KieContainer kContainer = KieServices.Factory.get().newKieContainer(
				releaseId);
		KieScanner kScanner = kieServices.newKieScanner(kContainer);
		KieSession kSession = kContainer.newKieSession();
		kScanner.start(3000);
		// KieScanner will continue scanning the server looking for artifact
		// update
		while (true) {
			Thread.sleep(3000);
			kSession.fireAllRules();
		}
	}
}
