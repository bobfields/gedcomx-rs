package org.familysearch.gedcom.rex.gender;

import org.familysearch.gedcom.rex.Value;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Merlin Carpenter
 *         Date: Aug 14, 2008
 */
public class GenderValue extends Value {

  private GenderType type;

  public GenderValue() {
  }

  @XmlAttribute
  public GenderType getType() {
    return type;
  }

  public void setType(GenderType type) {
    this.type = type;
  }

}