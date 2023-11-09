/**
 * @kind problem
 * @problem.severity error
 * @language java
 */

import java

from Variable v, StringLiteral s
where 
  v.getName().toLowerCase().matches("%password%") and
  s.getRepresentedString().length() > 0 and
  s.getParent() instanceof VariableAssign and
  v = s.getParent().(VariableAssign).getDest()
select s, "This string contains a hardcoded password which should be removed."
