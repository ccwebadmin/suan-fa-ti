## list1转list2
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
## mybiats 查询参考
```java
    @Override
public IQuery<SysSubsysDTO> querySubSystem(SysSubsysFindDTO dto) {
        int pageNo = dto == null ? 0 : dto.getPageNo();
        int pageSize = dto == null ? 999 : dto.getPageSize();

        IPage<SysSubsysDDO> page = new Page<SysSubsysDDO>(pageNo, pageSize);

        QueryWrapper<SysSubsysDDO> queryWrapper = new QueryWrapper<SysSubsysDDO>();
        queryWrapper.lambda().eq(SysSubsysDDO::getValiFlag, BizConstants.ValiFlag.ENABLE.getValue());
        if (dto != null && !StringUtils.isEmpty(dto.getSubsysCodg())) {
        queryWrapper.apply(" instr(SUBSYS_CODG,{0}) > 0 ", dto.getSubsysCodg());
        }

        if (dto != null && !StringUtils.isEmpty(dto.getSubsysName())) {
        queryWrapper.apply(" instr(SUBSYS_NAME,{0}) > 0 ", dto.getSubsysName());
        }
        queryWrapper.lambda().orderByAsc(SysSubsysDDO::getSubsysCodg);
        IPage<SysSubsysDDO> find = sysSubsysDDao.selectPage(page, queryWrapper);
        IQuery<SysSubsysDTO> rs = new QueryResult<SysSubsysDTO>(find.getCurrent(), find.getSize(), find.getTotal());
        List<SysSubsysDTO> rsDto = new ArrayList<SysSubsysDTO>();
        find.getRecords().stream().forEach(e -> {
        SysSubsysDTO d = new SysSubsysDTO();
        ToolUtil.copyProperties(e, d);
        rsDto.add(d);
        });
        rs.setRecords(rsDto);

        return rs;
        }

```

## list中判空指针的地方
```java
// 不报npe       
List<String> list =new ArrayList<>();
        for(String str:list){
        System.out.println(str);
        }

        // 报npe       
        List<String> list =null;
        for(String str:list){
        System.out.println(str);
        }
        
        //list需要判不为空
        List<T> collect = list.stream().map(s -> {
        xxx
        }).collect(Collectors.toList());

```

## inputStream转MultipartFile
```java
    /**
     * 获取封装得MultipartFile
     *
     * @param inputStream inputStream
     * @param fileName    fileName
     * @return MultipartFile
     */
    public MultipartFile getMultipartFile(InputStream inputStream, String fileName) {
        FileItem fileItem = createFileItem(inputStream, fileName);
        //CommonsMultipartFile是feign对multipartFile的封装，但是要FileItem类对象
        return new CommonsMultipartFile(fileItem);
    }

/**
 * FileItem类对象创建
 *
 * @param inputStream inputStream
 * @param fileName    fileName
 * @return FileItem
 */
public FileItem createFileItem(InputStream inputStream, String fileName) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "file";
        FileItem item = factory.createItem(textFieldName, MediaType.MULTIPART_FORM_DATA_VALUE, true, fileName);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        OutputStream os = null;
        //使用输出流输出输入流的字节
        try {
        os = item.getOutputStream();
        while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
        os.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        } catch (IOException e) {
        log.error("Stream copy exception", e);
        throw new IllegalArgumentException("文件上传失败");
        } finally {
        if (os != null) {
        try {
        os.close();
        } catch (IOException e) {
        log.error("Stream close exception", e);

        }
        }
        if (inputStream != null) {
        try {
        inputStream.close();
        } catch (IOException e) {
        log.error("Stream close exception", e);
        }
        }
        }
        return item;
        }
```

方法2 自己实现MultipartFile

```java
public class DsmMultipartFile implements MultipartFile, Serializable {
    private final String name;
    private String originalFilename;
    @Nullable
    private String contentType;
    private final byte[] content;

    public DsmMultipartFile(String name, @Nullable String originalFilename, @Nullable String contentType, @Nullable byte[] content) {
        Assert.hasLength(name, "Name must not be null");
        this.name = name;
        this.originalFilename = originalFilename != null ? originalFilename : "";
        this.contentType = contentType;
        this.content = content != null ? content : new byte[0];
    }

    public DsmMultipartFile(String name, @Nullable String originalFilename, @Nullable String contentType, InputStream contentStream) throws IOException {
        this(name, originalFilename, contentType, FileCopyUtils.copyToByteArray(contentStream));
    }

    public String getName() {
        return this.name;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    @Nullable
    public String getContentType() {
        return this.contentType;
    }

    public boolean isEmpty() {
        return this.content.length == 0;
    }

    public long getSize() {
        return (long)this.content.length;
    }

    public byte[] getBytes() throws IOException {
        return this.content;
    }

    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(this.content);
    }

    public void transferTo(File dest) throws IOException, IllegalStateException {
        FileCopyUtils.copy(this.content, dest);
    }
}

```

使用

```java
        MultipartFile multipartFile =null;
        if (fsEntity != null) {
            try {
               multipartFile = new DsmMultipartFile(fileName, fileName, "application/octet-stream", fsEntity.getInputstream());
            } catch (IOException e) {
                e.printStackTrace();
                throw new PortalException(110023);
            }
        }

```


