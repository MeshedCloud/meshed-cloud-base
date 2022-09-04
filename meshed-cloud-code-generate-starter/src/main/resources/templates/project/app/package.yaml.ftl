${domainName}:
  executor:
    - query:
      - ByIdQryExe.java
      - ListQryExe.java
    - AddCmdExe.java
    - DelCmdExe.java
    - UpdateCmdExe.java
  serviceimpl: ServiceImpl.java

