package com.util.tree.exam1;

import com.util.tree.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author cc
 * @date 2023/9/14-10:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResuNodeDTO extends TreeNode implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8578191015419431919L;

    private SysResuDDTO data;
}
