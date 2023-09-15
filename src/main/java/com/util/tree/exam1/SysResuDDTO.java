package com.util.tree.exam1;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author cc
 * @date 2023/9/14-10:53
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SysResuDDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String resuId;

    private String resuCodg;

    private String resuName;

    private String resuType;

    private String pubComtFlag;

    private String resuPath;

    private String resuIcon;

    private String resuImg;

    private Integer seq;

    private String dscr;

    private String subsysId;

    private String prntResuId;

    private String valiFlag;

    private String leafnodFlag;

    private String crterId;

    private String admdvs;
}
