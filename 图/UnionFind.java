/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package 图;

/**
 *
 * @author msy
 */
public class UnionFind {
    private  int []id;
    private int []sz;//每个根节点对应的分量的大小
    private int count;

    public UnionFind(int N) {
        count=N;
        id=new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
        sz=new int[N];
        for (int i = 0; i < N; i++) {
            sz[i]=1;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int p){
        return id[p];
    }
    public void union(int p,int q){
        int pID=find(p);
        int qID=find(q);
        if (qID==pID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i]==pID) {
                id[i]=qID;
            }
        }
        count--;
    }
    //quick-union
    private int find1(int p){
        while (p!=id[p]) {            
            p=id[p];
        }
        return p;
    } 
    public void union1(int p,int q){
        int pRoot=find1(p);
        int qRoot=find1(q);
        if (qRoot==pRoot) {
            return ;
        }
        id[pRoot]=qRoot;
        //总是将小树连接到大树上面去
//        if (sz[pRoot]<sz[qRoot]) {
//            id[pRoot]=qRoot;
//            sz[qRoot]+=sz[pRoot];
//        }else{
//            id[qRoot]=pRoot;
//            sz[pRoot]+=sz[qRoot];
//        }
       
        count--;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
