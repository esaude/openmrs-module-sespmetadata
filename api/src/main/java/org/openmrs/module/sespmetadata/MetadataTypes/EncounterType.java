/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * OpenMRS is also distributed under the terms of the Healthcare Disclaimer located at
 * http://openmrs.org/license.
 *
 * <p>Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS graphic logo is a
 * trademark of OpenMRS Inc.
 */
package org.openmrs.module.sespmetadata.MetadataTypes;

public class EncounterType {
  String Uuid;
  String Name;
  String Description;

  public EncounterType(String Uuid, String Name, String Description) {
    this.Uuid = Uuid;
    this.Name = Name;
    this.Description = Description;
  }

  public String getName() {
    return this.Name;
  }

  public String getUuid() {
    return this.Uuid;
  }

  public String getDescription() {
    return this.Description;
  }
}
