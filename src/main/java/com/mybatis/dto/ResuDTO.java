package com.mybatis.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author cc
 * @date 2023/9/16-13:48
 */
@Data
public class ResuDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ResuDTO> children;
    private String rid;
    private String resuId;
    private String resuCodg;
    private String resuName;
    private String resuType;
    private String pubComtFlag;
    private String resuPath;
    private String resuIcon;
    private String resuImg;
    private int seq;
    private String dscr;
    private String subsysId;
    private String prntResuId;
    private String leafnodFlag;
    private String subsysCodg;
    private String subsysName;
    private String sysPath;
    private String fullPath;
}
