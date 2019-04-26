SESP-POC Metadata Module
==========================

[![Build Status](https://travis-ci.org/esaude/openmrs-module-eptsmetadata.svg?branch=master)](https://travis-ci.org/esaude/openmrs-module-eptsmetadata) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/6cb836f28bd141a3a4f8fe388f1d8c3d)](https://app.codacy.com/app/esaude-ops/openmrs-module-eptsmetadata?utm_source=github.com&utm_medium=referral&utm_content=esaude/openmrs-module-eptsmetadata&utm_campaign=Badge_Grade_Dashboard) [![codecov](https://codecov.io/gh/esaude/openmrs-module-eptsmetadata/branch/master/graph/badge.svg)](https://codecov.io/gh/esaude/openmrs-module-eptsmetadata)

Description
-----------
Sistema Electrónico de Seguimento de Pacientes (SESP) metadata pack OpenMRS module

Prerequisites
-------------

1. [Install Java and Maven](https://wiki.openmrs.org/display/docs/OpenMRS+SDK#OpenMRSSDK-Installation)
2. Install git
   - `sudo apt-get install git`
3. To setup the OpenMRS SDK, you just need to open up a terminal/console and enter:
   - `mvn org.openmrs.maven.plugins:openmrs-sdk-maven-plugin:setup-sdk`

Building from Source
--------------------
You will need to have Java 1.6+ and Maven 2.x+ installed.  Use the command 'mvn package' to
compile and package the module.  The .omod file will be in the omod/target folder.

Alternatively you can add the snippet provided in the [Creating Modules](https://wiki.openmrs.org/x/cAEr) page to your
omod/pom.xml and use the mvn command:

    mvn package -P deploy-web -D deploy.path="../../openmrs-1.8.x/webapp/src/main/webapp"

It will allow you to deploy any changes to your web
resources such as jsp or js files without re-installing the module. The deploy path says
where OpenMRS is deployed.

Installation
------------
1. Build the module to produce the .omod file.
2. Use the OpenMRS Administration > Manage Modules screen to upload and install the .omod file.

If uploads are not allowed from the web (changable via a runtime property), you can drop the omod
into the ~/.OpenMRS/modules folder.  (Where ~/.OpenMRS is assumed to be the Application
Data Directory that the running openmrs is currently using.)  After putting the file in there
simply restart OpenMRS/tomcat and the module will be loaded and started.

Metadata Implemented
-------------------

How to perform a release
-------------------------

For more information on how to perform a release refer to this [link](https://wiki.openmrs.org/display/docs/Maven+Release+Process)

In summary execute the following:

```
mvn release:prepare
```

If there is a problem, you can rollback using:
```
mvn release:rollback
```