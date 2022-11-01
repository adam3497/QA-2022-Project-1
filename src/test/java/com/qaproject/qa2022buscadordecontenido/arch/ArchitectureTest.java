package com.qaproject.qa2022buscadordecontenido.arch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeAll;

abstract class ArchitectureTest {
    static final String DOMAIN_LAYER_PACKAGES = "com.qaproject.qa2022buscadordecontenido.models..";
    static final String SERVICE_LAYER_PACKAGES = "com.qaproject.qa2022buscadordecontenido.service..";
    static final String WEB_LAYER_CLASSES = "com.qaproject.qa2022buscadordecontenido.controller..";
    static final String CONFIG_PACKAGE = "com.qaproject.qa2022buscadordecontenido.config..";

    static JavaClasses classes;

    @BeforeAll
    public static void setUp() {
        classes = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
                .importPackages("gt.app");
    }


}