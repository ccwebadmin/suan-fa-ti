package com.util.tree;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cc
 * @date 2023/9/14-10:27
 */
@Data
public class TreeNode implements Serializable {

    private static final long serialVersionUID = -7998712544969085384L;

    private String id;

    private String name;

    private String parentId;

    private Boolean isLeaf;

    private Boolean isEdit;

    private Boolean disabled;

    private String lv;

    private List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
