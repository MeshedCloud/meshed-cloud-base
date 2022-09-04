${domainName}:
  api:
    Service.java
  common:
    - constant:
        Constant.java
    - package-info.java
  dto:
    cmd:
      - AddCmd.java
      - DelCmd.java
    query:
      - ByIdQry.java
      - ListQry.java
    vo: VO.java
  gateway: Gateway.java
