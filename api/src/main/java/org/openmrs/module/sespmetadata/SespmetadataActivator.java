/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * OpenMRS is also distributed under the terms of the Healthcare Disclaimer located at
 * http://openmrs.org/license.
 *
 * <p>Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS graphic logo is a
 * trademark of OpenMRS Inc.
 */
package org.openmrs.module.sespmetadata;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.metadatadeploy.api.MetadataDeployService;
import org.openmrs.module.metadatadeploy.bundle.MetadataBundle;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class SespmetadataActivator extends BaseModuleActivator {

  private Log log = LogFactory.getLog(this.getClass());

  /** @see #started() */
  public void started() {
    log.info("Started SespMetadata Module");

    // Install metadata bundles excluding depricated bundles
    MetadataDeployService metadataDeployService = Context.getService(MetadataDeployService.class);
    for (MetadataBundle metadataBundle : Context.getRegisteredComponents(MetadataBundle.class)) {
      if (metadataBundle.getClass().getAnnotation(Deprecated.class) == null) {
        metadataDeployService.installBundle(metadataBundle);
      }
    }
    log.info("SESP Metadata Installed");
  }

  /** @see #stopped() */
  public void stopped() {
    log.info("Stopped SespMetadata Module");
  }

  @Override
  public void contextRefreshed() {
    log.debug("SespMetadata Module refreshed");
  }

  @Override
  public void willRefreshContext() {
    log.debug("Refreshing SespMetadata Module");
  }

  @Override
  public void willStart() {
    log.debug("Starting SespMetadata Module");
  }

  @Override
  public void willStop() {
    log.debug("Stopping SespMetadata Module");
    try {
      // remove metadata
      log.debug("SESP Metadata purged");
    } catch (Exception e) {
      log.error("An error occured trying to purge SESP Metadata", e);
    }
  }
}
