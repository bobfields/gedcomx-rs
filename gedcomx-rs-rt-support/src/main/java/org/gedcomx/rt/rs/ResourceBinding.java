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
package org.gedcomx.rt.rs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Metadata for a specific binding of a resource definition.
 *
 * @author Ryan Heaton
 */
@Retention ( RetentionPolicy.RUNTIME )
@Target ({ ElementType.TYPE, ElementType.METHOD })
public @interface ResourceBinding {

  /**
   * The name of the binding. Default is the name of resource definition.
   *
   * @return The name of the binding.
   */
  String name() default "##default";

  /**
   * A namespace for the binding. Default is the namespace of the resource definition.
   *
   * @return A namespace for the resource.
   */
  String namespace() default "##default";

  /**
   * An identifier for a project to which this binding belongs. Default is the project id of the resource.
   *
   * @return An identifier for a project to which this binding belongs.
   */
  String projectId() default "##default";

  /**
   * The class defining the element used as the representation model for this binding. The
   * resource element should be a JAXB {@link javax.xml.bind.annotation.XmlRootElement}.
   *
   * @return The class defining the element used as the representation model for the resource.
   */
  Class<?>[] resourceElement() default {};
}
