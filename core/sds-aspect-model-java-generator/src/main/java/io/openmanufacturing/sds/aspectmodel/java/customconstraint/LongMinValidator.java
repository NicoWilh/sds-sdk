/*
 * Copyright (c) 2022 Robert Bosch Manufacturing Solutions GmbH
 *
 * See the AUTHORS file(s) distributed with this work for additional
 * information regarding authorship.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * SPDX-License-Identifier: MPL-2.0
 */

package io.openmanufacturing.sds.aspectmodel.java.customconstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import io.openmanufacturing.sds.metamodel.impl.BoundDefinition;

/**
 * Validates assigned values of type {@link Long}, which must be above or equal to this limit depending on the
 * provided {@link BoundDefinition}.
 */
public class LongMinValidator implements ConstraintValidator<LongMin, Long> {

   private long min;
   private BoundDefinition boundDefinition;

   @Override
   public void initialize( final LongMin longMin ) {
      this.min = longMin.value();
      this.boundDefinition = longMin.boundDefinition();
   }

   @Override
   public boolean isValid( final Long longValue, final ConstraintValidatorContext context ) {
      if ( longValue == null ) {
         return true;
      }
      return boundDefinition.isValid( longValue, min );
   }
}
