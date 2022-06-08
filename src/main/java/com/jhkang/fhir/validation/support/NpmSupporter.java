package com.jhkang.fhir.validation.support;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.context.support.IValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.*;

public class NpmSupporter {

    public ValidationSupportChain createNpmValidationSupportChain(FhirContext fhirContext) throws Exception {

        NpmPackageValidationSupport npmPackageSupport = new NpmPackageValidationSupport(fhirContext);
        npmPackageSupport.loadPackageFromClasspath("classpath:fhir/package/iteyes.myhw.core-1.0.9.tgz");

        return new ValidationSupportChain(
                npmPackageSupport,
                new DefaultProfileValidationSupport(fhirContext),
                new CommonCodeSystemsTerminologyService(fhirContext),
                new InMemoryTerminologyServerValidationSupport(fhirContext),
                new SnapshotGeneratingValidationSupport(fhirContext),
                new RemoteTerminologyServiceValidationSupport(fhirContext)
        );
    }
}
