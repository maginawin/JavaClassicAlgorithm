package ch2;
import java.util.Scanner;;
/*
 * 树结构
 */

//定义二叉树的结构类型
class CBType{
	String data; //元素数据
	CBType left; //左子树结点引用
	CBType right; //右子树结点引用
}

public class P2_5 {
	static final int MAXLEN = 20;
	static Scanner input = new Scanner(System.in); 
	@SuppressWarnings("unused")
	//初始化二叉树的根
	CBType InitTree(){
		CBType node;
		if((node = new CBType()) != null){ //申请内存
			System.out.println("请先输入一个根结点数据：\n");
			node.data = input.next();
			node.left = null;
			node.right = null;
			if(node != null){
				return node;
			}
			return null;
		}
		return null;
	}
	
	void AddTreeNode(CBType treeNode){
		CBType pnode, parent = null;
		String data;
		int menusel;
		if((pnode = new CBType()) != null){
			System.out.println("请输入二叉树结点数据：\n");
			pnode.data = input.next();
			pnode.left = null;
			pnode.right = null;
			
			System.out.println("输入该结点的你结点数据:");
			if(parent == null){
				System.out.println("未找到该你结点！\n");
				pnode = null;
				return;
			}
			
		}
	}
}
