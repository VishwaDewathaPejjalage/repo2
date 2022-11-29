package Assignment5;

/**
 * The Tree Node Class. Generic
 * 
 * @author Vishwa Dewatha Pejjalage
 * @param <T>
 */
public class TreeNode<T> {

	protected TreeNode<T> left = null;
	protected TreeNode<T> right = null;
	private T data = null;

	/**
	 * Main constructor that create a new TreeNode with left and right child set to
	 * null and data set to the dataNode.
	 * 
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		left = null;
		right = null;
		data = dataNode;
	}

	/**
	 * Constructor, used for making deep copies
	 * 
	 * @param node
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
	}

	/**
	 * Return data
	 * 
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set data
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}
}