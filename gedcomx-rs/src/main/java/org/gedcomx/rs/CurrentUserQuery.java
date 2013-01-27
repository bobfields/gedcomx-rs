/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.rs;

import org.gedcomx.Gedcomx;
import org.gedcomx.rt.rs.ResourceDefinition;
import org.gedcomx.rt.rs.ResponseCode;
import org.gedcomx.rt.rs.StatusCodes;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

/**
 * The current user query is used to query the application for the current user.
 */
@ResourceDefinition (
  name = "Current User",
  id = CurrentUserQuery.REL,
  description = "The query for the person for the current user.",
  resourceElement = Gedcomx.class
)
public interface CurrentUserQuery {

  public static final String REL = "current-user";

  /**
   * Read a person and their relationships.
   *
   * @return The person and relationships.
   */
  @GET
  @StatusCodes({
    @ResponseCode ( code = 200, condition = "TUpon a successful read.")
  })
  Response get();
}
