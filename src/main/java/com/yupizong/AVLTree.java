package com.yupizong;

/**
 * 自平衡二叉搜索树：效率log2N,2分查找
 * 二叉搜索树：满足二叉搜索树的条件
 * 1. 节点的左子树和右子树都是二叉搜索树
 * 2. 节点的左子树小于该节点，节点的右子树大于该节点
 *
 * 自平衡：满足平衡条件
 * 1. 节点的平衡因子为：左子树的高度减去右子树的高度
 * 2. 平衡因子的绝对值不能大于1
 * 3. 插入和删除操作时，要保证平衡
 *
 * @author cc
 * @date 2026年01月07日 15:07
 * @return
 */
class AVLTree {
    // 树节点类
    // AVL树节点定义
    static class Node {
        int val;
        int height; // 节点高度（叶子节点高度为1）
        Node left, right;

        Node(int val) {
            this.val = val;
            this.height = 1; // 初始高度为1
        }
    }

    private Node root;

    // 获取节点高度（空节点高度为0）
    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    // 计算平衡因子：右子树高度 - 左子树高度
    private int getBalanceFactor(Node node) {
        return node == null ? 0 : getHeight(node.right) - getHeight(node.left);
    }

    // **************** 核心旋转操作 ****************
    // 1. 右旋（解决左子树过高）
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // 执行旋转
        x.right = y;
        y.left = T2;

        // 更新节点高度（先更下面的y，再更上面的x）
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x; // 返回新的根节点
    }

    // 2. 左旋（解决右子树过高）
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // 执行旋转
        y.left = x;
        x.right = T2;

        // 更新节点高度
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y; // 返回新的根节点
    }

    // **************** 插入节点（自动平衡） ****************
    public Node insert(Node node, int val) {
        // 1. 普通BST的插入逻辑
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        } else {
            return node; // 不允许重复值
        }

        // 2. 更新当前节点的高度
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // 3. 计算平衡因子，判断是否失衡
        int balance = getBalanceFactor(node);

        // 4. 失衡处理（4种情况）
        // 情况1：左左失衡（左子树过高，且新节点插在左子树的左侧）→ 右旋
        if (balance < -1 && val < node.left.val) {
            return rightRotate(node);
        }
        // 情况2：右右失衡（右子树过高，且新节点插在右子树的右侧）→ 左旋
        if (balance > 1 && val > node.right.val) {
            return leftRotate(node);
        }
        // 情况3：左右失衡（左子树过高，且新节点插在左子树的右侧）→ 先左旋左子树，再右旋当前节点
        if (balance < -1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // 情况4：右左失衡（右子树过高，且新节点插在右子树的左侧）→ 先右旋右子树，再左旋当前节点
        if (balance > 1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // 未失衡，返回原节点
    }

    // 对外暴露的插入方法
    public void insert(int val) {
        root = insert(root, val);
    }

    // **************** 搜索节点（核心功能） ****************
    public Node search(int val) {
        return search(root, val);
    }

    private Node search(Node node, int val) {
        // 终止条件：节点为空（未找到） 或 找到目标值
        if (node == null || node.val == val) {
            return node;
        }
        // 目标值小于当前节点 → 搜左子树
        if (val < node.val) {
            return search(node.left, val);
        }
        // 目标值大于当前节点 → 搜右子树
        return search(node.right, val);
    }

    // 测试用：中序遍历（验证BST特性：输出有序）
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.val + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        // 插入数据（模拟可能导致失衡的场景）
        int[] nums = {10, 20, 30, 40, 50, 25,15,17,41};
        for (int num : nums) {
            avl.insert(num);
        }

        // 中序遍历：验证是有序的（BST特性）
        System.out.println("AVL树中序遍历（有序）：");
        avl.inorder(avl.root); // 输出：10 20 25 30 40 50

        // 搜索测试
        int target = 25;
        Node result = avl.search(target);
        if (result != null) {
            System.out.println("\n找到节点：" + result.val);
        } else {
            System.out.println("\n未找到节点：" + target);
        }
    }
}