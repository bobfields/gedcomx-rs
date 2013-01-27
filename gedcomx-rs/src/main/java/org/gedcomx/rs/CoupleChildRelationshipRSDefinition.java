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
import org.gedcomx.conclusion.CoupleChildRelationship;
import org.gedcomx.rt.rs.ResourceDefinition;
import org.gedcomx.rt.rs.ResponseCode;
import org.gedcomx.rt.rs.StateTransition;
import org.gedcomx.rt.rs.StatusCodes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;


/**
 * <p>The couple-child relationship resource manages the relationship between a child and <em>one or two</em> parents.</p>
 */
@ResourceDefinition (
  name = "Couple-Child Relationship",
  id = CoupleChildRelationshipRSDefinition.REL,
  description = "A couple-child relationship.",
  resourceElement = Gedcomx.class,
  transitions = {
    @StateTransition ( rel = SourceReferencesRSDefinition.REL, description = "The source references for the couple-child relationship.", scope = CoupleChildRelationship.class, conditional = true, targetResource = SourceReferencesRSDefinition.class ),
    @StateTransition ( rel = CoupleChildRelationshipRSDefinition.REL_PARENT1, description = "The father of the couple-child relationship.", scope = CoupleChildRelationship.class, conditional = true, targetResource = PersonRSDefinition.class ),
    @StateTransition ( rel = CoupleChildRelationshipRSDefinition.REL_PARENT2, description = "The mother of the couple-child relationship.", scope = CoupleChildRelationship.class, conditional = true, targetResource = PersonRSDefinition.class ),
    @StateTransition ( rel = CoupleChildRelationshipRSDefinition.REL_CHILD, description = "The child of the couple-child relationship.", scope = CoupleChildRelationship.class, conditional = true, targetResource = PersonRSDefinition.class ),
    @StateTransition ( rel = NotesRSDefinition.REL, description = "The notes for the couple-child relationship.", scope = CoupleChildRelationship.class, conditional = true, targetResource = NotesRSDefinition.class  )
  }
)
public interface CoupleChildRelationshipRSDefinition {

  public static final String REL = "couple-child-relationship";
  public static final String REL_PARENT1 = "parent1";
  public static final String REL_PARENT2 = "parent2";
  public static final String REL_CHILD = "child";

  /**
   * Read a couple-child relationship header attributes.
   *
   * @return The couple-child relationship.
   */
  @HEAD
  @StatusCodes ({
    @ResponseCode ( code = 200, condition = "Upon a successful read."),
    @ResponseCode ( code = 404, condition = "If the requested resource is not found.")
  })
  Response head();

  /**
   * Read a couple-child relationship.
   *
   * @return The couple-child relationship.
   */
  @GET
  @StatusCodes ({
    @ResponseCode ( code = 200, condition = "Upon a successful read."),
    @ResponseCode ( code = 404, condition = "If the requested resource is not found.")
  })
  Response get();

  /**
   * Update a couple-child relationship.
   *
   * @return The couple-child relationship.
   */
  @POST
  @StatusCodes ({
    @ResponseCode ( code = 204, condition = "The update was successful."),
    @ResponseCode ( code = 404, condition = "If the requested relationship is not found."),
    @ResponseCode ( code = 410, condition = "If the requested relationship has been deleted.")
  })
  Response post(Gedcomx root);

  /**
   * Delete a couple-child relationship.
   *
   */
  @DELETE
  @StatusCodes ({
    @ResponseCode ( code = 204, condition = "The delete was successful."),
    @ResponseCode ( code = 404, condition = "If the requested resource is not found.")
  })
  Response delete();
}
