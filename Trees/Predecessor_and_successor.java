
class Solution {
    public static void successor(Node root,Node[] suc,int key)
    {
       if(root==null)
       {
           return;
       }
       
       if(root.data<=key)
       {
          successor(root.right,suc,key);
       }
       else 
       {
           suc[0]=root;
           successor(root.left,suc,key);
       }
       return;
    }
    public static void  predecessor(Node root,Node[] pre,int key)
    {
       if(root==null)
       {
           return;
       }
       
       if(root.data>=key)
       {
          predecessor(root.left,pre,key);
       }
       else
       {
           pre[0]=root;
            predecessor(root.right,pre,key);
       }
       
    }
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
         pre[0] = null;
        suc[0] = null;
        successor(root,suc,key);
         predecessor(root,pre,key);
    }
}
