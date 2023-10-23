1. list1转list2
```java
	public List<OrgUntTreeNode> method1(String adminRoleId)  {
		WrapperResponse<List<SysOrguntDTO>> response = orguntService.getAdminRoleUnitsByAdminRoleId(adminRoleId);
		if (response.getCode() != WrapperResponse.SUCCESS) {
			log.error("xx");
		}

		List<OrgUntTreeNode> orgUntTreeNodes = response.getData().stream().map(s -> {
			OrgUntTreeNode treeNode = new OrgUntTreeNode();
			OrgUntMergeDTO orgUntMergeDTO = new OrgUntMergeDTO();
			ToolUtil.copyProperties(s, orgUntMergeDTO);
			treeNode.setId(s.getOrguntId());
			treeNode.setName(s.getOrgName());
			treeNode.setParentId(s.getPrntOrgId());
			treeNode.setDisabled(true);
			treeNode.setChildren(Collections.emptyList());
			treeNode.setData(orgUntMergeDTO);
			return treeNode;
		}).collect(Collectors.toList());

		return orgUntTreeNodes;
	}
    //参考2
        List<SysOrguntDDO> orguntDOs = sysOrguntDDao.selectList(qwOrg);
        List<SysOrguntDTO> sysListDtos = new ArrayList<SysOrguntDTO>();
        if (ValidateUtil.isNotEmpty(orguntDOs)) {

        orguntDOs.stream().forEach(k -> {
        SysOrguntDTO orguntDTO = new SysOrguntDTO();
        ToolUtil.copyProperties(k, orguntDTO);
        sysListDtos.add(orguntDTO);
        });
        }
        return sysListDtos;
```