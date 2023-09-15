package com.util.tree.exam1;

import com.util.BizConstants;
import com.util.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cc
 * @date 2023/9/14-10:48
 */
public class Example1 {

    protected List<ResuNodeDTO> getTree(List<SysResuDDTO> sysResuDDTOs, String root) {
        List<ResuNodeDTO> trees = new ArrayList<>();
        for (SysResuDDTO dto : sysResuDDTOs) {
            ResuNodeDTO node = new ResuNodeDTO();
            node.setId(dto.getResuId());
            node.setName(dto.getResuName());
            node.setParentId(dto.getPrntResuId());
            node.setIsLeaf(BizConstants.LeafNodFlag.YES.getValue().equals(dto.getLeafnodFlag()));
            node.setData(dto);
            trees.add(node);
        }
        return TreeUtil.buildByRecursive(trees, root);
    }
}
