/*
 * Copyright (c) 2021 Robert Bosch Manufacturing Solutions GmbH
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

package io.openmanufacturing.sds.aspectmodel.jackson;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Represents properties that can have two different types given as the Left or Right value.
 */
public class Either<L, R> {

   private final Optional<L> left;
   private final Optional<R> right;

   @JsonCreator
   public Either( @JsonProperty( "left" ) final Optional<L> left, @JsonProperty( "right" ) final Optional<R> right ) {
      this.left = left;
      this.right = right;
   }

   public static <L, R> Either<L, R> left( final L leftValue ) {
      return new Either<>( Optional.of( leftValue ), Optional.empty() );
   }

   public static <L, R> Either<L, R> right( final R rightValue ) {
      return new Either<>( Optional.empty(), Optional.of( rightValue ) );
   }

   public Optional<L> getLeft() {
      return left;
   }

   public Optional<R> getRight() {
      return right;
   }
}
